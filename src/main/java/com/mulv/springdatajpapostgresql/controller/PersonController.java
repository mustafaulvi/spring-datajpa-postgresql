package com.mulv.springdatajpapostgresql.controller;

import com.mulv.springdatajpapostgresql.dto.PersonDto;
import com.mulv.springdatajpapostgresql.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> add(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPerson(){
        return ResponseEntity.ok(personService.getAll());
    }
}
