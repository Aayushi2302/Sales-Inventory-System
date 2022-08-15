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
import javax.swing.Timer;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;


public class loginForm extends JFrame {

	private JPanel contentPane;
	private JTextField userInput;
	private JPasswordField passwordInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForm frame = new loginForm();
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
	public loginForm() {
		setTitle("Login Page");
		setResizable(false);
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
		
		JLabel lb1 = new JLabel("");
		lb1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb1.setBounds(369, 301, 222, 19);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb2.setBounds(369, 392, 222, 19);
		contentPane.add(lb2);
		
		JButton submit = new JButton("Submit");
		submit.setForeground(new Color(25, 25, 112));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(userInput.getText().trim().isEmpty())
					lb1.setText("Username is empty");
				if(passwordInput.getText().trim().isEmpty())
					lb2.setText("Password is empty");
				
				int delay = 3000;
				Timer tm = new Timer(delay,event->{
					lb1.setText("");
					lb2.setText("");
				});
				tm.setRepeats(false);
				tm.start();
				
				if(lb1.getText().trim().isEmpty() && lb2.getText().trim().isEmpty()) {
					
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
						
						String Username = userInput.getText();
						String Password = passwordInput.getText();
						
						PreparedStatement ps = con.prepareStatement("SELECT * FROM Register WHERE USERNAME='"+Username+"' and PASSWORD='"+Password+"'");
						
						ResultSet rs = ps.executeQuery();
						boolean flag = rs.next();
						
						if(flag) {
							mainPage obj = new mainPage();
							obj.setVisible(true);
						}
					}
					
					catch(Exception exp) {
						System.out.println(exp);
					}
					
					
					
					
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
		
		passwordInput = new JPasswordField();
		passwordInput.setFont(new Font("Malgun Gothic", Font.PLAIN, 30));
		passwordInput.setBounds(369, 343, 264, 39);
		contentPane.add(passwordInput);
		
		
	}
}
