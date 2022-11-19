
public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Kim", "Park", "Lee"};
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
		String tmp = names[2];
		System.out.println(tmp);
		
		names[0] = "You";
		for(String str : names) {
			System.out.println(str);
		}
	}

}
