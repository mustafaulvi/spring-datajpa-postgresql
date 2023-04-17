package com.mulv.springdatajpapostgresql.service.impl;

import com.mulv.springdatajpapostgresql.dto.PersonDto;
import com.mulv.springdatajpapostgresql.entity.Address;
import com.mulv.springdatajpapostgresql.entity.Person;
import com.mulv.springdatajpapostgresql.repo.AddressRepository;
import com.mulv.springdatajpapostgresql.repo.PersonRepository;
import com.mulv.springdatajpapostgresql.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        Assert.notNull(personDto.getVorname(), "Diese Field muss ausfüllen!");

        Person person = new Person();
        person.setVorname(personDto.getVorname());
        person.setNachname(personDto.getNachname());
        final Person personDb = personRepository.save(person);
        List<Address> addresses = new ArrayList<>();

        personDto.getAddresses().forEach(item -> {
                    Address address = new Address();
                    address.setAddress(item);
                    address.setAddressType(Address.AddressType.ANDERE);
                    address.setActive(true);
                    address.setPerson(personDb);
                    addresses.add(address);
                }
        );
        addressRepository.saveAll(addresses);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        personList.forEach(it -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(it.getId());
            personDto.setNachname(it.getNachname());
            personDto.setVorname(it.getVorname());
            personDto.setAddresses(it.getAddresses().stream().map(Address::getAddress)
                    .collect(Collectors.toList()));
            personDtoList.add(personDto);
        });
        return personDtoList;
    }


    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
