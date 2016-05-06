package controller;

import com.opensymphony.xwork2.Action;
import com.vetardim.DAO.*;
import com.vetardim.controller.AnalyseController;
import com.vetardim.controller.CureController;
import com.vetardim.controller.UserController;
import com.vetardim.model.*;
import dao.UserDaoTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserControllerTest {
    private UserController controller;
    private User user;
    private int id = 1;
    private int roleid = id;
    private String login = "blabalvvv";
    private String password = "blablgffg";

    private Role role;
    private String roleName = "bla";

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(id);
        user.setRoleId(roleid);
        user.setNickname(login);
        user.setPassword(password);

        role = new Role();
        role.setId(id);
        role.setName(roleName);
        RoleDao.addOrUpdateRole(role);

        controller = new UserController();
        controller.setUser(user);
        controller.setId(id);
        UserDao.addOrUpdateUser(user);
    }

    @After
    public void tearDown() throws Exception {
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