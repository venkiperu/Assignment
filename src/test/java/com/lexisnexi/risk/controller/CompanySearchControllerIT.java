//package com.lexisnexi.risk.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.tomakehurst.wiremock.WireMockServer;
//import com.github.tomakehurst.wiremock.client.WireMock;
//import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
//import com.lexisnexi.risk.model.Address;
//import com.lexisnexi.risk.model.CompanyDetailsResponse;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import static com.github.tomakehurst.wiremock.client.WireMock.*;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//import static org.springframework.http.HttpStatus.OK;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("wiremock")
//public class CompanySearchControllerIT {
//
//    private static WireMockServer wireMockServer;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private static String urlToStub;
//    private static String searchTerm;
//
//    @BeforeAll
//    static void init() {
//        wireMockServer = new WireMockServer(
//                new WireMockConfiguration()
//                        .port(7070)
//        );
//        wireMockServer.start();
//        WireMock.configureFor("localhost", 7070);
//
//        searchTerm = "appl";
//        urlToStub = String.format("/CompanyDetails/%s", searchTerm);
//    }
//
//    @AfterEach
//    public void afterEach() {
//        this.wireMockServer.resetAll();
//    }
//
//    @Test
//    void shouldCallGetStockDetailsAndReturnItsData() throws Exception {
//
//        CompanyDetailsResponse companyDetailsResponse = getCompanyDetailsResponse();
//
//        stubFor(WireMock.get(urlMatching(urlToStub))
//                .willReturn(aResponse()
//                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
//                        .withBody("{ \"id\": 1, \"stockCode\": \"APPL\", \"companyName\": \"Apple Inc.\"" +
//                                ",\"currentPrice\": 179.35, \"previousClosePrice\": 180.10, \"yield\": 0.49, " +
//                                "\"priceToEarningsRatio\":31.98 }")
//                        .withStatus(OK.value())));
//
//
//        mockMvc.perform(get("/api/stocks/{code}", searchTerm))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect((ResultMatcher) content().json(parseToJson(companyDetailsResponse)));
//
//        verify(getRequestedFor(urlPathEqualTo(urlToStub)));
//    }
//
//    private static String parseToJson(CompanyDetailsResponse companyDetailsResponse) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(companyDetailsResponse);
//    }
//
//    private CompanyDetailsResponse getCompanyDetailsResponse(){
//        return null;
//    }
//
//    private Address getAddress() {
//        return null;
//    }
//}
