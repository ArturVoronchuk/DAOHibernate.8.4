package daohibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PersonId implements Serializable {
    @Column(nullable = false, length = 15)
    private String name;

    @Column(nullable = false, length = 25)
    private String surname;

    @Column(nullable = false)
    private int age;

    @Override
    public String toString() {
        return "name= " + name
                + ", surname= " + surname
                + ", age= " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonId personId = (PersonId) o;
        return age == personId.age && Objects.equals(name, personId.name) && Objects.equals(surname, personId.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
