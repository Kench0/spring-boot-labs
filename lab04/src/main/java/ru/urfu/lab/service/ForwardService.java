package ru.urfu.lab.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.util.*;

@Service
@lombok.extern.slf4j.Slf4j
public class ForwardService {
  private final ModifyRequestService modifier;
  private final RestTemplate http;

  @Value("${downstream.url:http://localhost:8084/receive}")
  private String url;

  public ForwardService(
      ModifyRequestService modifier,
      org.springframework.boot.web.client.RestTemplateBuilder builder) {
    this.modifier = modifier;
    this.http =
        builder
            .setConnectTimeout(java.time.Duration.ofSeconds(3))
            .setReadTimeout(java.time.Duration.ofSeconds(5))
            .build();
  }

  public void send(Request q, long received) {
    modifier.modify(q);
    HttpHeaders h = new HttpHeaders();
    h.setContentType(MediaType.APPLICATION_JSON);
    h.set("X-Received-At", Long.toString(received));
    http.postForEntity(url, new HttpEntity<>(q, h), String.class);
    log.info("forwarded uid={}", q.getUid());
  }
}
