package goncharenko.GVV.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

public class GenerateMassage {

    private static Logger LOGGER = LoggerFactory.getLogger(GenerateMassage.class);

    public static void generateMessage(int currentHour) {
        if (currentHour >= 6 && currentHour <= 8) {
            printGreeting("morning");

        } else if (currentHour >= 9 && currentHour <= 18) {
            printGreeting("day");

        } else if (currentHour >= 19 && currentHour <= 22) {
            printGreeting("evening");

        } else if ((currentHour >= 0 && currentHour <= 5) || currentHour == 23) {
            printGreeting("night");
        }
    }

    private static void printGreeting(String msg) {
        ResourceBundle enResourceBundle = ResourceBundle.getBundle("Message");
        LOGGER.info(enResourceBundle.getString(msg));
    }
}
