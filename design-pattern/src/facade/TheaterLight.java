package facade;

public class TheaterLight {

    final String KIND_OF_LIGHT= "조명";
    public void dim(int i) {
        System.out.println(KIND_OF_LIGHT+"밝기를 " +i+"% 로 설정합니다.");
    }

    public void on() {
        System.out.println(KIND_OF_LIGHT+"을 끕니다.");
    }
}
