package facade;

public class Amplifier {

    StreamingPlayer player ;

    public Amplifier(StreamingPlayer player){
        this.player= player;
    }

    final String KIND_OF_AMP = "엠프";

    public void on() {
        System.out.println(KIND_OF_AMP+"가 켜졌습니다.");
    }

    public void setStreamingPlayer() {
        System.out.println(KIND_OF_AMP+"를 "+player.getClass().getSimpleName()+"플에이어와 연결합니다.");
    }

    public void setSurroundSound() {
        System.out.println(KIND_OF_AMP+"를 서라운드 모드롤 설정합니다(5.1채널)");
    }

    public void setVolume(int i) {
        System.out.println(KIND_OF_AMP+"볼륨을 "+i+" 로 설정합니다.");
    }

    public void off() {
        System.out.println(KIND_OF_AMP+"가 꺼졌습니다.");
    }
}
