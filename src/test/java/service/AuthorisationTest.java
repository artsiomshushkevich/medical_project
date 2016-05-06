package service;

import com.opensymphony.xwork2.Action;
import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Role;
import com.vetardim.model.User;
import com.vetardim.service.Authorisation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static org.junit.Assert.*;

public class AuthorisationTest {
    private User user;
    private int id = 1;
    private int roleid = id;
    private String login = "blabal";
    private String password = "bla";

    private Role role;
    private String roleName = "bla";

    private Authorisation log;
    private Map<String, Object> map;

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
        UserDao.addOrUpdateUser(user);




        log = new Authorisation();
        log.setLogin(login);
        log.setPassword(password);

    }

    @After
    public void tearDown() throws Exception {
        UserDao.deleteUser(id);
        RoleDao.deleteRole(id);
    }

    @Test
    public void login() throws Exception {
       assertEquals(Action.SUCCESS,log.execute());

    }

    @Test
    public void logout() throws Exception {
        assertEquals(Action.SUCCESS,log.execute());
    }

}