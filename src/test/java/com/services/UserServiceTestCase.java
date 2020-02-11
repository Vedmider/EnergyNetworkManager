package com.services;

import com.persitence.entity.User;
import com.persitence.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceTestCase {
    private static final String FIRST_NAME = "Antoni";
    private static final String LAST_NAME = "Kievski";
    private static final String EMAIL = "test@email.com";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final Integer ID = 1;

    @TestConfiguration
    static class TestConfig {

        @Bean(name = "testUser")
        User testUser() {
            User user = new User();
            user.setFirstName(FIRST_NAME);
            user.setLastName(LAST_NAME);
            user.setEmail(EMAIL);
            user.setLogin(LOGIN);
            user.setPassword(PASSWORD);
            user.setId(ID);
            return user;
        }

    }

    @Resource
    User testUser;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    public void shouldReturnPresentOptionalUserAfterValidateUserWithCorrectCredentials(){
        Mockito.when(userRepository.findUserByLoginAndPassword(LOGIN, PASSWORD))
                .thenReturn(Optional.of(testUser));
        Optional<User> actualUser = userService.validateUser(LOGIN, PASSWORD);

        Assert.assertTrue(actualUser.isPresent());
        Assert.assertEquals(testUser, actualUser.get());
    }

}
