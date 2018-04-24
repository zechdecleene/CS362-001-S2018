/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt0.setValid();
      assertEquals(true, appt0.isOn(9, 14, 2018));
      assertEquals(false, appt0.isOn(8, 15, 2020));
      assertTrue(appt0.hasTimeSet());
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      assertTrue(appt0.getValid());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    Appt appt1 = new Appt(320, 310, 2, "My Birthday", "Today is my birthday", "abc@gmail.com");
    appt1.setValid();
    String string1 = appt1.toString();
    assertFalse(appt1.hasTimeSet());
    assertEquals(320, appt1.getStartDay());
    assertEquals("My Birthday", appt1.getTitle());
    assertEquals("Today is my birthday", appt1.getDescription());
    assertEquals("abc@gmail.com", appt1.getEmailAddress());
    assertEquals(false,appt1.getValid());
    assertEquals("\tThis appointment is not valid\n", string1);
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable {
    Appt appt2 = new Appt(0, 30, 23, 4, 2018, "Assignment 2 is due", "Due date for CS362 Assignment 2", "myemail@gmail.com");
    appt2.setValid();
    String string2 = appt2.toString();
    assertEquals(2, appt2.getRecurBy());
    assertFalse(appt2.isRecurring());
    assertEquals("\t4/23/2018 at 12:30am ,Assignment 2 is due, Due date for CS362 Assignment 2\n", string2);
  }

  @Test(timeout = 4000)
  public void test03() throws Throwable {
    Appt appt3 = new Appt(100, 30, 23, 4, 2018, "test1", "test1", "test1");
    Appt appt4 = new Appt(10, 300, 23, 4, 2018, "test1", "test1", "test1");
    Appt appt5 = new Appt(10, 30, 230, 4, 2018, "test1", "test1", "test1");
    Appt appt6 = new Appt(10, 30, 23, 40, 2018, "test1", "test1", "test1");
    Appt appt7 = new Appt(10, 30, 23, 4, 0,     "test1", "test1", "test1");
    Appt appt8 = new Appt(10, 30, 23, 4, 2018,  null     , "test1", "test1");
    Appt appt9 = new Appt(10, 30, 23, 4, 2018,  "test1", null     , "test1");
    Appt appt10 = new Appt(10, 30, 23, 4, 2018, "test1", "test1", null);
    appt3.setValid();
    appt4.setValid();
    appt5.setValid();
    appt6.setValid();
    appt7.setValid();
  }

}
