
public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] score = {
				{100, 100, 100}
				,{20, 20, 20}
				,{30, 30, 30}
				,{40, 40, 40}
				,{50, 50, 50}
		}; // 각 학생의 점수값을 다중배열로 정리해 둡니다.
		
		System.out.println("  번호     국어     영어     수학     총점     평균"); // 각 과목명을 적어줍니다.
		System.out.println("================================"); // 라인을 그어줍니다.
		
		
		// 점수의 배열의 담겨져 있는 수를 불러 올 수 있는 포문을 생성해줍니다.
		for(int i=0; i<score.length; i++) {
			System.out.printf("%3d", i+1); // 학생의 인덱스를 지정하기 위한 출력문입니다.
			int sum=0; // 학생의 과목의 합을 담아 두는 변수를 지정합니다.
			double avg = 0.0f; // 학생의 과목의 평균을 내기 위한 double형의 변수를 만들어 줍니다.
			for(int j=0; j<score[i].length; j++) {
				System.out.printf("%5d", score[i][j]);
				sum += score[i][j]; // 총점과 평균을 구하기위해 배열의 열의 값을 미리 지정해둔 변수 sum에 더해줍니다.
			} avg = sum/score[i].length; // 과목의 합을 배열의 수로 나누어 평균을 구해줍니다.
			System.out.printf("%5d", sum); // 과목의 합을 출력합니다. 서식을 지정해주어 라인을 정리해줍니다.
			System.out.printf("%6.1f", avg); // 미리 값을 정해두었던 평균 값을 합과 마찬가지로 서식을 지정해주어 출력합니다.
			System.out.println(); // 개행을 합니다.
		}  System.out.println("================================"); //라인을 그어줍니다.
		System.out.print("총점:");
		// 세로의 합을 구하기 위한 for문을 위의 인덱스 값을 리버스한 형식으로 만들어줍니다.
		for(int i=0; i<score[i].length; i++) {
			int allSum =0; // 각각의 과목의 합을 담는 값을 담는 변수를 만듭니다.
			for(int j=0; j<score.length; j++) {
				 allSum += score[j][i];
			} System.out.printf("%5d", allSum); // 각각의 변수를 출력합니다.
		}
	}
}
