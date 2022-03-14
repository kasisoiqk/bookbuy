package com.laptrinhjavaweb.utils;

import java.util.Date;

public class FormatTimeUtils {

	@SuppressWarnings("deprecation")
	public static String convertTime(Date oldTime) {
		Date currentTime = new Date();
		int year = currentTime.getYear()-oldTime.getYear();
		int month = currentTime.getMonth()-oldTime.getMonth();
		int day = currentTime.getDate()-oldTime.getDate();
		int hour = currentTime.getHours()-oldTime.getHours();
		int minute = currentTime.getMinutes()-oldTime.getMinutes();
		
		boolean isRun = true;
		while(isRun) {
			isRun = false;
			if(month < 0) {
				month += 12;
				year--;
				isRun = true;
			}
			if(day < 0) {
				day += dayOfMonth(month, year);
				month--;
				isRun = true;
			}
			if(hour < 0) {
				hour += 24;
				day--;
				isRun = true;
			}
			if(minute < 0) {
				minute += 60;
				hour--;
				isRun = true;
			}
		}
		
		return (year > 0) ? year + " năm" : (month > 0) ? month + " tháng" : (day >= 7) ? day/7 + " tuần" :
			(day > 0) ? day + " ngày" : (hour > 0) ? hour + " giờ" : (minute > 0) ? minute + " phút" : "0";
	}
	
	public static int dayOfMonth(int month, int year) {
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			return 31;
		case 2:
			return (year%400 == 0 || (year%4 == 0 && year%100 != 0)) ? 29 : 28;
		case 4: case 6: case 9: case 11:
			return 30;

		default:
			return -1;
		}
	}
	
}
