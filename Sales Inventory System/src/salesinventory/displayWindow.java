package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class displayWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayWindow frame = new displayWindow();
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
	public displayWindow() {
		setTitle("Display");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblShowDetails = new JLabel("Show Details");
		lblShowDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowDetails.setForeground(new Color(25, 25, 112));
		lblShowDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblShowDetails.setBounds(244, 56, 485, 68);
		contentPane.add(lblShowDetails);
		
		JButton btnShowEmployeeDetails = new JButton("Show Employee Details");
		btnShowEmployeeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				employeeRecords obj = new employeeRecords();
				obj.setVisible(true);
			}
		});
		btnShowEmployeeDetails.setForeground(new Color(25, 25, 112));
		btnShowEmployeeDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnShowEmployeeDetails.setBounds(304, 193, 394, 53);
		contentPane.add(btnShowEmployeeDetails);
		
		JButton btnShowProductDetails = new JButton("Show Product Details");
		btnShowProductDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				productRecords obj = new productRecords();
				obj.setVisible(true);
			}
		});
		btnShowProductDetails.setForeground(new Color(25, 25, 112));
		btnShowProductDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnShowProductDetails.setBounds(304, 306, 394, 53);
		contentPane.add(btnShowProductDetails);
		
		JButton btnShowSalesDetails = new JButton("Show Sales Details");
		btnShowSalesDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salesRecords obj = new salesRecords();
				obj.setVisible(true);
			}
		});
		btnShowSalesDetails.setForeground(new Color(25, 25, 112));
		btnShowSalesDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnShowSalesDetails.setBounds(304, 420, 394, 53);
		contentPane.add(btnShowSalesDetails);
		
		JButton btnShowPurchaseDetails = new JButton("Show Purchase Details");
		btnShowPurchaseDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				purchaseRecords obj = new purchaseRecords();
				obj.setVisible(true);
			}
		});
		btnShowPurchaseDetails.setForeground(new Color(25, 25, 112));
		btnShowPurchaseDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnShowPurchaseDetails.setBounds(304, 534, 394, 53);
		contentPane.add(btnShowPurchaseDetails);
	}
}
