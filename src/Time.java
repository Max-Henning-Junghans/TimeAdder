public class Time {

	private int hour;
	private int minute;

	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public void addToTime(Time time) {
		hour += time.hour;
		minute += time.minute;
		if (minute >= 60) {
			minute -= 60;
			hour++;
		}
	}

	public static Time subtractTimes(Time firstTime, Time secondTime) {
		int newHours = secondTime.hour - firstTime.hour;
		int newMinutes = secondTime.minute - firstTime.minute;
		if (newHours < 0) {
			newHours = 24 + newHours;
		}
		if (newMinutes < 0) {
			newMinutes = 60 + newMinutes;
			newHours--;
		}
		return new Time(newHours, newMinutes);
	}

	@Override
	public String toString() {
		return String.format("Stunden: %d, Minuten: %d", hour, minute);
	}
}
