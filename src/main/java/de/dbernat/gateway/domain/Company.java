package de.dbernat.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company
{
    @Id
    private String id;
    private String description;
    private String name;
    private String street;
    private String zipCode;
    private String city;
    private String email;
    private String phone1;
    private String phone2;
    private String copyright;
}
