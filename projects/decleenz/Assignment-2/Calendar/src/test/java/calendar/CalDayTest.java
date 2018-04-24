/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import java.util.GregorianCalendar;
import calendar.CalDay;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    GregorianCalendar gcal = new GregorianCalendar();
    CalDay calday00 = new CalDay(gcal);
    Appt appt0 = new Appt(15, 30, 23, 4, 2018, "do something", "do something", "email@gmail.com");
    calday00.addAppt(appt0);
    String string00 = calday00.getFullInfomrationApp(calday00);
    String string01 = calday00.toString();
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    GregorianCalendar gcal2 = new GregorianCalendar();
    CalDay calday01 = new CalDay(gcal2);
    Appt appt1 = new Appt(0, 9, 23, 4, 2018, "do something", "do something", "email@gmail.com");
    calday01.addAppt(appt1);
    String string10 = calday01.getFullInfomrationApp(calday01);
    String string11 = calday01.toString();
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable {
    CalDay calday02 = new CalDay();
    assertFalse(calday02.isValid());
    String string20 = calday02.toString();
  }

  @Test(timeout = 4000)
  public void test03() throws Throwable {
    GregorianCalendar gcal2 = new GregorianCalendar();
    CalDay calday01 = new CalDay(gcal2);
    Appt appt1 = new Appt(1, 19, 23, 4, 2018, "do something", "do something", "email@gmail.com");
    calday01.addAppt(appt1);
    Appt appt2 = new Appt(0, 9, 23, 4, 2018, "do something", "do something", "email@gmail.com");
    calday01.addAppt(appt2);
    String string10 = calday01.getFullInfomrationApp(calday01);
    String string11 = calday01.toString();
  }

}
