package no.nav.demo.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@RepositoryRestController
public class CustomController {

    private final AuthorRepository repository;
    private final PagedResourcesAssembler pagedResourcesAssembler;

    @Autowired
    public CustomController(AuthorRepository repository, PagedResourcesAssembler pagedResourcesAssembler) {
        this.repository = repository;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/people/living")
    @ResponseBody
    @SuppressWarnings("unchecked") // Q&D
    public PagedResources<PersistentEntityResource> getLivingAuthors(Pageable pageable, PersistentEntityResourceAssembler persistentEntityResourceAssembler) {

        List<Author> authors = ((List<Author>) repository.findAll())
                .stream()
                .filter(author -> author.getDateOfDeath() == null)
                .collect(Collectors.toList());
        Page<Author> page = new PageImpl<>(authors, pageable, authors.size());
        return pagedResourcesAssembler.toResource(page, persistentEntityResourceAssembler);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/people/{id}/dto")
    @ResponseBody
    public AuthorDTO getDtoAuthor(@PathVariable Long id) {

        Author author = repository.findOne(id);
        return new AuthorDTO(author.getFirstName(), author.getLastName());

    }

}
