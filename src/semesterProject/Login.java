/*LOGIN INTERFACE
 * 
 * */

package semesterProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends Employee {
	private JLabel label;
	private JRadioButton employeRadioButton;
	private JRadioButton managerRadioButton;
	private JTextField userNameField;
	private static String name;
	
	private JPasswordField passwordField;
	private JButton loginButton;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Login.name = name;
	}

	Connection connection = null;

	public Login() {
		connection = SqliteCon.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		
		
		label = new JLabel("Enter valid username and password to access the panel");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(384, 191, 503, 23);
		frame.getContentPane().add(label);
		
		employeRadioButton = new JRadioButton("Employee");
		employeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(employeRadioButton.isSelected()){
					loginButton.setEnabled(true);
					managerRadioButton.setSelected(false);
				}
				else{
					loginButton.setEnabled(false);
				}
			}
		});
		employeRadioButton.setSelected(true);
		employeRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		employeRadioButton.setBounds(591, 253, 105, 23);
		frame.getContentPane().add(employeRadioButton);
		
		managerRadioButton = new JRadioButton("Manager");
		managerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(managerRadioButton.isSelected()){
					employeRadioButton.setSelected(false);
					loginButton.setEnabled(true);
				}
				else {
					loginButton.setEnabled(false);
				}
			}
		});
		managerRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		managerRadioButton.setBounds(766, 253, 109, 23);
		frame.getContentPane().add(managerRadioButton);
		
		userNameField = new JTextField();
		userNameField.setFont(new Font("Tahoma", Font.BOLD, 15));
		userNameField.setColumns(10);
		userNameField.setBounds(659, 302, 216, 25);
		frame.getContentPane().add(userNameField);
		
		label_1 = new JLabel("Username");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(561, 306, 83, 28);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/login.png"))
		.getImage();
		label_2.setIcon(new ImageIcon(img2));
		label_2.setForeground(Color.YELLOW);
		label_2.setBackground(Color.GRAY);
		label_2.setBounds(384, 250, 128, 161);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("Password");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(561, 345, 88, 34);
		frame.getContentPane().add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setBounds(659, 350, 216, 25);
		frame.getContentPane().add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation", "static-access" })
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Manager
					String manQuery = "select * from Manager where username=? and password=? ";
					// Employee

					String empQuery = "select * from Employee where username=? and password=? ";

					// manager
					PreparedStatement manPst = connection
							.prepareStatement(manQuery);

					// employee
					PreparedStatement empPst = connection
							.prepareStatement(empQuery);

					// manager
					manPst.setString(1, userNameField.getText());
					manPst.setString(2, passwordField.getText());

					// employee
					empPst.setString(1, userNameField.getText());
					empPst.setString(2, passwordField.getText());

					// manager
					ResultSet manRS = manPst.executeQuery();

					// employee
					ResultSet empRS = empPst.executeQuery();

					int manCount = 0, empCount = 0;
					// manager
					while (manRS.next()) {
						manCount++;
					}

					// manager
					while (empRS.next()) {
						empCount++;
					}

					// to launch the manager JFrame
						if (manCount == 1 && managerRadioButton.isSelected()) {
						setName(userNameField.getText());
						// class manager
						// to initialize main function/ JFrame in the manager class
						// close the login JFrame before opening the manager JFrame
						frame.dispose();
						Manager.main(null);
						

					}
					// to launch the employee JFrame
					else if (empCount == 1 && employeRadioButton.isSelected()) {
						setName(userNameField.getText());
						// close the login JFrame before opening the Employee JFrame
						 frame.dispose();
						// class employee
						// to initialize main function/ JFrame in the Employee class
						Employee.main(null);		 
					}

					else if (manCount > 1 || empCount > 1) {
						JOptionPane.showMessageDialog(null,
								"Duplicate username and password");
					} else {
						JOptionPane.showMessageDialog(null,
								"username and password are incorrect", "Error",
								JOptionPane.ERROR_MESSAGE);
						userNameField.setText(null);
						passwordField.setText(null);

					}
					manPst.close();
					empPst.close();
					manRS.close();
					empRS.close();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		Image loginImg = new ImageIcon(this.getClass().getResource("/ok.png"))
		.getImage();
		loginButton.setIcon(new ImageIcon(loginImg));
		loginButton.setBounds(707, 404, 109, 34);
		frame.getContentPane().add(loginButton);
		
		lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MAOTO M\\Desktop\\JavaPrograms\\BOP311SemesterProject\\image\\ocean.jpg"));
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\image\\ocean.jpg"));
		lblNewLabel.setBounds(0, 0, 1360, 739);
		frame.getContentPane().add(lblNewLabel);
		
		

	}

}
