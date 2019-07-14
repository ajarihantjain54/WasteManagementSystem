package fp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

public class Consu_page {

	private JFrame frame;
	private JTextField textFieldName;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consu_page window = new Consu_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Consu_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(280, 100, 848, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(10, 11, 812, 69);
		frame.getContentPane().add(panel);
		
		JLabel lblMeetYourRepresentative = new JLabel("FIND YOUR WASTE CONSUMER");
		lblMeetYourRepresentative.setForeground(Color.WHITE);
		lblMeetYourRepresentative.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMeetYourRepresentative.setBounds(209, 11, 423, 47);
		panel.add(lblMeetYourRepresentative);
		
		JLabel lblName = new JLabel("TYPE :");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(215, 118, 56, 23);
		frame.getContentPane().add(lblName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Landfills");
		comboBox.addItem("Incinerators");
		comboBox.addItem("Compost plants");
		comboBox.setEditable(true);
		comboBox.setBounds(281, 116, 123, 28);
		frame.getContentPane().add(comboBox);
		
		JLabel lblName_1 = new JLabel("NAME :");
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_1.setBounds(450, 121, 63, 14);
		frame.getContentPane().add(lblName_1);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(523, 116, 170, 28);
		frame.getContentPane().add(textFieldName);
		
		JRadioButton radioName = new JRadioButton("Name");
		radioName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioName.setBounds(306, 174, 65, 23);
		frame.getContentPane().add(radioName);
		
		JLabel lblSortBy = new JLabel("SORT BY :");
		lblSortBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSortBy.setBounds(215, 178, 85, 14);
		frame.getContentPane().add(lblSortBy);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 220, 812, 2);
		frame.getContentPane().add(separator);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textFieldName.getText();
				String type = comboBox.getSelectedItem().toString();
				//int ward = Integer.parseInt(spinnerWard.getValue().toString());
				if(type.equals("") )
				{
					JOptionPane.showMessageDialog(null, "Select a type");
				}
				else
				{
				
				  try {
						String sql;
				        // step1 load the driver class			
				        Class.forName("oracle.jdbc.driver.OracleDriver");			
				        // step2 create the connection object			
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "a41");			
				        // step3 create the statement object			
				        Statement stmt = con.createStatement();			
				        // step4 execute query
				        if(type.equals("Landfills"))
				        {
				        	if(name.equals(""))
				        		sql = "Select * from Landfills";
				        	else
				        		sql = "Select * from Landills where name = '"+name+"'";
				        }
				        else if(type.equals("Incinerators"))
				        {
				        	if(name.equals(""))
				        		sql = "Select * from Incinerators";
				        	else
				        		sql = "Select * from Incinerators where name = '"+name+"'";
				        }
				        
				        else 
				        {
				        	if(name.equals(""))
				        		sql = "Select * from compost_plants";
				        	else
				        		sql = "Select * from compost_plants where name = '"+name+"'";
				        }
				        
				        
				        if(radioName.isSelected())
				        {
				            sql = sql+" order by name"; 
				            
				        }
				        
				        
				        
				        
				        System.out.println(sql);
				        ResultSet rs = stmt.executeQuery(sql);
				        System.out.println("connected");
				       
				        table.setModel(DbUtils.resultSetToTableModel(rs) );	
				        
				        // step5 close the connection object			
				        con.close();				
				    } catch (SQLException ex) {
				    	JOptionPane.showMessageDialog(null, "Invalid Details");
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		}});
		btnSubmit.setBounds(450, 176, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 812, 198);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				First_Page.main(null);
				frame.dispose();
			}
		});
		btnHome.setBounds(604, 176, 89, 23);
		frame.getContentPane().add(btnHome);
		
		
	}
}
