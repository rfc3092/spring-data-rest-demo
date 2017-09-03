package no.nav.demo.storage;

import org.springframework.data.rest.core.annotation.Description;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;


@Entity
public class BookDTO {

    @Id
    private Long id;

    @Version
    private Long version = 0L; // Just to show how e-tags are enabled.

    @Description("Dette er tittelen på denne boka.")
    private String tittel;

    protected BookDTO() {

    }

    BookDTO(Long id, String tittel) {
        this.id = id;
        this.tittel = tittel;
    }

    Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

}
