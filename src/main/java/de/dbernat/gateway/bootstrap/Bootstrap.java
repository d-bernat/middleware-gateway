package de.dbernat.gateway.bootstrap;

import de.dbernat.gateway.domain.Company;
import de.dbernat.gateway.repositories.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class Bootstrap implements CommandLineRunner
{
    private final CompanyRepository companyRepository;

    public Bootstrap(CompanyRepository companyRepository)
    {
        this.companyRepository = companyRepository;
    }

    @Override
    public void run(String... args)
    {
       Long count = companyRepository.count().block();
       if(count != null && count == 0)
       {
           log.info("loading company data ...");
           Company company = Company.builder()
                                    .id("1")
                                    .description("Senior Full Stack Developer")
                                    .name("Dusan Bernat")
                                    .city("Wedel")
                                    .copyright("2020")
                                    .email("mail@it-bernat.de")
                                    .zipCode("22880")
                                    .street("Bekstr. 11")
                                    .phone1("+491722865677")
                                    .build();
           companyRepository.save(company).block();
       }
    }
}
