package util;

import com.vetardim.util.UnixTimeConverter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

public class UnixTimeConverterTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void timeToUnixTime() throws Exception {
        UnixTimeConverter.convertTimeToUnixTime("03:00","hh:mm");
    }

    @Test
    public void UnixTimeToTime() throws Exception {
        UnixTimeConverter.convertUnixTimeToTime(28800,"hh:mm");
    }

}