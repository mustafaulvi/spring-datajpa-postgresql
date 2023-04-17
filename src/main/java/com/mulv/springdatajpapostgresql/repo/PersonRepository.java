package com.mulv.springdatajpapostgresql.repo;

import com.mulv.springdatajpapostgresql.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
