package calendar;


import org.junit.Test;
import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void caldaytest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 GregorianCalendar gcal = new GregorianCalendar(2018, 5, 21);
		 CalDay calday = new CalDay(gcal);
		 try{
 			for (int iteration = 0; iteration < 100; iteration++) {
 				long randomseed =System.currentTimeMillis(); //10
 	//			System.out.println(" Seed:"+randomseed );
 				Random random = new Random(randomseed);

				int startHourAny=ValuesGenerator.getRandomIntBetween(random, -12, 50);
				int startHourCorrect=ValuesGenerator.getRandomIntBetween(random, 1, 11);

				int startMinuteAny=ValuesGenerator.getRandomIntBetween(random, -1, 100);
				int startMinuteCorrect=ValuesGenerator.getRandomIntBetween(random, 1, 59);

				int startDayAny=ValuesGenerator.getRandomIntBetween(random, -1, 31);
				int startDayCorrect=ValuesGenerator.getRandomIntBetween(random, 1, 61);

				int startMonthAny=ValuesGenerator.getRandomIntBetween(random, -1, 20);
				int startMonthCorrect=ValuesGenerator.getRandomIntBetween(random, 1, 11);

				int startYearAny=ValuesGenerator.getRandomIntBetween(random, -2018, 2018);
				int startYearCorrect=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);

				String title="Birthday Party";
				String description="This is my birthday party.";
				String emailAddress="xyz@gmail.com";

				//Construct a new Appointment object with the initial data
				//Construct a new Appointment object with the initial data
					 Appt apptA = new Appt(startHourAny,
										 startMinuteAny ,
										 startDayAny ,
										 startMonthAny ,
										 startYearAny ,
										 title,
										 description,
										 emailAddress);
					 Appt apptB = new Appt(startHourCorrect,
										 startMinuteCorrect ,
										 21,
										 5 ,
										 2018,
										 title,
										 description,
										 emailAddress);
				apptA.setValid();
				apptB.setValid();

				 calday.addAppt(apptA);
				 calday.addAppt(apptB);

 				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
 			   System.out.println("elapsed time: "+ elapsed + "\t iteration " + iteration);

 			}
 		}catch(NullPointerException e){

 		}
	 }

}
