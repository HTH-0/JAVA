package Practice;



class car{
	String brand;
	int speed;
	
	car(String brand, int speed){		
	this.brand = brand;
	this.speed = speed;
	}
	
	void accelerate() {
		speed += 10;
		System.out.println(brand + speed);
	}
	
	void brake() {
		speed -= 10;
		System.out.println(brand + speed);
	}
}

public class P01 {
	public static void main(String[] args) {
		
		car car1 = new car("현대", 0);
		car1.accelerate();
		car1.brake();
		
	}
}
