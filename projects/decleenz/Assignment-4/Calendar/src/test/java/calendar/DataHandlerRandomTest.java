package calendar;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void datahandlertest()  throws Throwable  {
		long randomseed =System.currentTimeMillis();
		Random random = new Random(randomseed);
		try{

			for(int i = 0; i < 100; i++){
				DataHandler dataHandler;
				boolean autosave = ValuesGenerator.getBoolean(.5f, random);
				dataHandler = new DataHandler("test.xml", autosave);
				int counter = 0;
				LinkedList<Appt> allappts = new LinkedList<Appt>();
				for(int iterations = 0; iterations < 100; iterations++){


					Calendar rightnow = Calendar.getInstance();
					int thisMonth = rightnow.get(Calendar.MONTH);
					int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
					int thisYear = rightnow.get(Calendar.YEAR);
					GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			 		GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay);
			 		tomorrow.add(today.DAY_OF_MONTH,1);
					CalDay calday = new CalDay(today);

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
											 thisDay ,
											 thisMonth ,
											 thisYear,
											 title,
											 description,
											 emailAddress);

						Appt apptC = new Appt(startHourCorrect,
											 startMinuteCorrect ,
						   				 thisDay+1 ,
											 thisMonth ,
											 thisYear,
											 title,
											 description,
											 emailAddress);

						apptA.setValid();
						apptB.setValid();
						apptC.setValid();
						calday.addAppt(apptA);
	 				  calday.addAppt(apptB);
						calday.addAppt(apptC);

						LinkedList<CalDay> calDays = new LinkedList<CalDay>();
						calDays = (LinkedList<CalDay>) dataHandler.getApptRange(today, tomorrow);
						allappts.add(apptA);
						allappts.add(apptB);
						allappts.add(apptC);
				}
				for(int k = 0; k < allappts.size(); k++){
					dataHandler.deleteAppt(allappts.get(k));
				}
			}
		}catch(NullPointerException e){

		}


	 	}




}
