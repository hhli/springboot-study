package com.hhli.springbootstduy.feign;

import feign.*;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary  feign的github测试
 */
public class GitHubExample {
    interface GitHub{

        class Repository {
            String name;
        }

        class Contributor {
            String login;
        }

        @RequestLine("GET /users/{username}/repos?sort=full_name")
        List<Repository> repos(@Param("username") String owner);

        @RequestLine("GET /repos/{owner}/{repo}/contributors")
        List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

        default  List<String> contributors(String owner){
            return repos(owner).stream()
                    .flatMap(repository -> contributors(owner, repository.name).stream())
                    .map(c->c.login)
                    .distinct()
                    .collect(Collectors.toList());
        }

        static GitHub connect(){
            Decoder decoder = new GsonDecoder();

            return Feign.builder().decoder(decoder)
                    .errorDecoder(new GitHubErrorDecoder(decoder))
                    .logger(new Logger.ErrorLogger())
                    .logLevel(Logger.Level.BASIC)
                    .target(GitHub.class, "https://api.github.com");
        }

        static class GitHubClientError extends RuntimeException{
            private static final long serialVersionUID = -4057763213700877495L;

            private String message;

            @Override
            public String getMessage(){
                return message;
            }
        }

        static class GitHubErrorDecoder implements ErrorDecoder{
            final Decoder decoder;
            final ErrorDecoder defaultErrorCodeer = new ErrorDecoder.Default();

            GitHubErrorDecoder(Decoder decoder){
                this.decoder = decoder;
            }

            @Override
            public Exception decode(String s, Response response) {
                try {
                    return (Exception) decoder.decode(response, GitHubClientError.class);
                } catch (IOException e) {
                    return defaultErrorCodeer.decode(s, response);
                }
            }
        }


        public static void main(String[] args) {
            GitHub gitHub = GitHub.connect();

            System.out.println("Let's fetch and print a list of the contributors to this org.");
            List<String> contributors = gitHub.contributors("netflix");
            contributors.forEach(c-> System.out.println(c));

            System.out.println("Now, let's cause an error.");
            try{
                gitHub.contributors("netflix", "some-unknown-project");
            }catch (GitHubClientError e){
                System.out.println(e.getMessage());
            }
        }
    }
}
