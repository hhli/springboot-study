package com.hhli.springbootstduy.rest;

import com.hhli.springbootstduy.model.vo.Contributor;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary
 */
@FeignClient(value = "test-service", url = "${github.server}")
public interface GitHubRest {
    /***
     * 获取github仓库的贡献者及其对应数量
     * @param owner
     * @param repo
     * @return
     */
    @RequestMapping(value = "/repos/{owner}/{repo}/contributors", method = RequestMethod.GET)
    List<Contributor> contributors(@PathVariable("owner") String owner, @PathVariable("repo") String repo);

}
