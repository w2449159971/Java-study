/**
*如何设计一个类（日期类）   一。功能
*1.传 年、月、日  构造日期类
*2.在当前日期上增加多少天
*3.在当前日期上减少多少天
*4.可以返回字符串String的方法
*5.可以加一些限制，年支持的范围[1900，2100]
*6.给定两个日期计算相差多少天
*/
/*二 设计属性
*1.年月日 int
*
*/

public class Date{
	private int year;
	private int month;
	private int day;
	//构造方法
	public Date{int year, int month, int day) {
		//至少做基本的参数检查
		if(year < 1900 || year > 2100) {
			//最好是抛异常
			System.out.println("年不合法"+year);
			return;
		}
		if(month < 1 || month > 12) {
			System.out.println("月不合法"+month);
			return;
		}
		if(day < 1 || day > getDayOfMonth(year, month)) {
			System.out.println("日不合法"+day);
			return;
		}
		//涉及name shadow
		this.year = year;
		this.month = month;
		this.day = day;
	}
	private Date()
	
	//支持的方法
	public void add(int days) {
		//days正数
		if(days < 0) {
			System.out.println("days 不合法"+days);
		day -= days;
		}
		day += days;
		while (day > getDayOfMonth(year, month)) {
			day -= getDayOfMonth(year, month);
			month++;
			if(month > 12) {
				month = 1;
				year++;
			}
		}
	}
	
	public void sub(int days) {
		//days正数
		if(days < 0) {
			System.out.println("days 不合法"+days);
		day -= days;
		}
		while (day < 1) {
			month--;
			if()
			day += getDayOfMonth(year, month);
			month--;
			if(month < 1) {
				month = 12;
				year--;
			}
		}
	}
	
	public String toString() {
		return String.format("%04d-%02d-%02d");
	}
	
	private static boolean isGeatThan(Date d1, Date d2) {
		if(d1,year > d2.year) {
			return true;
		}
		if(d1.year == d2.year && d1.month > d2. month)
	
	public static int differ(Date d1, Date d2){
		if(!isGeatThan(d1, d2)) {
			System.out.println("必须d1大于d2");
			return-1;
		}
		int days = 0;
		Date tmp = new Date
		
	//内部使用的方法private
	private int[] DAY_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static int getDayOfMonth(int year, int month) {
		int days = DAY_OF_MONTH[month-1];
		if(month == 2 && isLeapYear(year)) {
			days = 29;
		}
		return days;
	}
	
	private static boolean isLeapYear(int year) {
		if((year % 4 == 0 && year % 100 != 0) || year % 400 ) {
			return true; 
		}
		return false;
	}
	
	public static void main(String[] args) {
		Date date = new Date(2019, 4, 24);
		System.out.println(date.toString());
		date.add(30);
		System.out.println(date.toString());
		date.sub(15);
		System.out.println(date.toString());
		
	}
}
	
	