package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class mainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage frame = new mainPage();
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
	public mainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("Sales Inventory System");
		heading.setForeground(new Color(25, 25, 112));
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		heading.setBounds(124, 58, 588, 85);
		contentPane.add(heading);
		
		JButton btn1 = new JButton("Sales");
		btn1.setForeground(new Color(25, 25, 112));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salesChoice ob = new salesChoice();
				ob.setVisible(true);
			}
			
		});
		btn1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btn1.setBounds(327, 262, 208, 53);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Purchase");
		btn2.setForeground(new Color(25, 25, 112));
		btn2.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btn2.setBounds(327, 367, 208, 53);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("Admin");
		btn3.setForeground(new Color(25, 25, 112));
		btn3.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btn3.setBounds(327, 477, 208, 53);
		contentPane.add(btn3);
		
		JLabel lblNewLabel = new JLabel("What you want to know about ?");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblNewLabel.setBounds(204, 165, 449, 42);
		contentPane.add(lblNewLabel);
	}
}
