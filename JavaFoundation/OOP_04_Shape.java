
public class OOP_04_Shape {

	void draw(){
		System.out.println("Drawing Shape");
	}
	
	void erase(){
		System.out.println("Erasing Shape");
	}
	
}

class Circle extends OOP_04_Shape{
	@Override
	void draw(){
		System.out.println("Drawing Circle");
	}
	void erase(){
		System.out.println("Erasing Circle");
	}
}

class Triangle extends OOP_04_Shape{
	@Override
	void draw(){
		System.out.println("Drawing Triangle");
	}
	void erase(){
		System.out.println("Drawing Triangle");
	}
}

class Square extends OOP_04_Shape{
	@Override
	void draw(){
		System.out.println("Drawing Square");
	}
	void erase(){
		System.out.println("Drawing Square");
	}
	
}
