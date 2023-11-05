package com.lexisnexi.risk.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.lexisnexis.risk.WireMockInitializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {WireMockInitializer.class})
public class CompanySearchControllerIT {

    @Autowired
    private WireMockServer wireMockServer;

    @Autowired
    private WebTestClient webTestClient;

    @LocalServerPort
    private Integer port;

    @AfterEach
    public void afterEach() {
        this.wireMockServer.resetAll();
    }

    @Test
    void testGetAllTodosShouldReturnDataFromClient() {
        this.wireMockServer.stubFor(
                WireMock.get("/Officers")
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBodyFile("0422ef7a-5034-4f7a-afc0-14209d73c85e.json"))
        );

        this.webTestClient
                .get()
                .uri("/TruProxyAPI/rest/Companies/v1/Officers")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .jsonPath("$companyName")
                .isEqualTo("sarsun");

    }
}
