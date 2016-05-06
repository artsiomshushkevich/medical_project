package controller;

import com.opensymphony.xwork2.Action;
import com.vetardim.DAO.*;
import com.vetardim.controller.AnalyseController;
import com.vetardim.controller.CureController;
import com.vetardim.controller.MedicalHistoryController;
import com.vetardim.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicalHistoryControllerTest {
    private MedicalHistoryController controller;
    private MedicalHistory medicalHistory;
    private int id = 1;
    private int clientid = 1;

    private Client client;
    private int userid = 1;
    private String firstname = "bla";
    private String secondname = "bla";
    private String lastname = "bla";
    private String phonenumber = "4444444";
    private String address = "bla";
    private String email = "bla@mail.ru";

    private User user;
    private int roleid = 1;
    private String login = "bla";
    private String password = "blaggggg";

    private Role role;
    private String roleName = "Client";

    @Before
    public void setUp() throws Exception {
        medicalHistory = new MedicalHistory();
        medicalHistory.setId(id);
        medicalHistory.setClientId(clientid);

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

        client = new Client();
        client.setId(id);
        client.setUserId(userid);
        client.setFirstname(firstname);
        client.setLastname(lastname);
        client.setSecondname(secondname);
        client.setPhoneNumber(phonenumber);
        client.setAddress(address);
        client.setEmail(email);
        ClientDao.addOrUpdateClient(client);

        controller = new MedicalHistoryController();
        controller.setMedicalHistory(medicalHistory);
        controller.setId(id);
        MedicalHistoryDao.addOrUpdateMedicalHistory(medicalHistory);
    }

    @After
    public void tearDown() throws Exception {
        controller.delete();
        ClientDao.deleteClient(id);
        UserDao.deleteUser(id);
        RoleDao.deleteRole(id);
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