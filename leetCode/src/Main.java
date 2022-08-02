import java.util.Arrays;

class Main{

    public static void main(String[] args) {

        SelectTwoNumAndAdd selectTwoNumAndAdd  =new SelectTwoNumAndAdd();

        int[] numbers= new int[]{2,1,3,4,1};
        int[] result=selectTwoNumAndAdd.selectTwoNumAndAdd(numbers);

        for (int i=0; i<result.length; i++){

            System.out.println(result[i]);
        }
    }
}
