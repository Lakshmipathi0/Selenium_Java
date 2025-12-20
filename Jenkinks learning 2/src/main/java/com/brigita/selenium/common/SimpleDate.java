package com.brigita.selenium.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
public class SimpleDate {

	public static final String MONTHS[] = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	private static SimpleDateFormat timeStamp = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
	private Calendar calendar = Calendar.getInstance();   //is used to create a Calendar object that represents the current date and time The Calendar.getInstance() method returns an instance of the Calendar class that is set to the current system date and time, based on the default time zone and locale of the system.
	private int month = calendar.get(Calendar.MONTH);
	private int day = calendar.get(Calendar.DATE);
	private int year = calendar.get(Calendar.YEAR);
	private int hour = calendar.get(Calendar.HOUR_OF_DAY);
	private int minutes = calendar.get(Calendar.MINUTE);
	private int seconds = calendar.get(Calendar.SECOND);

	private static final String DATE_FORMAT = "MM/dd/yyyy";
	private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);

	public SimpleDate() {
	}

	public Calendar getCalendar() {   //This method returns the value of the calendar object.
		return calendar;       
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;   
		month = this.calendar.get(Calendar.MONTH);   //This line extracts the month from the Calendar object and stores it in the month variable of the class.
		day = this.calendar.get(Calendar.DATE);  // This line extracts the day of the month from the Calendar object and stores it in the day variable.
		year = this.calendar.get(Calendar.YEAR); //This line extracts the year from the Calendar object and stores it in the year variable.
	}

	public int getMonth() {  //It is used to retrieve the current month stored in the month variable.         
		return month;
	}

	public void setMonth(int month) {   //This is a method used to set or update the value of the month variable
		this.month = month;   //This line sets the class's month variable to the value that was passed into the method. It updates the current month with the new value provided by the user.
		calendar.set(Calendar.MONTH, month);  //This line updates the calendar object with the new month value. It changes the month of the calendar object to match the month value provided.
	}

	public int getDay() {  //It is used to retrieve the current date stored in the date variable.
		return day;
	}

	public void setDay(int day) {   //This is a method used to set or update the value of the date variable
		this.day = day;  // //This line sets the class's date variable to the value that was passed into the method. It updates the current date with the new value provided by the user.
		calendar.set(Calendar.DATE, day);//This line updates the calendar object with the new date value. It changes the date of the calendar object to match the date value provided.
	}

	public int getYear() {  //It is used to retrieve the current year stored in the year variable.
		return year;
	}

	public int getHour() {  ////It is used to retrieve the current hours stored in the hours variable.
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;  //This line sets the class's hours variable to the value that was passed into the method. It updates the current hour with the new value provided by the user.
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;  //This line sets the class's minits variable to the value that was passed into the method. It updates the current minits with the new value provided by the user.
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;      //This line sets the class's seconds variable to the value that was passed into the method. It updates the current seconds with the new value provided by the user.
	}

	public void setYear(int year) {   //This is a method used to set or update the value of the year variable
		this.year = year;
		calendar.set(Calendar.YEAR, year);
	}

	public SimpleDate advanceDay(int days) {  
		                                     // This line adds the specified number of days to the calendar object.
		calendar.add(Calendar.DATE, days);  //The calendar.add() method is part of the Calendar class. By passing Calendar.DATE and days, it adjusts the current date stored in calendar by adding the number of days given in days.
		day = calendar.get(Calendar.DATE);  //After advancing the date, the calendar.get(Calendar.DATE) method retrieves the updated day from the calendar object and assigns it to the day variable.
		return this;
	}

	public SimpleDate advanceMonth(int months) {
		calendar.add(Calendar.MONTH, months);
		month = calendar.get(Calendar.MONTH);
		return this;
	}

	public SimpleDate advanceYear(int years) {
		calendar.add(Calendar.YEAR, years);
		year = calendar.get(Calendar.YEAR);
		return this;
	}

	public String getMonthString() {
		return MONTHS[month];
	}

	public String toString(String format) {
		SimpleDateFormat simpleDate = new SimpleDateFormat(format);
		Date date = calendar.getTime();
		String dateString = simpleDate.format(date);
		return dateString;
	}

	public boolean isBefore(SimpleDate date) {  //This method checks if the current calendar date is before the date of the passed SimpleDate object.
		return calendar.before(date);  //The calendar.before() method returns true if the current date (calendar) is earlier than the SimpleDate object's date, and false otherwise.
	}

	public boolean isAfter(SimpleDate date) {
		return calendar.after(date);
	}

	public int compareTo(SimpleDate date) {     //This method compares the current calendar date to another SimpleDate object.
		return calendar.compareTo(date.getCalendar());  //The calendar.compareTo() method is part of the Calendar class and is used to compare two Calendar objects. It retrieves the Calendar from the passed SimpleDate object via date.getCalendar() and compares it to the current calendar.
	}

	public int compareCalendarTo(Calendar calendar) {  //This method compares the current calendar date to another Calendar object directly.
		return this.calendar.compareTo(calendar);  //It directly uses the compareTo() method to compare the current instance's calendar object with the passed Calendar object.
	}

	public static Object getTimestamp() {

		return timeStamp.format(new Date());  //This method generates a timestamp based on the current date and time and returns it as a formatted string.
	}

	@Deprecated
	public static String getAdvancedDate() {
		Date currentDate = new Date();
		System.out.println("date : " + dateFormat.format(currentDate));

		LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("localDateTime : " + dateFormat8.format(localDateTime));

		localDateTime = localDateTime.plusYears(0).plusMonths(0).plusDays(3);
		localDateTime = localDateTime.plusHours(1).plusMinutes(2).minusMinutes(1).plusSeconds(1);

		Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		return dateFormat.format(currentDatePlusOneDay);

	}

	public String getAdvancedDateDays(int days) {
		Date currentDate = new Date();
		System.out.println("date : " + dateFormat.format(currentDate));

		LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("localDateTime : " + dateFormat8.format(localDateTime));

		localDateTime = localDateTime.plusYears(0).plusMonths(0).plusDays(days);
		localDateTime = localDateTime.plusHours(1).plusMinutes(2).minusMinutes(1).plusSeconds(1);

		Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		return dateFormat.format(currentDatePlusOneDay);

	}

	/************************************************************
	 * This Method will return date as per user requirments
	 * 
	 * @author Mahesh
	 * @param format(dd/MM/yyyy
	 *            or MM/dd/yyyy),days,month,year
	 ************************************************************/
	public static String getAdvancedDate(String format, int days, int month, int year) {

		DateFormat dateFormat = new SimpleDateFormat(format);

		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2024/09/15 12:08:43

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.add(Calendar.DATE, days);
		c.add(Calendar.MONTH, month);
		c.add(Calendar.YEAR, year);
		Date currentDatePlusOne = c.getTime();
		return dateFormat.format(currentDatePlusOne);

	}
}
