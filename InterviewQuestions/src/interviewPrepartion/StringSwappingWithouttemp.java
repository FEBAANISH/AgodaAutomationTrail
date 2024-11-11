package interviewPrepartion;

public class StringSwappingWithouttemp {
	//swapstring substring concept
	//s1=s+s2
	//s2= s1.substring(0,s1.length-s2.length
	//s1=s1.substring(s2.length);
	
	public static void swapString(String s1, String s2)
	{
		s1 =s1+s2;
		s2 = s1.substring(0, s1.length()-s2.length());
		System.out.println(s2.length());
		System.out.println("s2 after swapping:"+s2);
		s1= s1.substring(s2.length());
		System.out.println("s1 after swapping:"+s1);
	}

	public static void main(String[] args) {
		
		swapString("hello","world");
	}

}
