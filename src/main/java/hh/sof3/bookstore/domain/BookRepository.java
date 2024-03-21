package hh.sof3.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long>{

    // peritään findAll(), finsId(), deleteById(), save();

    List<Book> findByTitle(String title);

}
