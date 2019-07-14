package rp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import fp.First_Page;
import net.proteanit.sql.DbUtils;

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

public class Rep_Page {

	private JFrame frame;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rep_Page window = new Rep_Page();
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
	public Rep_Page() {
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
		
		JLabel lblMeetYourRepresentative = new JLabel("FIND YOUR REPRESENTATIVE");
		lblMeetYourRepresentative.setForeground(Color.WHITE);
		lblMeetYourRepresentative.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMeetYourRepresentative.setBounds(209, 11, 423, 47);
		panel.add(lblMeetYourRepresentative);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(130, 116, 86, 28);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblName = new JLabel("ID :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(81, 121, 39, 14);
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
				String id = textFieldID.getText();
				int ward = Integer.parseInt(spinnerWard.getValue().toString());
				if(name.equals("") && id.equals("") && ward == 0)
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
				        if(name.equals("") && id.equals("") )
				        {
				        	sql = "Select * from representatives where ward_no = "+ward;
				        }
				        else if (id.equals("")&& ward==0)
				        {
				        	System.out.println(name);
				        	sql = "Select * from representatives where fname = '"+name+"'";
				        	System.out.println(sql);
				        }
				        else if( name.equals("")&& ward==0)
				        {
				        	sql = "Select * from representatives where id = "+id;
				        }
				        else if(name.equals(""))
				        {
				        	sql = "Select * from representatives where id = "+id+" and ward = "+ward;
				        }
				        else if(id.equals(""))
				        {
				        	sql = "Select * from representatives where fname = '"+name+"' and ward = "+ward;
				        }
				        else if(ward == 0)
				        {
				        	sql = "Select * from representatives where fname = '"+name+"' and id = "+id;
				        }
				        else
				        	sql = "Select * from representatives where fname = '"+name+"' and ward = "+ward+"and id ="+id;
				        
				        
				        if(radioName.isSelected()&& radioWard.isSelected())
				        {
				            sql = sql+" order by fname,ward_no"; //Male
				        }
				        
				        else if (radioName.isSelected())
				        {
				        	sql = sql+" order by fname"; 
				        	System.out.println(sql);//Female
				        }
				        
				        else
				        {
				        	sql = sql+" order by ward_no";
				        }
				        ResultSet rs = stmt.executeQuery(sql);
				        System.out.println("connected");
				        System.out.println(rs);
				     
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
		scrollPane.setBounds(10, 220, 812, 209);
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
		btnHome.setBounds(703, 176, 89, 23);
		frame.getContentPane().add(btnHome);
		
	}
}
