package com.outbrain.wordcloud.wc;

import com.outbrain.wordcloud.wc.dto.WordCloudRequest;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;

public interface WordCloudApi {
    @RequestLine("GET /wordcloud?text={text}")
    Response getWordCloud(@Param("text") String text);

    @RequestLine("POST /wordcloud")
    @Headers({"Content-Type: application/json"})
    Response getWordCloudWithParams(WordCloudRequest wordcloudrequest);
}
