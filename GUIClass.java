/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Simulator;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;


/*
1. in the last rtu there is another tag named ITC
2. Add RTU information somewhere in the GUI 

 */
public class GUIClass {
    
   // public static paramforfile [] = new paramforfile[100];

    GUIClass() {
        
        
        JTabbedPane rtu_tabPane = new JTabbedPane();

        for (int rtu_itr = 0; rtu_itr < Global.rtu_data.length; rtu_itr++) {

            MigLayout layout = new MigLayout("hidemode 3, nocache");

            JPanel rtuPanel = new JPanel();
            rtuPanel.setLayout(layout);

            JPanel BCH_Panel = new JPanel();
            BCH_Panel.setLayout(new MigLayout("hidemode 3, nocache"));

            JPanel IS_Panel = new JPanel();
            IS_Panel.setLayout(new MigLayout("hidemode 3, nocache"));

            JPanel CB_Panel = new JPanel();
            CB_Panel.setLayout(new MigLayout("hidemode 3, nocache"));
            
            JPanel ITC_Panel = new JPanel();
            ITC_Panel.setLayout(new MigLayout("hidemode 3, nocache"));

            JPanel TFM_Panel = new JPanel();
            TFM_Panel.setLayout(new MigLayout("hidemode 3, nocache"));

            JTabbedPane rtu_child_tabPane = new JTabbedPane();
            
            JPanel Is_Panel_pg1 = new JPanel();
            Is_Panel_pg1.setLayout(new MigLayout("hidemode 3, nocache"));

            JPanel Is_Panel_pg2 = new JPanel();
            Is_Panel_pg2.setLayout(new MigLayout("hidemode 3, nocache"));

            JPanel CB_Panel_pg1 = new JPanel();
            CB_Panel_pg1.setLayout(new MigLayout("hidemode 3, nocache"));

            JPanel CB_Panel_pg2 = new JPanel();
            CB_Panel_pg2.setLayout(new MigLayout("hidemode 3, nocache"));
            
            JPanel TFM_Panel_pg1 = new JPanel();
            TFM_Panel_pg1.setLayout(new MigLayout("hidemode 3, nocache"));
            
            JPanel TFM_Panel_pg2 = new JPanel();
            TFM_Panel_pg2.setLayout(new MigLayout("hidemode 3, nocache"));

            JTabbedPane is_tab = new JTabbedPane();
            JTabbedPane cb_tab = new JTabbedPane();
             JTabbedPane tfm_tab = new JTabbedPane();

            RTUData rTUData = Global.rtu_data[rtu_itr];

            //For Analog Sensor: Transformer panel
            SensorData[] ag_sensorData = rTUData.getAnalogSensorData();
          //  int tfm=0;
            for (int i = 0; i < ag_sensorData.length; i++) {

                JPanel panel = new JPanel();
                panel.setLayout(new MigLayout("hidemode 3, nocache"));
                panel.setBorder(new TitledBorder(ag_sensorData[i].getEq_name()));

                ParameterData[] pm = ag_sensorData[i].getParam();
                for (ParameterData pm1 : pm) {
                    JRadioButton radioButton = new JRadioButton();
                    JLabel rbLabel = new JLabel(pm1.getParam_name());
                    JTextField tText= new JTextField("0.00");

                        
                     tText.setEnabled(false);
                        radioButton.addItemListener(evt -> 
                        {
                            // Array
                            
                            tText.setEnabled(evt.getStateChange() == ItemEvent.SELECTED); 
                        
                        });
                    panel.add(radioButton, "width 5%,split 2");
                    panel.add(rbLabel, "width 10%");
                        panel.add(tText, "width 20%,wrap");
                   
                }

                int flag = i + 1;
               // tfm++;
                         //   if (flag <= 9) {
                                    if (flag == 0) {
                                        TFM_Panel.add(panel, "width 40%,height 40%");

                                    } else if (flag % 3 == 0) {
                                        TFM_Panel.add(panel, "width 40%,height 40%, wrap");
                                    } else {
                                        TFM_Panel.add(panel, "width 40%,height 40%");
                                    }
            
//                                } else {
//                                    if (flag == 0) {
//                                        TFM_Panel_pg2.add(panel, "width 40%,height 40%");
//                                    } else if (flag % 3 == 0) {
//                                        TFM_Panel_pg2.add(panel, "width 40%,height 40%, wrap");
//                                    } else {
//                                        TFM_Panel_pg2.add(panel, "width 40%,height 40%");
//                                    }
//
//                                }
            }
        
    

            //For Discrete Sensor : BCH,IS,CB
            SensorData[] pf_sensorData = rTUData.getDiscreteSensorData();
            int is = 0, cb = 0, bch = 0, itc=0;
            for (int i = 0; i < pf_sensorData.length; i++) {
                JPanel panel = new JPanel();
                panel.setLayout(new MigLayout("fillx"));
                panel.setBorder(new TitledBorder(pf_sensorData[i].getEq_name()));

                ParameterData[] pm = pf_sensorData[i].getParam();
                if (pm != null) {
                    for (int pm1 = 0; pm1 < pm.length; pm1++) {
                        JRadioButton radioButton = new JRadioButton();
                        JLabel rb1Label = new JLabel(pm[pm1].getParam_name());
                        //JTextField tText = new JTextField();
                        String[] items1 = {"H/W SIM", "OPEN", "CLOSE"};
                        JComboBox<String> comboBox1 = new JComboBox<>(items1);
                        comboBox1.setEnabled(false);
                        radioButton.addItemListener(evt -> 
                        {
                            // Array
                            
                            comboBox1.setEnabled(evt.getStateChange() == ItemEvent.SELECTED); 
                        
                        });
                        panel.add(radioButton, "width 1%");
                        panel.add(rb1Label, "width 3%");
                        //panel.add(tText, "width 15%");
                        panel.add(comboBox1, "width 2%, wrap");
                    }

                    if (null != pf_sensorData[i].getTag()) {
                        switch (pf_sensorData[i].getTag()) {
                            case "BCH": {

                                bch++;
                                if (bch == 0) {
                                    BCH_Panel.add(panel, "width 30%,height 30%");
                                } else if (bch % 3 == 0) {
                                    BCH_Panel.add(panel, "width 30%,height 30%, wrap");
                                } else {
                                    BCH_Panel.add(panel, "width 30%,height 30%");
                                }
                            }
                            break;

                            case "IS": {
                                is++;
                                if (is <= 9) {
                                    if (is == 0) {
                                        Is_Panel_pg1.add(panel, "width 30%,height 30%");

                                    } else if (is % 3 == 0) {
                                        Is_Panel_pg1.add(panel, "width 30%,height 30%, wrap");
                                    } else {
                                        Is_Panel_pg1.add(panel, "width 30%,height 30%");
                                    }

                                } else {
                                    if (is == 0) {
                                        Is_Panel_pg2.add(panel, "width 30%,height 30%");
                                    } else if (is % 3 == 0) {
                                        Is_Panel_pg2.add(panel, "width 30%,height 30%, wrap");
                                    } else {
                                        Is_Panel_pg2.add(panel, "width 30%,height 30%");
                                    }

                                }

                            }
                            break;
                            case "CB": {
                                cb++;
                                if (cb <= 6) {
                                    if (cb == 0) {
                                        CB_Panel_pg1.add(panel, "width 30%,height 30%");

                                    } else if (cb % 3 == 0) {
                                        CB_Panel_pg1.add(panel, "width 30%,height 30%, wrap");
                                    } else {
                                        CB_Panel_pg1.add(panel, "width 30%,height 30%");
                                    }

//                                    
                                } else {
                                    if (cb == 0) {
                                        CB_Panel_pg2.add(panel, "width 30%,height 30%");
                                    } else if (cb % 3 == 0) {
                                        CB_Panel_pg2.add(panel, "width 30%,height 30%, wrap");
                                    } else {
                                        CB_Panel_pg2.add(panel, "width 30%,height 30%");
                                    }
                                }                                    
                            }                           
                            break;
                             case "ITC": {

                                itc++;
                                if (itc == 0) {
                                    ITC_Panel.add(panel, "width 30%,height 30%");
                                } else if (itc % 3 == 0) {
                                    ITC_Panel.add(panel, "width 30%,height 30%, wrap");
                                } else {
                                    ITC_Panel.add(panel, "width 30%,height 30%");
                                }
                            }
                            break;
                            default: {
                            }
                        }
                    }
                }

            }
//              if ( tfm <= 9) {
//                TFM_Panel.add(TFM_Panel_pg1);
//                rtu_child_tabPane.add("TRANSFORMER", TFM_Panel);
//            } else {
//                tfm_tab.add("page 1", TFM_Panel_pg1);
//                tfm_tab.add("page 2", TFM_Panel_pg2);
//                TFM_Panel.add(tfm_tab);
//                tfm_tab.setTabPlacement(JTabbedPane.BOTTOM);
//                rtu_child_tabPane.add("TRANSFORMER", TFM_Panel);
//            }

                 
             rtu_child_tabPane.add("TRANSFORMER", TFM_Panel);
            if (is <= 9) {
                IS_Panel.add(Is_Panel_pg1);
                rtu_child_tabPane.add("IS", IS_Panel);
            } else {
                is_tab.add("page 1", Is_Panel_pg1);
                is_tab.add("page 2", Is_Panel_pg2);
                IS_Panel.add(is_tab);
                is_tab.setTabPlacement(JTabbedPane.BOTTOM);
                rtu_child_tabPane.add("IS", IS_Panel);
            }

            if(cb<=6)
               {
                    CB_Panel.add(CB_Panel_pg1);
                    rtu_child_tabPane.add("CB", CB_Panel);
                }
            else 
            { cb_tab.add("page 1",CB_Panel_pg1);
            cb_tab.add("page 2",CB_Panel_pg2);
             CB_Panel.add(cb_tab);
             cb_tab.setTabPlacement(JTabbedPane.RIGHT);
             rtu_child_tabPane.add("CB", CB_Panel);
           }
            if ( "TSS-ARTHALA".equals(Global.rtu_data[rtu_itr].getName()) || "AMS-ARTHALA".equals(Global.rtu_data[rtu_itr].getName()) ){
                
            }
            else {
                rtu_child_tabPane.add("BCH", BCH_Panel);
            }
            if ( "NBAA".equals(Global.rtu_data[rtu_itr].getName()) || "SHAHID NAGAR".equals(Global.rtu_data[rtu_itr].getName()) ){
            rtu_child_tabPane.add("ITC", ITC_Panel);
           }

            rtuPanel.add(rtu_child_tabPane, "width 100%,height 100%,wrap");

            rtu_tabPane.setTabPlacement(JTabbedPane.LEFT);
            String tooltip = "Id:" + Global.rtu_data[rtu_itr].getId() + " IP:" + Global.rtu_data[rtu_itr].getIp() + " Port:" + Global.rtu_data[rtu_itr].getPort() + " Level:" + Global.rtu_data[rtu_itr].getLevel();
            rtu_tabPane.addTab(Global.rtu_data[rtu_itr].getName(), null, rtuPanel, tooltip);
        }

        JFrame mainFrame = new JFrame("TRACTION SCADA Simulator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setMinimumSize(new Dimension(1366, 768));
        mainFrame.getContentPane().add(rtu_tabPane);
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.setVisible(true);
    }

}