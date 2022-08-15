package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class deletePurchase extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deletePurchase frame = new deletePurchase();
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
	public deletePurchase() {
		setTitle("Delete Purchase Records");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeletePurchaseRecord = new JLabel("Delete Purchase Record");
		lblDeletePurchaseRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletePurchaseRecord.setForeground(new Color(25, 25, 112));
		lblDeletePurchaseRecord.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblDeletePurchaseRecord.setBounds(155, 55, 579, 68);
		contentPane.add(lblDeletePurchaseRecord);
		
		JLabel lblEnterProductId = new JLabel("Enter Product Id & Employee Id");
		lblEnterProductId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterProductId.setForeground(new Color(25, 25, 112));
		lblEnterProductId.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblEnterProductId.setBounds(221, 125, 449, 42);
		contentPane.add(lblEnterProductId);
		
		JLabel lblProductId = new JLabel("Product Id");
		lblProductId.setForeground(new Color(25, 25, 112));
		lblProductId.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblProductId.setBounds(172, 242, 242, 41);
		contentPane.add(lblProductId);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setForeground(new Color(25, 25, 112));
		lblEmployeeId.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblEmployeeId.setBounds(172, 338, 242, 41);
		contentPane.add(lblEmployeeId);
		
		t1 = new JTextField();
		t1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		t1.setColumns(10);
		t1.setBounds(432, 244, 264, 39);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		t2.setColumns(10);
		t2.setBounds(432, 339, 264, 39);
		contentPane.add(t2);
		
		JLabel l1 = new JLabel("");
		l1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l1.setBounds(442, 293, 402, 27);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("");
		l2.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l2.setBounds(442, 388, 402, 27);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("");
		l3.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		l3.setBounds(303, 508, 305, 41);
		contentPane.add(l3);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().trim().isEmpty())
					l1.setText("Product Id is empty");
				if(t2.getText().trim().isEmpty())
					l2.setText("Employee Id is empty");
				
				int delay = 3000;
				Timer tm = new Timer(delay, event ->{
					l1.setText("");
					l2.setText("");
				});
				
				tm.setRepeats(false);
				tm.start();
				
				if(l1.getText().trim().isEmpty() && l2.getText().trim().isEmpty()) {
						
						
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
						
						String proId = t1.getText();
						PreparedStatement ps = con.prepareStatement("SELECT * FROM purchase WHERE ProductId='"+proId+"'");
						ResultSet rs = ps.executeQuery();
						boolean flag = rs.next();
						
						if(flag) {
							
							String empId = t2.getText();
							ps = con.prepareStatement("SELECT * FROM purchase WHERE EmployeeId='"+empId+"'");
							rs = ps.executeQuery();
							flag = rs.next();
							
							if(flag) {
								int opt = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the record?","Delete",JOptionPane.YES_NO_OPTION);
								if(opt == 0) {
									
									ps = con.prepareStatement("DELETE FROM purchase WHERE ProductId='"+proId+"' and EmployeeId='"+empId+"'");
									ps.executeUpdate();
									
									l3.setText("Data removed successfully");
								}
								
							}
							else {
								
								l2.setText("EmployeeId does not exist in purchase records");
							}
							
						}
						else {
							
							l1.setText("ProductId does not exist in purchase records");
						}
						
					}
					catch(Exception exp) {
						System.out.println(exp);
					}
				}
			}
			
		});
		btnDelete.setForeground(new Color(25, 25, 112));
		btnDelete.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnDelete.setBounds(356, 435, 208, 53);
		contentPane.add(btnDelete);
		
		
	}
}
