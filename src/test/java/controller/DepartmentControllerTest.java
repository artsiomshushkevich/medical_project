package controller;

import com.opensymphony.xwork2.Action;
import com.vetardim.DAO.*;
import com.vetardim.controller.AnalyseController;
import com.vetardim.controller.CureController;
import com.vetardim.controller.DepartmentController;
import com.vetardim.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentControllerTest {
    private DepartmentController controller;
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

        controller = new DepartmentController();
        controller.setDepartment(department);
        controller.setId(id);
        DepartmentDao.addOrUpdateDepartment(department);
    }

    @After
    public void tearDown() throws Exception {
        controller.delete();
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