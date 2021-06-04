package com.example.webapp.Model;

import java.util.ArrayList;

// POJO - Plain Old Java Object
public class Weather {
   private String timezone;
   private Current current;
   ArrayList<Hour> hourly = new ArrayList<>();
   ArrayList<Day> daily = new ArrayList<>();

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public ArrayList<Hour> getHourly() {
        return hourly;
    }

    public void setHourly(ArrayList<Hour> hourly) {
        this.hourly = hourly;
    }

    public ArrayList<Day> getDaily() {
        return daily;
    }

    public void setDaily(ArrayList<Day> daily) {
        this.daily = daily;
    }

    public class Current{
       private int dt;
       private int sunrise;
       private int sunset;
       private float temp;
       private float pressure;
       private float humidity;
       private float uvi;
       private float wind_speed;
       ArrayList<WeatherDesc> weather = new ArrayList<>();

        public ArrayList<WeatherDesc> getWeather() {
            return weather;
        }

        public void setWeather(ArrayList<WeatherDesc> weather) {
            this.weather = weather;
        }

        public int getDt() {
            return dt;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

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

        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public float getPressure() {
            return pressure;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        public float getHumidity() {
            return humidity;
        }

        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }

        public float getUvi() {
            return uvi;
        }

        public void setUvi(float uvi) {
            this.uvi = uvi;
        }

        public float getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(float wind_speed) {
            this.wind_speed = wind_speed;
        }
    }


   public class WeatherDesc{
       private String description;
       private String icon;

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
   }

   public class Hour{
       private int dt;
       private float temp;
       ArrayList<WeatherDesc> weather = new ArrayList<>();

       public int getDt() {
           return dt;
       }

       public void setDt(int dt) {
           this.dt = dt;
       }

       public float getTemp() {
           return temp;
       }

       public void setTemp(float temp) {
           this.temp = temp;
       }

       public ArrayList<WeatherDesc> getWeather() {
           return weather;
       }

       public void setWeather(ArrayList<WeatherDesc> weather) {
           this.weather = weather;
       }
   }

   public class Day{
       private int dt;
        private Temp temp;
        private int sunrise;
        private int sunset;
       ArrayList<WeatherDesc> weather = new ArrayList<>();

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

       public int getDt() {
           return dt;
       }

       public void setDt(int dt) {
           this.dt = dt;
       }

       public Temp getTemp() {
           return temp;
       }

       public void setTemp(Temp temp) {
           this.temp = temp;
       }

       public ArrayList<WeatherDesc> getWeather() {
           return weather;
       }

       public void setWeather(ArrayList<WeatherDesc> weather) {
           this.weather = weather;
       }

       public class Temp{
           private float max;
           private float min;

           public float getMax() {
               return max;
           }

           public void setMax(float max) {
               this.max = max;
           }

           public float getMin() {
               return min;
           }

           public void setMin(float min) {
               this.min = min;
           }
       }
   }


}
