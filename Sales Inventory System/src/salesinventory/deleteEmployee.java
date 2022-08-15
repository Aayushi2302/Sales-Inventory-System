package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class deleteEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteEmployee frame = new deleteEmployee();
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
	public deleteEmployee() {
		setTitle("Delete Employee Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteEmployee = new JLabel("Delete Employee");
		lblDeleteEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteEmployee.setForeground(new Color(25, 25, 112));
		lblDeleteEmployee.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblDeleteEmployee.setBounds(214, 40, 485, 68);
		contentPane.add(lblDeleteEmployee);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Employee Id");
		lblEnterEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterEmployeeId.setForeground(new Color(25, 25, 112));
		lblEnterEmployeeId.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblEnterEmployeeId.setBounds(214, 113, 449, 42);
		contentPane.add(lblEnterEmployeeId);
		
		JLabel lblEmployeeId = new JLabel("Employee Id");
		lblEmployeeId.setForeground(new Color(25, 25, 112));
		lblEmployeeId.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblEmployeeId.setBounds(165, 226, 242, 41);
		contentPane.add(lblEmployeeId);
		
		JLabel l1 = new JLabel("");
		l1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l1.setBounds(468, 276, 384, 27);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("");
		l2.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		l2.setBounds(305, 454, 305, 39);
		contentPane.add(l2);
		
		t1 = new JTextField();
		t1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		t1.setColumns(10);
		t1.setBounds(458, 227, 264, 39);
		contentPane.add(t1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().trim().isEmpty())
					l1.setText("Employee Id is empty");
				
				int delay = 3000;
				Timer tm = new Timer(delay,event -> {
					l1.setText("");
				});
				
				tm.setRepeats(false);
				tm.start();
				
				if(l1.getText().trim().isEmpty()) {
							
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
						
						String empId = t1.getText();
						PreparedStatement ps = con.prepareStatement("SELECT * FROM register WHERE EmployeeId='"+empId+"'");
						ResultSet rs = ps.executeQuery();
						boolean flag = rs.next();
						
						if(flag) {
							
							int opt = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the record?","Delete",JOptionPane.YES_NO_OPTION);
							
							if(opt == 0) {
								
								ps = con.prepareStatement("DELETE FROM register WHERE EmployeeId='"+empId+"'");
								ps.executeUpdate();
								
								
								l2.setText("Data removed successfully");
								
							}
								
						}
						else {
							l1.setText("EmployeeId does not exist in employee records");
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
		btnDelete.setBounds(346, 361, 208, 53);
		contentPane.add(btnDelete);
		
		
	}
}
