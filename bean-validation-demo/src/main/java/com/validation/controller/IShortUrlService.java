package com.validation.controller;

/**
 * 接口描述：IShortUrlService
 *
 * @author yaojinhua
 * @version v1.0
 * @date 2023-02-22 16:29
 */
public interface IShortUrlService {

    /**
     * 生成短链
     *
     * @param shortUrlRequest
     * @return
     */
    String shortUrlGenerator(ShortUrlRequest shortUrlRequest);

    /**
     * 根据短链获取完整链接
     *
     * @param shortUrl
     * @return
     */
    String getUrl(String shortUrl);

    /**
     * 增加短链点击量
     *
     * @param shortUrl
     * @return
     */
    Boolean addClickCount(String shortUrl);

}
