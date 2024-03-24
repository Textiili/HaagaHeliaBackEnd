package hh.sof3.bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserByUsername() {
        User user = userRepository.findByUsername("admin");
        assertThat(user.getUsername()).isEqualTo("admin");
    }
    
    @Test 
    public void createNewUserTest() {
        //New user in this case gets id value 5L assigned to it automatically
        User user = new User("jaska", "$2a$10$tN1dezKHj4ttNZjmzrC.f.h774ee12b4pDUmxbYStlEiypsma5wQy", "USER");
    	userRepository.save(user);
    	assertThat(userRepository.findByUsername("jaska")).isNotNull();
    }    

    @Test
    public void deleteUserTest() {
        //Lets test first that User with id 3L exists
        assertThat(userRepository.findById(3L)).isNotNull();

        userRepository.deleteById(3L);
        assertThat(userRepository.findById(3L)).isEmpty();
    }
}

