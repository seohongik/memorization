package singleton;

public class ChocolateBoiler {

    private boolean empty;
    public boolean boiled;

    /*
    // private static ChocolateBoiler chocolateBoiler;
    //첫번째 방법 속도 중요하지 않으면 멀티 스레드 환경서  synchronized
    public static synchronized ChocolateBoiler getInstance(){

        if(chocolateBoiler==null){

            return new ChocolateBoiler();
        }

        return chocolateBoiler;
    };
    */


    /*
    // 방법 2 아예 처음 부터 만들어서 return
    private static ChocolateBoiler chocolateBoiler = new ChocolateBoiler();

    public static ChocolateBoiler getInstance(){
        return chocolateBoiler;
    }*/



    /*
    volatile keyword는 Java 변수를 Main Memory에 저장하겠다라는 것을 명시하는 것입니다.
        매번 변수의 값을 Read할 때마다 CPU cache에 저장된 값이 아닌 Main Memory에서 읽는 것입니다.
        또한 변수의 값을 Write할 때마다 Main Memory에 까지 작성하는 것입니다.
    */


    // 벙법 3 DCL( Double-Checked Locking   ) 써서 getInstace()에서 동기화 되는 부분을 줄인다.
    private volatile static  ChocolateBoiler chocolateBoiler;
    public static ChocolateBoiler getInstance(){
        if(chocolateBoiler==null){
            synchronized (ChocolateBoiler.class){
                if(chocolateBoiler==null){
                    chocolateBoiler = new ChocolateBoiler();
                }
            }
        }

        return chocolateBoiler;
    }

    private ChocolateBoiler() {
        empty=true;
        boiled=false;
    }

    public void fill(){
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(!isEmpty()&&isBoiled()){
            empty=true;
        }
    }

    public void boil(){
        if(!isEmpty()&&!isBoiled()){
            boiled=true;
        }
    }



    public  boolean isEmpty(){
        return this.empty;
    }

    public boolean isBoiled(){
        return this.boiled;
    }

}
