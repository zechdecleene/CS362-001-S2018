/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import java.util.GregorianCalendar;
import java.util.*;
import calendar.CalDay;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    GregorianCalendar gcal = new GregorianCalendar();
    CalDay calday00 = new CalDay(gcal);
    Appt appt0 = new Appt(15, 45, 9, 9, 2018, "do something", "do something", "email@gmail.com");
    Appt appt1 = new Appt(15, 5, 15, 15, 15, "15", "15", "15");
    Appt appt2 = new Appt(15, 30, 9, 9, 2018, "do something", "do something", "email@gmail.com");
    Appt appt3 = new Appt(9, 9, 2018, "do something", "do something", "email@gmail.com");
    Appt appt4 = new Appt(4, 30, 10, 9, 2018, "do something", "do something", "email@gmail.com");
    Appt appt5 = new Appt(9, 12, 2018, "do something", "do something", "email@gmail.com");
    calday00.addAppt(appt0);
    calday00.addAppt(appt1);
    calday00.addAppt(appt2);
    calday00.addAppt(appt4);
    calday00.addAppt(appt3);
    calday00.addAppt(appt5);
    String string00 = calday00.getFullInfomrationApp(calday00);
    String string000 = calday00.getFullInfomrationApp(calday00);
    String string01 = calday00.toString();
    String string02 = calday00.toString();
    assertEquals(string000, string00);
    assertEquals(string02, string01);
    assertTrue(calday00.isValid());

    assertEquals(15, appt0.getStartHour());
    assertEquals(45, appt0.getStartMinute());
    assertEquals(9, appt0.getStartDay());
    assertEquals(9, appt0.getStartMonth());
    assertEquals(2018, appt0.getStartYear());
    assertEquals("do something", appt0.getTitle());
    assertEquals("do something", appt0.getDescription());
    assertEquals("email@gmail.com", appt0.getEmailAddress());
    assertTrue(appt0.getValid());
    assertTrue(appt0.hasTimeSet());

    assertEquals(15, appt1.getStartHour());
    assertEquals(5, appt1.getStartMinute());
    assertEquals(15, appt1.getStartDay());
    assertEquals(15, appt1.getStartMonth());
    assertEquals(15, appt1.getStartYear());
    assertEquals("15", appt1.getTitle());
    assertEquals("15", appt1.getDescription());
    assertEquals("15", appt1.getEmailAddress());



    assertEquals(6, calday00.getSizeAppts());
    assertEquals(7, calday00.getDay());
    assertEquals(4, calday00.getMonth());
    assertEquals(2018, calday00.getYear());

    assertNotNull(calday00.toString());
    assertNotNull(string00);
    assertNotNull(string000);
    assertNotNull(string01);
    assertNotNull(string02);

    Iterator itr = calday00.iterator();

    String buffer;
    buffer = Integer.toString(((CalDay)calday00).getMonth())+ "-";
    buffer += Integer.toString(((CalDay)calday00).getDay())+ "-";
    buffer += Integer.toString(((CalDay)calday00).getYear())+ " ";

    Appt appointment;

    int minute;
    int hour;
    String minString;
    String meridianString;

    //go through the day and get the data to display
    while(itr.hasNext()){

      buffer += "\n\t";

      appointment = (Appt)itr.next();

  if(appointment.hasTimeSet()){

    //figure AM/PM notation
    hour = appointment.getStartHour();
    if(hour>12){
      meridianString = "PM";
    }
    else{
      meridianString = "AM";
    }

    //convert from 24 to 12 hour time
    if(hour == 0){
      hour = 12;
    }
    else{
      hour = hour%12;
    }

    //add preceding zero to minutes less than 10
    minute = appointment.getStartMinute();
    if(minute < 10){
      minString = new String("0" + Integer.toString(minute));
    }
    else{
      minString = Integer.toString(minute);
    }

    //create the string containing a data summary
    buffer += hour + ":" + minString + meridianString + " ";

  }
    buffer += appointment.getTitle()+ " ";
    buffer += appointment.getDescription()+ " ";


    }







    assertEquals(buffer, string00);

  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    GregorianCalendar gcal2 = new GregorianCalendar();
    CalDay calday01 = new CalDay(gcal2);
    Appt appt1 = new Appt(0, 9, 23, 4, 2018, "do something", "do something", "email@gmail.com");
    calday01.addAppt(appt1);
    String string10 = calday01.getFullInfomrationApp(calday01);
    String string11 = calday01.toString();

    assertNotNull(calday01.iterator());
    assertNotNull(calday01.getAppts());

    assertEquals(1, calday01.getSizeAppts());
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable {
    CalDay calday02 = new CalDay();
    assertFalse(calday02.isValid());
    assertNull(calday02.iterator());
    String string20 = calday02.toString();
    assertNotNull(calday02.toString());

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
