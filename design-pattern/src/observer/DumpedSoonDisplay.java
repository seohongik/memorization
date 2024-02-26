package observer;

public class DumpedSoonDisplay implements Observer, DisplayElement{

    private float temperature;
    private  float humidity;

    private WeatherData weatherData;

    public DumpedSoonDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);


    }
    @Override
    public void display() {
        System.out.println("곧 구독 취소");
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();

    }
}
