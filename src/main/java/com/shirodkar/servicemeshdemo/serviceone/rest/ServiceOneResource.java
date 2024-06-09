package com.shirodkar.servicemeshdemo.serviceone.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ServiceOneResource {

  private final RestClient restClient;

  public ServiceOneResource(RestClient.Builder restClientBuilder) {
    this.restClient = restClientBuilder.baseUrl("http://service-two:8080").build();
  }

  @GetMapping("/handle/{value}")
  public String handleServiceOne(@PathVariable String value) {
    String serviceTwoResponse = this.restClient.get().uri("/handle/{value}", value).retrieve().body(String.class);
    return "Sent the value - '" + value + "' to Service Two.\nService Two Responded with - '" + serviceTwoResponse + "'";
  }

}
