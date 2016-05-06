package dao;

import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Role;
import com.vetardim.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    private User user;
    private int id = 1;
    private int roleid = id;
    private String login = "blabal";
    private String password = "bla";

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
    }

    @After
    public void tearDown() throws Exception {
        RoleDao.deleteRole(id);
    }

    @Test
    public void deleteUser() throws Exception {
        UserDao.deleteUser(id);
    }

    @Test
    public void updateUser() throws Exception {
        UserDao.addOrUpdateUser(user);
    }

    @Test
    public void addUser() throws Exception {
        UserDao.addOrUpdateUser(user);
    }

    @Test
    public void getUserList() throws Exception {
        assertNotNull(UserDao.getUsersList());
    }
}