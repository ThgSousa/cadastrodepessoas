package com.spring.thiago.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "mail")
@Data
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    String adr;

    @NotBlank
    String iduser;

    @NotBlank
    String cep;

}
