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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import javax.swing.UIManager;

import javax.swing.SwingConstants;

public class Hello {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_1;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	int temp = 25;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hello window = new Hello();
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
	public Hello() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.setBounds(280, 100, 848, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(524, 35, 118, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First name :");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(461, 225, 89, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name :");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(461, 254, 89, 14);
		frame.getContentPane().add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(560, 223, 126, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(560, 252, 126, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblWardNo = new JLabel("Ward no. :");
		lblWardNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWardNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWardNo.setBounds(465, 285, 73, 14);
		frame.getContentPane().add(lblWardNo);
		
		JLabel lblPhoneNo = new JLabel("Phone no. :");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhoneNo.setBounds(460, 315, 89, 14);
		frame.getContentPane().add(lblPhoneNo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(560, 283, 126, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(560, 314, 126, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(477, 346, 63, 14);
		frame.getContentPane().add(lblAddress);
		
		textField_5 = new JTextField();
		textField_5.setBounds(560, 345, 126, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(25, 25, 112));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 0, 311, 429);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Representatives");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(492, 65, 162, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(382, 104, 395, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(461, 135, 89, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(467, 166, 89, 14);
		frame.getContentPane().add(lblPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(560, 133, 126, 20);
		frame.getContentPane().add(textFieldUsername);
		
		JButton btnGoBack = new JButton(" GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.main(null);
				frame.dispose();
			}
		});
		btnGoBack.setBounds(686, 395, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		
		JButton btnLetsGo = new JButton("LETS GO");
		btnLetsGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
                    String r1 =textField_1.getText();
                    String r2 =textField_2.getText();
                    int r3 =Integer.parseInt(textField_3.getText());
                    String r4 =textField_4.getText();
                    String r5 =textField_5.getText();
                    System.out.println(r5);
                    int x1 =(int)Math.random()*50+temp;
                    temp++;
                    System.out.println(x1);
                    String x = "Rep";
                    String x2 = x+x1;
                    String sql="insert into user_details values ('"+s1+"' , '"+s3+"')";
                    if(r1.equals("") || r2.equals("") || textField_3.getText().equals("") || r4.equals("") || r5.equals(""))
                    {
                    	JOptionPane.showMessageDialog(null, "Enter all values");
        
                    }
                    else
                    {
                    
                    String sql2 = "insert into representatives values ('"+x2+"' , '"+r1+"' , '"+r2+"' , "+r3+" , '"+r4+"' , '"+r5+"')";
                    System.out.println(x2);
                    System.out.println(r1);
                    System.out.println(r2);
                    System.out.println(r3);
                    System.out.println(r4);
                    
                    System.out.println(sql);
                    System.out.println(sql2);
                    
                    ResultSet rs1 = stmt.executeQuery(sql2);
                    System.out.println("connected");
                    ResultSet rs = stmt.executeQuery(sql);
                    System.out.println(rs);
                    
                        
                        JOptionPane.showMessageDialog(null, "Welcome to database");
                        First_Page.main(null);
                       
                    // step5 close the connection object
                   
                    con.close();           
                } }catch (SQLException ex) {
                	JOptionPane.showMessageDialog(null, "Invalid Details");
                    System.out.println(ex);
   
                }catch (ClassNotFoundException ex) {
   
                    System.out.println(ex);           
                }
				
			}
		});
		btnLetsGo.setBounds(461, 395, 89, 23);
		frame.getContentPane().add(btnLetsGo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(560, 165, 126, 20);
		frame.getContentPane().add(passwordField);
	}
}
