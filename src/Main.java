import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String input;
		boolean finished = false;
		Time timeCount = new Time(0, 0);

		while (!finished) {
			input = scanner.nextLine();
			if (input.equals("stop")) {
				finished = true;
				continue;
			}
			try {
				String[] times = input.split(" ");
				String[] firstTimeString = times[0].split(":");
				String[] secondTimeString = times[1].split(":");
				Time firstTime = new Time(Integer.parseInt(firstTimeString[0]), Integer.parseInt(firstTimeString[1]));
				Time secondTime = new Time(Integer.parseInt(secondTimeString[0]), Integer.parseInt(secondTimeString[1]));
				timeCount.addToTime(Time.subtractTimes(firstTime, secondTime));
				System.out.println(timeCount);
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException ignored) {
				System.out.println("Wrong format. Please try again.");
			}
		}
	}
}