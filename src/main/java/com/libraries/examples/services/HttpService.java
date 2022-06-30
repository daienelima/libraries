package com.libraries.examples.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpService {

    public static final String APPLICATION_JSON = "application/json";
    public static final String ACCEPT = "Accept";
    private final HttpClient httpClient= HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    public <T> T sendGetReturnModel(String url, Class<T> responseType) throws InterruptedException, IOException {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).header(ACCEPT, APPLICATION_JSON).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return new ObjectMapper().readValue(response.body(), responseType);
    }

    public <T> List<T> sendGetReturnList(String url, Class<T> responseType) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).header(ACCEPT, APPLICATION_JSON).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.body(), objectMapper.getTypeFactory().constructCollectionType(List.class, responseType));
    }

    public <T> T sendPostReturnModel(String url, Class<T> responseType, Object object) throws InterruptedException, IOException {
        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(object);
        HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(url)).header(ACCEPT, APPLICATION_JSON).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), responseType);
    }
}
