package controller;

import com.opensymphony.xwork2.Action;
import com.vetardim.DAO.*;
import com.vetardim.controller.AnalyseController;
import com.vetardim.controller.CureController;
import com.vetardim.controller.DepartmentController;
import com.vetardim.controller.DoctorController;
import com.vetardim.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorControllerTest {
    private DoctorController controller;
    private Doctor doctor;
    private int id = 1;
    private int userid = 1;
    private int departmentid = 1;
    private String firstname = "bla";
    private String secondname = "bla";
    private String lastname = "bla";
    private String qualification = "bla";
    private String speciality = "bla";
    private String phonenumber = "+375293338950";
    private String email = "bla@mail.ru";

    private User user;
    private int roleid = 1;
    private String login = "bla";
    private String password = "blaggggg";

    private Role role;
    private String roleName = "Doctor";

    private Department department;
    private String departmentName = "bla";
    private String address = "bla";

    @Before
    public void setUp() throws Exception {
        doctor = new Doctor();
        doctor.setId(id);
        doctor.setUserId(userid);
        doctor.setDepartmentId(departmentid);
        doctor.setFirstname(firstname);
        doctor.setLastname(lastname);
        doctor.setSecondname(secondname);
        doctor.setQualification(qualification);
        doctor.setSpeciality(speciality);
        doctor.setPhoneNumber(phonenumber);
        doctor.setEmail(email);

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

        department = new Department();
        department.setId(id);
        department.setName(departmentName);
        department.setAddress(address);
        DepartmentDao.addOrUpdateDepartment(department);

        controller = new DoctorController();
        controller.setDoctor(doctor);
        controller.setId(id);
        DoctorDao.addOrUpdateDoctor(doctor);
    }

    @After
    public void tearDown() throws Exception {
        controller.delete();
        UserDao.deleteUser(id);
        RoleDao.deleteRole(id);
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