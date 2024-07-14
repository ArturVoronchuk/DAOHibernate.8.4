package daohibernate.contorller;

import daohibernate.entity.Person;
import daohibernate.repo.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    @ResponseBody
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        List<Person> result = personRepository.findPersonByCity(city);
        System.out.println(result);
        return result;
    }

    @GetMapping("/persons/by-age")
    @ResponseBody
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        List<Person> result = personRepository.findPersonByAge(age);
        System.out.println(result);
        return result;
    }

    @GetMapping("/persons/by-name")
    @ResponseBody
    public Optional<Person> getPersonsByName(@RequestParam("name") String name,
                                         @RequestParam("surname") String surname) {
        Optional<Person> result = personRepository.findPersonByName(name,surname);
        System.out.println(result);
        return result;
    }
}
