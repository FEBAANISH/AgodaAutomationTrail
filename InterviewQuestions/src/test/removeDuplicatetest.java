package test;

public class removeDuplicatetest {

	public static void main(String[] args) {
		String original = "abcdabcd";
		String dup ="";
		for(int i =0;i<=original.length()-1;i++)
		{
			if(dup.contains(""+original.charAt(i)))
			{
				continue;
			}
			dup=dup+original.charAt(i);
		}
		System.out.println(dup);

	}

}
