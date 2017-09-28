import java.util.Scanner;


public class JF_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please Enter your Gender: ");
		String Gender=scanner.nextLine();
		System.out.println("Please Enter Your Age");
		int Age=scanner.nextInt();
				
		
		if(Gender.equals("Male") && (Age<61) && (Age>0)){
			System.out.println("Interest Rate is 9.2%");
		}
		else if(Gender.equals("Male") && Age>60 && Age<121){
			System.out.println("Interest Rate is 8.3%");
		}
		else if(Gender.equals("Female") && Age<59 && Age>0){
			System.out.println("Interest Rate is 8.2%");
		}
		else if(Gender.equals("Female") && (Age<121) && (Age>57)){
			System.out.println("Interest Rate is 7.6%");
		}
		else{
			System.out.println("Error In Arguments, please follow format 'JF_08 <GENDER> <AGE>'");
		}
	}

}
