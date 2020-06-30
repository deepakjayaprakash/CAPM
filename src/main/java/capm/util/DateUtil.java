package capm.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author ravi
 */
public class DateUtil {


    public static final String ISO_FORMAT_DATE = "yyyy-MM-dd";

    public static final TimeZone TZ_IST = TimeZone.getTimeZone("IST");

    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance(TZ_IST);
        return calendar.getTime();
    }

    public static Date getTodaysMidnight() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.setTimeZone(TZ_IST);
        return calendar.getTime();
    }

    public static int getDiffMonths(Date start, Date end) {

        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(start);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(end);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        return diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
    }

    public static int getDiffWeeks(Date start, Date end) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(start);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(end);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        return diffYear * 52 + endCalendar.get(Calendar.WEEK_OF_YEAR) - startCalendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static Long getDiffMinutes(Date start, Date end) {

        Long diff = start.getTime() - end.getTime();
        return diff / (60 * 1000) % 60;
    }

    public static Long getDiffSeconds(Date start, Date end) {

        long diff = start.getTime() - end.getTime();
        return diff / 1000 % 60;
    }

    public static Long getDiffHours(Date start, Date end) {
        long diffInMilliSec = start.getTime() - end.getTime();
        return  (diffInMilliSec / (1000 * 60 * 60));
    }

    
    public static Long getDiffDays(Date start, Date end) {

        Long diff = start.getTime() - end.getTime();
        return diff / (24 * 60 * 60 * 1000);
    }

    public static String getFormattedDate(Date date) {
        DateFormat dateDisplayFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
        return dateDisplayFormat.format(date);
    }

    public static String getFormattedDate(Date date, TimeZone tz) {
        DateFormat dateDisplayFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
        dateDisplayFormat.setTimeZone(tz);
        return dateDisplayFormat.format(date);
    }

    public static String getFormattedDateWithouttime(Date date) {
        DateFormat dateDisplayFormat = new SimpleDateFormat("dd MMMM yyyy");
        return dateDisplayFormat.format(date);
    }

    public static String convertDateToString(Date date) {
        return (date != null ? convertDateToString(date, ISO_FORMAT_DATE) : null);
    }

    public static String convertDateToString(Date date, String format, TimeZone timezone) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (timezone != null) {
            sdf.setTimeZone(timezone);
        }
        return sdf.format(date);
    }

    public static String convertDateToString(Date date, String format) {
        if (date != null) {
            return convertDateToString(date, format, null);
        }
        return null;
    }

    public static Date convertStringToDate(String date) throws ParseException {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(ISO_FORMAT_DATE);
            return sdf.parse(date);
        }
        return null;
    }

    public static Date convertStringToDate(String date, String format) throws ParseException {
        return convertStringToDate(date, format, null);
    }

    public static Date convertStringToDate(String date, String format, TimeZone timezone) throws ParseException {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            if (timezone != null) {
                sdf.setTimeZone(timezone);
            }
            return sdf.parse(date);
        }
        return null;
    }

    public static Date todayMidnightPlusDays(int days) {
        DateTime todayAtMidnight = new DateTime().withTimeAtStartOfDay();
        DateTime tomorrowAtMidnight = todayAtMidnight.plusDays(days);
        return tomorrowAtMidnight.toDate();
    }

    public static Date todayMidnightMinusDays(int days) {
        DateTime todayAtMidnight = new DateTime().withTimeAtStartOfDay();
        DateTime tomorrowAtMidnight = todayAtMidnight.minusDays(days);
        return tomorrowAtMidnight.toDate();
    }

    public static Date todayMidnightPlusDays(int days, TimeZone timezone) {
        DateTimeZone timeZone = DateTimeZone.forTimeZone(timezone);
        DateTime todayAtMidnight = new DateTime(timeZone).withTimeAtStartOfDay();
        DateTime tomorrowAtMidnight = todayAtMidnight.plusDays(days);
        return tomorrowAtMidnight.toDate();
    }

    public static Date todayMidnight(TimeZone timezone) {
        DateTimeZone timeZone = DateTimeZone.forTimeZone(timezone);
        DateTime todayAtMidnight = new DateTime(timeZone).withTimeAtStartOfDay();
        return todayAtMidnight.toDate();
    }

    public static Date todayMidnight() {
        DateTime todayAtMidnight = new DateTime().withTimeAtStartOfDay();
        return todayAtMidnight.toDate();
    }

    /**
     * @param date
     * @return date's or today's start time of the day
     */
    public static Date dateMidnight(Date date) {
        if (date != null) {
            DateTime todayAtMidnight = new DateTime(date).withTimeAtStartOfDay();
            return todayAtMidnight.toDate();
        }
        return null;
    }

    /**
     * date's midnight plus days, so returns that day's start of the day
     */
    public static Date dateMidnightPlusDays(Date date, int days) {
        if (date != null) {
            DateTime todayAtMidnight = new DateTime(date).withTimeAtStartOfDay();
            DateTime tomorrowAtMidnight = todayAtMidnight.plusDays(days);
            return tomorrowAtMidnight.toDate();
        }
        return null;
    }

    /**
     * date's midnight minus days, so returns that day's start of the day
     */
    public static Date dateMidnightMinusDays(Date date, int days) {
        if (date != null) {
            DateTime todayAtMidnight = new DateTime(date).withTimeAtStartOfDay();
            DateTime tomorrowAtMidnight = todayAtMidnight.minusDays(days);
            return tomorrowAtMidnight.toDate();
        }
        return null;
    }

    /**
     * @param date
     * @return date's or today's start time of the day
     */
    public static Date dateMidnight(Date date, TimeZone timezone) {
        if (date != null) {
            DateTimeZone timeZone = DateTimeZone.forTimeZone(timezone);
            DateTime todayAtMidnight = new DateTime(date, timeZone).withTimeAtStartOfDay();
            return todayAtMidnight.toDate();
        }
        return null;
    }

    public static Date dateMidnightPlusDays(Date date, TimeZone timezone, int days) {
        if (date != null) {
            DateTimeZone timeZone = DateTimeZone.forTimeZone(timezone);
            DateTime todayAtMidnight = new DateTime(date, timeZone).withTimeAtStartOfDay();
            DateTime tomorrowAtMidnight = todayAtMidnight.plusDays(days);
            return tomorrowAtMidnight.toDate();
        }
        return null;
    }
    
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }

    public static String getHumanTime(Date date) {
        return (date != null) ? convertDateToString(date, "dd MMM yyyy, hh:mm a") : "";
    }

    public static Date jodaLocalDateToDate(LocalDate localDate) {
        return localDate.toDateTimeAtStartOfDay().toDate();
    }

	public static Date getTodaysEndDateWithTime() {
		Calendar calendar = new GregorianCalendar();
		return DateUtils.addMilliseconds(DateUtils.ceiling(calendar.getTime(), Calendar.DATE), -1);
	}
	
	public static long getRemainingTimeInSecToEndOfToday() {
		Date now = new Date();
		return Math.abs(com.paytmmoney.mf.transaction.utils.DateUtil.getTodaysEndDateWithTime().getTime() - now.getTime()) / 1000;
	}
	
	public static Date getDayEndDateWithTime(Date date) {
		return DateUtils.addMilliseconds(DateUtils.ceiling(date, Calendar.DATE), -1);
	}

    public static LocalDate dateTojodaLocalDate(Date date) {
        if(date==null) return null;
        DateTime dt = new DateTime(date);
        return dt.toLocalDate();
    }
    
    public static String dateConverterSolr(java.time.LocalDate localDate) {
        String time = String.format("%s", localDate);
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat sdf = new SimpleDateFormat(ISO_FORMAT_DATE);
        Calendar cal = Calendar.getInstance();
        Date d = null;
        try {
            d = sdf.parse(time);
            cal.setTime(d);
            cal.add(Calendar.HOUR, -5);
            cal.add(Calendar.MINUTE, -30);
        } catch (ParseException e) {
            logger.error(" date parser failed {} ", time);
        }
        return output.format(cal.getTime());
    }
    
    public static Date atEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance(TZ_IST);
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
    /**
     * Get Date with minus given hours
     * @param hours
     * @return
     */
    public static Date getCurrentDateWIthMinusHours(int hours) {
    	LocalDateTime dateTime = new LocalDateTime().minusHours(hours);
    	return dateTime.toDate();
    }

    public static Date nowMinusHours(int hours) {
        DateTime now = new DateTime(getCurrentDate());
        DateTime dt = now.minusHours(hours);
        return dt.toDate();
    }

    public static String getFormattedDayWithOrdinal(Date date) {
        StringBuilder sb = new StringBuilder();
        Calendar calendar = Calendar.getInstance(TZ_IST);
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        sb.append(day);
        switch (day) {
            case 1:
            case 21:
            case 31:
                sb.append("st");
                break;
            case 2:
            case 22:
                sb.append("nd");
                break;
            case 3:
            case 23:
                sb.append("rd");
                break;
            default:
                sb.append("th");
                break;
        }

        return sb.toString();
    }

    public static boolean isPastDate(Date date) {
        Date now = new Date();
        return now.after(getDayEndDateWithTime(date));
    }
    
	public static Date addMonthToGivenDate(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}
}
