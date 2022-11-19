
public class Ex03 {
	public static void main(String[] args) {
		int[] arr= new int[5];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] =i+1;
			
		}
		
		//System.out.println(arr.length);
	
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println();
		//¾èÀº º¹»ç
		int[] tmp = new int[arr.length*2];
		for(int i=0; i<arr.length; i++) {
			tmp[i] = arr[i];
		}
		
		for(int i=0; i<tmp.length; i++) {
			System.out.println(tmp[i]);
		}
		
		System.out.println(arr);
		System.out.println(tmp);
		System.out.println();
		//±íÀº º¹»ç
		arr =tmp;
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);			
		}
		System.out.println();
		System.out.println(arr);
		System.out.println(tmp);
	}	
}