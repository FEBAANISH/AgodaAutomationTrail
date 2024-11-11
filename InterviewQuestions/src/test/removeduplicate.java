package test;

public class removeduplicate {

	public static void main(String[] args) {
		String org = "abcdabcd";
		String dup = " ";
		for(int i =0;i<=org.length()-1;i++)
		{
			if(dup.contains(""+org.charAt(i)))
			{
				continue;
			}
			dup = dup+org.charAt(i);
		}
		System.out.println(dup);

	}

}
