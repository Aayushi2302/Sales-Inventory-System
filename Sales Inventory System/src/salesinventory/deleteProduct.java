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

public class deleteProduct extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteProduct frame = new deleteProduct();
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
	public deleteProduct() {
		setTitle("Delete Product Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteEmployee = new JLabel("Delete Product");
		lblDeleteEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteEmployee.setForeground(new Color(25, 25, 112));
		lblDeleteEmployee.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblDeleteEmployee.setBounds(222, 56, 485, 68);
		contentPane.add(lblDeleteEmployee);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Product Id");
		lblEnterEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterEmployeeId.setForeground(new Color(25, 25, 112));
		lblEnterEmployeeId.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblEnterEmployeeId.setBounds(232, 134, 449, 42);
		contentPane.add(lblEnterEmployeeId);
		
		JLabel lblProductId = new JLabel("Product Id");
		lblProductId.setForeground(new Color(25, 25, 112));
		lblProductId.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblProductId.setBounds(185, 253, 242, 41);
		contentPane.add(lblProductId);
		
		t1 = new JTextField();
		t1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		t1.setColumns(10);
		t1.setBounds(466, 254, 264, 39);
		contentPane.add(t1);
		
		JLabel l1 = new JLabel("");
		l1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l1.setBounds(476, 303, 379, 27);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("");
		l2.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		l2.setBounds(293, 461, 305, 41);
		contentPane.add(l2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().trim().isEmpty())
					l1.setText("Product Id is empty");
				
				int delay = 3000;
				Timer tm = new Timer(delay, event->{
					l1.setText("");
				});
				
				tm.setRepeats(false);
				tm.start();
				
				if(l1.getText().trim().isEmpty()) {
						
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
						
						String proId = t1.getText();
						PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE ProductId='"+proId+"'");
						ResultSet rs = ps.executeQuery();
						boolean flag = rs.next();
						
						if(flag) {
							
							int op = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the record?","Delete",JOptionPane.YES_NO_OPTION);
							
							if(op == 0) {
								
								ps = con.prepareStatement("DELETE FROM product WHERE ProductId='"+proId+"'");
								ps.executeUpdate();
								
								l2.setText("Data removed successfully");
							}
							
						}
						else {
							l1.setText("ProductId does not exist in product records");
						}
						
					}
					
					catch(Exception ex) {
						System.out.println(ex);
					}
					
				}
			}	
		});
		btnDelete.setForeground(new Color(25, 25, 112));
		btnDelete.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnDelete.setBounds(350, 382, 208, 53);
		contentPane.add(btnDelete);
		
		
	}
}
