package controller;

import com.opensymphony.xwork2.Action;
import com.vetardim.DAO.*;
import com.vetardim.controller.AnalyseController;
import com.vetardim.controller.CureController;
import com.vetardim.controller.TreatmentController;
import com.vetardim.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreatmentControllerTest {
    private TreatmentController controller;
    private Treatment treatment;
    private int id = 1;
    private int cureid = 1;
    private int visitid = 1;
    private String prescription = "bla";
    private int curecount = 111111111;
    private String methodofusing = "bla";

    private Cure cure;
    private String name = "bla";

    private Visit visit;
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
    private String phonenumberC = "222222";
    private String addressC = "bla";
    private String emailC = "bla@mail.ru";

    private Doctor doctor;
    private int useridD = 2;
    private int departmentid = 1;
    private String firstnameD = "bla";
    private String secondnameD = "bla";
    private String lastnameD = "bla";
    private String qualification = "bla";
    private String speciality = "bla";
    private String phonenumberD = "3333333";
    private String emailD = "bla@MAIL.RU";

    private User userC, userD;
    private int roleid = 1;
    private String login = "bla";
    private String password = "blaggggg";

    private Role roleC;
    private String roleNameC = "Client";

    private Role roleD;
    private String roleNameD = "Doctor";

    private Department department;
    private String departmentName = "bla";
    private String address = "bla";

    private MedicalHistory medicalHistory;

    @Before
    public void setUp() throws Exception {
        treatment = new Treatment();
        treatment.setId(id);
        treatment.setCureId(cureid);
        treatment.setMethodOfUsing(methodofusing);
        treatment.setCureCount(curecount);
        treatment.setPrescription(prescription);
        treatment.setVisitId(visitid);

        cure = new Cure();
        cure.setId(id);
        cure.setName(name);
        CureDao.addOrUpdateCure(cure);

        roleC = new Role();
        roleC.setId(id);
        roleC.setName(roleNameC);
        RoleDao.addOrUpdateRole(roleC);

        roleD = new Role();
        roleD.setId(2);
        roleD.setName(roleNameD);
        RoleDao.addOrUpdateRole(roleD);

        userC = new User();
        userC.setId(1);
        userC.setRoleId(roleid);
        userC.setNickname(login);
        userC.setPassword(password);
        UserDao.addOrUpdateUser(userC);

        userD = new User();
        userD.setId(2);
        userD.setRoleId(2);
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

        visit = new Visit();
        visit.setId(id);
        visit.setMedicalHistoryId(medical_history_id);
        visit.setOrderId(orderid);
        visit.setComplaints(complaints);
        visit.setDiagnosys(diagnosys);
        VisitDao.addOrUpdateVisit(visit);

        controller = new TreatmentController();
        controller.setTreatment(treatment);
        controller.setId(id);
        TreatmentDao.addOrUpdateTreatment(treatment);
    }

    @After
    public void tearDown() throws Exception {
        controller.delete();
        CureDao.deleteCure(id);
        OrderDao.deleteOrder(id);
        VisitDao.deleteVisit(id);
        MedicalHistoryDao.deleteMedicalHistory(id);
        DoctorDao.deleteDoctor(id);
        ClientDao.deleteClient(id);
        UserDao.deleteUser(1);
        UserDao.deleteUser(2);
        RoleDao.deleteRole(id);
        RoleDao.deleteRole(2);
        DepartmentDao.deleteDepartment(id);
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