package daohibernate.entity;

import daohibernate.repo.PersonRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class PersonFindService {
    private PersonRepository personRepository;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        return personRepository.findPersonByCity(city);
    }

    @Transactional
    public List<Person> getPersonsByAgeLess(int age) {
        return personRepository.findPersonByAge(age);
    }

    @Transactional
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findPersonByName(name,surname);
    }
}
