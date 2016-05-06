package dao;

import com.vetardim.DAO.*;
import com.vetardim.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScheduleDaoTest {
    private Schedule schedule;
    private int id = 1;
    private int doctorid = 1;
    private String workday = "bla";
    private long beginworkday = 11111111;
    private long endworkday = 111111111;
    private int room = 1;

    private User user;
    private int roleid = 1;
    private String login = "bla";
    private String password = "bla";

    private Role role;
    private String roleName = "bla";

    private Department department;
    private String departmentName = "bla";
    private String address = "bla";

    private Doctor doctor;
    private int userid = 1;
    private int departmentid = 1;
    private String firstname = "bla";
    private String secondname = "bla";
    private String lastname = "bla";
    private String qualification = "bla";
    private String speciality = "bla";
    private String phonenumber = "bla";
    private String email = "bla";

    @Before
    public void setUp() throws Exception {
        schedule = new Schedule();
        schedule.setId(id);
        schedule.setWorkday(workday);
        schedule.setDoctorId(doctorid);
        schedule.setBeginWorkday(beginworkday);
        schedule.setEndWorkday(endworkday);
        schedule.setRoom(room);

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
        DoctorDao.addOrUpdateDoctor(doctor);
    }

    @After
    public void tearDown() throws Exception {
        DoctorDao.deleteDoctor(id);
        UserDao.deleteUser(id);
        RoleDao.deleteRole(id);
        DepartmentDao.deleteDepartment(id);
    }

    @Test
    public void deleteSchedule() throws Exception {
        ScheduleDao.deleteSchedule(id);
    }

    @Test
    public void updateSchedule() throws Exception {
        ScheduleDao.addOrUpdateSchedule(schedule);
    }

    @Test
    public void addSchedule() throws Exception {
        ScheduleDao.addOrUpdateSchedule(schedule);
    }

    @Test
    public void getScheduleList() throws Exception {
        assertNotNull(ScheduleDao.getSchedulesList());
    }
}