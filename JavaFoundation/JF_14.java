import java.util.Scanner;

public class JF_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String randomnum = "";
		
		// User Inputs
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Array Size");
		int size = scanner.nextInt();
		System.out.println("Enter Number to Search For: ");
		int search = scanner.nextInt();
		
		// Generate Random Array
		int[] randoms = new int[size];
		for(int i = 0; i < randoms.length; i++){
			randoms[i] = (int)(Math.random() * 100 );
			randomnum = randomnum + randoms[i] + " ";
		}
		System.out.println(randomnum);
		
		// Search Through array for match.
		int count = 0;
		for(int j = 0; j < randoms.length; j++){
			if(randoms[j]==search){
				count = 1;
				System.out.println(search + " Is in the Array At Position: " + j);
			}
			else{
				continue;
			}
		}
		
		if(count == 0){
			System.out.println("-1\n" + search + " Is not in the Array!");
		}
		
		scanner.close();
	}

}
