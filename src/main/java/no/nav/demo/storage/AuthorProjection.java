package no.nav.demo.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.config.Projection;

@Description("This is our description of this projection.")
@Projection(name = "simple", types = Author.class)
public interface AuthorProjection {

    @Description("Combines first and last names into one.")
    @Value("#{target.firstName} #{target.lastName}")
    String getName();

}
