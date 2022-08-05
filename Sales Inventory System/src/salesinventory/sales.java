package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import java.util.*;
import javax.swing.JScrollBar;
import com.toedter.components.JSpinField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class sales extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sales frame = new sales();
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
	public sales() {
		setTitle("Sales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 743);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterProductDetails = new JLabel("Product Registeration");
		lblEnterProductDetails.setBounds(230, 56, 523, 68);
		lblEnterProductDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterProductDetails.setForeground(new Color(25, 25, 112));
		lblEnterProductDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		contentPane.add(lblEnterProductDetails);
		
		JLabel lb1 = new JLabel("Product Id");
		lb1.setForeground(new Color(25, 25, 112));
		lb1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lb1.setBounds(74, 171, 161, 41);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("Product Name");
		lb2.setForeground(new Color(25, 25, 112));
		lb2.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lb2.setBounds(74, 242, 218, 41);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("Quantity");
		lb3.setForeground(new Color(25, 25, 112));
		lb3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lb3.setBounds(74, 313, 218, 41);
		contentPane.add(lb3);
		
		JLabel lb4 = new JLabel("Sales Date");
		lb4.setForeground(new Color(25, 25, 112));
		lb4.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lb4.setBounds(74, 388, 218, 41);
		contentPane.add(lb4);
		
		JLabel lb5 = new JLabel("Sales Time");
		lb5.setForeground(new Color(25, 25, 112));
		lb5.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lb5.setBounds(74, 465, 218, 41);
		contentPane.add(lb5);
		
		JLabel lb6 = new JLabel("Employee Id");
		lb6.setForeground(new Color(25, 25, 112));
		lb6.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lb6.setBounds(74, 544, 218, 41);
		contentPane.add(lb6);
		
		t1 = new JTextField();
		t1.setForeground(new Color(25, 25, 112));
		t1.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		t1.setColumns(10);
		t1.setBounds(375, 173, 264, 39);
		contentPane.add(t1);
		
		t2 = new JTextField();
		t2.setForeground(new Color(25, 25, 112));
		t2.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		t2.setColumns(10);
		t2.setBounds(375, 244, 264, 39);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setForeground(new Color(25, 25, 112));
		t3.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		t3.setColumns(10);
		t3.setBounds(375, 315, 120, 39);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setForeground(new Color(25, 25, 112));
		t4.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		t4.setColumns(10);
		t4.setBounds(375, 546, 264, 39);
		contentPane.add(t4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(375, 390, 264, 39);
		contentPane.add(dateChooser);
		
		JSpinner sp1 = new JSpinner();
		sp1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		sp1.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		sp1.setBounds(375, 473, 49, 33);
		contentPane.add(sp1);
		
		JSpinner sp2 = new JSpinner();
		sp2.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		sp2.setModel(new SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		sp2.setBounds(446, 473, 62, 33);
		contentPane.add(sp2);
		
		JSpinner sp3 = new JSpinner();
		sp3.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		sp3.setModel(new SpinnerListModel(new String[] {"AM", "PM"}));
		sp3.setBounds(530, 473, 64, 33);
		contentPane.add(sp3);
		
		JLabel l1 = new JLabel("");
		l1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l1.setBounds(659, 184, 175, 19);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("");
		l2.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l2.setBounds(659, 252, 175, 19);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("");
		l3.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l3.setBounds(505, 326, 175, 19);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("");
		l4.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l4.setBounds(659, 399, 175, 19);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("");
		l5.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l5.setBounds(659, 555, 226, 19);
		contentPane.add(l5);
		
		
		JLabel l6 = new JLabel("");
		l6.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		l6.setBounds(621, 634, 264, 28);
		contentPane.add(l6);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().trim().isEmpty())
					l1.setText("Product Id is empty");
				if(t2.getText().trim().isEmpty())
					l2.setText("Product Name is empty");
				if(t3.getText().trim().isEmpty())
					l3.setText("Qunatity is empty");
				if(dateChooser.getDate() == null)
					l4.setText("Sales Date is empty");
				if(t4.getText().trim().isEmpty())
					l5.setText("Employee Id is empty");
				
				if(l1.getText().trim().isEmpty() && l2.getText().trim().isEmpty() && l3.getText().trim().isEmpty() && l4.getText().trim().isEmpty() && l5.getText().trim().isEmpty()) {
					
					
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
						
						String prId = t1.getText();
						
						PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE ProductId='"+prId+"'");
						
						ResultSet rs = ps.executeQuery();
						boolean flag = rs.next();
						
						if(flag) {
							
							String empId = t4.getText();
							ps = con.prepareStatement("SELECT * FROM register WHERE EmployeeId='"+empId+"'");
							rs = ps.executeQuery();
							flag = rs.next();
							
							if(flag) {
								
								ps = con.prepareStatement("INSERT INTO sales VALUES(?,?,?,?,?,?)");
								
								ps.setString(1, prId);
								
								String prName = t2.getText();
								ps.setString(2, prName);
								
								int quant = Integer.parseInt(t3.getText());
								ps.setInt(3, quant);
								
								java.util.Date salesDate = dateChooser.getDate();
								java.sql.Date SalesDate = new java.sql.Date(salesDate.getTime());
								ps.setDate(4, (java.sql.Date)SalesDate);
								
								String SalesTime = sp1.getValue()+":"+sp2.getValue()+" "+sp3.getValue();
								ps.setString(5, SalesTime);
								
								ps.setString(6, empId);
								
								ps.executeUpdate();
								l6.setText("Data Stored Successfully");
								
							}
							else {
								
								l5.setText("Employee is not registered");
							}
						}
						else {
							
							l1.setText("Product is not registered");
						}
						
					}
					
					catch(Exception exp) {
						System.out.println(exp);
					}
				}
			}
		});
		submit.setForeground(new Color(25, 25, 112));
		submit.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		submit.setBounds(406, 622, 161, 53);
		contentPane.add(submit);
		
		
		
		
		
		
		
		
	}
}
