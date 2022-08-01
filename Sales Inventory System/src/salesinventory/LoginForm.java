package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.PreparedStatement;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;


public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField userInput;
	private JTextField passwordInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(25, 25, 112));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblLogin.setBounds(381, 83, 145, 68);
		contentPane.add(lblLogin);
		
		JLabel user = new JLabel("Username");
		user.setForeground(new Color(25, 25, 112));
		user.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		user.setBounds(157, 252, 161, 41);
		contentPane.add(user);
		
		JLabel pass = new JLabel("Password");
		pass.setForeground(new Color(25, 25, 112));
		pass.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		pass.setBounds(157, 343, 161, 41);
		contentPane.add(pass);
		
		userInput = new JTextField();
		userInput.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		userInput.setBounds(369, 252, 264, 39);
		contentPane.add(userInput);
		userInput.setColumns(10);
		
		passwordInput = new JTextField();
		passwordInput.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		passwordInput.setColumns(10);
		passwordInput.setBounds(369, 345, 264, 39);
		contentPane.add(passwordInput);
		
		JButton submit = new JButton("Submit");
		submit.setForeground(new Color(25, 25, 112));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","mysql@aayushi");
					
					String Username = userInput.getText();
					String Password = passwordInput.getText();
					
					PreparedStatement ps = con.prepareStatement("SELECT * FROM Login WHERE USERNAME='"+Username+"' and PASSWORD='"+Password+"'");
					
					ResultSet rs = ps.executeQuery();
					boolean flag = rs.next();
					
					if(flag) {
						sales obj = new sales();
						obj.setVisible(true);
					}
				}
				
				catch(Exception exp) {
					System.out.println(exp);
				}
			}
		
		});
		
		submit.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		submit.setBounds(390, 479, 161, 53);
		contentPane.add(submit);
		
		JLabel lblEnterDetails = new JLabel("Enter credentials");
		lblEnterDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetails.setForeground(new Color(25, 25, 112));
		lblEnterDetails.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblEnterDetails.setBounds(244, 168, 449, 42);
		contentPane.add(lblEnterDetails);
		
		JButton btnNewButton_1 = new JButton("->");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(67, 10, 59, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("<-");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesChoice ob = new salesChoice();
				ob.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1_1.setBounds(10, 10, 59, 42);
		contentPane.add(btnNewButton_1_1);
	}
}
