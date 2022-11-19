
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
		for(int i=0; i<score.length ; i++ ) {//행의 길이
			for(int j=0; j<score[i].length; j++) {// 열의길이
				sum=sum +score[i][j];
			}//end of 안쪽 for
		
		}//end of 바깥 for
			System.out.println(sum);
			
			sum=0;
			for(int[] i : score) {
				for(int j :i) {
					//sum =sum + score[i][j]; 
					sum = sum +j;
				}//end of 안쪽 어드벤스 for
				
			}//end of 바깥 어드벤스 for
			System.out.println(sum);
	}
}


