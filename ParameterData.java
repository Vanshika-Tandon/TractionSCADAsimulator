/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Simulator;

/**
 *
 * @author Lenovo
 */
public class ParameterData {
    String param_name;
    int param_type;
    String RTU_Internal_Indication;
    String IEC_Address;
    int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getParam_name() {
        return param_name;
    }

    public void setParam_name(String param_name) {
        this.param_name = param_name;
    }

    public int getParam_type() {
        return param_type;
    }

    public void setParam_type(int param_type) {
        this.param_type = param_type;
    }

    public String getRTU_Internal_Indication() {
        return RTU_Internal_Indication;
    }

    public void setRTU_Internal_Indication(String RTU_Internal_Indication) {
        this.RTU_Internal_Indication = RTU_Internal_Indication;
    }

    public String getIEC_Address() {
        return IEC_Address;
    }

    public void setIEC_Address(String IEC_Address) {
        this.IEC_Address = IEC_Address;
    }  

    
}