
public class Strings_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1 = new String("CatDog");
		String S2 = new String();
		
		S2 = S1.substring(0, (S1.length()/2));
		
		if(S1.length()% 2 == 0){
			System.out.println(S2);
		}
		else{
			System.out.println("Null");
		}
		
	}

}
