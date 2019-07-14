package fp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;


import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import javax.swing.UIManager;

import javax.swing.SwingConstants;

public class consumer_screen {

	private JFrame frame;
	private JTextField textField_3;
	private JTextField textFieldUsername;
	private JTextField textField_2;
	private JPasswordField passwordField;
	int temp = 50;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consumer_screen window = new consumer_screen();
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
	public consumer_screen() {
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
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(new Color(25, 25, 112));
		label.setBounds(0, 0, 311, 429);
		frame.getContentPane().add(label);
		
		JLabel lblConsumers = new JLabel("CONSUMERS");
		lblConsumers.setForeground(Color.BLUE);
		lblConsumers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConsumers.setBackground(Color.BLUE);
		lblConsumers.setBounds(515, 67, 125, 20);
		frame.getContentPane().add(lblConsumers);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(390, 98, 385, 2);
		frame.getContentPane().add(separator);
		
		JLabel label_1 = new JLabel("SIGN UP");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_1.setBounds(524, 35, 118, 25);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Name :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(484, 253, 62, 14);
		frame.getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(559, 283, 126, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel label_3 = new JLabel("Producer type :");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(431, 312, 116, 20);
		frame.getContentPane().add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Consumer");
		
		comboBox.addItem("Landfills");
		comboBox.addItem("Incinerators");
		comboBox.addItem("Compost plants");
		comboBox.setEditable(true);
		comboBox.setBounds(559, 221, 126, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel label_4 = new JLabel("Username :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(460, 131, 89, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Password :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(466, 162, 89, 14);
		frame.getContentPane().add(label_5);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(559, 129, 126, 20);
		frame.getContentPane().add(textFieldUsername);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(559, 252, 126, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblConsumer = new JLabel("Consumer :");
		lblConsumer.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsumer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsumer.setBounds(452, 219, 97, 20);
		frame.getContentPane().add(lblConsumer);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("Residential");
		comboBox_1.addItem("Commercial");
		comboBox_1.addItem("Industrial");
		comboBox_1.addItem("Biomedical");
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(559, 314, 126, 20);
		
		
		frame.getContentPane().add(comboBox_1);
		JLabel lblLocation = new JLabel("Location :");
		lblLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLocation.setBounds(460, 282, 97, 20);
		frame.getContentPane().add(lblLocation);
		
		JButton btnLetsGo = new JButton("LETS GO");
		btnLetsGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					// step1 load the driver class           
                    Class.forName("oracle.jdbc.driver.OracleDriver");           
                    // step2 create the connection object           
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "a41");           
                    // step3 create the statement object           
                    Statement stmt = con.createStatement();           
                    // step4 execute query
					String s3 = "";
                    String s1=textFieldUsername.getText();
                    char s2[]= passwordField.getPassword();
                    System.out.println(s2);
                    for(int i = 0;i<s2.length;i++)
                    {
                         s3 = s3+s2[i];
                    }
                    System.out.println(s3);
                    System.out.println(s1);
                    int rn = (int)(Math.random()*2)+1;
                    
                    
                    
                    CallableStatement cst = con.prepareCall("{CALL ff(?,?)}");		
			        // step4 execute query
			       
			       cst.registerOutParameter(2,Types.VARCHAR);	
			       cst.setInt(1,rn);
			       cst.execute();
			       String r5 = cst.getString(2);
                    cst.close();
                    
                    System.out.println(r5);
             
					String r1 ="";
                    String r2 =textField_2.getText();
                    String r3 =textField_3.getText();
                    String r4 =comboBox_1.getSelectedItem().toString();
                    String jj= comboBox.getSelectedItem().toString();
                    String sql2 = new String();
                    int x1 =(int)Math.random()*40+temp;
                    
                    String sql="insert into user_details values ('"+s1+"' , '"+s3+"')";
                    if(  r2.equals("") || r3.equals("") || r4.equals(""))
                    {
                    	JOptionPane.showMessageDialog(null, "Enter all values");
        
                    }
                    else
                    {
                    if(jj.equals("Incinerators")) {
                    	r1 = "Inc"+x1;
                    	sql2 = "insert into incinerators values ( '"+r1+"' , '"+r2+"' , '"+r3+"' ,'"+r5+"',  '"+r4+"')";
                    }
                    else if(jj.equals("Landfills"))
                    {
                    	r1 = "Lan"+x1;
                    	sql2 = "insert into landfills values ('"+r1+"' , '"+r2+"' , '"+r3+"' ,'"+r5+"', '"+r4+"')";
                    }
                    else if(jj.equals("Compost plants"))
                    {
                    	r1 = "Con"+x1;
                    	sql2 = "insert into compost_plants values ( '"+r1+"' , '"+r2+"' , '"+r3+"' ,'"+r5+"', '"+r4+"')";
                    	
                    }
                    System.out.println(sql2);
                    System.out.println(sql);
                    
                    ResultSet rs2 = stmt.executeQuery(sql2);
                    System.out.println(sql2);
                   
                    System.out.println("connected");
                    ResultSet rs = stmt.executeQuery(sql);
                    System.out.println(rs);
                        
                        JOptionPane.showMessageDialog(null, "Welcome to database");
                        First_Page.main(null);                       
                    
                    // step5 close the connection object
                   
                    con.close();           
                } 
				}catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Invalid Details");
                    System.out.println(ex);   
                }catch (ClassNotFoundException ex) {
                    System.out.println(ex);           
                }
			}
		});
		btnLetsGo.setBounds(460, 365, 89, 23);
		frame.getContentPane().add(btnLetsGo);
		
		JButton btnGoBack = new JButton(" GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.main(null);
				frame.dispose();
			}
		});
		btnGoBack.setBounds(686, 365, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(559, 161, 126, 20);
		frame.getContentPane().add(passwordField);
		
		
	}
}
