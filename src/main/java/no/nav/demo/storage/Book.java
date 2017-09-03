package no.nav.demo.storage;

import org.springframework.data.annotation.Version;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    private String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
