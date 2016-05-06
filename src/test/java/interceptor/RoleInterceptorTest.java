package interceptor;

import com.vetardim.interceptor.RoleInterceptor;
import org.hibernate.mapping.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class RoleInterceptorTest {
    private RoleInterceptor interceptor;
    private String listRole;

    @Before
    public void setUp() throws Exception {
        interceptor = new RoleInterceptor();
        listRole = "Admin,Client";
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void handleRejection() throws Exception {
        assertEquals("invalidAdminAccess",interceptor.handleRejection(null,null));
    }

    @Test
    public void stringToList() throws Exception {
        assertNotEquals(Collections.EMPTY_LIST,interceptor.stringToList(listRole));
    }

}