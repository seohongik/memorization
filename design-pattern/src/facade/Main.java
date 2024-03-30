package facade;

public class Main {

    /** 어뎁터는 인터페이스를 변경해서 클라이언트에서 필요로 하는 인터페이스를 적응시키는 용도로 쓰고
     * 파사드는 어떤 서브시스템에 대해 간단한 인터페이스를 제공하는 용도로 쓴다.*/

    /*
    * 파사드 페턴(Facade Pattern)은 서브시스템에 있는 일련의 인터페이스를 통합 인터페이스로 묶어 줍니다.
    * 또한 고수준 인터페이스에도 정의하므로 서브시스템을 더 편린하게 사용할 수 있습니다.
    *
    * */
    public static void main(String[] args) {

        String movie = "인디아나 존스:레이더스";
        StreamingPlayer player=new StreamingPlayer(movie);

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(
                new Amplifier(player)
                //,new Tuner()
                ,new Projector()
                ,player
                ,new TheaterLight()
                ,new Screen()
                ,new PopcornPopper()
        );

        homeTheaterFacade.watchMovie(movie);
        homeTheaterFacade.endMovie();

    }
}
