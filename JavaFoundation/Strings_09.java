
public class Strings_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1 = new String("Wipro");
		String S2 = new String();
		String S3 = new String();
		int n = 3;
		
		
		S2 = S1.substring(S1.length()-n, S1.length());
		
		for(int i = 0; i < n; i++){
			S3 = S3 + (S2 + "");
		}
		
		System.out.println("" + S3);
	}

}
