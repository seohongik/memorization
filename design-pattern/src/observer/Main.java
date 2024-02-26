package observer;

public class Main {

    /***
     *
     * 옵저버 패턴(Observer Pattern)은 한 객체의 상태가 바뀌면 그 객체의 의존하는 다른 객체에게 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다 (one to many) 의존성을 정의한다.
     *
     * */
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        DumpedSoonDisplay dumpedSoonDisplay = new DumpedSoonDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.removeObserver(dumpedSoonDisplay);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);

    }
}
