
public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Kim","Park","Lee"};
		
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		String temp =names[2];
		System.out.println(temp);
		
		names[0] ="you";
		for(String str : names) {
			System.out.println(str);
		}
	}

}
