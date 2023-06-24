/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Simulator;

/**
 *
 * @author Lenovo
 */
public class RTUData {
    
    SensorData[] analogSensorData;
    SensorData[] discreteSensorData;  
    int id;
    String ip;
    String port;
    String name;
    int level;

    public SensorData[] getAnalogSensorData() {
        return analogSensorData;
    }

    public void setAnalogSensorData(SensorData[] analogSensorData) {
        this.analogSensorData = analogSensorData;
    }

    public SensorData[] getDiscreteSensorData() {
        return discreteSensorData;
    }

    public void setDiscreteSensorData(SensorData[] discreteSensorData) {
        this.discreteSensorData = discreteSensorData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    
}
