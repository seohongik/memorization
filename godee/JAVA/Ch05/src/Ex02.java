
public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1= new int[10];
		
		int[] arr2 = new int[10];
		int[] arr3 = {100,90,80,70,60};
		
		for(int i=0; i<arr1.length; i++) {
			arr1[i] =i+1;		
		}
		for(int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
	}

		for(int i =0; i<arr2.length; i++) {
		 	arr2[i] = (int)(Math.random()*10)+1;
		}
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		for(int i=0; i<arr3.length; i++) {
			System.out.printf("%3d", arr3[i]);
		}
	
	}
	
}