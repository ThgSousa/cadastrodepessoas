package com.spring.thiago.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "phoneusers")
@Data
public class Tell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    String iduser;

    @NotBlank
    String tell;

}
