package no.nav.demo.storage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.Description;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
public class Author {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Description("This is a description of this field.")
    private Date dateOfBirth;

    private Date dateOfDeath;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private Set<Book> books;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public Set<Book> getBooks() {
        return books;
    }

}
