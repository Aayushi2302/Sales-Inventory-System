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

public class deleteDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteDetails frame = new deleteDetails();
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
	public deleteDetails() {
		setTitle("Delete Details");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1027, 761);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeletedetails = new JLabel("Delete Details");
		lblDeletedetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletedetails.setForeground(new Color(25, 25, 112));
		lblDeletedetails.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblDeletedetails.setBounds(257, 70, 485, 68);
		contentPane.add(lblDeletedetails);
		
		JButton btnDeleteEmployeeDetails = new JButton("Delete Employee Details");
		btnDeleteEmployeeDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteEmployee obj = new deleteEmployee();
				obj.setVisible(true);
			}
		});
		btnDeleteEmployeeDetails.setForeground(new Color(25, 25, 112));
		btnDeleteEmployeeDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnDeleteEmployeeDetails.setBounds(311, 218, 394, 53);
		contentPane.add(btnDeleteEmployeeDetails);
		
		JButton btnDeleteProductDetails = new JButton("Delete Product Details");
		btnDeleteProductDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteProduct obj = new deleteProduct();
				obj.setVisible(true);
			}
		});
		btnDeleteProductDetails.setForeground(new Color(25, 25, 112));
		btnDeleteProductDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnDeleteProductDetails.setBounds(311, 337, 394, 53);
		contentPane.add(btnDeleteProductDetails);
		
		JButton btnDelteSalesDetails = new JButton("Delete Sales Details");
		btnDelteSalesDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSales obj = new deleteSales();
				obj.setVisible(true);
			}
		});
		btnDelteSalesDetails.setForeground(new Color(25, 25, 112));
		btnDelteSalesDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnDelteSalesDetails.setBounds(311, 467, 394, 53);
		contentPane.add(btnDelteSalesDetails);
		
		JButton btnDeletePurchaseDetails = new JButton("Delete Purchase Details");
		btnDeletePurchaseDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePurchase obj = new deletePurchase();
				obj.setVisible(true);
			}
			
		});
		btnDeletePurchaseDetails.setForeground(new Color(25, 25, 112));
		btnDeletePurchaseDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnDeletePurchaseDetails.setBounds(311, 596, 394, 53);
		contentPane.add(btnDeletePurchaseDetails);
	}

}
