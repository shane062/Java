import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.time.*;
import java.time.format.*;

public class setBMI extends JPanel implements btnActionAdd, btnActionCalc{


    public setBMI() {
        initComponents();
    }

    //to calculate BMI
    public double calculateBMI(double height, double weight){
        double bmi = weight/(height*height);
        
        return Math.round(bmi);
    }
    
    //getting BMI status
    public String getStatusBMI(double bmi){
        if(bmi>30.0)
            return "Obese";
        else if (bmi>=25.0 && bmi <= 29.9)
            return "Overweight";
        else if (bmi>=18.5 && bmi <= 24.9)
            return "Healthy";
        else 
            return "Underweight ";
    }
    
 
                        
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtHeight = new javax.swing.JTextField();
        jTxtWeight = new javax.swing.JTextField();
        jTxtBodyTemp = new javax.swing.JTextField();
        jBtnCalcBMI = new javax.swing.JButton();
        jBtnAdd = new javax.swing.JButton();
        result2 = new javax.swing.JTextField();
        result1 = new javax.swing.JTextField();

   
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("BMI Calculator");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Height (m)");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Weight (kg)");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Body Temperature");

        jBtnCalcBMI.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jBtnCalcBMI.setText("Calculate BMI");
        jBtnCalcBMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCalcBMIActionPerformed(evt);
            }
        });

        jBtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jBtnAdd.setText("Add Record");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        result2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        result2.setForeground(new java.awt.Color(255, 51, 51));

        result1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        result1.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(result1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(result2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtHeight)
                            .addComponent(jTxtWeight)
                            .addComponent(jTxtBodyTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jBtnCalcBMI, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jBtnAdd)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtBodyTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jBtnCalcBMI, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(result1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(result2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

      
    }                      
	@Override
    public void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if(jTxtHeight.getText().isEmpty() || jTxtWeight.getText().isEmpty() || jTxtBodyTemp.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter all fields!");
        }
        else{
            double height = Double.parseDouble(jTxtHeight.getText());
            double weight = Double.parseDouble(jTxtWeight.getText());
            double bmi = calculateBMI(height, weight);
            
            double bodytemp = Double.parseDouble(jTxtBodyTemp.getText());
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatted = DateTimeFormatter.ofPattern("HH:mm:ss a");
            LocalDateTime now = LocalDateTime.now();
            String Date = formatter.format(now);
            String time = formatted.format(now);
            try{
                String filePath = "record.txt";
                FileWriter add = new FileWriter(filePath, true);
                add.write(height + "\t" + weight + "\t" + bmi + "\t" + bodytemp + "\t" + Date + "\t" + time + "\t");
                add.write(System.getProperty("line.separator"));
                add.close();
                JOptionPane.showMessageDialog(null, "Record added!");

              
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Oops... Something went wrong...");
            }
            
            jTxtWeight.setText("");
            jTxtHeight.setText("");
            jTxtBodyTemp.setText("");
            result1.setText("");
            result2.setText("");
        }
    }                                       
	@Override
    public void jBtnCalcBMIActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(jTxtHeight.getText().isEmpty() || jTxtWeight.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter all fields!");
        }
        else{
            double height = Double.parseDouble(jTxtHeight.getText());
            double weight = Double.parseDouble(jTxtWeight.getText());
            double bmi = calculateBMI(height, weight);
            String bmiStatus = getStatusBMI(bmi);
            
            String output = Double.toString(bmi);
            this.result1.setText("Your BMI is " + output);
            this.result2.setText(bmiStatus);
        }
    }                                           

                        
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnCalcBMI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtBodyTemp;
    private javax.swing.JTextField jTxtHeight;
    private javax.swing.JTextField jTxtWeight;
    private javax.swing.JTextField result1;
    private javax.swing.JTextField result2;
    // End of variables declaration                   
}
