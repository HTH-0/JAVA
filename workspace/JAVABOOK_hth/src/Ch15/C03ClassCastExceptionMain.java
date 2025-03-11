package Ch15;

class Animal{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}


public class C03ClassCastExceptionMain {
	public static void changeDog(Animal animal) {
		
		Dog down = (Dog)animal;
		
	}
	
	public static void main(String[] args) {
		
		try {
			
		Animal poppy = new Dog();
		Animal tori = new Cat();
		
		changeDog(tori);
		changeDog(poppy);
	
		}catch(ClassCastException e){
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
		System.out.println("HELLOWORLD");
		
	}
}
