package dao;

import com.vetardim.DAO.DepartmentDao;
import com.vetardim.DAO.DoctorDao;
import com.vetardim.DAO.RoleDao;
import com.vetardim.DAO.UserDao;
import com.vetardim.model.Department;
import com.vetardim.model.Doctor;
import com.vetardim.model.Role;
import com.vetardim.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorDaoTest {
    private Doctor doctor;
    private int id = 1;
    private int userid = 1;
    private int departmentid = 1;
    private String firstname = "bla";
    private String secondname = "bla";
    private String lastname = "bla";
    private String qualification = "bla";
    private String speciality = "bla";
    private String phonenumber = "bla";
    private String email = "bla";

    private User user;
    private int roleid = 1;
    private String login = "bla";
    private String password = "bla";

    private Role role;
    private String roleName = "bla";

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
    }

    @After
    public void tearDown() throws Exception {
        UserDao.deleteUser(id);
        RoleDao.deleteRole(id);
        DepartmentDao.deleteDepartment(id);
    }

    @Test
    public void deleteDoctor() throws Exception {
        DoctorDao.deleteDoctor(id);
    }

    @Test
    public void updateDoctor() throws Exception {
        DoctorDao.addOrUpdateDoctor(doctor);
    }

    @Test
    public void addDoctor() throws Exception {
        DoctorDao.addOrUpdateDoctor(doctor);
    }

    @Test
    public void getDoctorList() throws Exception {
        assertNotNull(DoctorDao.getDoctorsList());
    }
}