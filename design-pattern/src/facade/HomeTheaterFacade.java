package facade;

public class HomeTheaterFacade {
    Amplifier amp;
    //Tuner tuner;
    Projector projector;
    StreamingPlayer player;
    TheaterLight light;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade(Amplifier amp
                            //,Tuner tuner
                            ,Projector projector
                            ,StreamingPlayer player
                            ,TheaterLight light
                            ,Screen screen
                            ,PopcornPopper popper)
    {
        this.amp = amp;
        //this.tuner=tuner;
        this.projector = projector;
        this.screen=screen;
        this.light = light;
        this.popper = popper;
        this.player = player;

    }

    public void watchMovie(String movie){
        System.out.println("====영화 볼 준비 중====");
        popper.on();
        popper.pop();
        light.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setStreamingPlayer();
        amp.setSurroundSound();
        amp.setVolume(5);
        player.on();
        player.play(movie);
    }
    public void endMovie(){
        System.out.println("====홈시어터 끄는 중====");
        popper.off();
        light.on();
        screen.up();
        projector.off();
        amp.off();
        player.stop();
        player.off();
    }


}
