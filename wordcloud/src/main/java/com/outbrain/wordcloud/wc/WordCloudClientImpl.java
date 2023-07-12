package com.outbrain.wordcloud.wc;

import com.outbrain.wordcloud.wc.dto.WordCloudRequest;
import feign.Feign;
import feign.Response;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordCloudClientImpl implements WordCloudClient {

    public WordCloudApi api;

    @Autowired
    public WordCloudClientImpl() {
        this.api = Feign.builder().decoder(new GsonDecoder()).encoder(new GsonEncoder()).target(WordCloudApi.class, "https://quickchart.io");
    }

    @Override
    public Response getWordCloud(String text) {
        return this.api.getWordCloud(text);
    }

    @Override
    public Response getWordCloud(WordCloudRequest request) {
        return this.api.getWordCloud(request);
    }
}
