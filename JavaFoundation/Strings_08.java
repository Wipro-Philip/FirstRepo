
public class Strings_08 {

	public static void main(String[] args) {
		String S1 = new String("Hello");
		String S2 = new String("World");
		String S3 = new String();
		int length = 0;
		
		if(S1.length() < S2.length()){
			length = S2.length();
		}
		else{
			length = S1.length();
		}
		
		for(int i =0; i < length;i++){
			S3 = S3 + S1.substring(i,i+1) + S2.substring(i,i+1);			
		}
		
		System.out.println(S3);
		
		
	}

}
