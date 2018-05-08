/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      appt0.setValid();
      assertEquals(true, appt0.isOn(9, 9, 2018));
      assertEquals(false, appt0.isOn(8, 15, 2020));
      assertTrue(appt0.hasTimeSet());
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t9/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      
      assertEquals(15, appt0.getStartHour());
      assertEquals(30, appt0.getStartMinute());
      assertEquals(9, appt0.getStartDay());
      assertEquals(9, appt0.getStartMonth());
      assertEquals(2018, appt0.getStartYear());
      assertEquals("Birthday Party", appt0.getTitle());
      assertEquals("This is my birthday party", appt0.getDescription());
      assertEquals("xyz@gmail.com", appt0.getEmailAddress());
      assertTrue(appt0.getValid());
      assertTrue(appt0.hasTimeSet());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    Appt appt1 = new Appt(2,2,2, 2, 2, "My Birthday", "Today is my birthday", "abc@gmail.com");
    appt1.setValid();
    String string1 = appt1.toString();
    assertEquals(2, appt1.getStartDay());
    assertEquals("My Birthday", appt1.getTitle());
    assertEquals("Today is my birthday", appt1.getDescription());
    assertEquals("abc@gmail.com", appt1.getEmailAddress());
    assertTrue(appt1.getValid());
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable {
    Appt appt2 = new Appt(0, 30, 23, 4, 2018, "Assignment 2 is due", "Due date for CS362 Assignment 2", "myemail@gmail.com");
    appt2.setValid();
    String string2 = appt2.toString();
    assertEquals(2, appt2.getRecurBy());
    assertFalse(appt2.isRecurring());
    assertEquals("\t4/23/2018 at 12:30am ,Assignment 2 is due, Due date for CS362 Assignment 2\n", string2);
    assertTrue(appt2.getValid());
  }

  @Test(timeout = 4000)
  public void test03() throws Throwable {
    Appt appt3 = new Appt(9999, 30, 10, 4, 2018, "test1", "test1", "test1");
    Appt appt4 = new Appt(10, 9999, 2, 4, 2018, "test1", "test1", "test1");
    Appt appt5 = new Appt(12, 40, 9999, 9, 2018, "test1", "test1", "test1");
    Appt appt6 = new Appt(20, 45, 10, 9999, 2018, "test1", "test1", "test1");
    Appt appt7 = new Appt(10, 30, 10, 4, 0,     "test1", "test1", "test1");
    Appt appt8 = new Appt(10, 30, 10, 4, 2018,  null     , "test1", "test1");
    Appt appt9 = new Appt(10, 30, 10, 4, 2018,  "test1", null     , "test1");
    Appt appt10 = new Appt(10, 30, 10, 4, 2018, "test1", "test1", null);
    appt3.setValid();
    appt4.setValid();
    appt5.setValid();
    appt6.setValid();
    appt7.setValid();
    assertFalse(appt3.getValid());
    assertFalse(appt4.getValid());
    assertFalse(appt5.getValid());
    assertFalse(appt6.getValid());
    assertFalse(appt7.getValid());
    
    assertEquals(9999, appt3.getStartHour());
    assertEquals(10, appt4.getStartHour());
    assertEquals(12, appt5.getStartHour());
    assertEquals(20, appt6.getStartHour());
    
    assertEquals(30, appt3.getStartMinute());
    assertEquals(9999, appt4.getStartMinute());
    assertEquals(40, appt5.getStartMinute());
    assertEquals(45, appt6.getStartMinute());
    
    assertEquals(10, appt3.getStartDay());
    assertEquals(2, appt4.getStartDay());
    assertEquals(9999, appt5.getStartDay());
    
    assertEquals(4, appt3.getStartMonth());
    assertEquals(9, appt5.getStartMonth());
    assertEquals(9999, appt6.getStartMonth());
    
    assertNotNull(appt8.getTitle());
    assertNotNull(appt9.getDescription());
    assertNotNull(appt10.getEmailAddress());
    assertEquals("", appt8.getTitle());
    assertEquals("", appt9.getDescription());
    assertEquals("", appt10.getEmailAddress());
  }
  
  @Test(timeout = 4000)
  public void test04() throws Throwable {
    Appt apt1 = new Appt(2, 2, 2, 2, 2, "abc", "abcd", "abcde");
    Appt apt2 = new Appt(2, 2, 2, 2, 2, "bca", "abcd", "notABCDE");
    Appt apt3 = new Appt(2, 2, 2, 2, 2, "ccc", "abcd", "notABCDE");
    Appt apt4 = new Appt(2, 3, 4, 5, 6, "ddd", "easyas", "123");
    
    
    assertNotSame(apt1, apt2);
    assertNotSame(apt4, apt2);
    assertSame(apt4, apt4);
    assertSame(apt2, apt2);
    
    assertEquals("abc", apt1.getTitle());
    assertEquals("bca", apt2.getTitle());
    assertEquals("ccc", apt3.getTitle());
    assertEquals("ddd", apt4.getTitle());
  }

}
