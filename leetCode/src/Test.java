import java.util.ArrayList;

public class Test {



    public  void  test(){

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(3);
        list.add(4);

        for (int i=0; i<list.size(); i++) {

            ArrayList<Integer> newList = new ArrayList<>();

            newList.add(6);
            newList.add(7);

            testFor(newList, i);


        }

    }

    public void testFor(ArrayList<Integer> newlist , int idx ){


        for(int j=0; j<newlist.size(); j++){

            if(idx<=0){
                System.out.println(newlist.get(j));
            }
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }
}
