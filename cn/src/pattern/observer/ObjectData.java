package pattern.observer;

import java.util.Date;

public class ObjectData {
    private Date date;

    private String weather;

    public ObjectData() {
    }

    public ObjectData(Date date, String weather) {
        this.date = date;
        this.weather = weather;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "ObjectData{" +
                "date=" + date +
                ", weather='" + weather + '\'' +
                '}';
    }
}
