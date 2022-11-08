import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import java.text.*;


public class Record extends JPanel implements RecordOperation {

    /**
     * Creates new form Record
     */
    public Record() {
        initComponents();
        jPanel2.setVisible(false);
        showRecord();
    }
    
	public void showRecord(){
        File file = new File("record.txt");

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            DefaultTableModel model = (DefaultTableModel)jTableRecord.getModel();
            Object[] lines = br.lines().toArray();

            //sort record
            TableRowSorter sorter = new TableRowSorter(model);
            jTableRecord.setRowSorter(sorter);

            for(int i=0; i<lines.length; i++){
                String[] row = lines[i].toString().split("\t");
                model.addRow(row);
            }

            fr.close();
            br.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
	
	
    public void setEmpty(){
        jTxtEditH.setText("");
        jTxtEditW.setText("");
        jTxtEditBd.setText("");
        jTxtEditDate.setText("");
        jTxtEditTime.setText("");
    }

                      
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRecord = new javax.swing.JTable();
        jBtnRefresh = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jToggleBtnEdit = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBtnUpdate = new javax.swing.JButton();
        jTxtEditH = new javax.swing.JTextField();
        jTxtEditW = new javax.swing.JTextField();
        jTxtEditBd = new javax.swing.JTextField();
        jTxtEditDate = new javax.swing.JTextField();
        jTxtEditTime = new javax.swing.JTextField();
        jBtnSave = new javax.swing.JButton();


        jLabel1.setFont(new java.awt.Font("Dubai Medium", 3, 18)); // NOI18N
        jLabel1.setText("RECORDS");

        jTableRecord.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Height", "Weight", "BMI", "Temperature", "Date", "Time"
            }
        ));
        jTableRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRecord);

        jBtnRefresh.setIcon(new javax.swing.ImageIcon("icons8-refresh-21.png")); // NOI18N
        jBtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshActionPerformed(evt);
            }
        });

        jBtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnDelete.setText("Delete");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jToggleBtnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleBtnEdit.setText("Edit");
        jToggleBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleBtnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jToggleBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRefresh)
                .addGap(18, 18, 18)
                .addComponent(jBtnDelete)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnDelete)
                    .addComponent(jToggleBtnEdit))
                .addGap(40, 40, 40))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Height");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Weight");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Body Temperature");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Date");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Time");

        jBtnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jBtnUpdate.setText("Update");
        jBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateActionPerformed(evt);
            }
        });

        jBtnSave.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jBtnSave.setText("SAVE");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtEditH)
                            .addComponent(jTxtEditW)
                            .addComponent(jTxtEditBd)
                            .addComponent(jTxtEditDate)
                            .addComponent(jTxtEditTime, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jBtnUpdate)
                        .addGap(62, 62, 62)
                        .addComponent(jBtnSave)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtEditH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtEditW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtEditBd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtEditDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtEditTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnUpdate)
                    .addComponent(jBtnSave))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

  
    }                     
	@Override
    public void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {                                            
		jTableRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String []{
                "Height", "Weight", "BMI", "Temperature", "Date", "Time"
            }));			
			
        File file = new File("record.txt");

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            DefaultTableModel model = (DefaultTableModel)jTableRecord.getModel();
            Object[] lines = br.lines().toArray();

            //sort record
            TableRowSorter sorter = new TableRowSorter(model);
            jTableRecord.setRowSorter(sorter);
            
            for(int i=0; i<lines.length; i++){
                String[] row = lines[i].toString().split("\t");
                model.addRow(row);
            }
            
            fr.close();
            br.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }                                           
	@Override
    public void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        DefaultTableModel model = (DefaultTableModel)jTableRecord.getModel();
        
        if(jTableRecord.getSelectedRowCount()==1){
            double height = Double.parseDouble(jTxtEditH.getText());
            double weight = Double.parseDouble(jTxtEditW.getText());
            double bmi = weight/Math.pow(height,2);
            
            DecimalFormat format_double = new DecimalFormat("#.#");//changes the new bmi to one decimal point to avoid multiple points
            String bmiString = format_double.format(bmi);//Place the new value into here
            
            double body = Double.parseDouble(jTxtEditBd.getText());

            
            String date = jTxtEditDate.getText();
            String time = jTxtEditTime.getText();
            
            
            model.setValueAt(height, jTableRecord.getSelectedRow(),0);
            model.setValueAt(weight, jTableRecord.getSelectedRow(),1);
            model.setValueAt(bmiString, jTableRecord.getSelectedRow(),2);//Update the new value into the table
            model.setValueAt(body, jTableRecord.getSelectedRow(),3);
            model.setValueAt(date, jTableRecord.getSelectedRow(),4);
            model.setValueAt(time, jTableRecord.getSelectedRow(),5);
            
            JOptionPane.showMessageDialog(this, "Update Successfully!");
        
            File file = new File("temp.txt");
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                for(int i = 0; i < jTableRecord.getRowCount(); i++){//rows
                    for(int j = 0; j < jTableRecord.getColumnCount(); j++){//columns
                        bw.write(jTableRecord.getValueAt(i, j).toString()+"\t");
                    }
                    bw.newLine();
                }
            
            bw.close();
            fw.close();
            
            }catch(IOException e){
                Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, e);
            }
            }else{
                if(jTableRecord.getRowCount()==0){
                    JOptionPane.showMessageDialog(this, "Table empty...");
                }else{
                    JOptionPane.showMessageDialog(this, "Select record to update");
                }
            }
    }                                          

    private void jToggleBtnEditActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if(jToggleBtnEdit.isSelected()){
            jPanel2.setVisible(true);
        }else{
            jPanel2.setVisible(false);
            setEmpty();
        }
        
    }                                              
@Override
    public void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                           
        DefaultTableModel table = (DefaultTableModel)jTableRecord.getModel();
        int selectDelete = jTableRecord.getSelectedRow();
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Delete this record", "Delete", dialogButton);
        
        if(selectDelete >= 0){
            if(dialogResult ==0){
                table.removeRow(selectDelete);
            }
            
        File file = new File("temp.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i = 0; i < jTableRecord.getRowCount(); i++){                //rows
                for(int j = 0; j < jTableRecord.getColumnCount(); j++){         //columns
                    bw.write(jTableRecord.getValueAt(i, j).toString()+"\t");
                }
                bw.newLine();
            }
            
            bw.close();
            fw.close();
            
        }catch(IOException e){
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, e);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Unable to delete. Choose data to delete.");
        }
    }                                          

    private void jTableRecordMouseClicked(java.awt.event.MouseEvent evt) {                                          
        DefaultTableModel model = (DefaultTableModel)jTableRecord.getModel();
        
        String editH = model.getValueAt(jTableRecord.getSelectedRow(), 0).toString();
        String editW = model.getValueAt(jTableRecord.getSelectedRow(), 1).toString();
        String editBd = model.getValueAt(jTableRecord.getSelectedRow(), 3).toString();
        String editD = model.getValueAt(jTableRecord.getSelectedRow(), 4).toString();
        String editT = model.getValueAt(jTableRecord.getSelectedRow(), 5).toString();
        
        
        jTxtEditH.setText(editH);
        jTxtEditW.setText(editW);
        jTxtEditBd.setText(editBd);
        jTxtEditDate.setText(editD);
        jTxtEditTime.setText(editT);
    }                                         

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Save Changes", "SAVE", dialogButton);
        
        if(dialogResult ==0){
        ArrayList<String> result = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader("temp.txt"))) {
                while (br.ready()) {
                    result.add(br.readLine());
		}
            }catch(IOException e){
            	System.out.println(e);
            }
		
            try{
                FileWriter writer = new FileWriter("record.txt"); 
		for(String str: result) {
                    writer.write(str + System.lineSeparator());
		}
                    writer.close();
		}catch(IOException x){
			System.out.println(x);
		}
        }    
        JOptionPane.showMessageDialog(this, "Changes Saved!");
    }                                        
                  
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRecord;
    private javax.swing.JToggleButton jToggleBtnEdit;
    private javax.swing.JTextField jTxtEditBd;
    private javax.swing.JTextField jTxtEditDate;
    private javax.swing.JTextField jTxtEditH;
    private javax.swing.JTextField jTxtEditTime;
    private javax.swing.JTextField jTxtEditW;                 
}
