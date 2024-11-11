package interviewPrepartion;

public class Additionofnum {

	public static void main(String[] args) {
		//additionOfNum=whileloop
		int num = 102030;
		int sum =0;
		while(num!=0)
		{
			sum = sum+num%10;
			num=num/10;
		}
		System.out.println(sum);

	}

}
