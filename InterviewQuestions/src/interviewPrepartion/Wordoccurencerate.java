package interviewPrepartion;

public class Wordoccurencerate {

	public static void main(String[] args) {
		String word = "hello hai hai hai";
		String[] split = word.split(" ");
		System.out.println(split.length);
		String target = "hai";
		int count = 0;

		for (int i = 0; i < split.length; i++) {

			if (split[i].equalsIgnoreCase(target)) {

				count++;
			}
		}

		System.out.println(target + ":" + count);
	}

}
