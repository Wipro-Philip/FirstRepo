import java.util.Scanner;


public class JF_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Gets Input from User
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the lowest Number");
		int min = scanner.nextInt();
		System.out.println("Please Enter the Highest Number");
		int max = scanner.nextInt();
		scanner.close();
		
		String Evens = "";
		
		for (int i=min; i < max + 1; i++)
        {
            if (i % 2 == 0){
            	Evens = Evens + i + " ";
            }
        }    
		System.out.println("\nEvens Are: ");
		System.out.println(Evens);
	}

}
