/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Simulator;
/**
 *
 * @author Lenovo
 */
public class SensorData {

    private int eq_type;
    private int eq_id;
    private String eq_name;
    ParameterData[] param;
    String Tag;

    
    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public int getEq_type() {
        return eq_type;
    }

    public void setEq_type(int eq_type) {
        this.eq_type = eq_type;
    }

    public int getEq_id() {
        return eq_id;
    }

    public void setEq_id(int eq_id) {
        this.eq_id = eq_id;
    }

    public String getEq_name() {
        return eq_name;
    }

    public void setEq_name(String eq_name) {
        this.eq_name = eq_name;
    }

    public ParameterData[] getParam() {
        return param;
    }

    public void setParam(ParameterData[] param) {
        this.param = param;
    }

}
