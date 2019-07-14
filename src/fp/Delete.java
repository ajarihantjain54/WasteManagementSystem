package fp;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import fp.First_Page;
import fp.signup_connect;

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
import javax.swing.JComboBox;

public class Delete {

	private JFrame frame;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() {
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
		
		JLabel lblLoginScreen = new JLabel("DELETE SCREEN ");
		lblLoginScreen.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 18));
		lblLoginScreen.setForeground(Color.RED);
		lblLoginScreen.setBackground(Color.RED);
		lblLoginScreen.setBounds(511, 36, 163, 23);
		frame.getContentPane().add(lblLoginScreen);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(387, 85, 398, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblUsename = new JLabel(" FROM :");
		lblUsename.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsename.setBounds(477, 123, 65, 37);
		frame.getContentPane().add(lblUsename);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(564, 206, 172, 20);
		frame.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Representatives");
		comboBox.addItem("Waste_producers");
		comboBox.addItem("Landfills");
		comboBox.addItem("Incinerators");
		comboBox.addItem("Compost_plants");
		comboBox.setEditable(true);
		comboBox.setBounds(564, 133, 172, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPassword = new JLabel("ID :");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(515, 196, 39, 37);
		frame.getContentPane().add(lblPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(387, 279, 398, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnGoodbye = new JButton("GOOD BYE ");
		btnGoodbye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				  // step1 load the driver class			
		        Class.forName("oracle.jdbc.driver.OracleDriver");			
		        // step2 create the connection object			
		        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "a41");			
		        // step3 create the statement object			
		        Statement stmt = con.createStatement();			
		        // step4 execute query
		        String type = comboBox.getSelectedItem().toString();
		        
		        String f = textFieldId.getText(); 
				if(type.equals("")|| f.equals("")  )
				{
					JOptionPane.showMessageDialog(null, "Enter All Details");
				}
				else
				{
		      // String sql2 = "delete from user_details where user_id ='"+user+"'";
		        String sql="delete from "+type+" where id ='"+f+"'";
		        System.out.println(sql);
		        ResultSet rs = stmt.executeQuery(sql);
		        System.out.println("connected");
		        if(rs.next())
		        {		
		        	JOptionPane.showMessageDialog(null, "Delete Successful");
		        	First_Page.main(null);
		        	frame.dispose();
		        	
		        }
		        else
		        {
		        	JOptionPane.showMessageDialog(null, "Invalid Details ");
		        }
		        // step5 close the connection object
		        con.close();			
				} }catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Invalid Details ");
		        System.out.println(ex);

		    }catch (ClassNotFoundException ex) {

		        System.out.println(ex);			
		    }
			}
		});
		btnGoodbye.setForeground(Color.RED);
		btnGoodbye.setBounds(455, 318, 99, 23);
		frame.getContentPane().add(btnGoodbye);
		
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
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				First_Page.main(null);
				frame.dispose();
			}
		});
		btnHome.setForeground(Color.RED);
		btnHome.setBounds(628, 318, 99, 23);
		frame.getContentPane().add(btnHome);
		
		
		
		
	}
}
