package singleton;

public class Main {

    /**
     *  싱글턴 패턴(Singleton Patten)은 클래스 인스턴스를 하나만 만들고, 그 인스턴스로의 전역 접근을 제공함
     *
     * */


    public static void main(String[] args) {
        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();

        System.out.println(chocolateBoiler);
        System.out.println(chocolateBoiler);

    }

}
