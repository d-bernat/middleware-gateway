package de.dbernat.gateway.controller;

import de.dbernat.gateway.domain.Company;
import de.dbernat.gateway.repositories.CompanyRepository;
import de.dbernat.gateway.services.CompanyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

public class CompanyControllerTest
{
    private WebTestClient webTestClient;
    private CompanyRepository companyRepository;
    private CompanyService companyService;
    private CompanyController companyController;

    @Before
    public void setUp() throws Exception
    {
        companyRepository = Mockito.mock(CompanyRepository.class);
        companyService = new CompanyService(companyRepository);
        companyController = new CompanyController(companyService);
        webTestClient = WebTestClient.bindToController(companyController).build();
    }

    @Test
    public void getById()
    {
        BDDMockito.given(companyRepository.findById("1"))
                  .willReturn(Mono.just(Company.builder()
                                               .id("1")
                                               .description("Senior Full Stack Developer")
                                               .name("Dusan Bernat")
                                               .city("Wedel")
                                               .copyright("2020")
                                               .email("mail@it-bernat.de")
                                               .zipCode("22880")
                                               .street("Bekstr. 11")
                                               .phone1("+491722865677")
                                               .build()));
        webTestClient.get().uri("/company")
                     .exchange()
                     .expectBody(Company.class)
                     .value(c -> c.getCity().equals("Wedel"));
    }
}