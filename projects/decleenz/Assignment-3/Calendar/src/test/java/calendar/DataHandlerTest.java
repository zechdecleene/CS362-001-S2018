
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    DataHandler datahandler00 = new DataHandler();
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    DataHandler datahandler01 = new DataHandler("testFileName");
  }
  @Test(timeout = 4000)
  public void test02() throws Throwable {
    DataHandler dataHandler;
		dataHandler = new DataHandler();
    GregorianCalendar today = new GregorianCalendar();
    GregorianCalendar tomorrow = new GregorianCalendar();
    Appt newappt1 = new Appt(0, 9, 23, 3, 2018, "smthn", "smthn", "smthn");
    Appt newappt2 = new Appt(16, 20, 23, 3, 2018, "nthn", "nthn", "nthn");
    Appt newappt3 = new Appt(12, 23, 24, 4, 2018, "str", "srt", "asd");
    Appt newappt4 = new Appt(1022, 23, 204, 123, 0, "str", "srt", "asd");
    int[] recurdayz;
    recurdayz = new int[20];
    for(int i = 0; i < 20; i++){
      recurdayz[i] = i;
    }
    int[] nullist;
    nullist = new int[0];
    newappt1.setRecurrence(recurdayz, 1, 1, 1);
    newappt2.setRecurrence(nullist, 3, 10, 10);
    newappt3.setRecurrence(null, 1, 1, 1);
    newappt4.setRecurrence(recurdayz, 2, 2, 2);
    tomorrow.add(today.DAY_OF_MONTH,1);


          //Create a linked list of calendar days to return
          LinkedList<CalDay> calDays = new LinkedList<CalDay>();
          assertTrue(dataHandler.saveAppt(newappt3));
          dataHandler.saveAppt(newappt2);
          assertTrue(dataHandler.saveAppt(newappt1));
          assertTrue(dataHandler.saveAppt(newappt4));
      calDays = (LinkedList<CalDay>) dataHandler.getApptRange(today,tomorrow);
      assertNotNull(calDays);

      for (int i = 0; i < calDays.size(); i++){

        CalDay calday= calDays.get(i);

        String str= calday.getFullInfomrationApp(calday);

        LinkedList<Appt>  appts =calDays.get(i).getAppts();
        for(int index=0; index < appts.size();index++){
          Appt appt_=appts.get(index);
        }
      }
      assertTrue(dataHandler.save());

      assertTrue(dataHandler.deleteAppt(newappt2));
      assertTrue(dataHandler.deleteAppt(newappt1));
      assertTrue(dataHandler.deleteAppt(newappt3));
      assertTrue(dataHandler.deleteAppt(newappt4));
  }

  @Test(timeout = 4000)
  public void test03() throws Throwable {
    DataHandler dataHandler;
		dataHandler = new DataHandler();
    GregorianCalendar today = new GregorianCalendar();
    GregorianCalendar tomorrow = new GregorianCalendar();
    Appt newappt1 = new Appt(0, 9, 23, 3, 2018, "smthn", "smthn", "smthn");
    Appt newappt2 = new Appt(16, 20, 23, 3, 2018, "nthn", "nthn", "nthn");
    Appt newappt3 = new Appt(12, 23, 24, 4, 2018, "str", "srt", "asd");
    Appt badapt1 = new Appt(130, 130, 130, 130, 0, "strs", "bsads", "basa");
    Appt badapt2 = new Appt(130, 130, 130, 130, 0, "strs", "bsads", "basa");
    Appt badapt3 = new Appt(130, 130, 130, 130, 0, "strs", "bsads", "basa");
    badapt1.setValid();
    badapt2.setValid();
    badapt3.setValid();
    int[] recurdayz;
    recurdayz = new int[20];
    for(int i = 0; i < 20; i++){
      recurdayz[i] = i;
    }
    newappt1.setRecurrence(recurdayz, 1, 5, 7);
    newappt3.setRecurrence(null, 2, 0, 0);
    tomorrow.add(today.DAY_OF_MONTH,1);

    // assertNotNull(newappt2.getXmlElement());


          //Create a linked list of calendar days to return
          LinkedList<CalDay> calDays = new LinkedList<CalDay>();
          assertTrue(dataHandler.saveAppt(newappt3));
          assertTrue(dataHandler.saveAppt(newappt2));
          assertTrue(dataHandler.saveAppt(newappt1));
          assertFalse(dataHandler.saveAppt(badapt1));
          assertTrue(dataHandler.deleteAppt(newappt2));
          assertFalse(dataHandler.deleteAppt(badapt1));
          assertFalse(dataHandler.deleteAppt(badapt2));

      calDays = (LinkedList<CalDay>) dataHandler.getApptRange(today,tomorrow);



      for (int i = 0; i < calDays.size(); i++){

        CalDay calday= calDays.get(i);

        String str= calday.getFullInfomrationApp(calday);

        LinkedList<Appt>  appts =calDays.get(i).getAppts();
        for(int index=0; index < appts.size();index++){
          Appt appt_=appts.get(index);
          assertNotNull(appt_);
        }
      }

  }




}
