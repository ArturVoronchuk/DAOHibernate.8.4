package daohibernate.contorller;

import daohibernate.entity.Person;
import daohibernate.repo.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;
import jakarta.annotation.security.RolesAllowed;

@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    @Secured({"ROLE_READ"})
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        List<Person> result = personRepository.findPersonByCity(city);
        System.out.println(result);
        return result;
    }
    @GetMapping("/persons/by-age")
    @RolesAllowed({"ROLE_WRITE"})
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        List<Person> result = personRepository.findPersonByAge(age);
        System.out.println(result);
        return result;
    }

    @GetMapping("/persons/by-name")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Optional<Person> getPersonsByName(@RequestParam("name") String name,
                                         @RequestParam("surname") String surname) {
        Optional<Person> result = personRepository.findPersonByName(name,surname);
        System.out.println(result);
        return result;
    }

    @GetMapping("/persons/hello")
    @PreAuthorize("#username == authentication.principal.username")
    public String helloUser(String username) {
        return "Hello " + username;
    }
}
