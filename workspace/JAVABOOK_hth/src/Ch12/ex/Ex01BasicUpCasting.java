package Ch12.ex;

// Exercise 1: Basic Upcasting
class Animal {
    void makeSound() {
        System.out.println("동물이 소리를 냅니다");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("멍멍!");
    }
    
    void fetch() {
        System.out.println("강아지가 공을 가져옵니다!");
    }
}

public class Ex01BasicUpCasting {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 1: 기본 업캐스팅 ===");
        // 문제: 다음 코드를 완성하세요
        // 1. Dog 인스턴스를 생성하세요
        // 2. 생성한 Dog 인스턴스를 Animal 타입으로 업캐스팅하세요
        // 3. 업캐스팅된 참조로 makeSound() 메서드를 호출해보세요
        // 4. 업캐스팅된 참조로 fetch() 메서드를 호출해보고 결과를 확인하세요
        
        Dog d1 = new Dog();	// 인스턴스 생성
        
        Animal a1 = d1;		// 업캐스팅
        
        a1.makeSound();		// 메서드 실행
//      a1.fetch();			// 범위를 벗어난다
        
        
  
        
        // 실행 결과 예시:
        // 멍멍!
        // 컴파일 에러: fetch() 메서드는 Animal 타입에서 접근 불가
    }
} 