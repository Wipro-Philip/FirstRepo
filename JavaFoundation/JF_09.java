import java.util.Scanner;


public class JF_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Gets Input from User
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the Month Number: ");
		int Mon = scanner.nextInt();
		scanner.close();
		
		String[] Months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		if(Mon<13){
			System.out.println(Months[Mon-1]);
		}
		else{
			System.out.println("Invalid Month");
		}
	}

}
