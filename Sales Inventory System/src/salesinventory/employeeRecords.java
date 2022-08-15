package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class employeeRecords extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeRecords frame = new employeeRecords();
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
	public employeeRecords() {
		setTitle("Employee Records");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeDetails.setForeground(new Color(25, 25, 112));
		lblEmployeeDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblEmployeeDetails.setBounds(146, 50, 485, 68);
		contentPane.add(lblEmployeeDetails);
		
		
		JButton btnShowData = new JButton("Show Data");
		btnShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
						
						PreparedStatement ps = con.prepareStatement("SELECT * FROM register");
						ResultSet rs = ps.executeQuery();
						ResultSetMetaData rsmd = rs.getMetaData();
						DefaultTableModel model =  (DefaultTableModel) table.getModel();
						
						
						int col = rsmd.getColumnCount();
						String[] colSchema = new String[col];
						for(int i=0;i<col;i++)
							colSchema[i] = rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colSchema);
						
						String name,empId,DOB,dept,gender,username,password,mail;
						
						while(rs.next()) {
							
							proId = rs.getString(1);
							proName = rs.getString(2);
							proOrg = rs.getString(3);
							String[] rowRecord = {proId,proName,proOrg};
							model.addRow(rowRecord);
						}
				}
				catch(Exception exp) {
					System.out.println(exp);
				}
			}
		});
		btnShowData.setForeground(new Color(25, 25, 112));
		btnShowData.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnShowData.setBounds(21, 252, 204, 53);
		contentPane.add(btnShowData);
		
		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel());
			}
		});
		btnClearData.setForeground(new Color(25, 25, 112));
		btnClearData.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnClearData.setBounds(21, 355, 204, 53);
		contentPane.add(btnClearData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 164, 523, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
