package Practice;

class Bankaccount{		// 클래스 생성
	String acnum;
	int balance;
	
	Bankaccount(String acnum, int balance){	// 변수 초기화
		this.acnum = acnum;
		this.balance = balance;
	}
	
	void deposit(int amount) {		// deposit 
		balance += amount;
	}
	void withdraw(int amount) {
		balance -= amount;
	}
	
	void getBalance() {
		System.out.println(balance);
	}
}

public class P03BankAccount {
	public static void main(String[] args) {
		
		Bankaccount b1 = new Bankaccount("123-123", 50000);
		
		b1.deposit(4000);
		b1.getBalance();
		
		
		b1.withdraw(20000);
		b1.getBalance();
	}
}
