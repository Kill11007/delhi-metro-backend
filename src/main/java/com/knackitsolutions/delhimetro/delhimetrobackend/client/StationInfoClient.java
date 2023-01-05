package com.knackitsolutions.delhimetro.delhimetrobackend.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroRouteResponse;
import com.knackitsolutions.delhimetro.delhimetrobackend.dto.DelhiMetroStationInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class StationInfoClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${delhimetro.station-info.url}")
    private String url;

    public DelhiMetroStationInfoResponse infoResponse(String code){
        URI uri = UriComponentsBuilder.fromHttpUrl(url).build(code);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("referer", "https://www.delhimetrorail.com/");
        HttpEntity<Object> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> forEntity = restTemplate.exchange(uri, HttpMethod.GET,
                entity, String.class);
        DelhiMetroStationInfoResponse delhiMetroStationInfoResponse = null;
        try {
            delhiMetroStationInfoResponse = objectMapper.readValue(forEntity.getBody(), DelhiMetroStationInfoResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return delhiMetroStationInfoResponse;
    }

}
