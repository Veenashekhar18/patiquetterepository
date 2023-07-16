package Practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dateformat {

	public static void main(String[] args) {
		/*Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("YYYY-MM-dd");
		String fdata=s.format(d);
		System.out.println(fdata);
*/
		//to get date after 30days
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,30);
		Date data = cal.getTime();
		SimpleDateFormat s=new SimpleDateFormat("YYYY-MM-dd");
		String fdata=s.format(data);
		System.out.println(fdata);
	}

}
