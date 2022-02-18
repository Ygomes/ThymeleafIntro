package com.example.demo.repository;

import com.example.demo.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUsers(){
        Users users = new Users();
        users.setEmail("yuriteste@gmail.com");
        users.setPassword("1234abcd");
        users.setFirstName("Yuri");
        users.setLastName("Gomes");
        Users saveUsers = usersRepository.save(users);

        Users existUsers = testEntityManager.find(Users.class, saveUsers.getId());

        assertThat(existUsers.getEmail().equals(users.getEmail()));
        usersRepository.delete(users);
    }

}