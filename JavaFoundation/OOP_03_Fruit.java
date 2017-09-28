
public class OOP_03_Fruit {

	public String name;
	public String taste;
	int size;
	
	void eat(){
		System.out.println("This is a " + name + "Tastes like " + taste);
	}
		
}

class Orange extends OOP_03_Fruit{
	@Override
	void eat(){
		System.out.println("Orange tastes Orangey");
	}
}

class Apple extends OOP_03_Fruit{
	@Override
	void eat(){
		System.out.println("Apple tastes Appley");
	}
}


