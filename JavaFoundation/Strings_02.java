
public class Strings_02 {

	public static void main(String[] args) {
		String S1 = new String("Mark");
		String S2 = new String("Kate");
		
		S1 = S1.toLowerCase();
		S2 = S2.toLowerCase();
		
		char lastletter = S1.charAt(S1.length()-1);
		char firstletter = S2.charAt(0);
		
		
		
		if(firstletter == lastletter){
			S2 = S2.substring(1);
		}
		
		System.out.println("" + S1 + S2);
						
		
		
	}
	

}
