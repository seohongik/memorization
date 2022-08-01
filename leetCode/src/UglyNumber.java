import org.omg.CORBA.MARSHAL;

import java.util.*;

public class UglyNumber {

    public static boolean isUgly(int n) {

        n=7;
        int answer = 0;

        if(n<1){

            return false;
        }

        if(n==1){
            return true;
        }

        int[] number = new int[n+1];

        //2부터 n까지의 수를 배열에 넣는다.
        for(int i=2; i<=n; i++) {
            number[i] = i;
        }

        int times=0;

        //2부터 시작해서 그의 배수들을 0으로 만든다.
        //후에 0이면 넘어가고 아니면 그의 배수들을 다시 0으로 만든다.
        for(int i=2; i<=n; i++) {

            for(int j= 2*i; j<n; j += i) {
                number[j] = 0;

            }

            //System.out.println(number[i]);

            times = number[i];

            if(number[i]!=0 && (number[i]==2 || number[i]==3 || number[i]==5 )) {
                if (times * 2 == n || times * 3 == n || times * 5 == n) {

                    System.out.println("if" + times);
                }
            }
            if(number[i]!=0 && (number[i]!=2 || number[i]!=3 || number[i]!=5 )) {

                if (times * 2 != n || times * 3 != n || times * 5 != n) {

                    System.out.println("else if" + times);
                }
            }


        }


        //배열에서 0이 아닌 것들의 개수를 세준다.
        for(int i=0; i<number.length; i++) {
            if(number[i]!=0) {
                answer++;
            }




        }

        return true;
    }

}
