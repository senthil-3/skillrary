package genericlibraries;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility {
	/*
	 * this calss contains reusable number within the limit
	 */

	public int generaterandomnum(int limit) {
		/*
		 * this method gets sysytem time in specified format
		 */
		Random random = new Random();
		return random.nextInt(limit);
	}
	
	public String getcurrenttime() {
		Date date = new Date(0);
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yy_hh_mm_sss");
		return sdf.format(date);
		
	}
}
