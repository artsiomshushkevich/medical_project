package controller;

import com.opensymphony.xwork2.Action;
import com.vetardim.DAO.*;
import com.vetardim.controller.AnalyseController;
import com.vetardim.controller.ClientController;
import com.vetardim.controller.CureController;
import com.vetardim.controller.UserController;
import com.vetardim.model.*;
import dao.UserDaoTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientControllerTest {
    private ClientController controller;
    private Client client;
    private int id = 1;
    private int userid = 1;
    private String firstname = "Olegovich";
    private String secondname = "Olegovich";
    private String lastname = "Olegovich";
    private String phonenumber = "+375293338950";
    private String address = "Lenina, 44";
    private String email = "bla@mail.ru";

    private User user;
    private int roleid = 1;
    private String login = "blafffff";
    private String password = "blalllll";

    private Role role;
    private String roleName = "Client";

    @Before
    public void setUp() throws Exception {
        client = new Client();
        client.setId(id);
        client.setUserId(userid);
        client.setFirstname(firstname);
        client.setLastname(lastname);
        client.setSecondname(secondname);
        client.setPhoneNumber(phonenumber);
        client.setAddress(address);
        client.setEmail(email);

        role = new Role();
        role.setId(id);
        role.setName(roleName);
        RoleDao.addOrUpdateRole(role);

        user = new User();
        user.setId(id);
        user.setRoleId(roleid);
        user.setNickname(login);
        user.setPassword(password);
        UserDao.addOrUpdateUser(user);

        controller = new ClientController();
        controller.setClient(client);
        controller.setId(id);
        ClientDao.addOrUpdateClient(client);
    }

    @After
    public void tearDown() throws Exception {
        UserDao.deleteUser(id);
        RoleDao.deleteRole(id);
        //controller.delete();
    }

    @Test
    public void execute() throws Exception {
        assertEquals(Action.SUCCESS,controller.execute());
    }

    @Test
    public void add() throws Exception {
        assertEquals(Action.SUCCESS,controller.add());
    }

    @Test
    public void update() throws Exception {
        assertEquals(Action.SUCCESS,controller.update());
    }

    @Test
    public void delete() throws Exception {
        assertEquals(Action.SUCCESS,controller.delete());
    }
}