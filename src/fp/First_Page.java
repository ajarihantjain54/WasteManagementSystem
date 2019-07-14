package fp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import rp.Rep_Page;

public class First_Page {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First_Page window = new First_Page();
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
	public First_Page() {
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
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(10, 11, 812, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcomeTo = new JLabel("WELCOME TO WASTE MANAGEMENT PORTAL ");
		lblWelcomeTo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWelcomeTo.setForeground(new Color(255, 255, 255));
		lblWelcomeTo.setBounds(107, 11, 695, 47);
		panel.add(lblWelcomeTo);
		
		JButton btnNewButton = new JButton("Representatives");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rep_Page.main(null);
				frame.dispose();
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(269, 98, 259, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnConsumers = new JButton("Producers");
		btnConsumers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produ_page.main(null);
				frame.dispose();
			}
		});
		btnConsumers.setForeground(Color.RED);
		btnConsumers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsumers.setBounds(269, 191, 259, 46);
		frame.getContentPane().add(btnConsumers);
		
		JButton btnConsumers_1 = new JButton("Consumers");
		btnConsumers_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consu_page.main(null);
				frame.dispose();
			}
		});
		btnConsumers_1.setForeground(Color.RED);
		btnConsumers_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsumers_1.setBounds(269, 283, 259, 46);
		frame.getContentPane().add(btnConsumers_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(54, 98, 146, 46);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSave = new JLabel("SAVE");
		lblSave.setForeground(new Color(255, 255, 255));
		lblSave.setFont(new Font("Garamond", Font.BOLD, 17));
		lblSave.setBounds(49, 11, 61, 24);
		panel_1.add(lblSave);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(54, 191, 146, 46);
		frame.getContentPane().add(panel_2);
		
		JLabel lblWater = new JLabel("WATER");
		lblWater.setForeground(Color.WHITE);
		lblWater.setFont(new Font("Garamond", Font.BOLD, 17));
		lblWater.setBounds(36, 11, 89, 24);
		panel_2.add(lblWater);
		
		JButton btnDeleteUsers = new JButton("Delete Users");
		btnDeleteUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete.main(null);
				frame.dispose();
			}
		});
		btnDeleteUsers.setForeground(Color.RED);
		btnDeleteUsers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeleteUsers.setBounds(269, 372, 259, 46);
		frame.getContentPane().add(btnDeleteUsers);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(135, 206, 250));
		panel_7.setBounds(600, 280, 146, 46);
		frame.getContentPane().add(panel_7);
		
		JLabel label_4 = new JLabel("SAVE");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Garamond", Font.BOLD, 17));
		label_4.setBounds(47, 11, 61, 24);
		panel_7.add(label_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(135, 206, 250));
		panel_8.setBounds(600, 372, 146, 46);
		frame.getContentPane().add(panel_8);
		
		JLabel label_5 = new JLabel("EARTH");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Garamond", Font.BOLD, 17));
		label_5.setBounds(34, 11, 88, 24);
		panel_8.add(label_5);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.main(null);
				frame.dispose();
			}
		});
		btnLogout.setBounds(626, 114, 89, 23);
		frame.getContentPane().add(btnLogout);
	}
}
