class TV{
	//�ʵ�(�Ӽ�)
	String color;
	boolean power;
	int channel;
	
	
	//�޼���(���)
	void power() {
		power=!power;//�Ű������� ������ this ������ �Ⱦ�
	}
	
	void chanelUp() {
		channel++;
		
	}
	void chanelDown() {
		channel--;
	}
	
	
}



public class TVtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TV tv1=new TV();
		
		System.out.println(tv1.power);
		
		tv1.power();
		System.out.println(tv1.power);
		
		System.out.println(tv1.channel);
		tv1.channel=7;
		System.out.println(tv1.channel);
		
		tv1.chanelUp();
		tv1.chanelUp();
		System.out.println(tv1.channel);
		
		tv1.chanelDown();
		System.out.println(tv1.channel);
		
		tv1.power();
		System.out.println(tv1.power);

	}

}