package facade;

public class StreamingPlayer {

    String movie;

    public StreamingPlayer(String movie){
        this.movie=movie;
    }


    final String KIND_OF_PLAYER= "스트리밍 플레이어";

    public void on() {
        System.out.println(KIND_OF_PLAYER+"가 켜졌습니다.");
    }

    public void play(String movie) {
        this.movie = movie;
        System.out.println(KIND_OF_PLAYER+"에서 "+movie+" 를 재생합니다.");
    }

    public void stop() {
        System.out.println(KIND_OF_PLAYER+"에서"+ movie+ "재생을 종료 합니다.");
    }

    public void off() {
        System.out.println(KIND_OF_PLAYER+"가 꺼졌습니다.");
    }
}
