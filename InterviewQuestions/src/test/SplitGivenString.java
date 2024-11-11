package test;

public class SplitGivenString {
	
	public static void splitString(String s)
	{
		String[] split = s.split(" ");
		for(String e:split)
		{
			System.out.println("*"+e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		splitString("hai hello try");

	}

}
