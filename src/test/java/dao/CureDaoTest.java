package dao;

import com.vetardim.DAO.CureDao;
import com.vetardim.model.Cure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CureDaoTest {
    private Cure cure;
    private int id = 1;
    private String name = "bla";

    @Before
    public void setUp() throws Exception {
        cure = new Cure();
        cure.setId(id);
        cure.setName(name);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void deleteCure() throws Exception {
        CureDao.deleteCure(id);
    }

    @Test
    public void updateCure() throws Exception {
        CureDao.addOrUpdateCure(cure);
    }

    @Test
    public void addCure() throws Exception {
        CureDao.addOrUpdateCure(cure);
    }

    @Test
    public void getCureList() throws Exception {
        assertNotNull(CureDao.getCuresList());
    }
}