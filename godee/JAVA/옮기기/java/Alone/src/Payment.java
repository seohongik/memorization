class Drink {
	String name;
	int price;
	int count;
	
	Drink(String n, int p, int c) {
		name=n;
		price=p;
		count=c;
	}
	
	int getTotalPrice() {
		return count*price;
	}
	
	static void printTitle() {
		System.out.println("상품명\t\t단가\t수량\t금액");
	}
	
	void pirntData() {
		System.out.println(name+"\t"+price+"\t"+count+"\t"+getTotalPrice());
	}
}

class Alcohol extends Drink {
	float alcper;
	
	Alcohol(String n, int p, int c, float a) {
		super(n,p,c);
		alcper=a;
	}
	
	static void printTitle() {
		System.out.println("상품명(도수[%])\t단가\t수량\t금액");
	}
	
	void printData() {
		System.out.println(name+"("+alcper+")"+"\t"+price+"\t"+count+"\t"+getTotalPrice());
	}
}

public class Payment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Drink coffee = new Drink("커피", 200, 3);
		Drink tea = new Drink("녹차", 150 , 2);
		Alcohol wine == new Alcohol("와인", 300, 2, 15.0f);
	}

}
