import java.util.Scanner;

public class Ex03 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Scanner sc=new Scanner(System.in);
      
      int pure=sc.nextInt();
      
      System.out.println("��  :"+fact(pure));
      
      
   }
   
     public static int fact(int pure) {
   
      if(pure>0) {
         System.out.printf(pure+"*");
         
         return pure * fact(pure - 1);
         
         
      }else {
    	  
         return 1;
         
      }
      
   }   

}
