package ru.exwhythat.yather.network.weather.parts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sinjvf on 16.07.2017.
 * Data class describes main weather data
 */

public class Main {

    @SerializedName("temp") @Expose
    private double temp;
    @SerializedName("pressure") @Expose
    private double pressure;
    @SerializedName("humidity") @Expose
    private int humidity;
    @SerializedName("temp_min") @Expose
    private double tempMin;
    @SerializedName("temp_max") @Expose
    private double tempMax;
    @SerializedName("sea_level") @Expose
    private double seaLevel;
    @SerializedName("grnd_level") @Expose
    private double grndLevel;
    @SerializedName("temp_kf") @Expose
    private int tempKf;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public int getTempKf() {
        return tempKf;
    }

    public void setTempKf(int tempKf) {
        this.tempKf = tempKf;
    }
}
