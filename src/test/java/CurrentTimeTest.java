import goncharenko.GVV.utils.CurrentTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.junit.Assert.assertEquals;


/**
 * Created by Vitaliy on 02.12.2015.
 */
public class CurrentTimeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentTimeTest.class);

    @Test
    public void getCurrentHourTEst() {
        int expectedHour = getHour(getCurrentTime());
        int actualHour = CurrentTime.getCurrentHour();
        assertEquals(expectedHour, actualHour);
        LOGGER.info("Current time is correct");
    }

    private String getCurrentTime(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Date currentDate = gregorianCalendar.getTime();
        DateFormat df = DateFormat.getTimeInstance(DateFormat.DEFAULT, Locale.getDefault());
        return df.format(currentDate);
    }
    private int getHour(String time){
        return Integer.valueOf(time.split(":")[0]);
    }
}
