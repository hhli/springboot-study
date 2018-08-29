package com.hhli.springbootstduy.feign;

import com.hhli.springbootstduy.model.vo.Contributor;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary
 */
public interface GitHub {
    /**
     *  获取github用户特定仓库的贡献人员
     * @param owner
     * @param repo
     * @return
     */
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
}
