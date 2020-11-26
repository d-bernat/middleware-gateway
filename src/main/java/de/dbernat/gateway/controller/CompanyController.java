package de.dbernat.gateway.controller;

import de.dbernat.gateway.domain.Company;
import de.dbernat.gateway.services.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class CompanyController
{
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GetMapping("company")
    public Mono<Company> get()
    {
        return this.companyService.get();
    }

    @PostMapping("company")
    public Mono<Company> update(@RequestBody  Company company)
    {
        return this.companyService.update(company);
    }

}
