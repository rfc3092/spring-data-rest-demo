package no.nav.demo.storage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = true)
public interface BookRepository extends CrudRepository<Book, Long> {
}
