package service;


import com.opensymphony.xwork2.Action;
import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Client;
import com.vetardim.model.Role;
import com.vetardim.model.User;
import com.vetardim.service.Registration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

public class RegistrationTest {
    private Registration reg;
    private Client client;
    private int id = 1;
    private int userid = 1;
    private String firstname = "bla";
    private String secondname = "bla";
    private String lastname = "bla";
    private String phonenumber = "444444";
    private String address = "bla";
    private String email = "bla@mail.ru";

    private User user;
    private int roleid = 1;
    private String login = "bla";
    private String password = "blafffff";

    private Role role;
    private String roleName = "Client";

    @Before
    public void setUp() throws Exception {
         reg  = new Registration();
        client = new Client();
        client.setId(id);
        client.setUserId(userid);
        client.setFirstname(firstname);
        client.setLastname(lastname);
        client.setSecondname(secondname);
        client.setPhoneNumber(phonenumber);
        client.setAddress(address);
        client.setEmail(email);
        reg.setClient(client);

        role = new Role();
        role.setId(2);
        role.setName(roleName);
        RoleDao.addOrUpdateRole(role);

        reg.setLogin(login);
        reg.setPassword(password);

    }

    @After
    public void tearDown() throws Exception {
        UserDao.deleteUser(id);
        RoleDao.deleteRole(2);
    }

    @Test
    public void execute() throws Exception {
        assertEquals(Action.SUCCESS,reg.execute());
    }

    @Test
    public void signup() throws Exception {
       assertEquals(Action.SUCCESS,reg.singup());
    }

}