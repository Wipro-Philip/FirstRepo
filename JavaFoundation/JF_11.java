import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JF_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Gets Input from User
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the lowest Number");
		int min = scanner.nextInt();
		System.out.println("Please Enter the Highest Number");
		int max = scanner.nextInt();
		scanner.close();
		
		// Creates a List
		List<Integer> x = new ArrayList<Integer>();
		
		//String Divis = "";
		
		for (int i=min; i < max + 1; i++)
        {
            if (i % 2 == 0 && i % 3 ==0 && i % 5 == 0){
            	//Divis = Divis + i + " ";
            	x.add(i); // Append Number too List
            }
        }    
		System.out.println("\nNumbers Divisible by 2, 3, & 5 Are: ");
		//System.out.println(Divis);
		// Print First 5 in Array
		System.out.println(x.get(0) + " " + x.get(1) + " " + x.get(2) + " " + x.get(3) + " " + x.get(4));
	}

}
