package Ch16;

class Animal {
	String name;

}

class Panda extends Animal {
	public Panda(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "팬더 이름 : " + name;
	}
}

class Tiger extends Animal {
	public Tiger(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "호랑이 이름 : " + name;
	}
}

public class C04GenericMain {

	// Generic
	public static <T extends Animal> void PrintByGeneric(T [] arr) {
		for(T el : arr) {
			System.out.println(el);
		}
	}
	
	// Object
	public static void PrintByObject(Object [] Animal) {
		for(Object el : Animal) {
			System.out.println(el);
		}
	}
	
	public static void main(String[] args) {
		
		Tiger arr1 [] = {new Tiger("시베리안 호랑이"),new Tiger("뱅갈 호랑이") , new Tiger("그냥 호랑이")};
		PrintByGeneric(arr1);
		Panda arr2 [] = {new Panda("중국 팬더"),new Panda("래서 팬더") , new Panda("그냥 팬더")};
		PrintByGeneric(arr2);
		
		Object arr3 [] = {new Tiger("시베리안 호랑이"), new Panda("래서 팬더") , new Panda("그냥 팬더")};
		PrintByObject(arr3);
	}
}
