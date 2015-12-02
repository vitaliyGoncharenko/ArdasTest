import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import goncharenko.GVV.utils.GenerateMassage;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

/**
 * Created by Vitaliy on 02.12.2015.
 */
public class GenerateMassageTest {

    private static Logger LOGGER = LoggerFactory.getLogger(GenerateMassageTest.class);

    private int hourForMorning = 6;
    private int hourForDay = 12;
    private int hourForEvening = 20;
    private int hourForNight = 2;

    @Test
    public void generateEnMessageMorningTest() {
        Locale.setDefault(Locale.ENGLISH);
        checkLogger(hourForMorning, "Good morning, World!");
    }

    @Test
    public void generateRusMessageMorningTest() {
        Locale.setDefault(new Locale("ru","RU"));
        checkLogger(hourForMorning, "Доброе утро, Мир!");
    }

    @Test
    public void generateEnMessageDayTest() {
        Locale.setDefault(Locale.ENGLISH);
        checkLogger(hourForDay, "Good day, World!");
    }
    @Test
    public void generateRusMessageDayTest() {
        Locale.setDefault(new Locale("ru","RU"));
        checkLogger(hourForDay, "Доброго дня, Мир!");
    }

    @Test
    public void generateEnMessageEveningTest() {
        Locale.setDefault(Locale.ENGLISH);
        checkLogger(hourForEvening, "Good evening, World!");
    }

    @Test
    public void generateRusMessageEveningTest() {
        Locale.setDefault(new Locale("ru","RU"));
        checkLogger(hourForEvening, "Доброго вечера, Мир!");
    }

    @Test
    public void generateEnMessageNightTest() {
        Locale.setDefault(Locale.ENGLISH);
        checkLogger(hourForNight, "Good night, World!");
    }

    @Test
    public void generateRusMessageNightTest() {
        Locale.setDefault(new Locale("ru","RU"));
        checkLogger(hourForNight, "Доброй ночи, Мир!");
    }


    private void checkLogger(int hour, final String expectedMessage){
        ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
        final Appender mockAppender = mock(Appender.class);
        when(mockAppender.getName()).thenReturn("MOCK");
        root.addAppender(mockAppender);

        //... do whatever you need to trigger the log
        GenerateMassage.generateMessage(hour);

        verify(mockAppender).doAppend(argThat(new ArgumentMatcher() {
            public boolean matches(final Object argument) {
                return ((LoggingEvent)argument).getFormattedMessage().contains(expectedMessage);
            }
        }));

        LOGGER.info("Test message "+"\""+expectedMessage+"\""+" - is complete");
    }
}
