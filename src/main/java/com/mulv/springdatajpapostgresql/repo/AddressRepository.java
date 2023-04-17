package com.mulv.springdatajpapostgresql.repo;

import com.mulv.springdatajpapostgresql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
