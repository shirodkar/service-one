package com.shirodkar.servicemeshdemo.serviceone.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ServiceOneResource {

  @Value("${service-two.base-url}")
  private String baseUrl;

  private RestClient restClient;

  @GetMapping("/handle/{value}")
  public String handleServiceOne(@PathVariable String value) {

    RestClient.Builder restClientBuilder = RestClient.builder();
    this.restClient = restClientBuilder.baseUrl(baseUrl).build();

    String serviceTwoResponse = this.restClient.get().uri("/handle/{value}", value).retrieve().body(String.class);
    return "Service-One sent the value '" + value + "' to Service-Two (" + baseUrl + ").\nService-Two Responded with - '" + serviceTwoResponse + "'.\n";
  }

}
