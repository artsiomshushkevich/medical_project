package dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.vetardim.DAO.*;
import com.vetardim.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisitDaoTest {
    private Visit visit;
    private int id = 1;
    private int medical_history_id = 1;
    private int orderid = 1;
    private String complaints = "bla";
    private String diagnosys = "bla";

    private Order order;
    private int doctorid = 1;
    private int clientid = 1;
    private long date = 11111111;
    private long begintime = 111111111;

    private Client client;
    private int useridC = 1;
    private String firstnameC = "bla";
    private String secondnameC = "bla";
    private String lastnameC = "bla";
    private String phonenumberC = "bla";
    private String addressC = "bla";
    private String emailC = "bla";

    private Doctor doctor;
    private int useridD = 2;
    private int departmentid = 1;
    private String firstnameD = "bla";
    private String secondnameD = "bla";
    private String lastnameD = "bla";
    private String qualification = "bla";
    private String speciality = "bla";
    private String phonenumberD = "bla";
    private String emailD = "bla";

    private User userC, userD;
    private int roleid = 1;
    private String login = "bla";
    private String password = "bla";

    private Role role;
    private String roleName = "bla";

    private Department department;
    private String departmentName = "bla";
    private String address = "bla";

    private MedicalHistory medicalHistory;

    @Before
    public void setUp() throws Exception {
        visit = new Visit();
        visit.setId(id);
        visit.setMedicalHistoryId(medical_history_id);
        visit.setOrderId(orderid);
        visit.setComplaints(complaints);
        visit.setDiagnosys(diagnosys);

        role = new Role();
        role.setId(id);
        role.setName(roleName);
        RoleDao.addOrUpdateRole(role);

        userC = new User();
        userC.setId(1);
        userC.setRoleId(roleid);
        userC.setNickname(login);
        userC.setPassword(password);
        UserDao.addOrUpdateUser(userC);

        userD = new User();
        userD.setId(2);
        userD.setRoleId(roleid);
        userD.setNickname(login);
        userD.setPassword(password);
        UserDao.addOrUpdateUser(userD);

        department = new Department();
        department.setId(id);
        department.setName(departmentName);
        department.setAddress(address);
        DepartmentDao.addOrUpdateDepartment(department);

        client = new Client();
        client.setId(id);
        client.setUserId(useridC);
        client.setFirstname(firstnameC);
        client.setLastname(lastnameC);
        client.setSecondname(secondnameC);
        client.setPhoneNumber(phonenumberC);
        client.setAddress(addressC);
        client.setEmail(emailC);
        ClientDao.addOrUpdateClient(client);

        doctor = new Doctor();
        doctor.setId(id);
        doctor.setUserId(useridD);
        doctor.setDepartmentId(departmentid);
        doctor.setFirstname(firstnameD);
        doctor.setLastname(lastnameD);
        doctor.setSecondname(secondnameD);
        doctor.setQualification(qualification);
        doctor.setSpeciality(speciality);
        doctor.setPhoneNumber(phonenumberD);
        doctor.setEmail(emailD);
        DoctorDao.addOrUpdateDoctor(doctor);

        order = new Order();
        order.setId(id);
        order.setClientId(clientid);
        order.setDoctorId(doctorid);
        order.setBeginTime(begintime);
        order.setDate(date);
        OrderDao.addOrUpdateOrder(order);

        medicalHistory = new MedicalHistory();
        medicalHistory.setId(id);
        medicalHistory.setClientId(clientid);
        MedicalHistoryDao.addOrUpdateMedicalHistory(medicalHistory);
    }

    @After
    public void tearDown() throws Exception {
        OrderDao.deleteOrder(id);
        MedicalHistoryDao.deleteMedicalHistory(id);
        DoctorDao.deleteDoctor(id);
        ClientDao.deleteClient(id);
        UserDao.deleteUser(1);
        UserDao.deleteUser(2);
        RoleDao.deleteRole(id);
        DepartmentDao.deleteDepartment(id);
    }

    @Test
    public void deleteVisit() throws Exception {
        VisitDao.deleteVisit(id);
    }

    @Test
    public void updateVisit() throws Exception {
        VisitDao.addOrUpdateVisit(visit);
    }

    @Test
    public void addVisit() throws Exception {
        VisitDao.addOrUpdateVisit(visit);
    }

    @Test
    public void getVisitList() throws Exception {
        assertNotNull(VisitDao.getVisitsList());
    }
}