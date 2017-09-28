import java.util.Arrays;
import java.util.Scanner;

public class JF_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String randomnum = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Array Size");
		int size = scanner.nextInt();
		
		int[] randoms = new int[size];
		for(int i = 0; i < randoms.length; i++){
			randoms[i] = (int)(Math.random() * 100 );
			//System.out.println(randoms[i] + " ");
			randomnum = randomnum + randoms[i] + " ";
		}
		System.out.println(randomnum);
		
		int min = Arrays.stream(randoms).min().getAsInt();
		int max = Arrays.stream(randoms).max().getAsInt();
		
		System.out.println("Min is: " + min);
		System.out.println("Max is: " + max);
		scanner.close();
	}

}
