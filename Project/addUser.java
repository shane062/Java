import javax.swing.*;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import java.awt.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;


public class addUser extends JPanel implements btnActionSave, btnActionReset{


    public addUser() {
        initComponents();
		returnInfo();
    }

	private void returnInfo() {
		try{
      File file = new File("info.txt");
	  
	  
      if (!file.createNewFile()) {
			FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
			
			String firstLine = br.readLine().trim();
            String[] userInfo = firstLine.split("\t");
			
			txtName.setText(userInfo[0]);
			ddmBlood.setSelectedItem(userInfo[1]);
			txtHealth.setText(userInfo[2]);
			} 
		} catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
			}
	}
 
    private void initComponents() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel subpanel = new JPanel(new GridBagLayout());
			subpanel.setPreferredSize(new Dimension(375,200));
            subpanel.setMaximumSize(new Dimension(375,200));
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridwidth = GridBagConstraints.REMAINDER;
		JPanel subpanel2 = new JPanel();		
        lblName = new javax.swing.JLabel();
        lblBlood = new javax.swing.JLabel();
        lblHealth = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtHealth = new javax.swing.JTextField(10);
        txtName = new javax.swing.JTextField(10);
        btnReset = new javax.swing.JButton();
        ddmBlood = new javax.swing.JComboBox<>();


        lblName.setText("Name");

        lblBlood.setText("Blood type");

        lblHealth.setText("Health History");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        ddmBlood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select your blood type", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-", " " }));
		
				subpanel.add(lblName,gbc);
				subpanel.add(txtName,gbc);
				subpanel.add(lblBlood,gbc);
				subpanel.add(ddmBlood,gbc);
				subpanel.add(lblHealth,gbc);
				subpanel.add(txtHealth,gbc);
				subpanel2.add(btnSave,gbc);
				subpanel2.add(btnReset,gbc);
				add(subpanel);
				add(subpanel2);
			
    }
	@Override
    public void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String name = txtName.getText();
        String bloodType = (String) ddmBlood.getSelectedItem();
        String healthInfo = txtHealth.getText();
        
        
        try {
            try(FileWriter writer = new FileWriter("info.txt")){ //no true to make sure no multiple users can exit at one time
            writer.write(name + "\t" + bloodType + "\t" + healthInfo);
            writer.write(System.getProperty("line.separator"));
            writer.close();
            JOptionPane.showMessageDialog(null, "Success");
			}
			
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
	@Override
    public void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        txtName.setText(null);
        ddmBlood.setSelectedIndex(0);
        txtHealth.setText(null);
    }
	
  
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> ddmBlood;
    private javax.swing.JLabel lblBlood;
    private javax.swing.JLabel lblHealth;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtHealth;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}