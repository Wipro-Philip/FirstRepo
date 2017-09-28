
public class Strings_06 {

	public static void main(String[] args) {
		String S1 = new String ("xHix");

		if(S1.substring(0,1).equals("x")){
			S1 = S1.substring(1,S1.length()); 
		}
		
		if(S1.substring(S1.length()-1).equals("x")){
			S1 = S1.substring(0,S1.length()-1);
		}
		
		System.out.println("S1: " + S1);		
	}

}
