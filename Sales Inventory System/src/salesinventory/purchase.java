package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.Timer;
import javax.swing.SwingConstants;

public class purchase extends JFrame {

	private JPanel contentPane;
	private JTextField productId;
	private JTextField productName;
	private JTextField quantity;
	private JTextField employeeId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purchase frame = new purchase();
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
	public purchase() {
		setTitle("Purchase");
		setResizable(false);
		setBackground(new Color(173, 216, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 743);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Product ID");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1.setBounds(93, 170, 157, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name");
		lblNewLabel_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(93, 230, 215, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBounds(93, 287, 132, 39);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Purchase Date");
		lblNewLabel_1_1_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_2.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1_2.setBounds(93, 358, 215, 32);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Time");
		lblNewLabel_1_1_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1_3.setBounds(93, 416, 103, 39);
		contentPane.add(lblNewLabel_1_1_3);
		
		productId = new JTextField();
		productId.setForeground(new Color(25, 25, 112));
		productId.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		productId.setBounds(345, 163, 264, 39);
		contentPane.add(productId);
		productId.setColumns(10);
		
		productName = new JTextField();
		productName.setForeground(new Color(25, 25, 112));
		productName.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		productName.setColumns(10);
		productName.setBounds(345, 228, 264, 39);
		contentPane.add(productName);
		
		quantity = new JTextField();
		quantity.setForeground(new Color(25, 25, 112));
		quantity.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		quantity.setColumns(10);
		quantity.setBounds(345, 288, 120, 39);
		contentPane.add(quantity);
		
		employeeId = new JTextField();
		employeeId.setForeground(new Color(25, 25, 112));
		employeeId.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		employeeId.setColumns(10);
		employeeId.setBounds(345, 485, 264, 39);
		contentPane.add(employeeId);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Employee Id");
		lblNewLabel_1_1_5.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_5.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1_5.setBounds(93, 484, 190, 39);
		contentPane.add(lblNewLabel_1_1_5);
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(345, 351, 264, 39);
		contentPane.add(dateChooser);
		
		JSpinner sp1 = new JSpinner();
		sp1.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		sp1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		sp1.setBounds(345, 422, 49, 33);
		contentPane.add(sp1);
		
		JSpinner sp2 = new JSpinner();
		sp2.setModel(new SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		sp2.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		sp2.setBounds(425, 421, 62, 33);
		contentPane.add(sp2);
		
		JSpinner sp3 = new JSpinner();
		sp3.setModel(new SpinnerListModel(new String[] {"AM", "PM"}));
		sp3.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		sp3.setBounds(516, 421, 64, 33);
		contentPane.add(sp3);
		
		
		JLabel lb1 = new JLabel("");
		lb1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb1.setBounds(638, 181, 232, 21);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb2.setBounds(638, 241, 232, 21);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("");
		lb3.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb3.setBounds(491, 302, 232, 21);
		contentPane.add(lb3);
		
		JLabel lb4 = new JLabel("");
		lb4.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb4.setBounds(638, 370, 232, 21);
		contentPane.add(lb4);
		
		JLabel lb5 = new JLabel("");
		lb5.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb5.setBounds(638, 503, 232, 21);
		contentPane.add(lb5);
		
		JLabel lb6 = new JLabel("");
		lb6.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb6.setBounds(612, 609, 232, 27);
		contentPane.add(lb6);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(productId.getText().trim().isEmpty())
					lb1.setText("Product Id is Empty");
				if(productName.getText().trim().isEmpty())
					lb2.setText("Product Name is Empty");
				if(quantity.getText().trim().isEmpty())
					lb3.setText("Quantity is Empty");
				if(dateChooser.getDate()==null)
					lb4.setText("Date is Empty");
				if(employeeId.getText().trim().isEmpty())
					lb5.setText("Employee is empty");
				
				int delay = 3000;
				Timer tm = new Timer(delay, event->{
					lb1.setText("");
					lb2.setText("");
					lb3.setText("");
					lb4.setText("");
					lb5.setText("");
				});
				
				tm.setRepeats(false);
				tm.start();
				
				if(lb1.getText().trim().isEmpty() && lb2.getText().trim().isEmpty() &&  lb3.getText().trim().isEmpty() && lb4.getText().trim().isEmpty() && lb5.getText().trim().isEmpty())
				
				{
						try
						{
							Class.forName("com.mysql.cj.jdbc.Driver");				
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
							
							String ProductId = productId.getText();
							
							PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE ProductId='"+ProductId+"'");
							
							ResultSet rs = ps.executeQuery();
							boolean flag = rs.next();
							
							if(flag) {
								
								String empId = employeeId.getText();
								ps = con.prepareStatement("SELECT * FROM register WHERE EmployeeId='"+empId+"'");
								rs = ps.executeQuery();
								flag = rs.next();
								
								if(flag) {
									
									ps = con.prepareStatement("INSERT INTO purchase VALUES(?,?,?,?,?,?)");
									
									ps.setString(1, ProductId);
									
									String prName = productName.getText();
									ps.setString(2, prName);
									
									int quant = Integer.parseInt(quantity.getText());
									ps.setInt(3, quant);
									
									java.util.Date salesDate = dateChooser.getDate();
									java.sql.Date SalesDate = new java.sql.Date(salesDate.getTime());
									ps.setDate(4, (java.sql.Date)SalesDate);
									
									String SalesTime = sp1.getValue()+":"+sp2.getValue()+" "+sp3.getValue();
									ps.setString(5, SalesTime);
									
									ps.setString(6, empId);
									
									ps.executeUpdate();
									lb6.setText("Data Stored Successfully");
									
								}
								else {
									
									lb5.setText("Employee is not registered");
								}
							}
							else {
								
								lb1.setText("Product is not registered");
							}
							
						}
						catch(Exception exp)
						{
							System.out.println(exp);
						}
					}
			}
		});
		btnNewButton.setForeground(new Color(25, 25, 112));
		btnNewButton.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnNewButton.setBounds(407, 597, 149, 47);
		contentPane.add(btnNewButton);
		
		JLabel lblPurchaseForm = new JLabel("Purchase Form");
		lblPurchaseForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchaseForm.setForeground(new Color(25, 25, 112));
		lblPurchaseForm.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblPurchaseForm.setBounds(214, 31, 523, 68);
		contentPane.add(lblPurchaseForm);
		
		
		
		
		
	}
}

