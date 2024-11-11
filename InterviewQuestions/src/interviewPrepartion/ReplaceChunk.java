package interviewPrepartion;

public class ReplaceChunk {

	public static void main(String[] args) {
		String chunk = "@#@#test$%55";
		System.out.println(chunk.replaceAll("[^A-Za-z0-9]", ""));

	}

}
