package singleton;

public class SingletonAsis {

    private static SingletonAsis singletonAsis;

    private SingletonAsis(){}

    public  static SingletonAsis getInstance(){

        if(singletonAsis==null){
            return new SingletonAsis();
        }

        return singletonAsis;
    }

}
