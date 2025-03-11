package Ch08;

// 홍길동이 사과 장수에게 사과를 구매한다.

// 속성
// 구매자 (속성)
// 보유 금액, 사과 개수

// 판매자 (속성)
// 보유 금액, 사과 개수, 개당 가격

// 기능
// 구매 (기능)
// 내 보유 금액 - 구매 비용, 사과 개수 + 산 사과 개수

// 판매 (기능)
// 내 보유 금액 + 판매한 금액, 사과 개수 - 팔린 사과 개수
// 금액은 팔린 사과 개수 * 사과 가격

class Buyer {
	private int Bmoney;
	private int Bamount;

	Buyer(int Bmoney, int Bamount) {
		this.Bmoney = Bmoney;
		this.Bamount = Bamount;
	}

	@Override
	public String toString() {
		return "Buyer [보유 금액 : " + Bmoney + "원, 보유 사과 개수 : " + Bamount + "개]";
	}

	public int getBmoney() {
		return Bmoney;
	}

	public void setBmoney(int bmoney) {
		if(bmoney < 0) {
			System.out.println("구매자 보유금액 입력 오류");
			return;
		}
		this.Bmoney = bmoney;
	}

	public int getBamount() {
		return Bamount;
	}

	public void setBamount(int bamount) {
		if(bamount < 0) {
			System.out.println("구매자 사과개수 입력 오류");
			return;
		}
		this.Bamount = bamount;
	}

	public void payment(Seller seller, int paymoney) {

		if (Bmoney < paymoney) {
			System.out.println("돈이 부족합니다.");
			return;
		} else if (paymoney / seller.getPrice() > seller.getSamount()) {
			System.out.println("판매자가 보유한 사과보다 더 많이 주문하셨습니다.");
			return;
		}
		
		setBmoney(getBmoney() - paymoney);
		setBamount(getBamount() + paymoney / seller.getPrice());
		seller.selling(paymoney);

	}
}

class Seller {
	private int Smoney;
	private int Samount;
	private int price;

	Seller(int Smoney, int Samount, int price) {
		this.Smoney = Smoney;
		this.Samount = Samount;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Seller [보유 금액 : " + Smoney + "원, 보유 사과 개수 : " + Samount + "개, 개당 가격 : " + price + "원]";
	}

	public void selling(int paymoney) {
		setSmoney(getSmoney() + paymoney);
		setSamount(getSamount() - paymoney/getPrice());
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price < 0) {
			System.out.println("판매자 판매금액 입력 오류");
			return;
		}
		this.price = price;
	}

	public int getSamount() {
		return Samount;
	}

	public void setSamount(int samount) {
		if(samount < 0) {
			System.out.println("판매자 보유개수 입력 오류");
			return;
		}
		this.Samount = samount;
	}

	public int getSmoney() {
		return Smoney;
	}

	public void setSmoney(int smoney) {
		if(smoney < 0) {
			System.out.println("판매자 보유 금액 입력 오류");
			return;
		}
		this.Smoney = smoney;
	}

}

public class C10Main {
	public static void main(String[] args) {
		Seller seller = new Seller(10000, 100, 1000);

		Buyer 홍길동 = new Buyer(10000, 0);
		Buyer 노홍철 = new Buyer(5000, 0);

		홍길동.payment(seller, 5000);
		노홍철.payment(seller, 2000);

		System.out.println(홍길동);
		System.out.println(노홍철);
		System.out.println(seller);

	}
}
