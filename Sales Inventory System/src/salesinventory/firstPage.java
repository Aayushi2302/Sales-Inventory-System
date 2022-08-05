package salesinventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class firstPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstPage frame = new firstPage();
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
	public firstPage() {
		setTitle("Home Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 714);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(95, 158, 160));
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Inventory System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 57));
		lblNewLabel.setBounds(157, 181, 644, 173);
		contentPane.add(lblNewLabel);
		
		JButton btn = new JButton("Continue");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondPage obj =new secondPage();
				obj.setVisible(true);
			}
		});
		btn.setForeground(new Color(0, 0, 128));
		btn.setBackground(new Color(211, 211, 211));
		btn.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		btn.setBounds(395, 390, 139, 52);
		contentPane.add(btn);
		
		JLabel lblNewLabel_1 = new JLabel("Project By");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(340, 544, 266, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Aayushi Sharma");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(340, 586, 266, 52);
		contentPane.add(lblNewLabel_1_1);
	}
}
