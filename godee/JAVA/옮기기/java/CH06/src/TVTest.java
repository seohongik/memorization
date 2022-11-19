class TV {
	
	//필드(속성)
	String color;
	boolean power;
	int channel;

	
	
	//메서드(기능)
	void power() {
		power=!power;
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	
	
}


public class TVTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv1 = new TV();
		System.out.println(tv1.power);
		tv1.power();
		System.out.println(tv1.power);
		
		System.out.println(tv1.channel);
		tv1.channel = 7;
		System.out.println(tv1.channel);
		tv1.channelUp();
		System.out.println(tv1.channel);
		
		tv1.channelDown();
		System.out.println(tv1.channel);
		
		tv1.power();
		System.out.println(tv1.power);
		
	}

}
