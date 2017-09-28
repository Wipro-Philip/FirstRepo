import java.util.Arrays;
import java.util.Scanner;


public class JF_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String randomnum = "";
		
		// User Inputs
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Array Size");
		int size = scanner.nextInt();

		// Generate Random Array
		int[] randoms = new int[size];
		for(int i = 0; i < randoms.length; i++){
			randoms[i] = (int)(Math.random() * 100 );
			randomnum = randomnum + randoms[i] + " ";
		}
		scanner.close();
		System.out.println(randomnum);
		
		int LenArray = randoms.length;
		
		for(int i=0; i < LenArray; i++){
			for(int j=i+1; i < LenArray; j++){
				if(randoms[i] == randoms[j]){
					while (j < (LenArray) - 1){
						randoms[j] = randoms[j + 1];
						j++;
					}
					
					//randoms[j] = randoms[LenArray-1];
					LenArray--;
					//j--;
				}
			}
		}
	
		int [] Uniques = Arrays.copyOf(randoms, LenArray);
		
		 for (int i = 0; i < Uniques.length; i++)
	        {
	            System.out.print(Uniques[i]+"\t");
	        }
	         
	        System.out.println();
	         
	}

}
