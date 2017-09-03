package no.nav.demo.storage;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(
        excerptProjection = AuthorProjection.class,
        exported = true,
        collectionResourceDescription = @Description("Here's the collection resource description."),
        collectionResourceRel = "people",
        itemResourceDescription = @Description("Here's the item resource description."),
        itemResourceRel = "people",
        path = "people"
)
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    @RestResource(exported = false)
    void delete(Long aLong);

    @RestResource(exported = false)
    void delete(Author author);

    @RestResource(exported = false)
    void delete(Iterable<? extends Author> iterable);

    @RestResource(exported = false)
    void deleteAll();

}
