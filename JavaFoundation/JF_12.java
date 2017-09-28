import java.util.Scanner;


public class JF_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean menu = true;
		
		while(menu == true){
			Scanner scanner = new Scanner(System.in);
			System.out.println("######\n#Menu#\n######\nPlease Pick an Option\n1. Add\n2. Sub");
			int Opt = scanner.nextInt();
			if(Opt==1){
				System.out.println("Please Enter the first number: ");
				int No1 = scanner.nextInt();
				System.out.println("Please Enter the Second number: ");
				int No2 = scanner.nextInt();				
				System.out.println("The answer is: " + (No1+No2));
				//System.out.println(No1+No2);
				scanner.nextLine(); // Blank Next Line to stop error caused from switching from Int to Line
				System.out.println("Would You Like to Continue?");
				String Contin = scanner.nextLine();
				if(Contin.equals("y") || Contin.equals("Y")){
					continue;
				}
				else if (Contin.equals("n") || Contin.equals("N")){
					System.out.println("Closed!");
					scanner.close();
					menu = false;
				}
				else{
					System.out.println("Error");
				}
			}
			else if(Opt==2){
				System.out.println("Please Enter the first number: ");
				int No1 = scanner.nextInt();
				System.out.println("Please Enter the Second number: ");
				int No2 = scanner.nextInt();				
				System.out.println("The answer is: " + (No1-No2));
				//System.out.println(No1+No2);
				scanner.nextLine(); // Blank Next Line to stop error caused from switching from Int to Line
				System.out.println("Would You Like to Continue?");
				String Contin = scanner.nextLine();
				if(Contin.equals("y") || Contin.equals("Y")){
					continue;
				}
				else if (Contin.equals("n") || Contin.equals("N")){
					System.out.println("Closed!");
					scanner.close();
					menu = false;
				}
				else{
					System.out.println("Error");
				}
			}
			
		}
		
		
	}

}
