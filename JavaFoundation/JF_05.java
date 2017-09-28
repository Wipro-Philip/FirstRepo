import java.util.Scanner;

public class JF_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a Number: ");
		int num=scanner.nextInt();
		
		if(num==0){
			System.out.println("Number is Equal to Zero!");
		}
		else if(num>0){
			System.out.println("Number is Above Zero!");
		}
		else if(num<0){
			System.out.println("Number is Below Zero!");
		}
		else{
			System.out.println("Error!");
		}
	}

}
