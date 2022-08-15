package salesinventory;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;




public class productRecords extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productRecords frame = new productRecords();
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
	public productRecords() {
		setTitle("Product Records");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductDetails = new JLabel("Product Details");
		lblProductDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductDetails.setForeground(new Color(25, 25, 112));
		lblProductDetails.setFont(new Font("Malgun Gothic", Font.BOLD, 50));
		lblProductDetails.setBounds(158, 36, 485, 68);
		contentPane.add(lblProductDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 163, 510, 350);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnShowData = new JButton("Show Data");
		btnShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/salesinventory","root","");
					
					PreparedStatement ps = con.prepareStatement("SELECT * FROM product");
					ResultSet rs = ps.executeQuery();
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model =  (DefaultTableModel) table.getModel();
					
					
					int col = rsmd.getColumnCount();
					String[] colSchema = new String[col];
					for(int i=0;i<col;i++)
						colSchema[i] = rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colSchema);
					
					String proId,proName,proOrg;
					
					while(rs.next()) {
						
						proId = rs.getString(1);
						proName = rs.getString(2);
						proOrg = rs.getString(3);
						String[] rowRecord = {proId,proName,proOrg};
						model.addRow(rowRecord);
					}
				}
				catch(Exception exp) {
					System.out.println(exp);
				}
			}
		});
		btnShowData.setForeground(new Color(25, 25, 112));
		btnShowData.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnShowData.setBounds(22, 256, 204, 53);
		contentPane.add(btnShowData);
		
		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel());
			}
		});
		btnClearData.setForeground(new Color(25, 25, 112));
		btnClearData.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		btnClearData.setBounds(22, 362, 204, 53);
		contentPane.add(btnClearData);
	}
}
