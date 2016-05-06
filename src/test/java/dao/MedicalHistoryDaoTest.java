package dao;

import com.vetardim.DAO.ClientDao;
import com.vetardim.DAO.MedicalHistoryDao;
import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Client;
import com.vetardim.model.MedicalHistory;
import com.vetardim.model.Role;
import com.vetardim.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicalHistoryDaoTest {
    private MedicalHistory medicalHistory;
    private int id = 1;
    private int clientid = 1;

    private Client client;
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
    }

    @After
    public void tearDown() throws Exception {
        ClientDao.deleteClient(id);
        UserDao.deleteUser(id);
        RoleDao.deleteRole(id);
    }

    @Test
    public void deleteMedicalHistory() throws Exception {
        MedicalHistoryDao.deleteMedicalHistory(id);
    }

    @Test
    public void updateMedicalHistory() throws Exception {
        MedicalHistoryDao.addOrUpdateMedicalHistory(medicalHistory);
    }

    @Test
    public void addMedicalHistory() throws Exception {
        MedicalHistoryDao.addOrUpdateMedicalHistory(medicalHistory);
    }

    @Test
    public void getMedicalHistoryList() throws Exception {
        assertNotNull(MedicalHistoryDao.getMedicalHistoriesList());
    }
}