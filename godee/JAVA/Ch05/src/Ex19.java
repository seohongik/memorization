
public class Ex19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] score= {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
				
		};
		int sum=0;
		for(int i=0; i<score.length ; i++ ) {//���� ����
			for(int j=0; j<score[i].length; j++) {// ���Ǳ���
				sum=sum +score[i][j];
			}//end of ���� for
		
		}//end of �ٱ� for
			System.out.println(sum);
			
			sum=0;
			for(int[] i : score) {
				for(int j :i) {
					//sum =sum + score[i][j]; 
					sum = sum +j;
				}//end of ���� ��庥�� for
				
			}//end of �ٱ� ��庥�� for
			System.out.println(sum);
	}
}

