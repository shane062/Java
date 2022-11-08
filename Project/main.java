import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class main extends JFrame{
	
	JPanel graphPanel = new JPanel();
//	JPanel secondPanel = new JPanel(); 
	
	
	JLabel secondLabel = new JLabel("Second!");
	
	JTabbedPane tabbedPane = new JTabbedPane();
	private addUser user = new addUser();
	private setBMI bmi = new setBMI();
	private Record data = new Record();
	private openGraph graph = new openGraph();
	JScrollPane scrollUser = new JScrollPane(user,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JScrollPane scrollBmi = new JScrollPane(bmi,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
	JScrollPane scrollView = new JScrollPane(data,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	JButton btnGraph = new JButton("Click for graph");
	
	public main(){
		this.setLocationRelativeTo(null);
		
		
		btnGraph.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new openGraph();
			}
		});
		graphPanel.add(btnGraph);
		tabbedPane.add("User",scrollUser);
		tabbedPane.add("BMI",scrollBmi);
		tabbedPane.add("Records",scrollView);
		tabbedPane.add("Graph",graphPanel);
		/* tabbedPane.add("Records 2",scrollBmi); */
		tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
		add(tabbedPane);
	}
	
	public static void main(String[] args) {
		main tp = new main();
		tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tp.setSize(400,700);
		tp.setResizable(false);
		tp.setVisible(true);
	}
}