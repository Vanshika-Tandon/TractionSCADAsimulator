/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Simulator;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Lenovo
 */
public class mainClass {

    public static void main(String[] args) {
        File file = new File("xml/RTU_Overview.xml");
        String filePath = file.getAbsolutePath();
        readmyXML(filePath);
    }

    private static void readmyXML(String path) {
        try {
            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("\n ROOT :" + doc.getDocumentElement().getNodeName());

            NodeList nodeList_rtu = doc.getElementsByTagName("RTU");
            Global.rtu_data = new RTUData[nodeList_rtu.getLength()];
            for (int itr_rtu = 0; itr_rtu < nodeList_rtu.getLength(); itr_rtu++) {

                Node node_rtu = nodeList_rtu.item(itr_rtu);
                NamedNodeMap namedmap_rtu = node_rtu.getAttributes();
//                //Get Attributes
                RTUData rTUData = new RTUData();
                rTUData.setId(Integer.parseInt(namedmap_rtu.getNamedItem("ID").getNodeValue()));
                rTUData.setIp(namedmap_rtu.getNamedItem("IP").getNodeValue());
                rTUData.setPort(namedmap_rtu.getNamedItem("Port").getNodeValue());
                rTUData.setName(namedmap_rtu.getNamedItem("Name").getNodeValue());
                rTUData.setLevel(Integer.parseInt(namedmap_rtu.getNamedItem("Level").getNodeValue()));

                if (node_rtu.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement_rtu = (Element) node_rtu;

                    // Loop for Discrete sensors
                    NodeList nodeList_pf = eElement_rtu.getElementsByTagName("POTENTIAL_FREE");
                    SensorData[] pf_sensorsData = new SensorData[nodeList_pf.getLength()];
                    for (int itr_pf = 0; itr_pf < nodeList_pf.getLength(); itr_pf++) {

                        Node node_pf = nodeList_pf.item(itr_pf);
                        NamedNodeMap namedMap = node_pf.getAttributes();

                        SensorData sensor_data = new SensorData();
                        sensor_data.setEq_type(Integer.parseInt(namedMap.getNamedItem("eq_type").getNodeValue()));
                        sensor_data.setEq_id(Integer.parseInt(namedMap.getNamedItem("eq_id").getNodeValue()));
                        sensor_data.setEq_name(namedMap.getNamedItem("eq_name").getNodeValue());

                        Element eElement_pf = (Element) node_pf;
                        if (eElement_pf.getElementsByTagName("BCH").getLength() != 0) {
                            NodeList nodes_bch = eElement_pf.getElementsByTagName("BCH");
                            ParameterData[] parameter_data = new ParameterData[nodes_bch.getLength()];
                            for (int itrs1 = 0; itrs1 < nodes_bch.getLength(); itrs1++) {
                                Node node_bch = nodes_bch.item(itrs1);
                                NamedNodeMap namedMap_bch = node_bch.getAttributes();

                                ParameterData param_data = new ParameterData();
                                param_data.setParam_name(namedMap_bch.getNamedItem("Param_Name").getNodeValue());
                                param_data.setParam_type(Integer.parseInt(namedMap_bch.getNamedItem("Param_Type").getNodeValue()));
                                param_data.setRTU_Internal_Indication(namedMap_bch.getNamedItem("RTU_Internal_Indication").getNodeValue());
                                param_data.setIEC_Address(namedMap_bch.getNamedItem("IEC_Address").getNodeValue());
                                param_data.setStatus(2);
                                parameter_data[itrs1] = param_data;

                            }
                            sensor_data.setTag("BCH");
                            sensor_data.setParam(parameter_data);
                        } else if (eElement_pf.getElementsByTagName("ITC").getLength() != 0) {
                            NodeList nodes_itc = eElement_pf.getElementsByTagName("ITC");
                            ParameterData[] parameter_data = new ParameterData[nodes_itc.getLength()];
                            for (int itrs1 = 0; itrs1 < nodes_itc.getLength(); itrs1++) {
                                Node node_itc = nodes_itc.item(itrs1);
                                NamedNodeMap namedMap_itc = node_itc.getAttributes();

                                ParameterData param_data = new ParameterData();
                                param_data.setParam_name(namedMap_itc.getNamedItem("Param_Name").getNodeValue());
                                param_data.setParam_type(Integer.parseInt(namedMap_itc.getNamedItem("Param_Type").getNodeValue()));
                                param_data.setRTU_Internal_Indication(namedMap_itc.getNamedItem("RTU_Internal_Indication").getNodeValue());
                                param_data.setIEC_Address(namedMap_itc.getNamedItem("IEC_Address").getNodeValue());
                                param_data.setStatus(2);
                                parameter_data[itrs1] = param_data;

                            }
                            sensor_data.setTag("ITC");
                            sensor_data.setParam(parameter_data);
                        }
                        else if (eElement_pf.getElementsByTagName("IS").getLength() != 0) {
                            NodeList nodes_is = eElement_pf.getElementsByTagName("IS");
                            ParameterData[] parameter_data = new ParameterData[nodes_is.getLength()];
                            for (int itrs1 = 0; itrs1 < nodes_is.getLength(); itrs1++) {
                                Node node_is = nodes_is.item(itrs1);
                                NamedNodeMap namedMap_is = node_is.getAttributes();

                                ParameterData param_data = new ParameterData();
                                param_data.setParam_name(namedMap_is.getNamedItem("Param_Name").getNodeValue());
                                param_data.setParam_type(Integer.parseInt(namedMap_is.getNamedItem("Param_Type").getNodeValue()));
                                param_data.setRTU_Internal_Indication(namedMap_is.getNamedItem("RTU_Internal_Indication").getNodeValue());
                                param_data.setIEC_Address(namedMap_is.getNamedItem("IEC_Address").getNodeValue());
                                param_data.setStatus(2);
                                parameter_data[itrs1] = param_data;
                            }
                            sensor_data.setTag("IS");
                            sensor_data.setParam(parameter_data);
                        } else if (eElement_pf.getElementsByTagName("CB").getLength() != 0) {
                            NodeList nodes_cb = eElement_pf.getElementsByTagName("CB");
                            ParameterData[] parameter_data = new ParameterData[nodes_cb.getLength()];
                            for (int itrs1 = 0; itrs1 < nodes_cb.getLength(); itrs1++) {
                                Node node_cb = nodes_cb.item(itrs1);
                                NamedNodeMap namedMap_cb = node_cb.getAttributes();

                                ParameterData param_data = new ParameterData();
                                param_data.setParam_name(namedMap_cb.getNamedItem("Param_Name").getNodeValue());
                                param_data.setParam_type(Integer.parseInt(namedMap_cb.getNamedItem("Param_Type").getNodeValue()));
                                param_data.setRTU_Internal_Indication(namedMap_cb.getNamedItem("RTU_Internal_Indication").getNodeValue());
                                param_data.setIEC_Address(namedMap_cb.getNamedItem("IEC_Address").getNodeValue());
                                param_data.setStatus(2);
                                parameter_data[itrs1] = param_data;
                            }
                            sensor_data.setTag("CB");
                            sensor_data.setParam(parameter_data);
                        }
                        pf_sensorsData[itr_pf] = sensor_data;
                        //discrete_data.put(itr_pf, sensor_data);
                    }
                    rTUData.setDiscreteSensorData(pf_sensorsData);

                    //Loop for Analog Sensors
                    NodeList nodeList_ag = eElement_rtu.getElementsByTagName("ANALOG");
                    SensorData[] ag_sensorsData = new SensorData[nodeList_ag.getLength()];
                    for (int itr_ag = 0; itr_ag < nodeList_ag.getLength(); itr_ag++) {

                        Node node_analog = nodeList_ag.item(itr_ag);
                        NamedNodeMap namedMap = node_analog.getAttributes();

                        SensorData sensor_data = new SensorData();
                        sensor_data.setEq_type(Integer.parseInt(namedMap.getNamedItem("eq_type").getNodeValue()));
                        sensor_data.setEq_id(Integer.parseInt(namedMap.getNamedItem("eq_id").getNodeValue()));
                        sensor_data.setEq_name(namedMap.getNamedItem("eq_name").getNodeValue());

                        Element eElement_analog = (Element) node_analog;
                        if (eElement_analog.getElementsByTagName("TRANSFORMER") != null) {
                            NodeList nodeList_transformer = eElement_analog.getElementsByTagName("TRANSFORMER");
                            ParameterData[] parameter_data = new ParameterData[nodeList_transformer.getLength()];

                            for (int itrs1 = 0; itrs1 < nodeList_transformer.getLength(); itrs1++) {
                                Node node_transformer = nodeList_transformer.item(itrs1);
                                NamedNodeMap namedMap_transformer = node_transformer.getAttributes();

                                ParameterData param_data = new ParameterData();
                                param_data.setParam_name(namedMap_transformer.getNamedItem("Param_Name").getNodeValue());
                                param_data.setParam_type(Integer.parseInt(namedMap_transformer.getNamedItem("Param_Type").getNodeValue()));
                                param_data.setRTU_Internal_Indication(namedMap_transformer.getNamedItem("RTU_Internal_Indication").getNodeValue());
                                param_data.setIEC_Address(namedMap_transformer.getNamedItem("IEC_Address").getNodeValue());
                                param_data.setStatus(2);
                                parameter_data[itrs1] = param_data;
                            }
                            sensor_data.setParam(parameter_data);
                        }
                        ag_sensorsData[itr_ag] = sensor_data;
                        //analog_data.put(itr_ag, sensor_data); 
                    }
                    rTUData.setAnalogSensorData(ag_sensorsData);
                }
                Global.rtu_data[itr_rtu] = rTUData;
            }
            GUIClass guiClass = new GUIClass();
          //  datahandling data= new datahandling();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(mainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
