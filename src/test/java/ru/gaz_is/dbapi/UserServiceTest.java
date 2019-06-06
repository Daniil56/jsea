package ru.gaz_is.dbapi;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    Worker mockDataSource;
    @Mock
    Connection mockConn;
    @Mock
    Statement mockState;
    @Mock
    ResultSet mockRS;
    @Mock
    UserService service;
    private User thirdUser;


    @Before
    public void setUp() throws SQLException {
        assertNotNull(mockDataSource);
        thirdUser = new User();
        thirdUser.setId(3);
        thirdUser.setSurname("Smith");
        thirdUser.setFirstname("John");
        thirdUser.setUsername("John90");
    }


    @Test
    public void whenUpdateWithMockito() throws SQLException {
        service = new UserService();
        String expect = "newSurname8259";
        User user = service.getFor("ivan666");
        user.setSurname(expect);
        service.updateFor(user);

    }

    @Test
    public void whenSayMyNameThenRespUser() throws SQLException {
        String expect = "ivan666";
        service = new UserService();
        User user = service.getFor(expect);
        assertThat(user.getUsername(), is(expect));
    }

    @Test
    public void whenSayNewSureNameThenUpdateDb() throws SQLException {
        String expect = "newSurname89";
        service = new UserService();
        User user = service.getFor("ivan666");
        user.setSurname(expect);
        service.updateFor(user);
        service.getFor("ivan666");
    }

    @Test
    public void updateUserMock() throws SQLException {
        thirdUser.setSurname("testSur");
        service.updateFor(thirdUser);
    }
}