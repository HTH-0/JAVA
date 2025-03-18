package Practice;

import java.util.HashMap;
import java.util.Map;

class Bank {
	// 은행 변수
	private double bankMoney;
	private String bankName;
	private Map<String, Double> account; // 계좌번호, 계좌보유금액

	public double getBankMoney() {
		return bankMoney;
	}

	public void setBankMoney(double bankMoney) {
		this.bankMoney = bankMoney;
	}

	// 생성자 초기화
	public Bank(String bankname, double bankmoney) {
		this.bankName = bankname;
		this.bankMoney = bankmoney;
		this.account = new HashMap<>();
	}
	@Override
	public String toString() {
		return bankName + "은행";
	}
	// 계좌 등록 메서드
	public void Register(String accountnumber) {
		// 겹치지 않는 특정 형식으로 랜덤 번호를 부여하는게 좋을까?
		if (!account.containsKey(accountnumber)) {
			account.put(accountnumber, 0.0);
			System.out.println("[" + this + "] 계좌번호 : " + accountnumber + " 가 등록되었습니다.");
		} else {
			System.out.println("존재하는 계좌번호 입니다.");
		}
	}

	// 입금 메서드
	public void Deposit(String accountnum, double money) {
		if (account.containsKey(accountnum)) {
			account.put(accountnum, money + account.get(accountnum));
			bankMoney += money;
			System.out.println("[" + this + "] 계좌 " + accountnum + " 에 " + money + "원이 입금되었습니다.");
		} else {
			System.out.println("존재하지 않는 계좌번호 입니다.");
			return;
		}
	}

	// 출금 메서드
	public void Withdraw(String accountnum, double money) {
		if (bankMoney > money) {

			account.put(accountnum, account.get(accountnum) - money);
			bankMoney -= money;
		} else {
			System.out.println("은행 보유 금액이 부족하여 출금할 수 없습니다.");
			return;
		}
	}

}

class Owner {
	// 소유자 변수
	private String name;
	private double balance;
	private Map<String, Double> account;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Owner(String name, double balance) {
		this.name = name;
		this.balance = balance;
		this.account = new HashMap<>();
	}
	@Override
	public String toString() {
		return name;
	}
	// 계좌 등록 메서드
	public void Register(String accountnumber, Bank bank) {
		if (account.containsKey(accountnumber)) {
			System.out.println("이미 등록되어있는 계좌입니다.");
			return;
		} else {
			bank.Register(accountnumber);
			account.put(accountnumber, 0.0);
			System.out.println("[" + this + "] 계좌번호 : " + accountnumber + " 가 등록되었습니다.");
		}
	}

	// 입금 메서드
	public void Deposit(String accountnum, double money, Bank bank) {

		if (!account.containsKey(accountnum)) {
			System.out.println("존재하지 않는 계좌번호 입니다.");
			return;
		}
		if (balance < money) {
			System.out.println("보유 금액이 부족합니다.");
			return;
		}
		bank.Deposit(accountnum, money);
		account.put(accountnum, money + account.get(accountnum));
		balance -= money;
		System.out.println("[" + this + "] 계좌 " + accountnum + " 에 " + money + "원이 입금되었습니다.");
	}

	// 출금 메서드
	public void Withdraw(String accountnum, double money, Bank bank) {
		if (!account.containsKey(accountnum)) {
			System.out.println("존재하지 않는 계좌번호 입니다.");
			return;
		}
		bank.Withdraw(accountnum, money);
		account.put(accountnum, account.get(accountnum) - money);
		balance += money;

	}

}

public class BankService {
	public static void main(String[] args) {
		// 은행 객체 생성
		Bank b1 = new Bank("MyBank", 1000000.0);

		// 사용자 객체 생성
		Owner owner = new Owner("홍길동", 50000.0);

		// 계좌 등록
		owner.Register("123-456", b1);

		// 입금 테스트
		owner.Deposit("123-456", 20000, b1);

		// 출금 테스트
		owner.Withdraw("123-456", 10000, b1);

	}
}
