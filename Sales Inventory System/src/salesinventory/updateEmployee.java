package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class updateEmployee extends JFrame {

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
					updateEmployee frame = new updateEmployee();
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
	public updateEmployee() {
		setTitle("Update Employee Details");
		setResizable(false);
		setBackground(new Color(173, 216, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		t1.setBounds(497, 175, 201, 39);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Employee Id");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel.setBounds(185, 176, 201, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update Employee Details");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblNewLabel_1.setBounds(155, 28, 644, 85);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUpdate = new JLabel("Update\r\n");
		lblUpdate.setForeground(new Color(25, 25, 112));
		lblUpdate.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblUpdate.setBounds(185, 271, 201, 38);
		contentPane.add(lblUpdate);
		
		JComboBox cb1 = new JComboBox();
		cb1.setForeground(new Color(25, 25, 112));
		cb1.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		cb1.setModel(new DefaultComboBoxModel(new String[] {"EmployeeName", "Department", "Gender", "Username", "Password", "Email"}));
		cb1.setBounds(497, 271, 201, 38);
		contentPane.add(cb1);
		
		JLabel lblEnterUpdatedData = new JLabel("Updated data");
		lblEnterUpdatedData.setForeground(new Color(25, 25, 112));
		lblEnterUpdatedData.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblEnterUpdatedData.setBounds(185, 365, 225, 38);
		contentPane.add(lblEnterUpdatedData);
		
		t2 = new JTextField();
		t2.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		t2.setColumns(10);
		t2.setBounds(497, 365, 201, 39);
		contentPane.add(t2);
		
		JButton b1 = new JButton("Update");
		b1.setForeground(new Color(25, 25, 112));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
					
					Statement st = con.createStatement();
					
					String s1 = cb1.getSelectedItem() + "";
					
					if(s1=="EmployeeName")
					{
						st.execute("UPDATE register SET EmployeeName='" + t2.getText() + "' WHERE EmployeeId ='" + t1.getText()+"'" );
					}
					else if(s1=="Department")
					{
						st.execute("UPDATE register SET Department='" + t2.getText() + "' WHERE EmployeeId ='" + t1.getText()+"'" );
					}
					else if(s1=="Gender")
					{
						st.execute("UPDATE register SET Gender='" + t2.getText() + "' WHERE EmployeeId ='" + t1.getText()+"'" );
					}
					else if(s1=="Username")
					{
						st.execute("UPDATE register SET Username='" + t2.getText() + "' WHERE EmployeeId ='" + t1.getText()+"'" );
					}
					else if(s1=="Password")
					{
						st.execute("UPDATE register SET Password='" + t2.getText() + "' WHERE EmployeeId ='" + t1.getText()+"'" );
					}
					else
					{
						st.execute("UPDATE register SET Email='" + t2.getText() + "' WHERE EmployeeId ='" + t1.getText()+"'" );
					}
					
					JOptionPane.showMessageDialog(null, "Record is updated..");
					st.close();
					con.close();
					
				}
			catch(SQLException | ClassNotFoundException se)
			{
				JOptionPane.showMessageDialog(null, se);
			}
			}
		});
		b1.setFont(new Font("Malgun Gothic", Font.BOLD, 22));
		b1.setBounds(394, 479, 130, 39);
		contentPane.add(b1);
	}
}
