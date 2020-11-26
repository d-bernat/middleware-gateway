package de.dbernat.gateway.services;

import de.dbernat.gateway.domain.Company;
import de.dbernat.gateway.repositories.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CompanyService
{
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository)
    {
        this.companyRepository = companyRepository;
    }

    public Mono<Company> get() {
        return companyRepository.findById("1");
    }

    public Mono<Company>update(Company company)
    {
        company.setId("1");
        return companyRepository.save(company);
    }
}
