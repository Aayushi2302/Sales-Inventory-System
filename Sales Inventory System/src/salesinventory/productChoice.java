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

public class productChoice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productChoice frame = new productChoice();
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
	public productChoice() {
		setTitle("Purchase");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 697);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("Purchase");
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setForeground(new Color(25, 25, 112));
		heading.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		heading.setBounds(256, 46, 485, 68);
		contentPane.add(heading);
		
		JLabel lb2 = new JLabel("Register new product");
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setForeground(new Color(25, 25, 112));
		lb2.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lb2.setBounds(290, 173, 449, 42);
		contentPane.add(lb2);
		
		JButton btn1 = new JButton("Register New Product");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productDetails obj = new productDetails();
				obj.setVisible(true);
			}
		});
		btn1.setForeground(new Color(25, 25, 112));
		btn1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btn1.setBounds(317, 240, 380, 53);
		contentPane.add(btn1);
		
		JLabel lb3 = new JLabel("Enter purchase details");
		lb3.setHorizontalAlignment(SwingConstants.CENTER);
		lb3.setForeground(new Color(25, 25, 112));
		lb3.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lb3.setBounds(290, 414, 449, 42);
		contentPane.add(lb3);
		
		JButton btn2 = new JButton("Enter Purchase Details");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purchase ob = new purchase();
				ob.setVisible(true);
			}
		});
		btn2.setForeground(new Color(25, 25, 112));
		btn2.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btn2.setBounds(317, 476, 380, 53);
		contentPane.add(btn2);
	}
}
