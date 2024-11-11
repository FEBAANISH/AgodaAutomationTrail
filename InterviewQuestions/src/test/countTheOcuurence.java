package test;

public class countTheOcuurence {

	public static void main(String[] args) {
		String occurence ="malayalam";
		int count =0;
		char c ='a';
		for(int i =0;i<occurence.length();i++)
		{
			if(occurence.charAt(i)==c)
			{
				 count++;
			}
		}
		System.out.println(c+":"+count);

	}

}
