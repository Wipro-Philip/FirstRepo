public class Strings_07 {

	public static void main(String[] args) {
		String S1 = new String("ab*cd");
		StringBuffer S2 = new StringBuffer(S1);
		
		while(S2.indexOf("*") != 0){
			int index = S2.indexOf("*");
			S2.delete(index -1,  index + 2);
			System.out.println(S2);
		}
		
	}	
}