
public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = new int[5];
		int k = 1;
		
		score[0] = 50;
		score[1] = 60;
		score[2] = 70;
		score[k+2] = 80;
		score[k+3] = 90;
//		score[5] = 100;
		
		int sum = 0;
		for(int i=0; i<score.length;i++) {
			sum += score[i];
			System.out.println(score[i]);
		}
		System.out.println(sum);
	}

}
