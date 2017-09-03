package no.nav.demo.storage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "bok", itemResourceRel = "bok", path = "bok")
public interface CustomRepository extends CrudRepository<BookDTO, Long> {

    @RestResource(exported = false)
    Iterable<BookDTO> findAll(Iterable<Long> longs);

    @RestResource(exported = false)
    void delete(Long aLong);

    @RestResource(exported = false)
    void delete(BookDTO entity);

    @RestResource(exported = false)
    void delete(Iterable<? extends BookDTO> entities);

    @RestResource(exported = false)
    void deleteAll();

}
