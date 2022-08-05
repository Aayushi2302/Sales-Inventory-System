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
import java.awt.event.ActionEvent;


public class Purchase extends JFrame {
	
	private JPanel contentPane;
	private JTextField productId;
	private JTextField productName;
	private JTextField quantity;
	private JTextField employeeId;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
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
	public Purchase() {
		setResizable(false);
		setBackground(new Color(173, 216, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 789);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Purchase Form");
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBounds(214, 31, 370, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product ID");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1.setBounds(42, 124, 157, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name");
		lblNewLabel_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(42, 183, 215, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBounds(42, 242, 132, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Purchase Date");
		lblNewLabel_1_1_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_2.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1_2.setBounds(42, 302, 215, 32);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Time");
		lblNewLabel_1_1_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1_3.setBounds(42, 362, 90, 32);
		contentPane.add(lblNewLabel_1_1_3);
		
		productId = new JTextField();
		productId.setForeground(new Color(25, 25, 112));
		productId.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		productId.setBounds(335, 124, 204, 37);
		contentPane.add(productId);
		productId.setColumns(10);
		
		productName = new JTextField();
		productName.setForeground(new Color(25, 25, 112));
		productName.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		productName.setColumns(10);
		productName.setBounds(335, 178, 204, 37);
		contentPane.add(productName);
		
		quantity = new JTextField();
		quantity.setForeground(new Color(25, 25, 112));
		quantity.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		quantity.setColumns(10);
		quantity.setBounds(335, 237, 204, 37);
		contentPane.add(quantity);
		
		employeeId = new JTextField();
		employeeId.setForeground(new Color(25, 25, 112));
		employeeId.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		employeeId.setColumns(10);
		employeeId.setBounds(335, 417, 204, 37);
		contentPane.add(employeeId);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Employee Id");
		lblNewLabel_1_1_5.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_5.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		lblNewLabel_1_1_5.setBounds(43, 422, 190, 32);
		contentPane.add(lblNewLabel_1_1_5);
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(335, 302, 204, 32);
		contentPane.add(dateChooser);
		
		JLabel lb1 = new JLabel("");
		lb1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb1.setBounds(579, 144, 232, 21);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb2.setBounds(579, 194, 232, 21);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("");
		lb3.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb3.setBounds(579, 253, 232, 21);
		contentPane.add(lb3);
		
		JLabel lb4 = new JLabel("");
		lb4.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb4.setBounds(579, 313, 232, 21);
		contentPane.add(lb4);
		
		JLabel lb5 = new JLabel("");
		lb5.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb5.setBounds(579, 362, 232, 21);
		contentPane.add(lb5);
		
		JLabel lb6 = new JLabel("");
		lb6.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb6.setBounds(579, 433, 232, 21);
		contentPane.add(lb6);
		
	//	TimePicker timePicker = new TimePicker();
	//	timePicker.setBounds(335, 362, 204, 23);
	//	contentPane.add(timePicker);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(productId.getText().trim().isEmpty())
					lb1.setText("Product Id is Empty");
				if(productName.getText().trim().isEmpty())
					lb2.setText("Product Name is Empty");
				if(quantity.getText().trim().isEmpty())
					lb3.setText("Quantity is Empty");
				//if(dateChooser.getDate()==null)
				//	lb4.setText("Date is Empty");
				//if(timePicker.getTime()==null)
				//	lb5.setText("Time is Empty");
				if(employeeId.getText().trim().isEmpty())
					lb6.setText("Employee is empty");
				
		if(productId.getText().trim().isEmpty() && productName.getText().trim().isEmpty() &&  quantity.getText().trim().isEmpty() /*&& dateChooser.getDate()==null && timePicker.getTime()==null */&& employeeId.getText().trim().isEmpty())
		
		{
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sales_inventory","root","");
					
					PreparedStatement ps = con.prepareStatement("INSERT INTO purchase values(?,?,?,?,?,?)");
					
					String ProductId = productId.getText();
					ps.setString(1, ProductId);
					
					String ProductName = productName.getText();
					ps.setString(2, ProductName);
					
					int Quantity = Integer.parseInt(quantity.getText());
					ps.setInt(3, Quantity);
				
//					java.util.Date dob = dateChooser.getDate();
//					java.sql.Date DOB = new java.sql.Date(dob.getTime());
//					ps.setDate(4, (java.sql.Date) DOB);
				
    			//	java.util.Date date=new java.util.Date();
			    //	java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
			    //	ps.setTimestamp(5,sqlTime);
					
					String EmployeeId = employeeId.getText();
					ps.setString(6, EmployeeId);
					
					ps.executeUpdate();
					
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
		btnNewButton.setBounds(231, 527, 119, 47);
		contentPane.add(btnNewButton);	}

}
