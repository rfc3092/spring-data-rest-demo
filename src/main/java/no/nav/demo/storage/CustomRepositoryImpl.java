package no.nav.demo.storage;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomRepositoryImpl implements CustomRepository {

    private static final Map<Long, String> BOOKS = new HashMap<>(2);

    static {
        BOOKS.put(1L, "En bok");
        BOOKS.put(2L, "En annen bok");
    }

    private EntityManager manager; // Not actually used in this example, but you get the idea for a real world application.

    @Autowired
    public CustomRepositoryImpl(EntityManager manager) {
        this.manager = manager; // Could use a non-published repository, or any data source really.
    }

    @Override
    public <S extends BookDTO> S save(S entity) {
        BOOKS.put(entity.getId(), entity.getTittel());
        return entity;
    }

    @Override
    public <S extends BookDTO> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BookDTO findOne(Long aLong) {
        return BOOKS.containsKey(aLong) ? new BookDTO(aLong, BOOKS.get(aLong)) : null;
    }

    @Override
    public boolean exists(Long aLong) {
        return BOOKS.containsKey(aLong);
    }

    @Override
    public Iterable<BookDTO> findAll() {
        return BOOKS
                .keySet()
                .stream()
                .map(id -> new BookDTO(id, BOOKS.get(id)))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<BookDTO> findAll(Iterable<Long> longs) {
        return null; // I'm lazy.
    }

    @Override
    public long count() {
        return BOOKS.size();
    }

    @Override
    public void delete(BookDTO entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Iterable<? extends BookDTO> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

}
