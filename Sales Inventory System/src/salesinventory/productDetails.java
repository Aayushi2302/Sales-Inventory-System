package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class productDetails extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productDetails frame = new productDetails();
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
	public productDetails() {
		setTitle("Register Product");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterProductDetails = new JLabel("Product Registeration");
		lblEnterProductDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterProductDetails.setForeground(new Color(25, 25, 112));
		lblEnterProductDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblEnterProductDetails.setBounds(228, 70, 525, 68);
		contentPane.add(lblEnterProductDetails);
		
		JLabel lb1 = new JLabel("Product Id");
		lb1.setForeground(new Color(25, 25, 112));
		lb1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lb1.setBounds(122, 213, 161, 41);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("Product Name");
		lb2.setForeground(new Color(25, 25, 112));
		lb2.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lb2.setBounds(123, 326, 218, 41);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("Organization");
		lb3.setForeground(new Color(25, 25, 112));
		lb3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lb3.setBounds(122, 440, 196, 41);
		contentPane.add(lb3);
		
		t1 = new JTextField();
		t1.setForeground(new Color(25, 25, 112));
		t1.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		t1.setColumns(10);
		t1.setBounds(402, 215, 264, 39);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setForeground(new Color(25, 25, 112));
		t2.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		t2.setColumns(10);
		t2.setBounds(402, 328, 399, 39);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setForeground(new Color(25, 25, 112));
		t3.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		t3.setColumns(10);
		t3.setBounds(401, 442, 476, 41);
		contentPane.add(t3);
		
		JLabel l1 = new JLabel("");
		l1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l1.setBounds(412, 264, 211, 22);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("");
		l2.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l2.setBounds(412, 377, 211, 22);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("");
		l3.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l3.setBounds(411, 493, 211, 22);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("");
		l4.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l4.setBounds(614, 581, 264, 28);
		contentPane.add(l4);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().trim().isEmpty())
					l1.setText("Product Id is empty");
				if(t2.getText().trim().isEmpty())
					l2.setText("Product Name is empty");
				if(t3.getText().trim().isEmpty())
					l3.setText("Organization is empty");
				
				int delay = 3000;
				Timer tm = new Timer(delay, event->{
					
					l1.setText("");
					l2.setText("");
					l3.setText("");
				});
				
				tm.setRepeats(false);
				tm.start();
				
				if(l1.getText().trim().isEmpty() && l2.getText().trim().isEmpty() && l3.getText().trim().isEmpty()) {
					
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver"); 
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
					  
						PreparedStatement ps = con.prepareStatement("INSERT INTO product VALUES(?,?,?)"); 
						
						String proId = t1.getText();
						ps.setString(1, proId);
						
						String proName = t2.getText();
						ps.setString(2, proName);
						
						String proOrg = t3.getText();
						ps.setString(3, proOrg);
						
						ps.executeUpdate();
						l4.setText("Data Stored Successfully");
						
						
					}
					
					catch(Exception exp) {
						System.out.println(exp);
					}
				}
				
				
			}
		});
		submit.setForeground(new Color(25, 25, 112));
		submit.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		submit.setBounds(413, 564, 161, 53);
		contentPane.add(submit);
		
		
		
		
	}
}
