package de.dbernat.gateway.repositories;

import de.dbernat.gateway.domain.Company;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends ReactiveMongoRepository<Company, String>{}
