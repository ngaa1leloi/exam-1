package Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateNumber {
	public static void countDayBetweenTwoTimes(String startDate, String closeDate) {
		long totalDays = 0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date1 = dateFormat.parse(startDate);
			Date date2 = dateFormat.parse(closeDate);
			totalDays = TimeUnit.MILLISECONDS.toDays(date2.getTime() - date1.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Tổng số ngày giữa " + startDate + " và " + closeDate + ": " + totalDays);
	}

	public static void plusMonth(String startDate, int difMonth) {
		int year = Integer.parseInt(startDate.substring(0, 4));
		int month = Integer.parseInt(startDate.substring(5, 6));
		int day = Integer.parseInt(startDate.substring(6));
		int[] numberOfDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (year % 4 == 0)
			numberOfDays[1] = 29;
		for (int i = 1; i <= difMonth; i++) {
			month++;
			if (month > 12) {
				month = 1;
				year++;
				if (year % 4 == 0) {
					numberOfDays[1] = 29;
				} else
					numberOfDays[1] = 28;
			}
			if (month == 1) {
				day = day - numberOfDays[11] + numberOfDays[0];
			} else {
				day = day - numberOfDays[month - 2] + numberOfDays[month - 1];
			}
		}
		String dayStr = (day < 10) ? ("0" + Integer.toString(day)) : Integer.toString(day);
		String monthStr = (month < 10) ? ("0" + Integer.toString(month)) : Integer.toString(month);

		String endDate = Integer.toString(year).concat(monthStr).concat(dayStr);

		System.out.println("Ngày " + startDate + " cộng thêm " + difMonth + " tháng là: " + endDate);
	}

	public static void main(String[] args) {
		countDayBetweenTwoTimes("20170202", "20170331");
		plusMonth("20160229", 13);
	}
}
