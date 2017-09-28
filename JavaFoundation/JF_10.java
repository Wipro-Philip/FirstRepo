import java.util.Scanner;


public class JF_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Gets Input from User
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter Number: ");
		String Palin = scanner.nextLine();
		scanner.close();

		int mid = Palin.length() / 2;
		String[] split = {Palin.substring(0, mid),Palin.substring(mid)};
		
		System.out.println("\nHalfed is:");
		System.out.println(split[0]);
		System.out.println(split[1]);
		
		String part2 = new StringBuilder(split[1]).reverse().toString();
		String part1 = new StringBuilder(split[0]).toString();
		
		//Debug Code
		//System.out.println(part1);
		//System.out.println(part2);
		
		if(part1.equals(part2)){
			System.out.println("\n" + Palin + " Is a Palindrome!");
		}
		else{
			System.out.println("\n" + Palin + " Is Not a Palindrome!");
		}
		
	}

}
