package interviewPrepartion;

public class reverseSentence {

	public static void main(String[] args) {
		String s1 = "Test to reverse Sentence";
		String[]s3 = s1.split(" ");
		System.out.println(s3[0]);
		String rev = "";
		for(String word:s3)
		{
			System.out.println(word);
			for(int i =word.length()-1;i>=0;i--)
			{
				rev = rev+word.charAt(i);
			}
		}
		System.out.println(rev);
		
	}

}
