package hh.sof3.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository {
    User findByUsername(String username);
}
