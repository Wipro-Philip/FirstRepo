
public class OOP_00_Call_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("OOP_01 Task 01:\n" + OOP_01.getVolume(10,20,20) + "\n");
		
		System.out.println("OOP_02 Task 02:\n" + OOP_02_Calculator.powerInt(12,10) + "\n");
		
		System.out.println("OOP_03 Task 03:\n" + Apple.class.getName());
		OOP_03_Fruit a=new Apple();
		a.eat();
		
		System.out.println("\nOOP_04 Task 04:\n");
		OOP_04_Shape c=new Circle();
		OOP_04_Shape t=new Triangle();
		OOP_04_Shape s=new Square();
		c.draw();
		c.erase();
		t.draw();
		t.erase();
		s.draw();
		s.erase();
	
		
	}

}
