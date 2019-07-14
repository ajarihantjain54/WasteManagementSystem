package fp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton; 
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Produ_page {

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
					Produ_page window = new Produ_page();
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
	public Produ_page() {
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
		
		JLabel lblMeetYourRepresentative = new JLabel("FIND YOUR WASTE PRODUCER");
		lblMeetYourRepresentative.setForeground(Color.WHITE);
		lblMeetYourRepresentative.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMeetYourRepresentative.setBounds(209, 11, 423, 47);
		panel.add(lblMeetYourRepresentative);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("Residential");
		comboBox_1.addItem("Commercial");
		comboBox_1.addItem("Industrial");
		comboBox_1.addItem("Biomedical");
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(127, 120, 126, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblName = new JLabel("TYPE :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(57, 121, 63, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblName_1 = new JLabel("NAME :");
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_1.setBounds(278, 121, 63, 14);
		frame.getContentPane().add(lblName_1);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(351, 116, 170, 28);
		frame.getContentPane().add(textFieldName);
		
		JLabel lblWardNo = new JLabel("WARD NO :");
		lblWardNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWardNo.setBounds(566, 121, 85, 14);
		frame.getContentPane().add(lblWardNo);
		
		JRadioButton radioName = new JRadioButton("Name");
		radioName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioName.setBounds(366, 174, 65, 23);
		frame.getContentPane().add(radioName);
		
		JRadioButton radioWard = new JRadioButton("Ward no");
		radioWard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioWard.setBounds(457, 174, 98, 23);
		frame.getContentPane().add(radioWard);
		
		JLabel lblSortBy = new JLabel("SORT BY :");
		lblSortBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSortBy.setBounds(256, 178, 85, 14);
		frame.getContentPane().add(lblSortBy);
		
		JSpinner spinnerWard = new JSpinner();
		spinnerWard.setBounds(655, 120, 47, 20);
		frame.getContentPane().add(spinnerWard);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 220, 812, 2);
		frame.getContentPane().add(separator);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent arg0) {
				String name = textFieldName.getText();
				String type = comboBox_1.getSelectedItem().toString();
				int ward = Integer.parseInt(spinnerWard.getValue().toString());
				if(name.equals("") && type.equals("") && ward == 0)
				{
					JOptionPane.showMessageDialog(null, "Enter atleast one value");
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
				        
				        if(name.equals("") && type.equals("") )
				        {
				        	sql = "Select * from waste_producers where ward_no = "+ward;
				        }
				        else if (type.equals("")&& ward==0)
				        {
				        	sql = "Select * from waste_producers where name = '"+name+"'";
				        }
				        else if( name.equals("")&& ward==0)
				        {
				        	sql = "Select * from waste_producers where producer_type = '"+type+"'";
				        }
				        else if(name.equals(""))
				        {
				        	sql = "Select * from waste_producers where producer_type = '"+type+"' and ward_no = "+ward;
				        }
				        else if(type.equals(""))
				        {
				        	sql = "Select * from waste_producers where name = '"+name+"' and ward_no = "+ward;
				        }
				        else if(ward == 0)
				        {
				        	sql = "Select * from waste_producers where name = '"+name+"' and producer_type = '"+type+"'";
				        }
				        else
				        	sql = "Select * from waste_producers where name = '"+name+"' and ward_no = "+ward+"and producer_type = '"+type+"'";
				        
				        
				        if(radioName.isSelected()&& radioWard.isSelected())
				        {
				            sql = sql+"order by name,ward_no"; //Male
				        }
				        
				        else if (radioName.isSelected())
				        {
				        	sql = sql+"order by name";  //Female
				        }
				        
				        else
				        {
				        	sql = sql+"order by ward_no";
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
		btnSubmit.setBounds(598, 174, 89, 23);
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
		btnHome.setBounds(715, 174, 89, 23);
		frame.getContentPane().add(btnHome);
		
	}
}
