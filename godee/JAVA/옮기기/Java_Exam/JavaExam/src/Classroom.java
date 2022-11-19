class Test {
	String subject;
	int point;
	
	void setPoint(String s, int p) {
		subject = s;
		point = p;
	}
	
	String getPoint () {
		return subject + ":" + point;
	}
	
}


class Student {
	int id;
	String name;
	int subnum;
	Test[] test;
	
	Student (int i, String n, int s) {
		id = i;
		name = n;
		subnum = s;
		test = new Test[s];
		for(int j = 0; j <s; j++) {
			test[j] = new Test();
		}
	}
	
	String getName() {
		return id + ":" + name;
	}
}


public class Classroom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
