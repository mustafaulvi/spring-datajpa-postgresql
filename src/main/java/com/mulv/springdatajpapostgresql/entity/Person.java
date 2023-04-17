package com.mulv.springdatajpapostgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Person {

    @Id
    @SequenceGenerator(name="seq_person_address",allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address",strategy = GenerationType.SEQUENCE)
    private long id;

    private String vorname;

    private String nachname;

    @OneToMany
    @JoinColumn(name= "person_address_id")
    private List<Address> addresses;

}
