
public class Strings_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1 = new String("Wipro");
		String S2 = new String();
		String S3 = new String();
		
		S2 = S1.substring(0, 2);
		
		for(int i = 0; i < S1.length(); i++){
			S3 = S3 + (S2 + "");
		}
		
		System.out.println("" + S2);
		
		System.out.println("" + S3);
	}

}
