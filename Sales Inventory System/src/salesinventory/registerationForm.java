package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class registerationForm extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerationForm frame = new registerationForm();
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
	public registerationForm() {
		setTitle("Register Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 732);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel registeration = new JLabel("Registeration Form");
		registeration.setForeground(new Color(25, 25, 112));
		registeration.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		registeration.setBounds(236, 10, 485, 68);
		contentPane.add(registeration);

		JLabel Name = new JLabel("Employee Name");
		Name.setForeground(new Color(25, 25, 112));
		Name.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		Name.setBounds(148, 154, 163, 24);
		contentPane.add(Name);

		JLabel EmpID = new JLabel("Employee Id");
		EmpID.setForeground(new Color(25, 25, 112));
		EmpID.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		EmpID.setBounds(148, 197, 145, 24);
		contentPane.add(EmpID);

		JLabel DOB = new JLabel("Date OF Birth");
		DOB.setForeground(new Color(25, 25, 112));
		DOB.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		DOB.setBounds(148, 260, 145, 24);
		contentPane.add(DOB);

		JLabel Department = new JLabel("Department");
		Department.setForeground(new Color(25, 25, 112));
		Department.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		Department.setBounds(148, 316, 145, 26);
		contentPane.add(Department);

		JLabel Gender = new JLabel("Gender");
		Gender.setForeground(new Color(25, 25, 112));
		Gender.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		Gender.setBounds(148, 379, 145, 24);
		contentPane.add(Gender);

		JLabel Username = new JLabel("Username");
		Username.setForeground(new Color(25, 25, 112));
		Username.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		Username.setBounds(148, 436, 145, 24);
		contentPane.add(Username);

		JLabel Password = new JLabel("Password");
		Password.setForeground(new Color(25, 25, 112));
		Password.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		Password.setBounds(148, 487, 145, 24);
		contentPane.add(Password);

		JLabel mail = new JLabel("Email");
		mail.setForeground(new Color(25, 25, 112));
		mail.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		mail.setBounds(148, 541, 145, 24);
		contentPane.add(mail);

		t1 = new JTextField();
		t1.setBounds(362, 150, 194, 28);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(362, 201, 194, 28);
		contentPane.add(t2);

		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(362, 440, 194, 28);
		contentPane.add(t3);

		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(362, 545, 194, 28);
		contentPane.add(t5);

		JRadioButton rd1 = new JRadioButton("Male");
		rd1.setForeground(new Color(25, 25, 112));
		buttonGroup.add(rd1);
		rd1.setBackground(new Color(211, 211, 211));
		rd1.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		rd1.setBounds(362, 381, 68, 23);
		contentPane.add(rd1);

		JRadioButton rd2 = new JRadioButton("Female");
		rd2.setForeground(new Color(25, 25, 112));
		buttonGroup.add(rd2);
		rd2.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		rd2.setBackground(new Color(211, 211, 211));
		rd2.setBounds(486, 381, 105, 23);
		contentPane.add(rd2);

		JRadioButton rd3 = new JRadioButton("Prefer Not to Say");
		rd3.setForeground(new Color(25, 25, 112));
		buttonGroup.add(rd3);
		rd3.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		rd3.setBackground(new Color(211, 211, 211));
		rd3.setBounds(636, 381, 179, 23);
		contentPane.add(rd3);

		JComboBox cb4 = new JComboBox();
		cb4.setForeground(new Color(25, 25, 112));
		cb4.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		cb4.setModel(new DefaultComboBoxModel(new String[] { "Sales", "Marketing", "Purchase", "Admin", "Packaging" }));
		cb4.setBackground(Color.WHITE);
		cb4.setBounds(362, 316, 194, 26);
		contentPane.add(cb4);
		
		JDateChooser datePicker = new JDateChooser();
		datePicker.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		datePicker.setBounds(362, 260, 194, 28);
		contentPane.add(datePicker);

		JButton btn1 = new JButton("Reset");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				t1.setText("");
				t2.setText("");
				cb4.setSelectedIndex(0);
				buttonGroup.clearSelection();
				t3.setText("");
				t4.setText("");
				t5.setText("");
				
			}
		});
		btn1.setForeground(new Color(25, 25, 112));
		btn1.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btn1.setBounds(148, 612, 105, 38);
		contentPane.add(btn1);
		
		JLabel l1 = new JLabel("");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		l1.setBounds(584, 612, 285, 29);
		contentPane.add(l1);
		
		t4 = new JPasswordField();
		t4.setBounds(362, 489, 194, 28);
		contentPane.add(t4);

		JLabel lblEnterDetails_1 = new JLabel("Enter details");
		lblEnterDetails_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetails_1.setForeground(new Color(25, 25, 112));
		lblEnterDetails_1.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblEnterDetails_1.setBounds(236, 76, 449, 42);
		contentPane.add(lblEnterDetails_1);
		
		JLabel lb1 = new JLabel("");
		lb1.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb1.setBounds(584, 154, 194, 16);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb2.setBounds(584, 208, 194, 16);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("");
		lb3.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb3.setBounds(584, 271, 194, 16);
		contentPane.add(lb3);
		
		JLabel lb4 = new JLabel("");
		lb4.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb4.setBounds(362, 410, 194, 16);
		contentPane.add(lb4);
		
		JLabel lb5 = new JLabel("");
		lb5.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb5.setBounds(584, 447, 194, 16);
		contentPane.add(lb5);
		
		JLabel lb6 = new JLabel("");
		lb6.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb6.setBounds(584, 498, 194, 16);
		contentPane.add(lb6);
		
		JLabel lb7 = new JLabel("");
		lb7.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lb7.setBounds(584, 552, 194, 16);
		contentPane.add(lb7);

		JButton btn2 = new JButton("Submit");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(t1.getText().trim().isEmpty())
					lb1.setText("Employee Name is empty");
				if(t2.getText().trim().isEmpty())
					lb2.setText("Employee Id is empty");
				if(datePicker.getDate() == null)
					lb3.setText("Date of Birth is empty");
				if(!rd1.isSelected() && !rd2.isSelected() && !rd3.isSelected())
					lb4.setText("Gender is empty");
				if(t3.getText().trim().isEmpty())
					lb5.setText("Username is empty");
				if(t4.getText().trim().isEmpty())
					lb6.setText("Password is empty");
				if(t5.getText().trim().isEmpty())
					lb7.setText("Email is empty");
				
				int delay = 3000;
				Timer tm = new Timer(delay,event->{
					lb1.setText("");
					lb2.setText("");
					lb3.setText("");
					lb4.setText("");
					lb5.setText("");
					lb6.setText("");
					lb7.setText("");
				});
				
				tm.setRepeats(false);
				tm.start();
				
					
				if(lb1.getText().trim().isEmpty() && lb2.getText().trim().isEmpty() && lb3.getText().trim().isEmpty() && lb4.getText().trim().isEmpty() && lb5.getText().trim().isEmpty() && lb6.getText().trim().isEmpty() && lb7.getText().trim().isEmpty()) {
					
					
					try {
						  
						  Class.forName("com.mysql.cj.jdbc.Driver"); 
						  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
					  
						  PreparedStatement ps = con.prepareStatement("INSERT INTO register VALUES(?,?,?,?,?,?,?,?)"); 
						  
						  String empName = t1.getText();
						  ps.setString(1, empName);
						  
						  String empId = t2.getText();
						  ps.setString(2, empId);
						  
						  
						  java.util.Date dob = datePicker.getDate();
						  java.sql.Date DOB = new java.sql.Date(dob.getTime());
						  ps.setDate(3, (java.sql.Date) DOB);
						  
						  String dep = cb4.getSelectedItem()+"";
						  ps.setString(4, dep);
						  
						  if(rd1.isSelected()) {
							  ps.setString(5, "Male");
						  }
						  else if(rd2.isSelected()) {
							  ps.setString(5, "Female");
						  }
						  else
							  ps.setString(5, "Prefer Not to Say");
						  
						  String uName = t3.getText();
						  ps.setString(6, uName);
						  
						  String uPassword = t4.getText();
						  ps.setString(7, uPassword);
						  
						  String email = t5.getText();
						  ps.setString(8, email);
						 
						  ps.executeUpdate();
					      l1.setText("Data Stored Successfully!");
					      
					      secondPage ob = new secondPage();
					      ob.setVisible(true);
						  
					}
					 
					  catch(Exception ex) {
						  System.out.println(ex);
					  }
					
					
					
				}
				
				 
			}
		});
		
		btn2.setForeground(new Color(25, 25, 112));
		btn2.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btn2.setBounds(310, 612, 105, 38);
		contentPane.add(btn2);
		
		
		
		
		
	}
}
