package goncharenko.GVV;

import goncharenko.GVV.utils.CurrentTime;
import goncharenko.GVV.utils.GenerateMassage;

/**
 * Created by Vitaliy on 30.11.2015.
 */
public class App {

    public static void main(String[] args) {
        GenerateMassage generateMassage = new GenerateMassage();
        int currentHour = CurrentTime.getCurrentHour();
        generateMassage.generateMessage(currentHour);
    }
}
