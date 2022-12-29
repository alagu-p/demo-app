package com.example.demoapp;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsersRepositoryTest {
    @Autowired
    private UsersRepository userRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUser() {
        Users users = Users.builder()
                .firstName("test")
                .lastName("test")
                .email("test@test.com")
                .build();

        userRepository.save(users);
        assertThat(users.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getUserTest() {
        Users users = userRepository.findById(1l).get();

        assertThat(users.getId()).isEqualTo(1l);

    }

    @Test
    @Order(3)
    public void getListOfUsers() {
        List<Users> users = userRepository.findAll();
        assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void UpdateListOfUsers() {
        Users users = userRepository.findById(1l).get();
        users.setEmail("alagu@admin.com");
        Users users1 = userRepository.save(users);
        assertThat(users.getEmail()).isEqualTo("alagu@admin.com");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUser() {
        Users users = userRepository.findById(1l).get();
        userRepository.delete(users);

        Users users1 = null;
        Optional<Users> OptionalUser = userRepository.findByEmail("alagu@gmail.com");
        if (OptionalUser.isPresent()) {
            users1 = OptionalUser.get();

        }
        assertThat(users1).isNull();

    }

}
