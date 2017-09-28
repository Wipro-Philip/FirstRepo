import java.util.Scanner;


public class JF_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Defining Counters
		int i =0;
		int num =0;
		
		// Gets Input from User
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the lowest Number");
		int min = scanner.nextInt();
		System.out.println("Please Enter the Highest Number");
		int max = scanner.nextInt();
		scanner.close();
		
		// Prime Calculations
		String Primes = ""; //Empty String to Contain Primes
		for (i=min; i <= max; i++){ // Start at Min Number, until Max Number
			int count=0;
			for(num =i; num>=min;num--){
				if(i%num==0){ // Use Modular to determine if prime
					count = count + 1;
				}
			}
			if (count==2){
				Primes = Primes + i + " ";
			}
		}
		System.out.println("\nPrimes Are: ");
		System.out.println(Primes); // Print Primes

}
}
