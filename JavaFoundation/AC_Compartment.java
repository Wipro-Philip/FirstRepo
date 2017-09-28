
public abstract class AC_Compartment {
	
	abstract void notice();
	
}

class FirstClass extends AC_Compartment{

	@Override
	void notice() {
		System.out.println("This is First Class");
		
	}
	
}

class Ladies extends AC_Compartment{

	@Override
	void notice() {
		System.out.println("This is Ladies Class");
	}
	
}

class General extends AC_Compartment{

	@Override
	void notice() {
		System.out.println("This is General Class");
	}
	
}

class Luggage extends AC_Compartment{

	@Override
	void notice() {
		System.out.println("This is Luggage Class");
	}
	
}

class TestCompartment{
	public static void main(String[] args) {
		String randomnum = "";
		
		int[] Compartment = new int[10];
		for(int i = 0; i < Compartment.length; i++){
			Compartment[i] = (int)(Math.random() * 4+1 );
			randomnum = randomnum + Compartment[i] + " ";
		}
		
		AC_Compartment C1 = new FirstClass();
		System.out.println(C1.notice());
		
		System.out.println(randomnum);
		
		
	}
}
