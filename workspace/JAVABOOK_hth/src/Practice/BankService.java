package Practice;

import java.util.HashMap;
import java.util.Map;

class Bank{
	// 은행 변수
	private double bankMoney;
	private String bankName;
	private Map<String, Double> account;
	
	// 생성자 초기화
	public Bank(String bankname, double bankmoney) {
		this.bankName = bankname;
		this.bankMoney = bankmoney;
		this.account = new HashMap<>();
	}
	
	// 계좌 등록 메서드
	public void Resister(String accountnumber) {
		// 겹치지 않는 특정 형식으로 랜덤 번호를 부여하는게 좋을까?
		// 번호가 겹쳤을 때 
		account.put(accountnumber, 0.0);
	}
	
	// 출금 메서드
	public void Withdraw(double money) {
		bankMoney -= money;
		
	}
}
class Owner{
	// 소유자 변수
	private String name;
	private double balance;
	private Map<String, Double> account;
	
	public Owner(String name, double balance) {
		this.name = name;
		this.balance = balance;
		this.account = new HashMap<>();
	}
}

public class BankService {
	public static void main(String[] args) {
		
		
	}
}
