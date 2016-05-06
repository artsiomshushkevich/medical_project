package dao;

import com.vetardim.DAO.DepartmentDao;
import com.vetardim.model.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentDaoTest {
    private Department department;
    private int id = 1;
    private String name = "bla";
    private String address = "bla";

    @Before
    public void setUp() throws Exception {
        department = new Department();
        department.setId(id);
        department.setName(name);
        department.setAddress(address);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void deleteDepartment() throws Exception {
        DepartmentDao.deleteDepartment(id);
    }

    @Test
    public void updateDepartment() throws Exception {
        DepartmentDao.addOrUpdateDepartment(department);
    }

    @Test
    public void addDepartment() throws Exception {
        DepartmentDao.addOrUpdateDepartment(department);
    }

    @Test
    public void getDepartmentList() throws Exception {
        assertNotNull(DepartmentDao.getDepartmentsList());
    }
}