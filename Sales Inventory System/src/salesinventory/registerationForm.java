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

public class registerationForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		
		textField = new JTextField();
		textField.setBounds(362, 150, 194, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(362, 201, 194, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(362, 440, 194, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(362, 491, 194, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(362, 545, 194, 28);
		contentPane.add(textField_4);
		
		JRadioButton radio1 = new JRadioButton("Male");
		radio1.setForeground(new Color(25, 25, 112));
		buttonGroup.add(radio1);
		radio1.setBackground(new Color(211, 211, 211));
		radio1.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		radio1.setBounds(362, 381, 68, 23);
		contentPane.add(radio1);
		
		JRadioButton radio2 = new JRadioButton("Female");
		radio2.setForeground(new Color(25, 25, 112));
		buttonGroup.add(radio2);
		radio2.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		radio2.setBackground(new Color(211, 211, 211));
		radio2.setBounds(486, 381, 105, 23);
		contentPane.add(radio2);
		
		JRadioButton radio3 = new JRadioButton("Prefer Not to Say");
		radio3.setForeground(new Color(25, 25, 112));
		buttonGroup.add(radio3);
		radio3.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		radio3.setBackground(new Color(211, 211, 211));
		radio3.setBounds(636, 381, 179, 23);
		contentPane.add(radio3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(25, 25, 112));
		comboBox.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sales", "Marketing", "Purchase", "Admin", "Packaging"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(362, 316, 194, 26);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(25, 25, 112));
		comboBox_1.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(362, 260, 53, 24);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setForeground(new Color(25, 25, 112));
		comboBox_1_1.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"}));
		comboBox_1_1.setBounds(457, 260, 74, 24);
		contentPane.add(comboBox_1_1);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setForeground(new Color(25, 25, 112));
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		comboBox_1_2.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		comboBox_1_2.setBounds(584, 260, 74, 24);
		contentPane.add(comboBox_1_2);
		
		JButton btn1 = new JButton("Reset");
		btn1.setForeground(new Color(25, 25, 112));
		btn1.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btn1.setBounds(148, 612, 105, 38);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Submit");
		btn2.setForeground(new Color(25, 25, 112));
		btn2.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		btn2.setBounds(310, 612, 105, 38);
		contentPane.add(btn2);
		
		JLabel lblEnterDetails_1 = new JLabel("Enter details");
		lblEnterDetails_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterDetails_1.setForeground(new Color(25, 25, 112));
		lblEnterDetails_1.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblEnterDetails_1.setBounds(236, 76, 449, 42);
		contentPane.add(lblEnterDetails_1);
	}
}
