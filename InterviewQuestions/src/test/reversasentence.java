package test;

public class reversasentence {

	public static void main(String[] args) {
		String a ="java is a program";
		String[] split = a.split(" ");
		String rev = "";
		for(String s:split)
		{
			for(int i=s.length()-1;i>=0;i--)
			{
				rev = rev+s.charAt(i);
			}
		}
       System.out.println(rev);
	}

}
