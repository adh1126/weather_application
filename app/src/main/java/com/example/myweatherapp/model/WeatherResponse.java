package com.example.myweatherapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.Inet4Address;
import java.util.List;

public class WeatherResponse {

    @SerializedName("timezone")
    public Integer timezone;

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    @SerializedName("sys")
    public Sys sys;
    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }
    @SerializedName("rain")
    public Rain rain;

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public class Rain {
        @SerializedName("1h")
        public float h1;

        public float getH1() {
            return h1;
        }

        public void setH1(float h1) {
            this.h1 = h1;
        }
    }

    @SerializedName("main")
    public Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @SerializedName("weather")
    public List<Weather> weather;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("name")
    public String name;

    public class Main {
        @SerializedName("sea_level")
        public Integer seaLevel;
        public Integer getSeaLevel() {
            return seaLevel;
        }

        public void setSeaLevel(Integer seaLevel) {
            this.seaLevel = seaLevel;
        }

        @SerializedName("temp")
        public float temp;
        public float feels_like;

        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public float getTempMin() {
            return tempMin;
        }

        public void setTempMin(float tempMin) {
            this.tempMin = tempMin;
        }

        public float getTempMax() {
            return tempMax;
        }

        public void setTempMax(float tempMax) {
            this.tempMax = tempMax;
        }

        @SerializedName("temp_min")
        public float tempMin;

        @SerializedName("temp_max")
        public float tempMax;

        @SerializedName("humidity")
        public int humidity;

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    public class Weather {
        @SerializedName("main")
        public String main;

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        @SerializedName("description")
        public String description;

        @SerializedName("icon")
        public String icon;
    }

    @SerializedName("wind")
    public Wind wind;

    public Wind getWind() {
        return wind;
    }

    public Wind setWind(Wind wind){
        this.wind = wind;
        return wind;
    }

    public class Wind{
        @SerializedName("speed")
        public Double speed;

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }
    }

    public class Sys {

        @SerializedName("country")
        private String country;
        @SerializedName("sunrise")
        public int sunrise;

        @SerializedName("sunset")
        public int sunset;

        public int getSunrise() {
            return sunrise;
        }

        public void setSunrise(int sunrise) {
            this.sunrise = sunrise;
        }

        public int getSunset() {
            return sunset;
        }

        public void setSunset(int sunset) {
            this.sunset = sunset;
        }

    }


}
