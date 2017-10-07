package com.lzw.atmm.tsd.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
/**
 * 
 * 版权所有：2016-中实智达
 * 项目名称：zsda-Manager   
 * 类描述：日期工具类
 * 类名称：cn.hong.ssm.common.util.DateFormatUtil     
 * 创建人：杨洪
 * 创建时间：2016年6月21日 下午4:11:10   
 * 修改人：
 * 修改时间：2016年6月21日 下午4:11:10   
 * 修改备注：   
 * @version   V1.0
 */
public class DateFormatUtil {

	/**
	 * 获取 当前年、半年、季度、月、日、小时 开始结束时间
	 */
	private static SimpleDateFormat shortSdf;
	private static SimpleDateFormat longHourSdf;
	private static SimpleDateFormat longMinuteSdf;
	private static SimpleDateFormat longSdf;

	static {
		shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
		longMinuteSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获得本周的第一天，周一
	 * 
	 * @return
	 */
	public static Date getCurrentWeekDayStartTime() {
		Calendar c = Calendar.getInstance();
		try {
			int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
			c.add(Calendar.DATE, -weekday);
			c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 获得本周的最后一天，周日
	 * 
	 * @return
	 */
	public static Date getCurrentWeekDayEndTime() {
		Calendar c = Calendar.getInstance();
		try {
			int weekday = c.get(Calendar.DAY_OF_WEEK);
			c.add(Calendar.DATE, 8 - weekday);
			c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c.getTime();
	}

	/**
	 * 获得本天的开始时间，即2015-01-01 00:00:00
	 * 
	 * @return
	 */
	public static Date getCurrentDayStartTime() {
		Date now = new Date();
		try {
			now = shortSdf.parse(shortSdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本天的结束时间，即2015-01-01 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentDayEndTime() {
		Date now = new Date();
		try {
			now = longSdf.parse(shortSdf.format(now) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本小时的开始时间，即2015-01-01 12:00:00
	 * 
	 * @return
	 */
	public static Date getCurrentHourStartTime() {
		Date now = new Date();
		try {
			now = longHourSdf.parse(longHourSdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本小时的结束时间，即2015-01-01 12:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentHourEndTime() {
		Date now = new Date();
		try {
			now = longSdf.parse(longHourSdf.format(now) + ":59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获得本月的开始时间，即2015-01-01 00:00:00
	 * 
	 * @return
	 */
	public static Date getCurrentMonthStartTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.set(Calendar.DATE, 1);
			now = shortSdf.parse(shortSdf.format(c.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前月的结束时间，即2012-01-31 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentMonthEndTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.set(Calendar.DATE, 1);
			c.add(Calendar.MONTH, 1);
			c.add(Calendar.DATE, -1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 基本功能:返回date所在月的最后一天
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date getDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.setTime(date);
			c.set(Calendar.DATE, 1);
			c.add(Calendar.MONTH, 1);
			c.add(Calendar.DATE, -1);

			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 基本功能:获得某个月的最后一天
	 * 
	 * @param date
	 * @return int
	 */
	public static int getLastMonthDay(Date date) {
		Calendar c = Calendar.getInstance();
		int day = 0;
		try {
			c.setTime(date);
			c.set(Calendar.DATE, 1);
			c.add(Calendar.MONTH, 1);
			c.add(Calendar.DATE, -1);
			day = c.get(Calendar.DATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day;
	}

	/**
	 * 当前年的开始时间，即2015-01-01 00:00:00
	 * 
	 * @return
	 */
	public static Date getCurrentYearStartTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.set(Calendar.MONTH, 0);
			c.set(Calendar.DATE, 1);
			now = shortSdf.parse(shortSdf.format(c.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前年的结束时间，即2015-12-31 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentYearEndTime() {
		Calendar c = Calendar.getInstance();
		Date now = null;
		try {
			c.set(Calendar.MONTH, 11);
			c.set(Calendar.DATE, 31);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前季度的开始时间，即2015-01-1 00:00:00
	 * 
	 * @return
	 */
	public static Date getCurrentQuarterStartTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				c.set(Calendar.MONTH, 0);
			else if (currentMonth >= 4 && currentMonth <= 6)
				c.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				c.set(Calendar.MONTH, 4);
			else if (currentMonth >= 10 && currentMonth <= 12)
				c.set(Calendar.MONTH, 9);
			c.set(Calendar.DATE, 1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前季度的结束时间，即2012-03-31 23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrentQuarterEndTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				c.set(Calendar.MONTH, 2);
				c.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				c.set(Calendar.MONTH, 8);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获取当前时间季度开始与结束月份
	 * 
	 * @return yySMEM 年 + 开发月分 + 结束月分
	 */
	public static String getCurrentQuarterStartEndTime() {
		return dateToString(getCurrentQuarterStartTime(), "yyMM")
				+ dateToString(getCurrentQuarterEndTime(), "MM");
	}

	/**
	 * 获取前/后半年的开始时间
	 * 
	 * @return
	 */
	public static Date getHalfYearStartTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 0);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 6);
			}
			c.set(Calendar.DATE, 1);
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;

	}

	/**
	 * 获取前/后半年的结束时间
	 * 
	 * @return
	 */
	public static Date getHalfYearEndTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 6) {
				c.set(Calendar.MONTH, 5);
				c.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 12) {
				c.set(Calendar.MONTH, 11);
				c.set(Calendar.DATE, 31);
			}
			now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 获取日期格式为yyyy-MM-dd HH:mm:ss式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getSimpleStringDate(Date date) {
		if(date==null){
			return "";
		}
		return longSdf.format(date);
	}

	/**
	 * 将字符串解析成指定格式的 Date(java.util.Date)
	 * 
	 * @param strDate
	 * @param pattern
	 * @return
	 */
	public static Date toDate(String strDate, String pattern) {
		Date reVal = null;
		DateFormat df = new SimpleDateFormat(pattern);
		try {
			reVal = df.parse(strDate);
		} catch (ParseException e) {
			reVal = null;
			e.printStackTrace();
		}
		return reVal;
	}

	/**
	 * 基本功能：得到年月，行如：yyyy-MM
	 * 
	 * @param date
	 * @return String
	 */
	public static String getYearMonth(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		return df.format(date);
	}

	/**
	 * 基本功能：得到年，行如：yyyy
	 * 
	 * @param date
	 * @return String
	 */
	public static String getYear(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy");
		return df.format(date);
	}

	/**
	 * 基本功能:得到月份，行如：MM
	 * 
	 * @param date
	 * @return int
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 基本功能:得到日期，行如：dd
	 * 
	 * @param date
	 * @return int
	 */
	public static int getOneDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DATE);

	}

	/**
	 * 基本功能：得到日期，行如：yyyy-MM-dd
	 * 
	 * @param date
	 * @return String
	 */
	public static String getDay(Date date) {
		return shortSdf.format(date);
	}

	/**
	 * 基本功能:获得某个时间段的月数
	 * 
	 * 注意：参数的先后顺序， 些方法只判断月份，不会考虑年份的情况
	 * 
	 * @param startDate
	 * @param endDate
	 * @return int
	 */
	public static int getDaysMonth(Date startDate, Date endDate) {
		int end = getMonth(endDate);
		int start = getMonth(startDate);
		int months = 0;
		if (end < start) {
			months = end + 12 - start;
		} else {
			months = end - start;
		}
		return months;
	}
	
	/**
	 * 基本功能:获得某个时间段的月数
	 * 
	 * 注意：参数的先后顺序， 些方法只判断月份，不会考虑年份的情况
	 * 
	 * @param startDate
	 * @param endDate
	 * @return int
	 */
	public static int getDaysYear(Date startDate, Date endDate) {
		Integer end = Integer.valueOf(getYear(endDate));
		Integer start = Integer.valueOf(getYear(startDate));
		int year = 0;
		if (end < start) {
			year = end - start;
		} else {
			year = end - start;
		}
		return year;
	}

	/**
	 * 返回指定格式的 当前时间
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentDate(String pattern) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(c.getTime());
	}

	/**
	 * 基本功能:转换成SQL.date类型
	 * 
	 * @param strDate
	 * @param pattern
	 * @return java.sql.Date
	 */
	public static java.sql.Date toSqlDate(String strDate, String pattern) {
		return new java.sql.Date(toDate(strDate, pattern).getTime());
	}

	/**
	 * 将日期类转化成字符串，格式为"yyyy-MM-dd".
	 * 
	 * @param date
	 * @return
	 */
	public static String toNormalPatternString(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	/**
	 * 根据long类型日期，返回日期格式为{yyyy-MM-dd HH:mm:ss}的字符串
	 * 
	 * @param time
	 * @return String
	 */
	public static String getTimeAll(long time) {
		return longSdf.format(new Date(time));
	}

	/**
	 * 基本功能：返回指定格式日期字符串
	 * 
	 * @param time
	 * @param format
	 * @return String
	 */
	public static String getFormatStr(String format, long time) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(time));
	}

	/**
	 * 基本功能：返回格林威治时间（1970-1-1）到指定日期的毫秒数
	 * 
	 * @param format
	 * @param datestr
	 * @return long
	 * @throws Exception
	 */
	public static long getLongFormatDate(String format, String datestr) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			Date day = formatter.parse(datestr);
			return day.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 基本功能：返回第一个时间与第二个时间相差的秒数
	 * 
	 * @param first
	 * @param second
	 * @return long
	 */
	public static long getDistance(Date first, Date second) {
		return (first.getTime() - second.getTime()) / 1000;
	}

	/**
	 * 获得24小时制long型时间，形如:2007-07-01 01:23 PM
	 * 
	 * @param datestr
	 * @return
	 */
	public static long getLongTime24(String datestr) {
		long long24time = 0;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd h:mm a", Locale.US);
			Date dd = df.parse(datestr);
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String ddstr = df1.format(dd);
			long24time = getLongFormatDate("yyyy-MM-dd HH:mm", ddstr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return long24time;
	}

	/**
	 * 基本功能：返回yyyy-MM-dd日期字符串
	 * 
	 * @param time
	 * @return String
	 */
	public static String getTimeSimple(long time) {
		return shortSdf.format(new Date(time));
	}

	/**
	 * 基本功能：将long转换为Date
	 * 
	 * @param time
	 * @return java.sql.Date
	 */
	public static java.sql.Date getDateTimeSimple(long time) {
		return java.sql.Date.valueOf(shortSdf.format(new Date(time)));
	}

	/**
	 * 基本功能：将yyyy-MM-dd格式字符串转换为long
	 * 
	 * @param time
	 * @return long
	 * @throws Exception
	 */
	public static long getLongByTimeThreadStr(String time) throws Exception {
		ParsePosition pos = new ParsePosition(0);
		Date date = shortSdf.parse(time, pos);
		if (date == null)
			throw new Exception("the date/time string can not parse");
		return date.getTime();
	}

	/**
	 * 基本功能：将yyyy-MM-dd HH:mm:ss格式字符串转换为long
	 * 
	 * @param time
	 * @return long
	 * @throws Exception
	 */
	public static long getLongByFullTime(String time) throws Exception {
		ParsePosition pos = new ParsePosition(0);
		Date date = longSdf.parse(time, pos);
		if (date == null)
			throw new Exception("the date/time string can not parse");
		return date.getTime();
	}

	/**
	 * 基本功能：将yyyy.MM.dd格式字符串转换为long
	 * 
	 * @param time
	 * @param type
	 * @return long
	 * @throws Exception
	 */
	public static long getLongByTimeDotStrTime(String time, int type)
			throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(time, pos);
		if (date == null)
			throw new Exception("the date/time string can not parse");
		return date.getTime();
	}

	/**
	 * 基本功能：将java日期类转化成sql Timestamp类型
	 * 
	 * @param date
	 * @return java.sql.Timestamp
	 */
	public static java.sql.Timestamp toSqlTimestamp(Date date) {
		if (date == null)
			return null;
		else
			return new java.sql.Timestamp(date.getTime());
	}

	/**
	 * 基本功能:字符串转换为Timestamp str 格式为 yyyy-MM-dd HH:mm:ss 字符串
	 * 
	 * @param str
	 * @return java.sql.Timestamp
	 */
	public static java.sql.Timestamp toTimestamp(String str) {
		if (!str.equals("")) {
			Date date = toDate(str, "yyyy-MM-dd HH:mm:ss");
			return new java.sql.Timestamp(date.getTime());
		} else {
			return null;
		}
	}

	/**
	 * 获取日
	 * 
	 * @param date
	 * @return int
	 */
	public static int getCurDay(Date date) {
		DateFormat df = new SimpleDateFormat("dd");
		return Integer.parseInt(df.format(date));
	}

	/**
	 * 基本功能:将日期DATE转换为String
	 * 
	 * @param date
	 * @param parteen
	 * @return String
	 */
	public static String dateToString(Date date, String parteen) {
		DateFormat df = new SimpleDateFormat(parteen);
		return df.format(date);
	}

	/**
	 * 基本功能：得到date所在周的第一天
	 * 
	 * @param date
	 * @return String
	 */
	public static String getWeekStartDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int weekDay = c.get(Calendar.DAY_OF_WEEK) - 2;
		c.add(Calendar.HOUR, -24 * weekDay);
		return getDay(c.getTime());
	}

	/**
	 * 基本功能：得到date所在周的最后一天
	 * 
	 * @param date
	 * @return String
	 */
	public static String getWeekEndDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekDay = 8 - calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.HOUR, 24 * weekDay);
		return getDay(calendar.getTime());
	}

	/**
	 * 基本功能：得到date所在周的起始日期
	 * 
	 * @param date
	 * @return String[]
	 */
	public static String[] getWeekStartEnd(Date date) {
		String[] str = new String[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.HOUR, -24 * (weekDay - 2));
		str[0] = getDay(calendar.getTime());

		calendar.setTime(date);
		calendar.add(Calendar.HOUR, 24 * (8 - weekDay));
		str[1] = getDay(calendar.getTime());
		return str;
	}
	
	/**
	 * 获取当前时间周一到周天的日期名
	 * 
	 * @return yyMMsded 年 +　月　+　开始日期　+　结束日期
	 */
	public static String getWeekStartEndName(){
		String[] week = getWeekStartEnd(new Date());
		return week[0].replace("-", "").substring(2) + week[1].substring(8);
	}

	/**
	 * 基本功能：得到date所在月的起始结束日期
	 * 
	 * @param date
	 * @return String[]
	 */
	public static String[] getMonthStartEnd(Date date) {
		String[] str = new String[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		str[0] = getDay(calendar.getTime());

		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		str[1] = getDay(calendar.getTime());
		return str;
	}

	/**
	 * 转换日期格式为long型
	 * 
	 * @param date
	 * @return long
	 */
	public static long parseAnyDate(String date) {
		if (null != date) {
			List<SimpleDateFormat> list = new ArrayList<SimpleDateFormat>();
			list.add(new SimpleDateFormat("yyyy年MM月dd日 HH:mm"));
			list.add(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
			list.add(longSdf);
			list.add(longMinuteSdf);
			for (SimpleDateFormat format : list) {
				try {
					Date newdate = format.parse(date);
					return newdate.getTime();
				} catch (Exception e) {
					continue;
				}
			}
		}
		return 0L;
	}

	/**
	 * 转换日期格式为Date型
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date parseAnyDateToDate(String date) {
		if (null != date) {
			List<SimpleDateFormat> list = new ArrayList<SimpleDateFormat>();
			list.add(new SimpleDateFormat("yyyy年MM月dd日 HH:mm"));
			list.add(new SimpleDateFormat("yyyy年MM月dd日HH:mm"));
			list.add(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
			list.add(longSdf);
			list.add(longMinuteSdf);
			for (SimpleDateFormat format : list) {
				try {
					Date newdate = format.parse(date);
					return newdate;
				} catch (Exception e) {
					continue;
				}
			}
		}
		return new Date();
	}

	/**
	 * 日期的月份增加或减少
	 * 
	 * @param String
	 *            2005-09-09 ; len=5
	 * @return 2006-02-09
	 */
	public static String addMonth(String datestr, int len) {
		StringTokenizer token = new StringTokenizer(datestr, "-");
		int year = Integer.parseInt(token.nextToken());
		int month = Integer.parseInt(token.nextToken());
		int day = Integer.parseInt(token.nextToken());
		Calendar date = Calendar.getInstance();
		month = month + len - 1;
		date.set(year, month, day);
		return shortSdf.format(date.getTime()).toString();
	}

	/**
	 * 按当前时间增加分钟 datastr 格式为 yyyy-MM-dd HH:mm:ss 字符串
	 * 
	 * @param datastr
	 * @param minute
	 * @return
	 */
	public static String addMinute(String datastr, int minute) {
		Calendar c = Calendar.getInstance(); // 当时的日期和时间
		String strtime = "";
		try {
			Date d = longSdf.parse(datastr);
			c.setTime(d);
			long minutemillis = minute * 60 * 1000;
			c.setTimeInMillis(c.getTimeInMillis() + minutemillis);
			strtime = longSdf.format(c.getTime());
		} catch (Exception e) {
		}
		return strtime;
	}

	/**
	 * 按当前时间增加小时 datastr 格式为 yyyy-MM-dd HH:mm:ss 字符串
	 * 
	 * @param datastr
	 * @param minute
	 * @return
	 */
	public static String addHour(String datastr, int hour) {
		Calendar c = Calendar.getInstance(); // 当时的日期和时间
		String strtime = "";
		try {
			Date d = longSdf.parse(datastr);
			c.setTime(d);
			long hourmillis = hour * 60 * 60 * 1000L;
			c.setTimeInMillis(c.getTimeInMillis() + hourmillis);
			strtime = longSdf.format(c.getTime());
		} catch (Exception e) {
		}
		return strtime;
	}

	/**
	 * 获取当前日期 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 */
	public static String getToday() {
		Calendar cal = Calendar.getInstance();
		return longSdf.format(cal.getTime());
	}

	/**
	 * 获取当前日期 yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getDate() {
		return shortSdf.format(new Date());
	}

	/**
	 * 获取当前日期年 yyyy
	 * 
	 * @return String
	 */
	public static String getCurrentYear() {
		String time = getToday();
		return time.substring(0, time.indexOf("-"));
	}

	/**
	 * 改变日期 在当前时间上加天数
	 * 
	 * @param aDate
	 *            Date
	 * @param days
	 *            int
	 * @return String yyyy-MM-dd
	 */
	public static String getChangeDate(Date aDate, int days) {
		String datestr = "";
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(aDate);
			cal.add(Calendar.DATE, days);
			aDate = cal.getTime();
			datestr = shortSdf.format(aDate);
		} catch (Exception ex) {

		}
		return datestr;
	}

	/**
	 * 改变日期 在当前时间上加天数 aDate需要格式为 yyyy-MM-dd 字符串
	 * 
	 * @param aDate
	 * @param days
	 * @return
	 */
	public static String getChangeDate(String aDate, int days) {
		String datestr = "";
		try {
			Date d = shortSdf.parse(aDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DATE, days);
			d = cal.getTime();
			datestr = shortSdf.format(d);
		} catch (Exception ex) {

		}
		return datestr;
	}

	/**
	 * 改变日期 在当前时间上加天数 aDate需要格式为 yyyy-MM-dd HH:mm:ss 字符串
	 * 
	 * @param aDate
	 * @param days
	 * @return String
	 */
	public static String getChangeDateInfo(String aDate, int days) {
		String datestr = "";
		try {
			Date d = longSdf.parse(aDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DATE, days);
			d = cal.getTime();
			datestr = longSdf.format(d);

		} catch (Exception ex) {

		}
		return datestr;
	}

	/**
	 * 把当前日期格式转换成微秒格式 aDate 格式为 yyyy-MM-dd HH:mm:ss 字符串
	 * 
	 * @param aDate
	 * @return String
	 */
	public static String getMillisTime(String aDate) {
		String datestr = "";
		try {
			Date d = longSdf.parse(aDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			datestr = datestr + cal.getTimeInMillis();
		} catch (Exception ex) {

		}
		return datestr;
	}

	/**
	 * 获取当前是周几
	 * 
	 * @param dt
	 * @return
	 */
	public static int getWeekOfDate(Date dt) {
		int[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 比较两个日期大小
	 * dt1 > dt2 1;
	 * dt1 < dt2 -1;
	 * dt1 = dt2 0;
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static int compare_date(Date dt1, Date dt2) {
		if (dt1.getTime() > dt2.getTime()) {
			return 1;
		} else if (dt1.getTime() < dt2.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(compare_date(toDate("2017", "yyyy"), toDate("2015", "yyyy")));
	}
}
