package interviewPrepartion;

public class smallestandlargest {

	public static void main(String[] args) {
		int[] num = { 0,1, 2, 3, 4, 5 };
		int len = num.length;
		int largest = num[0];
		int smallest = num[0];
		for (int e : num) {
			if (e > largest) {
				largest = e;

			} else if (e < smallest) {
				smallest = e;
			}
		}
		System.out.println(largest);
		System.out.println(smallest);
	}

}
