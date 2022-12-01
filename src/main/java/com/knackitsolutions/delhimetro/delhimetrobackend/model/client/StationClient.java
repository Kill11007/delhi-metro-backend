package com.knackitsolutions.delhimetro.delhimetrobackend.model.client;

import com.knackitsolutions.delhimetro.delhimetrobackend.model.dto.StationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class StationClient {
    private final RestTemplate restTemplate;
    @Value("${delhimetro.stations.url}")
    private String url;

    @Async
    public List<StationResponse> stationsResponse(String letter){
        URI uri = UriComponentsBuilder.fromHttpUrl(url).build(letter);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("referer", "https://www.delhimetrorail.com/");
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<StationResponse>> forEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<StationResponse>>() {});
        return forEntity.getBody();
    }
}
