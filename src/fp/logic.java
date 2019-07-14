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
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class logic {

	private JFrame frame;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logic window = new logic();
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
	public logic() {
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
		
		JLabel lblLoginScreen = new JLabel("LOGIN SCREEN ");
		lblLoginScreen.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		lblLoginScreen.setForeground(Color.RED);
		lblLoginScreen.setBackground(Color.RED);
		lblLoginScreen.setBounds(511, 36, 145, 23);
		frame.getContentPane().add(lblLoginScreen);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(387, 85, 398, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblUsename = new JLabel("Username :");
		lblUsename.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsename.setBounds(463, 123, 91, 37);
		frame.getContentPane().add(lblUsename);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(575, 133, 172, 20);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(463, 196, 91, 37);
		frame.getContentPane().add(lblPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(387, 273, 398, 2);
		frame.getContentPane().add(separator_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(575, 206, 172, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
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
				        String sql="select * from user_details where u_id='"+s1+"' and password='"+s3+"'";
				        System.out.println(sql);
				        ResultSet rs = stmt.executeQuery(sql);
				        System.out.println(rs);
				        System.out.println("connected");
				        if(rs.next())
				        {		
				        	JOptionPane.showMessageDialog(null, "Login Successfull");
				        	First_Page.main(null);
				        	frame.dispose();
				        	
				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(null, "Incorrect Username Or Password");
				        }
				        // step5 close the connection object
				        textFieldUsername.setText("");
				        passwordField.setText("");
				        con.close();			
				    } catch (SQLException ex) {
				    	JOptionPane.showMessageDialog(null, "Invalid Details");
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		btnNewButton.setBounds(426, 312, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup_connect.main(null);
				frame.dispose();
				
			}
		});
		btnSignup.setForeground(Color.RED);
		btnSignup.setBounds(693, 312, 89, 23);
		frame.getContentPane().add(btnSignup);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, 0, 362, 429);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REDUCE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(102, 70, 124, 50);
		panel.add(lblNewLabel);
		
		JLabel lblReuse = new JLabel("REUSE");
		lblReuse.setForeground(Color.WHITE);
		lblReuse.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblReuse.setBounds(102, 152, 124, 50);
		panel.add(lblReuse);
		
		JLabel lblRecycle = new JLabel("RECYCLE");
		lblRecycle.setForeground(Color.WHITE);
		lblRecycle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRecycle.setBounds(99, 240, 145, 50);
		panel.add(lblRecycle);
		
		
	}
}
