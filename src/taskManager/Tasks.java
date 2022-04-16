package taskManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class Tasks extends JFrame {
	

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private static java.sql.Connection con;
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tasks frame = new Tasks();
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
	public Tasks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(184, 31, 612, 395);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "Task Title", "Start_Date", "End_date", "Due_date","Progress"
			}
		));
		
		btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String employ_id=textField.getText();
				String title=textField_1.getText();
				Date s_date=dateChoose.;
				String e_date=dateChooser_1.getText();
				String due_date=dateChooser_2.getText();
				String progress=textField_5.getText();
				
				
	try {
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					String query3 =(String.format("INSERT into task ( Employee_id,Title, Start_date, End_date, Due_date,Progress) values(%s,'%s','%s','%s','%s',%s)",));
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root", "");
					PreparedStatement pst = con.prepareStatement(query3);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Added");
					
	}
				
				catch (Exception e1) {
					System.out.println(e1);
				}
	            view_task(); 
			}
		});
		btnNewButton_1.setBounds(806, 69, 122, 50);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_task();
			}
		});
		btnNewButton_2.setBounds(806, 258, 122, 43);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	try {
					
				
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					String query4 =("delete from task where Employee_id =" +textField.getText());
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root", "");
					PreparedStatement pst = con.prepareStatement(query4);

					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Record Deleted");
					
	}
				
				catch (Exception e1) {
					System.out.println(e1);
				}
	            view_task();
				
			}
		});
		btnNewButton_3.setBounds(806, 343, 122, 47);
		contentPane.add(btnNewButton_3);
		
		/*btnNewButton_4 = new JButton("Fetch Data");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query5= "SELECT * from task";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root", "");
					PreparedStatement pst1 = con.prepareStatement(query5);
					ResultSet rs1 = (ResultSet) pst1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					

					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		btnNewButton_4.setBounds(365, 321, 114, 16);
		contentPane.add(btnNewButton_4);*/
		
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnNewButton.setBounds(806, 161, 122, 46);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 48, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 99, 143, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 297, 143, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 32, 143, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Task Title");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 80, 143, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Start Date");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 131, 143, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("End Date");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 177, 143, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Due Date");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 223, 143, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Progress");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(10, 272, 143, 14);
		contentPane.add(lblNewLabel_5);
		
		btnNewButton_5 = new JButton("Log out");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Mainlogin().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(784, 474, 144, 42);
		contentPane.add(btnNewButton_5);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\another.jpg"));
		lblNewLabel_8.setBounds(784, 0, 170, 463);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\another.jpg"));
		lblNewLabel_9.setBounds(0, 452, 954, 86);
		contentPane.add(lblNewLabel_9);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 146, 143, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(10, 192, 143, 20);
		contentPane.add(dateChooser_1);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(10, 241, 143, 20);
		contentPane.add(dateChooser_2);
		view_task();
	}

        private void view_task() {
        	try {
				
				String query5= "SELECT * from task";
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root", "");
				PreparedStatement pst1 = con.prepareStatement(query5);
				ResultSet rs1 = (ResultSet) pst1.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs1));
				

				
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
        }
}