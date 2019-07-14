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

public class signup_connect {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup_connect window = new signup_connect();
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
	public signup_connect() {
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
		
		JLabel label_1 = new JLabel("SIGN UP");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_1.setBounds(524, 70, 118, 25);
		frame.getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("Representative");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hello.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(492, 150, 174, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnProducer = new JButton("Producer");
		btnProducer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producer_screen.main(null);		
				frame.dispose();
			}
		});
		btnProducer.setBackground(Color.WHITE);
		btnProducer.setForeground(Color.BLUE);
		btnProducer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProducer.setBounds(492, 225, 174, 39);
		frame.getContentPane().add(btnProducer);
		
		JButton btnConsumer = new JButton("Consumer");
		btnConsumer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consumer_screen.main(null);
				frame.dispose();
			}
		});
		
		JButton btnGoBack = new JButton(" GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.main(null);
				frame.dispose();
			}
		});
		btnGoBack.setBounds(534, 375, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		btnConsumer.setBackground(Color.WHITE);
		btnConsumer.setForeground(Color.BLUE);
		btnConsumer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConsumer.setBounds(492, 300, 174, 39);
		frame.getContentPane().add(btnConsumer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(383, 106, 377, 2);
		frame.getContentPane().add(separator);
	}
}
