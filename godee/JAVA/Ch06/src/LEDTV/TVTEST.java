package LEDTV;
class TV{
	
	String color;
	boolean power;
	int channel;
	
	void power() {
		power=!power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}
public class TVTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV[] tvArr = new TV[2];//�׳� �迭
		for(int i=0; i<tvArr.length; i++) {
			
			tvArr[i] =new TV();//color power channel�� �Ѳ����� ��� �ν��Ͻ�ȭ
			tvArr[i].channel=i+10;
			
		}
		
		for(int i=0; i<tvArr.length; i++) {
			
			tvArr[i].channelUp();
			System.out.println(tvArr[i].channel);
		}
		
		
	}

}