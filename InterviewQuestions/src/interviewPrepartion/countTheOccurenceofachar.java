package interviewPrepartion;

public class countTheOccurenceofachar {
	
	//charactercount - count =0;
	//forloop i=0;i<str.length;i++
	//if check-count++
	//
	public static void countOcc(String s, char c)
	{
		int count =0;
		for(int i =0; i<s.length();i++)
		{
			if(s.charAt(i)==c)
			{
				count++;
			}
		}
		System.out.println(c+":"+count);
	}

	public static void main(String[] args) {
		
		countOcc("Malayalam",'a');
	}

}
