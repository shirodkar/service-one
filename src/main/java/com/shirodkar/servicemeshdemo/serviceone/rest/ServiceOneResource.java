package com.shirodkar.servicemeshdemo.serviceone.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private static final Logger logger = LoggerFactory.getLogger(ServiceOneResource.class);

  @GetMapping("/handle/{value}")
  public String handleServiceOne(@PathVariable String value) {

    logger.debug("Service-One received the value - '{}'", value);

    // Pass the value to another service
    RestClient.Builder restClientBuilder = RestClient.builder();
    this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    String response = this.restClient.get().uri("/handle/{value}", value).retrieve().body(String.class);

    return "Service-One sent the value '" + value + "' to (" + baseUrl + ").\nIt Responded with - '" + response + "'.\n";
  }

}
