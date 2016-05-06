package dao;

import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Client;
import com.vetardim.model.Role;
import com.vetardim.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientDaoTest {
    private Client client;
    private int id = 1;
    private int userid = 1;
    private String firstname = "bla";
    private String secondname = "bla";
    private String lastname = "bla";
    private String phonenumber = "bla";
    private String address = "bla";
    private String email = "bla";

    private User user;
    private int roleid = 1;
    private String login = "bla";
    private String password = "bla";

    private Role role;
    private String roleName = "bla";


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
    }

    @After
    public void tearDown() throws Exception {
        UserDao.deleteUser(id);
        RoleDao.deleteRole(id);
    }

    @Test
    public void deleteClient() throws Exception {
        ClientDao.deleteClient(id);
    }

    @Test
    public void updateClient() throws Exception {
        ClientDao.addOrUpdateClient(client);
    }

    @Test
    public void addClient() throws Exception {
        ClientDao.addOrUpdateClient(client);
    }

    @Test
    public void getClientList() throws Exception {
        assertNotNull(ClientDao.getClientsList());
    }
}