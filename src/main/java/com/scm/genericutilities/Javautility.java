package com.scm.genericutilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * contains java specific utility
 * @author veena
 *
 */
public class Javautility {
	Random random=new Random();
	Date dateobj=new Date();
	SimpleDateFormat sim= new SimpleDateFormat();
	/**
	 * gernerate random number within the limit 1000 for every invocation
	 * @return
	 */
	 public int getrandomnum()
	 {
		 int ranint =random.nextInt(1000);
		return ranint;
	 }
	 /**
	  * used get the system current date in "yyyy-MM-dd" format
	  * @param requireddatecount
	  * @return
	  */
	 public String getdate()
	 {
		 String date=sim.format(dateobj);
		return date;
	 }
	 /**
	  * used to get the required date in "yyyy-MM-dd"
	  * format required date count is positive number,it provides upcoming date based on numeric count given
	  *  format required date count is negative number,it provides previous date based on numeric count given
	  * @param requireddatecount
	  * @return
	  */
	 public String getdate(int requireddatecount)
	 {
		 Calendar cal=Calendar.getInstance();
		 cal.add(Calendar.DATE, requireddatecount);
		 Date date =cal.getTime();
		 String rdata=sim.format(date);
		return rdata;
		 
		 
	 }
}
