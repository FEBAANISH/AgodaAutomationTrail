package interviewPrepartion;

public class ReverseAstring {
	


	public static void main(String[] args) {
	String str = "Happy";
	String revStr ="";
	for(int i =str.length()-1;i>=0;i--)
	{
		revStr = revStr+str.charAt(i);
	}
	System.out.println(revStr);
	
	
	StringBuffer sb = new StringBuffer(str);
	System.out.println(sb.reverse());
	}

}
