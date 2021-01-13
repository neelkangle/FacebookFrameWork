package facebook.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gettimestamp {

	public static String getcurrenttimestamp()
	{
		DateFormat CustomDateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate = new Date();
		
		return CustomDateFormat.format(currentdate);
	}
}
