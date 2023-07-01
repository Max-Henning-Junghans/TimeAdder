import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		runProgram();
	}

	private static void runProgram() {
		String input;
		boolean finished = false;
		Time timeCount = new Time(0, 0);

		while (!finished) {
			input = scanner.nextLine();
			switch (input) {
				case "--stop" -> finished = true;
				case "--reset" -> timeCount = new Time(0, 0);
				case "--show" -> System.out.println(timeCount);
				case "--help" -> {
					System.out.println("This program has the following commands.");
					System.out.println("--help: Show all commands.");
					System.out.println("--stop: Stop the program.");
					System.out.println("--reset: Reset the counter to 0.");
					System.out.println("--show: Show the current value.");
					System.out.println("Inputs for this program have the following format.");
					System.out.println("<Hour of the first time>:<Minute of the first time> <Hour of the second time>:<Minute of the second time>");
					System.out.println("The times follow the 24-hour format. Here are some examples.");
					System.out.println("00:00 11:45");
					System.out.println("22:50 02:21");
					System.out.println("The program cannot count single durations longer than 24 hours.");
				}
				default -> processTimeInput(input, timeCount);
			}
		}
	}

	private static void processTimeInput(String input, Time timeCount) {
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