package com.mulv.springdatajpapostgresql.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonDto {

    private long id;
    private String vorname;
    private String nachname;
    private List<String> addresses;
}
