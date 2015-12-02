package goncharenko.GVV.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class CurrentTime {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentTime.class);

    public static int getCurrentHour() {
        Locale local = Locale.getDefault();
        DateFormat df = DateFormat.getTimeInstance(DateFormat.DEFAULT, local);
        Date currentDate = new Date();
        String currentTime = df.format(currentDate);
        LOGGER.info("Current time - " +currentTime);
        return getHour(currentTime);
    }

    private static int getHour(String time) {
        String[] array = time.split(":");
        String hour = array[0];
        return Integer.valueOf(hour);
    }
}
