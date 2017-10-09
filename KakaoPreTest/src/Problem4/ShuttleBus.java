package Problem4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ShuttleBus {
	
	private int runNum;
	private int runTime;
	private int peopleNum;
	private String[] peopleTime;
	

	public ShuttleBus(int n, int t, int m, String[] tt) {
		this.runNum = n;
		this.runTime = t;
		this.peopleNum = m;
		this.peopleTime = tt;
	}

	public void runFindLateTime() {
		
		String limitTime = getLimitTime();
		Bus[] buses = createBuses(limitTime);
	}

	private String getLimitTime() {
		
		String startTime = "09:00";
		String endTime = "23:59";
		String result ="";
		
		Calendar startCalendar = Calendar.getInstance();
		
		try {
			
			Date startDate = new SimpleDateFormat("HH:mm").parse(startTime);
 			Date limiteDate = new SimpleDateFormat("HH:mm").parse(endTime);
			
			startCalendar.setTime(startDate);
			
			if(startCalendar.getTime().getMinutes() + (runNum *runTime) < 60) {
				startCalendar.add(Calendar.MINUTE, runNum * runTime);
			}else {
				int hour = (startCalendar.getTime().getMinutes() + (runNum *runTime)) / 60;
				int min = (startCalendar.getTime().getMinutes() + (runNum *runTime)) % 60;
				
				startCalendar.add(Calendar.MINUTE, min);
				startCalendar.add(Calendar.HOUR, hour);
			}
			
			if(startCalendar.getTime().compareTo(limiteDate) >= 0) {
				result = new SimpleDateFormat("HH:mm").format(limiteDate);
			}
			
			result = new SimpleDateFormat("HH:mm").format(startCalendar.getTime());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	private Bus[] createBuses(String limstr) {
		
		ArrayList<Bus> tempBus = new ArrayList<>();
		
		try {
			
			Date date = new SimpleDateFormat("HH:mm").parse("09:00");
			Date limit = new SimpleDateFormat("HH:mm").parse(limstr);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			
			while( calendar.getTime().compareTo(limit) < 0) {
				String temp = new SimpleDateFormat("HH:mm").format(calendar.getTime());
				tempBus.add(new Bus(peopleNum, temp));
				
				if(calendar.getTime().getMinutes() + runTime < 60) {
					calendar.add(Calendar.MINUTE, runTime);
				}else {
					calendar.add(Calendar.HOUR, 1);
					calendar.add(Calendar.MINUTE, calendar.getTime().getMinutes()+runTime - 60);
				}
				
				System.out.println(temp);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return tempBus.toArray(new Bus[] {});
	}


	

}
