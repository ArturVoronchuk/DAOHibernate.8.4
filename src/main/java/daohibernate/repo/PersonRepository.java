package daohibernate.repo;

import daohibernate.entity.Person;
import daohibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {

    List<Person> findPersonByCity(String city);

    List<Person> findPersonByAge(int age);

    Optional<Person> findPersonByName(String name, String surname);
}
