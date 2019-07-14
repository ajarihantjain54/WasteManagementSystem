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
import javax.swing.JComboBox;
public class producer_screen {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JTextField textField;
	int temp = 34;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					producer_screen window = new producer_screen();
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
	public producer_screen() {
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
		
		JLabel lblName = new JLabel(" Name :");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(464, 194, 89, 14);
		frame.getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(565, 193, 126, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(new Color(25, 25, 112));
		label_1.setBounds(0, 0, 311, 429);
		frame.getContentPane().add(label_1);
		
		JLabel lblWardNo = new JLabel("Ward no. :");
		lblWardNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWardNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWardNo.setBounds(464, 227, 89, 14);
		frame.getContentPane().add(lblWardNo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Residential");
		comboBox.addItem("Industrial");
		comboBox.addItem("Biomedical");
		comboBox.addItem("Commercial");
		comboBox.setEditable(true);
		comboBox.setBounds(565, 288, 126, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("Decomposable");
		comboBox_1.addItem("Non-Decomposable");
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(565, 319, 126, 20);
		frame.getContentPane().add(comboBox_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(565, 226, 126, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblProducerType = new JLabel("Producer type :");
		lblProducerType.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducerType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProducerType.setBounds(436, 286, 116, 20);
		frame.getContentPane().add(lblProducerType);
		
		JLabel lblTypeOfWaste = new JLabel("Type of waste :");
		lblTypeOfWaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeOfWaste.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTypeOfWaste.setBounds(433, 317, 116, 20);
		frame.getContentPane().add(lblTypeOfWaste);
		
		JLabel lblNewLabel = new JLabel("Producers");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(520, 67, 106, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(396, 106, 377, 2);
		frame.getContentPane().add(separator);
		
		JLabel label = new JLabel("SIGN UP");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(524, 35, 118, 25);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("Username :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(464, 132, 89, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Password :");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(470, 163, 89, 14);
		frame.getContentPane().add(label_3);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(563, 130, 126, 20);
		frame.getContentPane().add(textFieldUsername);
		
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
                    System.out.println(s3);
                    System.out.println(s1);
					String r1 =textField_1.getText();
                    int r2 =Integer.parseInt(textField_2.getText());
                    String r3 =comboBox.getSelectedItem().toString();
                    String r4 =comboBox_1.getSelectedItem().toString();
                    String r5 = textField.getText();
                    int x1 =(int)Math.random()*50+temp;
                    temp++;
                    String x;
                    String x2="";
                    if(r3.equals("Residential"))
                    {
                    	x = "Res";
                    	x2 = x+x1;
                    }
                    else if(r3.equals("Biomedical")) 
                    {
                    	x = "Bio";
                    	x2 = x+x1;
                    }
                    else if(r3.equals("Commercial")) 
                    {
                    	x = "Com";
                    	x2 = x+x1;
                    }
                    else if(r3.equals("Industrial")) 
                    {
                    	x = "Ind";
                    	x2 = x+x1;
                    }
                    
                   if (r4.equals("Decomposable"))
                		   {
                	   r4 = "D";
                		   }
                   else
                	   r4 = "ND";
                   
                    String sql="insert into user_details values ('"+s1+"' , '"+s3+"')";
                    if(r1.equals("") || r2==0 || r3.equals("") || r4.equals(""))
                    {
                    	JOptionPane.showMessageDialog(null, "Enter all values");
        
                    }
                    else
                    {
                    	
                    String sql2 = "insert into waste_producers values ('"+x2+"' , '"+r1+"' , "+r2+" , '"+r3+"' , '"+r5+"','"+r4+"')";
                    System.out.println(sql2);
                    ResultSet rs2 = stmt.executeQuery(sql2);
                    System.out.println("connected");
                    
                    System.out.println(sql);
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
		btnLetsGo.setBounds(471, 375, 89, 23);
		frame.getContentPane().add(btnLetsGo);
		
		JButton btnGoBack = new JButton(" GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.main(null);
				frame.dispose();
			}
		});
		btnGoBack.setBounds(688, 375, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(564, 162, 126, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(464, 258, 89, 14);
		frame.getContentPane().add(lblAddress);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(565, 257, 126, 20);
		frame.getContentPane().add(textField);
		
	
	}
}
