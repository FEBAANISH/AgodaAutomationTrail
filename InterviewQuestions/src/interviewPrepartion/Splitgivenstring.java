package interviewPrepartion;

public class Splitgivenstring {

	public static void splitString(String s) {

		String s1[] = s.split(" ");
		for (String e : s1) {
			System.out.println("*" + e);
		}

	}

	public static void main(String[] args) {
		splitString("hey hello this is split String testing");

	}

}
