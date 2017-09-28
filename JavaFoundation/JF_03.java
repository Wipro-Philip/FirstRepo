public class JF_03{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string1 = new StringBuilder(args[1]).reverse().toString();
		
		if(args[0].equals(args[1])){
			System.out.println("The Two Strings are the same!");
		}
		
		
		System.out.println(args[0] + " " + string1);
	}

}
