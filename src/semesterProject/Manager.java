/*
 * MANAGER CLASS
 *
 * DESIGNED AND CODED BY : MMONTSHENG MAOTO
 * CONTANT : MMONTSHENGMAOTO@GMAIL.COM
 * SOFTWARE ENGINEERING PROJECT
 * 
 * 
 * A RESTAURENT MANAGEMENT SYSTEM
 * ALL WAITERS AND WAITRESSES TO PLACE ODERES AS THEY TAKE OREERS
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import lu.tudor.santec.jtimechooser.JTimeChooser;
import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class Manager {
	// transactions
	double total = 0.0;
	// belongs to toTable()
	ArrayList<Double> price = new ArrayList<Double>();
	ArrayList<String> desc = new ArrayList<String>();

	// sql database
	private PreparedStatement pst;
	private ResultSet rs;

	//------CALCULATOR----
	private double firstNumber;
	private double secondNumber;
	private double results;
	private String operation;
	private boolean newOperation = true;
	private JButton plusButton;
	private JButton button0;
	private JButton perctgButton;
	private JButton button9;
	private JButton minusButton;
	//------CALCULATOR----


	//------DATE AND TIME
	private int day;
	private int month;
	private int year;
	private int second;
	private int minutes;
	private int hours;
	//------DATE AND TIME
	
	
	
	// -----DINE IN PANEL--------
	private JLabel dineInLabel;
	private JButton btnCold;
	private JButton btnHot;
	private JButton btnBaked;
	private JButton soupButton;
	private JButton statersButton;
	private JButton saladsButton;
	private JButton chickenButton;
	private JButton dineInbutton;
	private JButton reservationButton;
	private JButton ItalianButton;
	private JButton printRecButton;
	private JButton previewButton;
	private JButton clearOrderButton;
	@SuppressWarnings("rawtypes")
	private JComboBox tableComboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox mealTimeComboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox NoOfPeoplecomboBox;
	private JRadioButton creditRadioButton;
	private JTextField totalTextField;
	private JTextField grandTotalTextField;
	private JTextField ReceivedTextField;
	private JTextField dueTextField;
	private JTextField taxTextField;
	private JTextField cashTextField;
	private JTextArea receiptTextArea;
	private JTextField rateTextField;
	private JTextField changeTextField;
	private JTextField refTextField;
	private JTable menuTable;
	// -----DINE IN PANEL--------
	
	

	// ------RESERVATION PANEL------
	private JDateChooser reservationJdate;
	private JButton clearResButton;
	private JLabel bookings;
	private JTextArea reservDescriptionTextArea;
	private JTextField reservationInitialsTextField;
	private JTextField reservationSurnameTextField;
	private JTextField reservationContaNoTextField;
	private JTextField reservationNoOfPeopleTextField;
	private JTextField referenceReserveTextField;
	private JTable editTable;
	private JTable bookingsTable;
	private JLabel warning;
	private JCalendar reservPanelCalendar;
	private JTimeChooser arrival;
	private JTimeChooser depart;
	private JLabel savedLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox ocassionComboBox ;

	
	// ------RESERVATION PANEL------

	
	
	// -----EDIT SALES PANEL-------
	private JButton saveSalesButton;
	private JButton editSalesClearButton;
	@SuppressWarnings("rawtypes")
	private JComboBox drinksComboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox dessertComboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox mainCoComboBox;
	private JRadioButton addSalesRdbtn;
	private JRadioButton updateSalesRdbtn;
	private JRadioButton deleteSalesRdbtn;
	private JRadioButton drinkRadioButton;
	private JRadioButton dessertRadioButton;
	private JRadioButton mainCoRadioButton;
	private JTextField productIDTextField;
	private JTextField descriptionTextField;
	
	// -----EDIT SALES PANEL---------

	
	
	
	// -----ADD EMPLOYEES PANEL-------
	@SuppressWarnings("rawtypes")
	private JComboBox roleComboBox;
	private JRadioButton addUserRdbtn;
	private JRadioButton updateUserRdbtn;
	private JRadioButton deleteUserRdbtn;
	private JLabel errorMessageLable;
	private JButton addEmButton;
	private JButton editEmpClearButton;
	private JTextField addEmUserNameTextField;
	private JTextField addEmUserPasswordTextField;
	private JTextField addEmUserPhoneNumbertextField;
	private JTextField addEmUserEmailtextField;
	private JTextField addEmNamesTextField;
	private JTable userInfoTable;
	
	// -----ADD EMPLOYEES PANEL-------

	
	//----CHECK TABLES------
	private JButton clearSearchButton;
	private JTable checkTabelsTable;
	private JTextField searchTextField;
	//----CHECK TABLES -----
	
	
	
	
	// ------MAIN PANEL------
	private JPanel mainPanel;
	private JLabel restaurentLabel;
	private JPanel addEmployeespanel;
	private JPanel dinePanel;
	private JPanel editSalesPanel;
	private JPanel checkTablepanel;
	private JPanel reservationPanel;
	private JTextArea dateTextArea;
	private JTextField calculatorScreen;
	private JButton logoutButton;
	private JButton AddOrDeleteEmpbutton;
	private JButton editSalesButton;
	JTextField LoggedtextField;
	// private JFrame frame;
	private JFrame frame;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Manager window = new Manager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void totalCost() {
		if (price.size() > 0) {
			for (int i = 0; i < price.size(); i++) {
				total += price.get(i);
			}
		}

	}

	// arrayList
	private void print() {
		receiptTextArea.append("\nItems \n");
		for (int i = 0; i < desc.size(); i++) {

			receiptTextArea.append("" + (i + 1) + " : " + desc.get(i));
			receiptTextArea.append("\n");
		}
	}

	// arrayList
	// adds items into arraylists of price and description
	private void toTable(double rate, String description) {
		price.add(rate);
		desc.add(description);
	}

	// refresh user Info table after every successful add or delete or update
	private void refreshUserInfoTable() {

		if (updateUserRdbtn.isSelected() || deleteUserRdbtn.isSelected()
				|| addUserRdbtn.isSelected()) {

			if ((roleComboBox.getSelectedIndex() + 1 == 1)) {
				try {
					String query = "select * from Employee";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();

					userInfoTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();


				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if ((roleComboBox.getSelectedIndex() + 1 == 2)) {
				try {
					String query = "select * from Manager where Username=?";
					pst = connection.prepareStatement(query);
					pst.setString(1, LoggedtextField.getText());
					rs = pst.executeQuery();

					userInfoTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// refresh reserve table after every successful add or delete or update
	private void refreshBooking() {
		try {
			String query = "select * from Reserv";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			bookingsTable.setModel(DbUtils.resultSetToTableModel(rs));

			// close the DB
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// refresh table after every successful add or delete or update
	private void refreshTable() {

		if (updateSalesRdbtn.isSelected() || deleteSalesRdbtn.isSelected()
				|| addSalesRdbtn.isSelected()) {

			if ((drinkRadioButton.isSelected())
					&& (drinksComboBox.getSelectedIndex() + 1 == 2)) {
				try {
					String query = "select * from ColdDrink order by ProductID ASC";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if ((drinkRadioButton.isSelected())
					&& (drinksComboBox.getSelectedIndex() + 1 == 3)) {
				try {
					String query = "select * from HotDrink";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if ((dessertRadioButton.isSelected())
					&& (dessertComboBox.getSelectedIndex() + 1 == 2)) {
				try {
					String query = "select * from Baked";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if ((dessertRadioButton.isSelected())
					&& (dessertComboBox.getSelectedIndex() + 1 == 3)) {
				try {
					String query = "select * from IceCream";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 2)) {
				try {
					String query = "select * from Starters";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 3)) {
				try {
					String query = "select * from Soup";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 4)) {
				try {
					String query = "select * from Salads";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 5)) {
				try {
					String query = "select * from Vegetarian";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 6)) {
				try {
					String query = "select * from Chicken";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 7)) {
				try {
					String query = "select * from Italian";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 8)) {
				try {
					String query = "select * from Pizza";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 9)) {
				try {
					String query = "select * from Beef";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 10)) {
				try {
					String query = "select * from Kids";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if ((mainCoRadioButton.isSelected())
					&& (mainCoComboBox.getSelectedIndex() + 1 == 11)) {
				try {
					String query = "select * from BBQ";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					editTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}
	// DINE IN PANEL
	// It's confusing, but it works
	private void costPanel() {
		
		if (cashTextField.getText().length() == 0) {
			cashTextField.setText(Double.toString(0));
		}
		if(desc.size()>0){
			// converts tax to double
			//sets the tax field as the  total cost increase
			double tax = (Double.parseDouble(totalTextField.getText()))* 0.14;
			taxTextField.setText(String.format("%.2f", tax));
			
			// sets the grand total field 
			//grand total field = total + tax
			double tot = Double.parseDouble(totalTextField.getText());
			double bala = (tot + tax);
			grandTotalTextField.setText(String.format("%.2f", bala));
			dueTextField.setText(grandTotalTextField.getText());
			
			//sets the cash received  textField with the amount of cash text field
			ReceivedTextField.setText(cashTextField.getText());
			
			double grand = Double.parseDouble(grandTotalTextField.getText());
			double cash = Double.parseDouble(cashTextField.getText());
			double ans = grand - cash;
			if (ans == 0) {
				//dueTextField.setText(Double.toString(0));
				changeTextField.setText(Double.toString(0));
			}
			if (ans < 0) {
				changeTextField.setText(String.format("%.2f", (ans / -1.0)));
				//dueTextField.setText(Double.toString(0));
			} else {
				//printRecButton.setEnabled(false);
				//dueTextField.setText(String.format("%.2f", grand - cash));
				changeTextField.setText(Double.toString(0));
			}
		}
		if(Double.parseDouble(totalTextField.getText())>0){
			cashTextField.setEditable(true);
		}
		
	}
	
	private void printReceipt() {
		dineInLabel.setText(null);

		// prints table number on receipt
		receiptTextArea.append("\nTable: "
				+ (tableComboBox.getSelectedIndex() + 1));

		// prints meal type on screen
		receiptTextArea.append("\nMeal type : "
				+ mealTimeComboBox.getSelectedItem());

		// prints no of people for order
		receiptTextArea.append("\nNo of People :"
				+ (NoOfPeoplecomboBox.getSelectedIndex() + 1));
	}

	// responsible for dynamically printing date and time on JFrame
	// uses a thread
	private void TimeAndDate() {

		Thread TimeAndDate = new Thread() {

			public void run() {

				try {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						day = cal.get(Calendar.DAY_OF_MONTH);
						month = cal.get(Calendar.MONTH);
						year = cal.get(Calendar.YEAR);

						second = cal.get(Calendar.SECOND);
						minutes = cal.get(Calendar.MINUTE);
						hours = cal.get(Calendar.HOUR_OF_DAY);

						dateTextArea.setText("Time : " + hours + ":" + minutes
								+ ":" + second);
						dateTextArea.append("\nDate : " + year + "/" + month
								+ "/" + day);
						if(Double.parseDouble(dueTextField.getText())>0){
							printRecButton.setEnabled(true);
							cashTextField.setEditable(true);
						}
						else{
							printRecButton.setEnabled(false);
							cashTextField.setEditable(false);
						}
						// this methods refreshes every transaction on the DINE in panel
						costPanel();
						//refresh the time every second
						Thread.sleep(1000);

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		TimeAndDate.start();

	}

	Connection connection = null;
	
	public Manager() {	
		// initialize sql connection
		// refer to sqliteCon class
		connection = SqliteCon.dbConnector();
		initialize();
		TimeAndDate();
		LoggedtextField.setText(Login.getName());
		// self-explanatory
		// sets the following texts to the receipt every time the JFrame is initialized 
		receiptTextArea.setText("   ..MMONTSHENG'S RESTAURENT..");
		receiptTextArea
				.append("\n       230 Jorrisen Street\n\t   Braamfontein\n\t   Johannesburg\n\t       2000");
		receiptTextArea.append("\n\tTel: 011 774 2312");
		receiptTextArea.append("\n\t     " + year + "/" + month + "/" + day);
		
		// self-explanatory
		productIDTextField.setText(null);
		descriptionTextField.setText(null);
		rateTextField.setText(null);
		drinksComboBox.setEnabled(false);

		editSalesClearButton = new JButton("Clear");
		Image clears = new ImageIcon(this.getClass().getResource("/clear1.png"))
				.getImage();
		editSalesClearButton.setIcon(new ImageIcon(clears));
		editSalesClearButton.setEnabled(false);
		editSalesClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				savedLabel.setText(null);
				productIDTextField.setText(null);
				descriptionTextField.setText(null);
				rateTextField.setText(null);
			}
		});
		editSalesClearButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		editSalesClearButton.setBounds(88, 387, 110, 30);
		editSalesPanel.add(editSalesClearButton);

		JLabel lblEditSales_1 = new JLabel("EDIT SALES");
		lblEditSales_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditSales_1.setForeground(Color.WHITE);
		lblEditSales_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEditSales_1.setBounds(392, 11, 181, 39);
		editSalesPanel.add(lblEditSales_1);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {

		frame = new JFrame();
		//
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		frame.setLocationRelativeTo(null);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(165, 42, 42));

		mainPanel = new JPanel();
		mainPanel.setBorder(null);
		mainPanel.setBounds(168, 143, 1182, 585);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		Image img2 = new ImageIcon(this.getClass().getResource("/ok.png"))
				.getImage();

		JPanel cslculatorPanel = new JPanel();
		cslculatorPanel.setBackground(new Color(250, 250, 210));
		cslculatorPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cslculatorPanel.setBounds(927, 253, 255, 332);
		mainPanel.add(cslculatorPanel);
		cslculatorPanel.setLayout(null);

		calculatorScreen = new JTextField();
		calculatorScreen.setBackground(Color.WHITE);
		calculatorScreen.setEditable(false);
		calculatorScreen.setFont(new Font("Tahoma", Font.BOLD, 24));
		calculatorScreen.setHorizontalAlignment(SwingConstants.TRAILING);
		calculatorScreen.setBounds(15, 11, 225, 58);
		cslculatorPanel.add(calculatorScreen);
		calculatorScreen.setColumns(10);

		final JButton button3 = new JButton("3");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (newOperation == true) {
					calculatorScreen.setText(button3.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button3.getText());

				}
			}

		});
		button3.setFont(new Font("Tahoma", Font.BOLD, 14));
		button3.setBounds(134, 120, 48, 42);
		cslculatorPanel.add(button3);

		final JButton button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (newOperation == true) {
					calculatorScreen.setText(button2.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button2.getText());

				}
			}
		});
		button2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button2.setBounds(73, 120, 48, 42);
		cslculatorPanel.add(button2);

		final JButton button1 = new JButton("1");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (newOperation == true) {
					calculatorScreen.setText(button1.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button1.getText());

				}
			}

		});
		button1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button1.setBounds(15, 120, 48, 42);
		cslculatorPanel.add(button1);

		final JButton button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (newOperation == true) {
					button4.setText(button4.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button4.getText());

				}
			}
		});
		button4.setFont(new Font("Tahoma", Font.BOLD, 14));
		button4.setBounds(15, 173, 48, 42);
		cslculatorPanel.add(button4);

		final JButton button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (newOperation == true) {
					calculatorScreen.setText(button5.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button5.getText());

				}
			}
		});
		button5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button5.setBounds(73, 173, 48, 42);
		cslculatorPanel.add(button5);

		final JButton button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (newOperation == true) {
					calculatorScreen.setText(button6.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button6.getText());

				}
			}
		});
		button6.setFont(new Font("Tahoma", Font.BOLD, 14));
		button6.setBounds(134, 173, 48, 42);
		cslculatorPanel.add(button6);

		JButton multiButton = new JButton("*");
		multiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNumber = Double.parseDouble(calculatorScreen.getText());
				calculatorScreen.setText("");
				operation = "*";

			}
		});
		multiButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		multiButton.setBounds(192, 277, 48, 42);
		cslculatorPanel.add(multiButton);

		final JButton button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (newOperation == true) {
					calculatorScreen.setText(button7.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button7.getText());

				}
			}
		});
		button7.setFont(new Font("Tahoma", Font.BOLD, 14));
		button7.setBounds(15, 226, 48, 42);
		cslculatorPanel.add(button7);

		final JButton button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (newOperation == true) {
					calculatorScreen.setText(button8.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button8.getText());

				}
			}
		});
		button8.setFont(new Font("Tahoma", Font.BOLD, 14));
		button8.setBounds(73, 226, 48, 42);
		cslculatorPanel.add(button8);

		JButton dotButton = new JButton("\u2022\t\r\n");
		dotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dotButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		dotButton.setBounds(15, 279, 48, 42);
		cslculatorPanel.add(dotButton);

		minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNumber = Double.parseDouble(calculatorScreen.getText());
				calculatorScreen.setText("");
				operation = "-";
			}
		});
		minusButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		minusButton.setBounds(192, 172, 48, 42);
		cslculatorPanel.add(minusButton);

		plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				firstNumber = Double.parseDouble(calculatorScreen.getText());
				calculatorScreen.setText("");
				operation = "+";
			}
		});
		plusButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		plusButton.setBounds(192, 226, 48, 42);
		cslculatorPanel.add(plusButton);

		button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (newOperation == true) {
					calculatorScreen.setText(button9.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button9.getText());

				}
			}
		});
		button9.setFont(new Font("Tahoma", Font.BOLD, 14));
		button9.setBounds(131, 226, 48, 42);
		cslculatorPanel.add(button9);

		button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (newOperation == true) {
					calculatorScreen.setText(button0.getText());
					newOperation = false;
				} else {
					String currenttext = calculatorScreen.getText();
					calculatorScreen.setText(currenttext + button0.getText());

				}
			}
		});
		button0.setFont(new Font("Tahoma", Font.BOLD, 14));
		button0.setBounds(73, 279, 48, 42);
		cslculatorPanel.add(button0);

		perctgButton = new JButton("%");
		perctgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (calculatorScreen.getText().length() > 0) {
					results = Double.parseDouble(calculatorScreen.getText());
					calculatorScreen.setText(String.format("%.2f",
							results / 100));
				}
			}
		});
		perctgButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		perctgButton.setBounds(192, 120, 48, 42);
		cslculatorPanel.add(perctgButton);

		JButton formatButton = new JButton("C");
		formatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculatorScreen.setText(null);
			}
		});
		formatButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		formatButton.setBounds(73, 80, 48, 29);
		cslculatorPanel.add(formatButton);

		JButton equalButton = new JButton("=");
		equalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String answer;
				if (calculatorScreen.getText().length() > 0) {
					secondNumber = Double.parseDouble(calculatorScreen
							.getText());
					if (operation == "+") {

						results = firstNumber + secondNumber;
						answer = String.format("%.2f", results);
						calculatorScreen.setText(answer);
					}

					else if (operation == "-") {

						results = firstNumber - secondNumber;
						answer = String.format("%.2f", results);
						calculatorScreen.setText(answer);
					} else if (operation == "*") {

						results = firstNumber * secondNumber;
						answer = String.format("%.2f", results);
						calculatorScreen.setText(answer);
					} else if (operation == "/") {

						results = firstNumber / secondNumber;
						answer = String.format("%.2f", results);
						calculatorScreen.setText(answer);
					}
				}

			}
		});
		equalButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		equalButton.setBounds(15, 80, 48, 29);
		cslculatorPanel.add(equalButton);

		JButton divideButton = new JButton("/");
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstNumber = Double.parseDouble(calculatorScreen.getText());
				calculatorScreen.setText("");
				operation = "/";
			}
		});
		divideButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		divideButton.setBounds(131, 279, 48, 42);
		cslculatorPanel.add(divideButton);

		JButton deletButton = new JButton("Del");
		deletButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String backspace = null;

				if (calculatorScreen.getText().length() > 0) {
					StringBuilder strB = new StringBuilder(calculatorScreen
							.getText());
					strB.deleteCharAt(calculatorScreen.getText().length() - 1);
					backspace = strB.toString();
					calculatorScreen.setText(backspace);
				}
			}
		});
		deletButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		deletButton.setBounds(134, 80, 106, 29);
		cslculatorPanel.add(deletButton);

		dinePanel = new JPanel();
		dinePanel.setBackground(new Color(165, 42, 42));
		dinePanel.setBounds(0, 0, 926, 585);
		mainPanel.add(dinePanel);
		dinePanel.setVisible(true);
		dinePanel.setLayout(null);
		// mainPanel.add(dinePanel);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel_2.setBackground(new Color(153, 204, 255));
		panel_2.setBounds(4, 5, 248, 195);
		dinePanel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTable = new JLabel("Table #");
		lblTable.setForeground(new Color(0, 51, 255));
		lblTable.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTable.setBounds(10, 11, 63, 25);
		panel_2.add(lblTable);

		JLabel lblOfPerson = new JLabel("# of Person");
		lblOfPerson.setForeground(new Color(0, 51, 255));
		lblOfPerson.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOfPerson.setBounds(10, 52, 101, 25);
		panel_2.add(lblOfPerson);

		JLabel lblMealTime = new JLabel("Meal Time");
		lblMealTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMealTime.setForeground(new Color(0, 51, 255));
		lblMealTime.setBounds(10, 88, 63, 25);
		panel_2.add(lblMealTime);

		mealTimeComboBox = new JComboBox();
		mealTimeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mealTimeComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		mealTimeComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"BreakFast", "Lunch", "Supper" }));
		mealTimeComboBox.setBounds(133, 88, 108, 25);
		panel_2.add(mealTimeComboBox);

		tableComboBox = new JComboBox();
		tableComboBox.setModel(new DefaultComboBoxModel(new String[] { "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		tableComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableComboBox.setBounds(133, 12, 50, 25);
		panel_2.add(tableComboBox);

		NoOfPeoplecomboBox = new JComboBox();
		NoOfPeoplecomboBox.setModel(new DefaultComboBoxModel(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30" }));
		NoOfPeoplecomboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		NoOfPeoplecomboBox.setBounds(133, 56, 50, 25);
		panel_2.add(NoOfPeoplecomboBox);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel_4.setBackground(new Color(51, 153, 255));
		panel_4.setBounds(4, 367, 595, 214);
		dinePanel.add(panel_4);
		panel_4.setLayout(null);

		clearOrderButton = new JButton("Clear");
		clearOrderButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		Image cleaImg = new ImageIcon(this.getClass()
				.getResource("/clear1.png")).getImage();
		clearOrderButton.setIcon(new ImageIcon(cleaImg));
		clearOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dueTextField.setText(null);
				dineInLabel.setText(null);
				// clear
				desc.clear();
				price.clear();

				receiptTextArea.setText("   ..MMONTSHENG'S RESTAURENT..");
				receiptTextArea
						.append("\n       230 Jorrisen Street\n\t   Braamfontein\n\t   Johannesburg\n\t       2000");
				receiptTextArea.append("\n\tTel: 011 774 2312");
				receiptTextArea.append("\n\t     " + year + "/" + month + "/"
						+ day);
				totalTextField.setText(Double.toString(0.0));
				grandTotalTextField.setText(null);
				cashTextField.setText(Double.toString(0));
				dueTextField.setText(Double.toString(0));
				taxTextField.setText(null);
			}
		});
		clearOrderButton.setBounds(10, 16, 100, 30);
		panel_4.add(clearOrderButton);

		totalTextField = new JTextField();
		totalTextField.setToolTipText("");
		totalTextField.setEditable(false);
		totalTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		totalTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		totalTextField.setColumns(10);
		totalTextField.setBackground(Color.WHITE);
		totalTextField.setText(Double.toString(0));
		totalTextField.setBounds(522, 16, 66, 22);
		panel_4.add(totalTextField);

		grandTotalTextField = new JTextField();
		grandTotalTextField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {

			}
		});
		// grandTotalTextField.setText(Double.toString(0));
		grandTotalTextField.setEditable(false);
		grandTotalTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		grandTotalTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		grandTotalTextField.setColumns(10);
		grandTotalTextField.setBackground(Color.WHITE);
		grandTotalTextField.setBounds(522, 47, 66, 22);
		panel_4.add(grandTotalTextField);

		ReceivedTextField = new JTextField();
		ReceivedTextField.setEditable(false);
		ReceivedTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		ReceivedTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		ReceivedTextField.setColumns(10);
		ReceivedTextField.setBackground(Color.WHITE);
		ReceivedTextField.setBounds(522, 113, 66, 22);
		panel_4.add(ReceivedTextField);

		JLabel lblTotal = new JLabel("Total ");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(405, 16, 51, 20);
		panel_4.add(lblTotal);

		JLabel lblGrand = new JLabel("Grand Total ");
		lblGrand.setForeground(Color.WHITE);
		lblGrand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrand.setBounds(402, 47, 91, 20);
		panel_4.add(lblGrand);

		JLabel lblRecieved = new JLabel("Recieved");
		lblRecieved.setForeground(Color.WHITE);
		lblRecieved.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRecieved.setBounds(405, 113, 82, 20);
		panel_4.add(lblRecieved);

		dueTextField = new JTextField();
		dueTextField.setText(Double.toString(0));
		dueTextField.setEditable(false);
		dueTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		dueTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		dueTextField.setColumns(10);
		dueTextField.setBackground(Color.WHITE);
		dueTextField.setBounds(522, 148, 66, 22);
		panel_4.add(dueTextField);

		JLabel lblBalance = new JLabel("Due");
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBalance.setBounds(405, 148, 82, 20);
		panel_4.add(lblBalance);

		JLabel lblSalesTax = new JLabel("Sales Tax(14%)");
		lblSalesTax.setForeground(Color.WHITE);
		lblSalesTax.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalesTax.setBounds(148, 16, 132, 20);
		panel_4.add(lblSalesTax);

		taxTextField = new JTextField();
		// taxTextField.setText(Double.toString(0));
		taxTextField.setEditable(false);
		taxTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		taxTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		taxTextField.setColumns(10);
		taxTextField.setBackground(Color.WHITE);
		taxTextField.setBounds(302, 16, 82, 22);
		panel_4.add(taxTextField);

		final JRadioButton cashRadioButton = new JRadioButton("");
		cashRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cashRadioButton.isSelected()) {
					cashTextField.setText(Double.toString(0));
					creditRadioButton.setSelected(false);

				} else {
					cashTextField.setEditable(false);
				}
			}
		});
		cashRadioButton.setSelected(true);
		cashRadioButton.setBackground(new Color(51, 153, 255));
		cashRadioButton.setBounds(210, 66, 21, 25);
		panel_4.add(cashRadioButton);

		creditRadioButton = new JRadioButton("");
		creditRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creditRadioButton.setSelected(true);

				cashRadioButton.setSelected(false);
				cashTextField.setText(Double.toString(0));
				cashTextField.setEditable(false);
				warning.setText(null);

			}
		});
		creditRadioButton.setBackground(new Color(51, 153, 255));
		creditRadioButton.setBounds(210, 102, 21, 25);
		panel_4.add(creditRadioButton);

		JLabel lblCash = new JLabel("Cash");
		lblCash.setForeground(Color.WHITE);
		lblCash.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCash.setBounds(148, 66, 82, 20);
		panel_4.add(lblCash);

		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setForeground(Color.WHITE);
		lblCredit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCredit.setBounds(148, 102, 82, 20);
		panel_4.add(lblCredit);

		previewButton = new JButton("Preview");
		previewButton.setVisible(false);
		previewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		previewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int click = 0;

				click++;

				if (click == 1) {
					receiptTextArea.setText("   ..MMONTSHENG'S RESTAURENT..");
					receiptTextArea
							.append("\n       230 Jorrisen Street\n\t   Braamfontein\n\t   Johannesburg\n\t       2000");
					receiptTextArea.append("\n\tTel: 011 774 2312");
					receiptTextArea.append("\n\t     " + year + "/" + month
							+ "/" + day);

					printReceipt();
					click--;
				}

				print();
			}
		});
		previewButton.setBounds(10, 142, 100, 30);
		panel_4.add(previewButton);

		cashTextField = new JTextField();
		cashTextField.setEditable(false);
		cashTextField.setText(Double.toString(0));
		cashTextField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {

			}
		});
		cashTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				// checks if input is a number
				if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
					// beeps a sound if input is not a number
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();
				}
			}
		});
		cashTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		cashTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		cashTextField.setColumns(10);
		cashTextField.setBackground(Color.WHITE);
		cashTextField.setBounds(302, 66, 82, 22);
		panel_4.add(cashTextField);

		JLabel lblR = new JLabel("R");
		lblR.setForeground(Color.WHITE);
		lblR.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblR.setBounds(281, 66, 21, 20);
		panel_4.add(lblR);

		JLabel label_3 = new JLabel("R");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(281, 16, 21, 20);
		panel_4.add(label_3);

		JLabel label_8 = new JLabel("R");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_8.setBounds(505, 113, 21, 20);
		panel_4.add(label_8);

		JLabel label_9 = new JLabel("R");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_9.setBounds(505, 148, 21, 20);
		panel_4.add(label_9);

		printRecButton = 
				new JButton("Print");
		printRecButton.setEnabled(false);
		printRecButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				totalCost();
				double total=Double.parseDouble(grandTotalTextField.getText())-Double.parseDouble(ReceivedTextField.getText());
				if (price.size() > 0 && desc.size() > 0) {

					if(total>0){
						Toolkit.getDefaultToolkit().beep();
						warning.setForeground(Color.RED);
						warning.setText("!!!!!!!!");

						dineInLabel.setText(null);

						try {
							String query = "insert into Serve (Waiter,Table_No, No_of_People, Meal_Time, Description,Total,Total_Items,Total_Tax,Reference_No,Time,Date,Status,Due) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
							pst = connection.prepareStatement(query);

							// supposed to set name of the waiter
							pst.setString(1, LoggedtextField.getText());
							

							// sets the table number
							pst.setInt(2,
									(tableComboBox.getSelectedIndex() + 1));

							// sets number of people
							pst.setInt(3,
									(NoOfPeoplecomboBox.getSelectedIndex() + 1));

							// sets meal time
							pst.setString(4,
									(String) mealTimeComboBox.getSelectedItem());

							// supposed to set all the food purchased as a
							// string
							if (desc.size() > 1) {
								
								String description = "";
								for(int i=0; i<desc.size(); i++){
								  description += desc.get(i)+" : R" + ""+ Double.toString(price.get(i))+ ", ";
								}
								pst.setString(5, description);
							} else {
								pst.setString(5,desc.get(0) + " : R"+ Double.toString(price.get(0)));
							}

							// sets total cost of transaction
							pst.setString(6,
									"R" + grandTotalTextField.getText());

							// sets number of items purchased
							// desc is an arrayList type, it contains the number
							// of items purchased
							pst.setInt(7, desc.size());

							// sets tax value for the transaction
							pst.setDouble(8,
									Double.parseDouble(taxTextField.getText()));

							// sets reference number for the transaction
							// a date and time of transaction are both used to
							// reference number
							pst.setString(9, "" + year + month + day + hours
									+ minutes + second);

							// sets time of transaction
							pst.setString(10, "" + hours + ":" + minutes + ":"
									+ second);

							// sets date of transaction
							pst.setString(11, "" + year + "/" + month + "/"
									+ day);

							// sets status of transaction, not paid in this case
							pst.setString(12, "Not paid");

							// sets the amount due for the transaction
							pst.setDouble(13,
									Double.parseDouble(dueTextField.getText()));

							// executes the query
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						dineInLabel.setText(null);
						try {
							String query = "insert into Serve (Waiter,Table_No, No_of_People, Meal_Time, Description,Total,Total_Items,Total_Tax,Reference_No,Time,Date,Status,Due) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
							pst = connection.prepareStatement(query);

							// supposed to set name of the waiter
							pst.setString(1, LoggedtextField.getText());

							// sets the table number
							pst.setInt(2,
									(tableComboBox.getSelectedIndex() + 1));

							// sets number of people
							pst.setInt(3,
									(NoOfPeoplecomboBox.getSelectedIndex() + 1));

							// sets meal time
							pst.setString(4,
									(String) mealTimeComboBox.getSelectedItem());

							// supposed to set all the food purchased as a
							// string
							if (desc.size() > 1) {
								
								String description = "";
								for(int i=0; i<desc.size(); i++){
								  description += desc.get(i)+" : R" + ""+ Double.toString(price.get(i))+ ", ";
								}
								pst.setString(5, description);
							} else {
								pst.setString(
										5,
										desc.get(0) + " : R"
												+ Double.toString(price.get(0)));
							}

							// sets number of items purchased
							pst.setString(6,
									"R" + grandTotalTextField.getText());

							// sets number of items purchased
							// desc is an arrayList type, it contains the number
							// of items purchased
							pst.setInt(7, desc.size());

							// sets tax value for the transaction
							pst.setDouble(8,
									Double.parseDouble(taxTextField.getText()));

							// sets reference number for the transaction
							// a date and time of transaction are both used to
							// reference number
							pst.setString(9, "" + year + month + day + hours
									+ minutes + second);

							// sets time of transaction
							pst.setString(10, "" + hours + ":" + minutes + ":"
									+ second);

							// sets date of transaction
							pst.setString(11, "" + year + "/" + month + "/"
									+ day);

							// sets status of transaction, paid in this case
							pst.setString(12, "Paid");

							// sets the amount due for the transaction
							pst.setDouble(13,0.0);

							// executes the query
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					receiptTextArea.append("\nTotal : R"
							+ grandTotalTextField.getText());
					receiptTextArea.append("\nTax : R" + taxTextField.getText());
					receiptTextArea.append("\nCash received : R"
							+ ReceivedTextField.getText());
					receiptTextArea.append("\nChange : R"
							+ changeTextField.getText());
					receiptTextArea.append("\nWaiter : "+LoggedtextField.getText());
					receiptTextArea.append("\nQuantity : " + desc.size());
					receiptTextArea.append("\nReference No : " + year + month
							+ day + hours + minutes + second);
					receiptTextArea.append("\nTime :" + hours + ":" + minutes
							+ ":" + second);
					taxTextField.setText(Double.toString(0.0));
					dueTextField.setText(Double.toString(0.0));
					changeTextField.setText(Double.toString(0.0));
					ReceivedTextField.setText(Double.toString(0.0));
					dueTextField.setText(Double.toString(0.0));
					totalTextField.setText(Double.toString(0.0));
					grandTotalTextField.setText(Double.toString(0.0));
					cashTextField.setText(Double.toString(0));
					// taxTextField.setText(null);

					desc.clear();
					price.clear();

				} else if (Double.parseDouble(dueTextField.getText()) > 0
						&& price.size() == 0 && desc.size() == 0) {
					double cash= Double.parseDouble(cashTextField.getText());
					double due= Double.parseDouble(dueTextField.getText());
					double answer= cash-due;

					String status = "Paid";
					

					try {
						String query = "Update serve set Status='" + status+ " ' ,Due= '" +answer + " '  where Reference_No='"+ refTextField.getText() + "' ";
						pst = connection.prepareStatement(query);
						pst.execute();

						// close the DB
						pst.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				else {
					Toolkit.getDefaultToolkit().beep();
					dineInLabel.setText("Perform trans first");
					dineInLabel.setBackground(Color.RED);
				}

			}

		});
		Image printerImg = new ImageIcon(this.getClass().getResource(
				"/printer.png")).getImage();
		printRecButton.setIcon(new ImageIcon(printerImg));
		printRecButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		printRecButton.setBounds(10, 75, 100, 30);
		panel_4.add(printRecButton);

		dineInLabel = new JLabel("");
		dineInLabel.setForeground(Color.RED);
		dineInLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		dineInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dineInLabel.setBounds(10, 114, 128, 14);
		panel_4.add(dineInLabel);

		JLabel label = new JLabel("R");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(505, 47, 21, 20);
		panel_4.add(label);

		JLabel label_4 = new JLabel("R");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(505, 16, 21, 20);
		panel_4.add(label_4);

		changeTextField = new JTextField();
		changeTextField.setText(Double.toString(0));
		changeTextField.setHorizontalAlignment(SwingConstants.TRAILING);
		changeTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		changeTextField.setEditable(false);
		changeTextField.setColumns(10);
		changeTextField.setBackground(Color.WHITE);
		changeTextField.setBounds(522, 179, 66, 22);
		panel_4.add(changeTextField);

		JLabel label_5 = new JLabel("R");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(505, 179, 21, 20);
		panel_4.add(label_5);

		JLabel lblChange = new JLabel("Change");
		lblChange.setForeground(Color.WHITE);
		lblChange.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChange.setBounds(405, 179, 82, 20);
		panel_4.add(lblChange);

		warning = new JLabel("");
		warning.setFont(new Font("Tahoma", Font.BOLD, 14));
		warning.setHorizontalAlignment(SwingConstants.CENTER);
		warning.setBounds(302, 90, 82, 18);
		panel_4.add(warning);

		refTextField = new JTextField();
		refTextField.setVisible(false);
		refTextField.setEnabled(false);
		refTextField.setEditable(false);
		refTextField.setBounds(142, 161, 200, 22);
		panel_4.add(refTextField);
		refTextField.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel_5.setBackground(new Color(153, 204, 255));
		panel_5.setBounds(603, 5, 319, 576);
		dinePanel.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblMainCourse = new JLabel("MAIN COURSE");
		lblMainCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMainCourse.setBounds(79, 11, 160, 19);
		panel_5.add(lblMainCourse);

		statersButton = new JButton("");
		statersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Starters where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Staters : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));
					}
				});

				try {
					String query = "select * from Starters";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Image statersImg = new ImageIcon(this.getClass().getResource(
				"/starters.png")).getImage();
		statersButton.setIcon(new ImageIcon(statersImg));
		statersButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		statersButton.setBounds(41, 41, 88, 63);
		panel_5.add(statersButton);

		soupButton = new JButton("");
		soupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Soup where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Soup : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));
					}
				});
				try {
					String query = "select * from Soup";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		Image soupImg = new ImageIcon(this.getClass().getResource("/Soup.png"))
				.getImage();
		soupButton.setIcon(new ImageIcon(soupImg));
		soupButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		soupButton.setBounds(188, 41, 88, 63);
		panel_5.add(soupButton);

		saladsButton = new JButton("");
		saladsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Salads where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Salad : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));
					}
				});

				try {
					String query = "select * from Salads";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Image saldsImg = new ImageIcon(this.getClass()
				.getResource("/Salad.png")).getImage();
		saladsButton.setIcon(new ImageIcon(saldsImg));
		saladsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		saladsButton.setBounds(41, 135, 88, 63);
		panel_5.add(saladsButton);

		JButton vegeterianButton = new JButton("");
		vegeterianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Vegetarian where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Veg : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));

					}
				});

				try {
					String query = "select * from Vegetarian";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		Image vegetarianImg = new ImageIcon(this.getClass().getResource(
				"/vegetables.png")).getImage();
		vegeterianButton.setIcon(new ImageIcon(vegetarianImg));
		vegeterianButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		vegeterianButton.setBounds(188, 135, 88, 63);
		panel_5.add(vegeterianButton);

		JButton beefButton = new JButton("");
		Image beefImg = new ImageIcon(this.getClass().getResource("/beef.png"))
				.getImage();
		beefButton.setIcon(new ImageIcon(beefImg));
		beefButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Beef where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Beef : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));
					}
				});

				try {
					String query = "select * from Beef";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		beefButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		beefButton.setBounds(188, 365, 88, 63);
		panel_5.add(beefButton);

		JButton pizzaButton = new JButton("");
		pizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Pizza where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Pizza : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));
					}
				});

				try {
					String query = "select * from Pizza";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		pizzaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image pizzaImg = new ImageIcon(this.getClass()
				.getResource("/Pizza.png")).getImage();
		pizzaButton.setIcon(new ImageIcon(pizzaImg));
		pizzaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		pizzaButton.setBounds(41, 365, 88, 63);
		panel_5.add(pizzaButton);

		chickenButton = new JButton("");
		chickenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Chicken where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Chicken : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));
					}
				});

				try {
					String query = "select * from Chicken";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Image chickenImg = new ImageIcon(this.getClass().getResource(
				"/Chicken.png")).getImage();
		chickenButton.setIcon(new ImageIcon(chickenImg));
		chickenButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		chickenButton.setBounds(41, 245, 88, 63);
		panel_5.add(chickenButton);

		ItalianButton = new JButton("");
		ItalianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Italian where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Italian : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));

					}
				});

				try {
					String query = "select * from Italian";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Image ItalianImg = new ImageIcon(this.getClass().getResource(
				"/noodles.png")).getImage();
		ItalianButton.setIcon(new ImageIcon(ItalianImg));
		ItalianButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ItalianButton.setBounds(188, 245, 88, 63);
		panel_5.add(ItalianButton);

		JButton kidsMealButton = new JButton("");
		kidsMealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Kids where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Kids : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));
					}
				});

				try {
					String query = "select * from Kids";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		Image kidsImg = new ImageIcon(this.getClass().getResource("/kids.png"))
				.getImage();
		kidsMealButton.setIcon(new ImageIcon(kidsImg));
		kidsMealButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		kidsMealButton.setBounds(41, 470, 88, 65);
		panel_5.add(kidsMealButton);

		JButton bbqButton = new JButton("");
		bbqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from BBQ where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "BBQ : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));
					}
				});

				try {
					String query = "select * from BBQ";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Image bbqImg = new ImageIcon(this.getClass().getResource("/grill.png"))
				.getImage();
		bbqButton.setIcon(new ImageIcon(bbqImg));
		bbqButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		bbqButton.setBounds(188, 470, 88, 63);
		panel_5.add(bbqButton);

		JLabel lblStaters = new JLabel("Staters");
		lblStaters.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStaters.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaters.setBounds(51, 110, 67, 14);
		panel_5.add(lblStaters);

		JLabel lblSoups = new JLabel("Soups");
		lblSoups.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoups.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoups.setBounds(208, 110, 46, 14);
		panel_5.add(lblSoups);

		JLabel lblSalads = new JLabel("Salads");
		lblSalads.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalads.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalads.setBounds(61, 202, 46, 14);
		panel_5.add(lblSalads);

		JLabel lblDeli = new JLabel("Vegeterian");
		lblDeli.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeli.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDeli.setBounds(188, 209, 88, 14);
		panel_5.add(lblDeli);

		JLabel lblChicken = new JLabel("Chicken");
		lblChicken.setHorizontalAlignment(SwingConstants.CENTER);
		lblChicken.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChicken.setBounds(56, 315, 57, 14);
		panel_5.add(lblChicken);

		JLabel lblItalian = new JLabel("Italian");
		lblItalian.setHorizontalAlignment(SwingConstants.CENTER);
		lblItalian.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblItalian.setBounds(203, 315, 57, 14);
		panel_5.add(lblItalian);

		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizza.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPizza.setBounds(56, 433, 57, 14);
		panel_5.add(lblPizza);

		JLabel lblBeef = new JLabel("Beef");
		lblBeef.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeef.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBeef.setBounds(198, 433, 57, 14);
		panel_5.add(lblBeef);

		JLabel lblKidsMeal = new JLabel("Kids Meal");
		lblKidsMeal.setHorizontalAlignment(SwingConstants.CENTER);
		lblKidsMeal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKidsMeal.setBounds(46, 540, 78, 14);
		panel_5.add(lblKidsMeal);

		JLabel lblBbqAndGrill = new JLabel("BBQ & Grill");
		lblBbqAndGrill.setHorizontalAlignment(SwingConstants.CENTER);
		lblBbqAndGrill.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBbqAndGrill.setBounds(188, 540, 88, 14);
		panel_5.add(lblBbqAndGrill);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel_7.setBackground(new Color(153, 204, 255));
		panel_7.setBounds(255, 5, 170, 195);
		dinePanel.add(panel_7);
		panel_7.setLayout(null);

		JLabel lblDrinks = new JLabel("DRINKS");
		lblDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrinks.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDrinks.setBounds(52, 11, 61, 19);
		panel_7.add(lblDrinks);

		btnCold = new JButton("");
		btnCold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//
				
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from ColdDrink where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);

							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "ColdDrink : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);

							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));

					}
				});

				//

				try {
					String query = "select * from ColdDrink";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Image coldImg = new ImageIcon(this.getClass().getResource("/beer.png"))
				.getImage();
		btnCold.setIcon(new ImageIcon(coldImg));
		btnCold.setBounds(42, 28, 89, 66);
		panel_7.add(btnCold);

		btnHot = new JButton("");
		btnHot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from HotDrink where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Hot Drink : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));
					}
				});

				try {
					String query = "select * from HotDrink";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnHot.setHorizontalAlignment(SwingConstants.LEFT);
		btnHot.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image hotImg = new ImageIcon(this.getClass().getResource("/coffee.png"))
				.getImage();
		btnHot.setIcon(new ImageIcon(hotImg));

		btnHot.setBounds(42, 110, 89, 66);
		panel_7.add(btnHot);

		JLabel lblCold = new JLabel("Cold");
		lblCold.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCold.setBounds(73, 93, 46, 14);
		panel_7.add(lblCold);

		JLabel lblHot = new JLabel("Hot");
		lblHot.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHot.setBounds(75, 175, 46, 14);
		panel_7.add(lblHot);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel_8.setBackground(new Color(153, 204, 255));
		panel_8.setBounds(429, 5, 170, 195);
		dinePanel.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblDessert = new JLabel("DESSERT");
		lblDessert.setHorizontalAlignment(SwingConstants.CENTER);
		lblDessert.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDessert.setBounds(41, 11, 89, 19);
		panel_8.add(lblDessert);

		btnBaked = new JButton("");
		btnBaked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Baked where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Desssert : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));

					}
				});

				try {
					String query = "select * from Baked";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		btnBaked.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image bakedImg = new ImageIcon(this.getClass()
				.getResource("/piece.png")).getImage();
		btnBaked.setIcon(new ImageIcon(bakedImg));
		btnBaked.setBounds(41, 28, 89, 66);
		panel_8.add(btnBaked);

		JButton btnIceCream = new JButton("");
		btnIceCream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						double Rate = 0.0;
						try {
							int row = menuTable.getSelectedRow();
							String productID_ = (menuTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from IceCream where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								String Descrip = "Dessert : "
										+ rs.getString("Description");
								Rate = rs.getDouble("Rate_R");
								toTable(Rate, Descrip);
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						previewButton.doClick();
						// refreshes the receipt screen after every click
						previewButton.doClick();
						totalTextField.setText(String.format("%.2f", Rate
								+ Double.parseDouble(totalTextField.getText())));

					}
				});

				try {
					String query = "select * from IceCream";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					menuTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnIceCream.setFont(new Font("Tahoma", Font.BOLD, 12));
		Image IcecreamImg = new ImageIcon(this.getClass().getResource(
				"/Ice.png")).getImage();
		btnIceCream.setIcon(new ImageIcon(IcecreamImg));
		btnIceCream.setBounds(41, 110, 89, 66);
		panel_8.add(btnIceCream);

		JLabel lblBaked = new JLabel("Baked");
		lblBaked.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBaked.setBounds(64, 93, 46, 14);
		panel_8.add(lblBaked);

		JLabel lblIceCream = new JLabel("Ice Cream");
		lblIceCream.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIceCream.setBounds(51, 175, 79, 14);
		panel_8.add(lblIceCream);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel_9.setBackground(new Color(153, 204, 255));
		panel_9.setBounds(4, 204, 595, 160);
		dinePanel.add(panel_9);
		panel_9.setLayout(null);

		JScrollPane drinkScrollPane = new JScrollPane();
		drinkScrollPane.setBounds(0, 0, 595, 160);
		panel_9.add(drinkScrollPane);

		menuTable = new JTable();
		drinkScrollPane.setViewportView(menuTable);
		menuTable.setDefaultEditor(Object.class, null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(250, 250, 210));
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_6.setBounds(927, 0, 255, 251);
		mainPanel.add(panel_6);

		JLabel lblReceipt = new JLabel("RECEIPT");
		lblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceipt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReceipt.setBounds(84, 11, 84, 14);
		panel_6.add(lblReceipt);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 235, 209);
		panel_6.add(scrollPane);

		receiptTextArea = new JTextArea();
		receiptTextArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		receiptTextArea.setLineWrap(true);
		receiptTextArea.setForeground(Color.BLACK);
		receiptTextArea.setEditable(false);
		receiptTextArea.setBackground(Color.WHITE);
		scrollPane.setViewportView(receiptTextArea);

		reservationPanel = new JPanel();
		reservationPanel.setBorder(new LineBorder(new Color(165, 42, 42), 4));
		reservationPanel.setBackground(new Color(153, 204, 255));
		reservationPanel.setBounds(0, 0, 926, 585);
		reservationPanel.setVisible(false);
		mainPanel.add(reservationPanel);
		reservationPanel.setLayout(null);

		JLabel lblBook = new JLabel("BOOK");
		lblBook.setForeground(Color.WHITE);
		lblBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblBook.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblBook.setBounds(404, 11, 91, 27);
		reservationPanel.add(lblBook);

		JLabel lblCheckBookings = new JLabel("CHECK BOOKINGS");
		lblCheckBookings.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckBookings.setForeground(Color.WHITE);
		lblCheckBookings.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblCheckBookings.setBounds(404, 367, 239, 27);
		reservationPanel.add(lblCheckBookings);

		JButton btnSubmit = new JButton("Submit");
		Image img = new ImageIcon(this.getClass().getResource("/ok.png"))
				.getImage();
		btnSubmit.setIcon(new ImageIcon(img));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((reservationInitialsTextField.getText().length() > 0)
						&& (reservationSurnameTextField.getText().length() > 0)
						&& (reservationContaNoTextField.getText().length() > 0)
						&& (reservationNoOfPeopleTextField.getText().length() > 0)) {

					try {

						String query = "insert into Reserv (Initials,Surname,Contact_No,No_Of_Guests,Date,Arrival_Time,Departure_Time,Occasion,Captured_By,Reference_No) values (?,?,?,?,?,?,?,?,?,?)";
						pst = connection.prepareStatement(query);
						pst.setString(1, reservationInitialsTextField.getText()
								.toUpperCase());
						pst.setString(2, reservationSurnameTextField.getText());
						pst.setString(3, reservationContaNoTextField.getText());
						pst.setInt(4, Integer
								.parseInt(reservationNoOfPeopleTextField
										.getText()));
						// gets date from the jdate component
						pst.setString(5, ((JTextField) reservationJdate.getDateEditor().getUiComponent()).getText());
						pst.setString(6, arrival.getTimeField().getText());
						pst.setString(7, depart.getTimeField().getText());
						pst.setString(8, (String) ocassionComboBox.getSelectedItem());
						pst.setString(9, LoggedtextField.getText());
						pst.setString(10, "" + year + month + day + hours+ minutes + second);

						pst.execute();
						pst.clearParameters();
						// display a success message below the save button
						bookings.setForeground(Color.WHITE);
						bookings.setText(null);
						bookings.setText("Reserv Submitted");

						// clears the text fields after a successful save
						reservationInitialsTextField.setText(null);
						reservationSurnameTextField.setText(null);
						reservationContaNoTextField.setText(null);
						reservationNoOfPeopleTextField.setText(null);
						((JTextField) reservationJdate.getDateEditor()
								.getUiComponent()).setText(null);

						// close the DB
						pst.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
					refreshBooking();
				} else {
					Toolkit.getDefaultToolkit().beep();
					bookings.setForeground(Color.RED);
					bookings.setText("Data not saved, empty fields");
				}

			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(292, 323, 110, 30);
		reservationPanel.add(btnSubmit);

		JButton btnRetrieveBookings = new JButton("Retrieve");
		btnRetrieveBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookings.setText(null);
				try {
					String query = "select * from Reserv";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					bookingsTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		btnRetrieveBookings.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRetrieveBookings.setBounds(10, 418, 89, 30);
		reservationPanel.add(btnRetrieveBookings);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((reservationInitialsTextField.getText().length() > 0)
						&& (reservationSurnameTextField.getText().length() > 0)
						&& (reservationContaNoTextField.getText().length() > 0)
						&& (reservationNoOfPeopleTextField.getText().length() > 0)) {
					try {
						String query = "Update Reserv set Initials='"+ reservationInitialsTextField.getText()+ " ' ,Surname= '"+ reservationSurnameTextField.getText()+ " ', Contact_No= '"+ reservationContaNoTextField.getText()+ "', No_Of_Guests= '"+ Integer.parseInt(reservationNoOfPeopleTextField.getText())+ "',Date='"+ ((JTextField) reservationJdate.getDateEditor().getUiComponent()).getText()+ "',Arrival_Time= '"+ arrival.getTimeField().getText()+ "',Departure_Time= '"+ depart.getTimeField().getText()+ "',Occasion= '"+ (String)ocassionComboBox.getSelectedItem()+ "',Captured_By= '"+ LoggedtextField.getText()+ "' where Reference_No='"+ referenceReserveTextField.getText() + "'";
						pst = connection.prepareStatement(query);
						pst.execute();
						
						// display a success message below the submit button
						bookings.setForeground(Color.WHITE);
						bookings.setText("Data updated");

						// clears the text fields after a successful save
						reservationInitialsTextField.setText(null);
						reservationSurnameTextField.setText(null);
						reservationContaNoTextField.setText(null);
						reservationNoOfPeopleTextField.setText(null);
						((JTextField) reservationJdate.getDateEditor()
								.getUiComponent()).setText(null);

						// close the DB
						pst.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					// display an error message below the submit button
					Toolkit.getDefaultToolkit().beep();
					bookings.setForeground(Color.RED);
					bookings.setText("Data not updated, select data to update from table");

				}
				refreshBooking();

			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(10, 474, 89, 30);
		reservationPanel.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((reservationInitialsTextField.getText().length() > 0)
						&& (reservationSurnameTextField.getText().length() > 0)
						&& (reservationContaNoTextField.getText().length() > 0)
						&& (reservationNoOfPeopleTextField.getText().length() > 0)) {
					try {
						String query = "delete from Reserv where Reference_No='"
								+ referenceReserveTextField.getText() + "' ";
						pst = connection.prepareStatement(query);
						pst.execute();

						// display a success message below the save button
						bookings.setForeground(Color.WHITE);
						bookings.setText("Data deleted");

						// clears the text fields after a successful delete
						reservationInitialsTextField.setText(null);
						reservationSurnameTextField.setText(null);
						reservationNoOfPeopleTextField.setText(null);
						reservationContaNoTextField.setText(null);
						((JTextField) reservationJdate.getDateEditor()
								.getUiComponent()).setText(null);

						// close the DB
						pst.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					Toolkit.getDefaultToolkit().beep();
					bookings.setText("No data deleted, select data to delete from table");
					bookings.setForeground(Color.RED);
				}
				refreshBooking();
			}

		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(10, 531, 89, 30);
		reservationPanel.add(btnDelete);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(109, 405, 807, 169);
		reservationPanel.add(scrollPane_1);

		bookingsTable = new JTable();
		bookingsTable.setDefaultEditor(Object.class, null);
		bookingsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = bookingsTable.getSelectedRow();
					String contact_No_ = (bookingsTable.getModel().getValueAt(
							row, 2)).toString();

					String query = "select * from Reserv where Contact_no= '"
							+ contact_No_ + "' ";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();

					while (rs.next()) {
						String date = rs.getString("Date");
						
						reservationInitialsTextField.setText(rs
								.getString("Initials"));
						reservationSurnameTextField.setText(rs
								.getString("Surname"));
						reservationContaNoTextField.setText((rs
								.getString("Contact_No")));
						reservationNoOfPeopleTextField.setText(Long.toString(rs
								.getLong("No_Of_Guests")));
						arrival.getTimeField().setText((rs.getString("Arrival_Time")));
						depart.getTimeField().setText((rs.getString("Departure_Time")));
						ocassionComboBox.setSelectedItem("Occasion");
						((JTextField) reservationJdate.getDateEditor().getUiComponent()).setText(date);
						referenceReserveTextField.setText(rs.getString("Reference_No"));

					}

					// close the DB
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		scrollPane_1.setViewportView(bookingsTable);

		ocassionComboBox = new JComboBox();
		ocassionComboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		ocassionComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Party", "Special Dinner", "Bussiness Meetings" }));
		ocassionComboBox.setBounds(245, 280, 157, 22);
		reservationPanel.add(ocassionComboBox);

		bookings = new JLabel("");
		bookings.setFont(new Font("Tahoma", Font.BOLD, 13));
		bookings.setBounds(48, 367, 460, 22);
		reservationPanel.add(bookings);

		reservationJdate = new JDateChooser();
		reservationJdate.setDateFormatString("yyyy-MM-dd");
		reservationJdate.setBounds(296, 180, 106, 22);
		// jdate
		reservationPanel.add(reservationJdate);

		reservPanelCalendar = new JCalendar();
		reservPanelCalendar.getDayChooser().setWeekdayForeground(
				new Color(0, 0, 0));
		reservPanelCalendar.getDayChooser().setBackground(new Color(0, 0, 0));
		reservPanelCalendar.getDayChooser().getDayPanel()
				.setForeground(new Color(153, 204, 255));
		reservPanelCalendar.getDayChooser().setForeground(Color.BLACK);
		reservPanelCalendar.setBounds(515, 60, 275, 224);
		reservationPanel.add(reservPanelCalendar);

		JLabel initialsLbl = new JLabel("Initials");
		initialsLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		initialsLbl.setForeground(new Color(0, 0, 0));
		initialsLbl.setBounds(150, 44, 62, 22);
		reservationPanel.add(initialsLbl);

		JLabel surnameLbl = new JLabel("Surname");
		surnameLbl.setForeground(new Color(0, 0, 0));
		surnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		surnameLbl.setBounds(150, 77, 80, 22);
		reservationPanel.add(surnameLbl);

		JLabel contactNoLbl = new JLabel("Contact No");
		contactNoLbl.setForeground(new Color(0, 0, 0));
		contactNoLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		contactNoLbl.setBounds(150, 114, 86, 22);
		reservationPanel.add(contactNoLbl);

		JLabel noOfPeopleLbl = new JLabel("No of People");
		noOfPeopleLbl.setForeground(new Color(0, 0, 0));
		noOfPeopleLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		noOfPeopleLbl.setBounds(150, 147, 96, 22);
		reservationPanel.add(noOfPeopleLbl);

		JLabel DdateLbl = new JLabel("Date ");
		DdateLbl.setForeground(new Color(0, 0, 0));
		DdateLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		DdateLbl.setBounds(150, 180, 46, 22);
		reservationPanel.add(DdateLbl);

		JLabel arrivalTimeLbl = new JLabel("Arrival Time");
		arrivalTimeLbl.setForeground(new Color(0, 0, 0));
		arrivalTimeLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		arrivalTimeLbl.setBounds(150, 213, 96, 22);
		reservationPanel.add(arrivalTimeLbl);

		JLabel leavingTimeLbl = new JLabel("Leaving Time");
		leavingTimeLbl.setForeground(new Color(0, 0, 0));
		leavingTimeLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		leavingTimeLbl.setBounds(150, 246, 96, 22);
		reservationPanel.add(leavingTimeLbl);

		JLabel ocassionLbl = new JLabel("Ocassion");
		ocassionLbl.setForeground(new Color(0, 0, 0));
		ocassionLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		ocassionLbl.setBounds(150, 280, 96, 22);
		reservationPanel.add(ocassionLbl);

		arrival = new JTimeChooser();
		arrival.setBounds(347, 213, 54, 20);
		reservationPanel.add(arrival);

		depart = new JTimeChooser();
		depart = new JTimeChooser();
		depart.setBounds(347, 246, 54, 20);
		reservationPanel.add(depart);

		reservationInitialsTextField = new JTextField();
		reservationInitialsTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();
				}
			}
		});
		reservationInitialsTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		reservationInitialsTextField.setBounds(367, 44, 35, 22);
		reservationPanel.add(reservationInitialsTextField);
		reservationInitialsTextField.setColumns(10);

		reservationSurnameTextField = new JTextField();
		reservationSurnameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();
				}
			}
		});
		reservationSurnameTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		reservationSurnameTextField.setBounds(264, 77, 138, 22);
		reservationPanel.add(reservationSurnameTextField);
		reservationSurnameTextField.setColumns(10);

		reservationContaNoTextField = new JTextField();
		reservationContaNoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();

				if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();

				}
			}
		});
		reservationContaNoTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		reservationContaNoTextField.setBounds(296, 114, 106, 22);
		reservationPanel.add(reservationContaNoTextField);
		reservationContaNoTextField.setColumns(10);

		reservationNoOfPeopleTextField = new JTextField();
		reservationNoOfPeopleTextField
				.setFont(new Font("Tahoma", Font.BOLD, 14));
		reservationNoOfPeopleTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();

				if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();

				}
			}
		});
		reservationNoOfPeopleTextField.setBounds(375, 147, 27, 22);
		reservationPanel.add(reservationNoOfPeopleTextField);
		reservationNoOfPeopleTextField.setColumns(10);

		clearResButton = new JButton("Clear");
		Image clearImg = new ImageIcon(this.getClass().getResource(
				"/clear1.png")).getImage();
		clearResButton.setIcon(new ImageIcon(clearImg));
		clearResButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookings.setText(null);
				arrival.getTimeField().setText(
						Integer.toString(hours) + Integer.toString(minutes)
								+ Integer.toString(second));
				depart.getTimeField().setText(
						Integer.toString(hours) + Integer.toString(minutes)
								+ Integer.toString(second));
				reservationContaNoTextField.setText(null);
				reservationInitialsTextField.setText(null);
				reservationSurnameTextField.setText(null);
				reservationNoOfPeopleTextField.setText(null);
				((JTextField) reservationJdate.getDateEditor().getUiComponent())
						.setText(null);

			}
		});
		clearResButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearResButton.setBounds(160, 323, 110, 32);
		reservationPanel.add(clearResButton);
		
		referenceReserveTextField = new JTextField();
		// leave it as invisible
		referenceReserveTextField.setVisible(false);
		referenceReserveTextField.setEditable(false);
		referenceReserveTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		referenceReserveTextField.setColumns(10);
		referenceReserveTextField.setBounds(264, 11, 138, 22);
		reservationPanel.add(referenceReserveTextField);
		// jTime.get

		checkTablepanel = new JPanel();
		checkTablepanel.setBorder(new LineBorder(new Color(165, 42, 42), 4));
		checkTablepanel.setBackground(new Color(153, 204, 255));
		checkTablepanel.setBounds(0, 0, 926, 585);
		checkTablepanel.setVisible(false);
		mainPanel.add(checkTablepanel);
		checkTablepanel.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(238, 61, 621, 250);
		checkTablepanel.add(scrollPane_2);

		checkTabelsTable = new JTable();
		checkTabelsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					int row = checkTabelsTable.getSelectedRow();
					String ref = (checkTabelsTable.getModel()
							.getValueAt(row, 8)).toString();

					String query = "select * from Serve where Reference_No= '"
							+ ref + "' ";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();

					while (rs.next()) {
						refTextField.setText(rs.getString("Reference_No"));
						reservDescriptionTextArea.setText("Waiter :"+rs.getString("Waiter"));
						reservDescriptionTextArea.append("\nItems\n"
								+ rs.getString("Description"));
						reservDescriptionTextArea.append("\nTotal tax: R"
								+ Double.toString(rs.getDouble("Total_Tax")));
						reservDescriptionTextArea.append("\nTotal Items: "
								+ Integer.toString(rs.getInt("Total_Items")));
						reservDescriptionTextArea.append("\nTotal Cost: "
								+ rs.getString("Total"));

						reservDescriptionTextArea.append("\n\nReference No: "
								+ rs.getString("Reference_No"));
						reservDescriptionTextArea.append("\nTime: "
								+ (rs.getString("Time")));
						reservDescriptionTextArea.append("\nDate: "
								+ (rs.getString("Date")));

						if (rs.getDouble("Due") > 0) {
							cashTextField.setEditable(true);
							cashTextField.setEnabled(true);
							dueTextField.setText(Double.toString(rs
									.getDouble("Due")));
						}
					}

					// close the DB
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		checkTabelsTable.setDefaultEditor(Object.class, null);
		scrollPane_2.setViewportView(checkTabelsTable);

		JLabel lblCheckTables = new JLabel("CHECK TABLES");
		lblCheckTables.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckTables.setForeground(Color.WHITE);
		lblCheckTables.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCheckTables.setBounds(431, 11, 181, 39);
		checkTablepanel.add(lblCheckTables);

		searchTextField = new JTextField();
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String query = "select * from Serve where Reference_No=?";
					pst = connection.prepareStatement(query);
					pst.setString(1, searchTextField.getText());
					rs = pst.executeQuery();

					checkTabelsTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();

					char c = arg0.getKeyChar();
					if ((c == KeyEvent.VK_BACK_SPACE)) {

						try {
							String queryr = "select * from Serve";
							pst = connection.prepareStatement(queryr);
							rs = pst.executeQuery();
							checkTabelsTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		searchTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchTextField.setColumns(10);
		searchTextField.setBackground(Color.WHITE);
		searchTextField.setBounds(10, 61, 187, 22);
		checkTablepanel.add(searchTextField);

		JLabel lblSearchByReceipt = new JLabel("Search by reference No");
		lblSearchByReceipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchByReceipt.setForeground(Color.BLACK);
		lblSearchByReceipt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearchByReceipt.setBackground(new Color(153, 204, 255));
		lblSearchByReceipt.setBounds(10, 80, 187, 20);
		checkTablepanel.add(lblSearchByReceipt);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(238, 345, 621, 176);
		checkTablepanel.add(scrollPane_4);

		reservDescriptionTextArea = new JTextArea();
		reservDescriptionTextArea.setEditable(false);
		reservDescriptionTextArea
				.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane_4.setViewportView(reservDescriptionTextArea);

		clearSearchButton = new JButton("Clear");
		Image clear = new ImageIcon(this.getClass().getResource("/clear1.png"))
				.getImage();
		clearSearchButton.setIcon(new ImageIcon(clear));
		clearSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchTextField.setText(null);

				try {
					String query = "select * from Serve";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					checkTabelsTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		clearSearchButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearSearchButton.setBounds(61, 111, 110, 32);
		checkTablepanel.add(clearSearchButton);

		JLabel lblR_1 = new JLabel("R");
		lblR_1.setForeground(Color.WHITE);
		lblR_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblR_1.setBounds(99, 181, 18, 20);
		checkTablepanel.add(lblR_1);

		editSalesPanel = new JPanel();
		editSalesPanel.setBorder(new LineBorder(new Color(165, 42, 42), 4));
		editSalesPanel.setBackground(new Color(153, 204, 255));
		editSalesPanel.setBounds(0, 0, 926, 585);
		mainPanel.add(editSalesPanel);
		editSalesPanel.setLayout(null);

		JLabel lblProduvtId = new JLabel("Product ID");
		lblProduvtId.setForeground(Color.WHITE);
		lblProduvtId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProduvtId.setBounds(20, 294, 90, 20);
		editSalesPanel.add(lblProduvtId);

		JLabel lblDrinks_1 = new JLabel("Drinks");
		lblDrinks_1.setForeground(Color.BLACK);
		lblDrinks_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDrinks_1.setBounds(85, 200, 50, 20);
		editSalesPanel.add(lblDrinks_1);

		JLabel lblDessert_1 = new JLabel("Dessert");
		lblDessert_1.setForeground(Color.BLACK);
		lblDessert_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDessert_1.setBounds(85, 231, 66, 20);
		editSalesPanel.add(lblDessert_1);

		drinkRadioButton = new JRadioButton("");
		drinkRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (drinkRadioButton.isSelected()) {
					drinksComboBox.setEnabled(true);
					dessertRadioButton.setSelected(false);
					mainCoRadioButton.setSelected(false);
					dessertComboBox.setEnabled(false);
					mainCoComboBox.setEnabled(false);
				} else {
					drinksComboBox.setEnabled(false);
				}
			}
		});

		drinkRadioButton.setVisible(false);
		drinkRadioButton.setBackground(new Color(153, 204, 255));
		drinkRadioButton.setBounds(188, 200, 21, 25);
		editSalesPanel.add(drinkRadioButton);

		dessertRadioButton = new JRadioButton("");
		dessertRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dessertRadioButton.isSelected()) {
					dessertComboBox.setEnabled(true);
					drinksComboBox.setEnabled(false);
					mainCoComboBox.setEnabled(false);
					drinkRadioButton.setSelected(false);
					mainCoRadioButton.setSelected(false);
				} else {
					dessertComboBox.setEnabled(false);
				}
			}
		});
		dessertRadioButton.setVisible(false);
		dessertRadioButton.setBackground(new Color(153, 204, 255));
		dessertRadioButton.setBounds(188, 231, 21, 25);
		editSalesPanel.add(dessertRadioButton);

		mainCoRadioButton = new JRadioButton("");
		mainCoRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (mainCoRadioButton.isSelected()) {

					drinkRadioButton.setSelected(false);
					dessertRadioButton.setSelected(false);

					drinksComboBox.setEnabled(false);
					dessertComboBox.setEnabled(false);
					mainCoComboBox.setEnabled(true);
				} else {
					mainCoComboBox.setEnabled(false);
				}
			}
		});
		mainCoRadioButton.setVisible(false);
		mainCoRadioButton.setBackground(new Color(153, 204, 255));
		mainCoRadioButton.setBounds(188, 262, 21, 25);
		editSalesPanel.add(mainCoRadioButton);

		JLabel lblMainCourse_1 = new JLabel("Main Course");
		lblMainCourse_1.setForeground(Color.BLACK);
		lblMainCourse_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMainCourse_1.setBounds(85, 262, 92, 20);
		editSalesPanel.add(lblMainCourse_1);

		rateTextField = new JTextField();
		rateTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();

				if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();

				}
			}
		});
		rateTextField.setVisible(false);
		rateTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		rateTextField.setColumns(10);
		rateTextField.setBackground(Color.WHITE);
		rateTextField.setBounds(290, 352, 92, 22);
		editSalesPanel.add(rateTextField);

		JLabel label_14 = new JLabel("R");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_14.setBounds(265, 352, 21, 20);
		editSalesPanel.add(label_14);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescription.setBounds(20, 325, 90, 20);
		editSalesPanel.add(lblDescription);

		JLabel lblRate = new JLabel("Rate");
		lblRate.setForeground(Color.WHITE);
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRate.setBounds(20, 352, 50, 20);
		editSalesPanel.add(lblRate);

		productIDTextField = new JTextField();
		productIDTextField.setVisible(false);
		productIDTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		productIDTextField.setColumns(10);
		productIDTextField.setBackground(Color.WHITE);
		productIDTextField.setBounds(213, 294, 169, 22);
		editSalesPanel.add(productIDTextField);

		descriptionTextField = new JTextField();
		descriptionTextField.setVisible(false);
		descriptionTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		descriptionTextField.setColumns(10);
		descriptionTextField.setBackground(Color.WHITE);
		descriptionTextField.setBounds(213, 323, 169, 22);
		editSalesPanel.add(descriptionTextField);

		JLabel lblTable_1 = new JLabel("Table : ");
		lblTable_1.setForeground(Color.WHITE);
		lblTable_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTable_1.setBounds(20, 200, 58, 20);
		editSalesPanel.add(lblTable_1);

		drinksComboBox = new JComboBox();
		drinksComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (updateSalesRdbtn.isSelected()
						|| deleteSalesRdbtn.isSelected()) {

					if ((drinkRadioButton.isSelected())
							&& (drinksComboBox.getSelectedIndex() + 1 == 2)) {
						try {
							String query = "select * from ColdDrink";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if ((drinkRadioButton.isSelected())
							&& (drinksComboBox.getSelectedIndex() + 1 == 3)) {
						try {
							String query = "select * from HotDrink";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				}

			}
		});
		drinksComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		drinksComboBox.setEnabled(true);
		drinksComboBox.setVisible(false);
		drinksComboBox.setModel(new DefaultComboBoxModel(new String[] { "",
				"Cold Drink", "Hot Drink" }));
		drinksComboBox.setBounds(290, 200, 92, 22);
		editSalesPanel.add(drinksComboBox);

		dessertComboBox = new JComboBox();
		dessertComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (updateSalesRdbtn.isSelected()
						|| deleteSalesRdbtn.isSelected()) {

					if ((dessertRadioButton.isSelected())
							&& (dessertComboBox.getSelectedIndex() + 1 == 2)) {
						try {
							String query = "select * from Baked";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					if ((dessertRadioButton.isSelected())
							&& (dessertComboBox.getSelectedIndex() + 1 == 3)) {
						try {
							String query = "select * from IceCream";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				}

			}
		});
		dessertComboBox.setEnabled(false);
		dessertComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		dessertComboBox.setVisible(false);
		dessertComboBox.setModel(new DefaultComboBoxModel(new String[] { "",
				"Baked", "Ice Cream" }));
		dessertComboBox.setBounds(290, 231, 92, 22);
		editSalesPanel.add(dessertComboBox);

		mainCoComboBox = new JComboBox();
		mainCoComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (updateSalesRdbtn.isSelected()
						|| deleteSalesRdbtn.isSelected()) {

					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 2)) {
						try {
							String query = "select * from Starters";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 3)) {
						try {
							String query = "select * from Soup";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 4)) {
						try {
							String query = "select * from Salads";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 5)) {
						try {
							String query = "select * from Vegetarian";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 6)) {
						try {
							String query = "select * from Chicken";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 7)) {
						try {
							String query = "select * from Italian";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 8)) {
						try {
							String query = "select * from Pizza";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 9)) {
						try {
							String query = "select * from Beef";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 10)) {
						try {
							String query = "select * from Kids";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 11)) {
						try {
							String query = "select * from BBQ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();
							editTable.setModel(DbUtils
									.resultSetToTableModel(rs));

							// close the DB
							pst.close();
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				}

			}
		});
		mainCoComboBox.setEnabled(false);
		mainCoComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		mainCoComboBox.setModel(new DefaultComboBoxModel(new String[] { "",
				"Starters", "Soups", "Salads", "Vegetarian", "Chicken",
				"Italian", "Pizza", "Beef", "Kids Meal", "BBQ & Grill" }));
		mainCoComboBox.setVisible(false);
		mainCoComboBox.setBounds(265, 262, 117, 22);
		editSalesPanel.add(mainCoComboBox);

		saveSalesButton = new JButton("Save");
		saveSalesButton.setVisible(false);
		saveSalesButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// ADD BGIN
				// checks if the edit fields are empty, data will be saved if
				// fields are not empty, else an error message will be displayed
				if (addSalesRdbtn.isSelected()
						&& productIDTextField.getText().length() > 0
						&& descriptionTextField.getText().length() > 0
						&& rateTextField.getText().length() > 0) {

					// if drink radio button=true and cold drink is selected
					if ((drinkRadioButton.isSelected())
							&& (drinksComboBox.getSelectedIndex() + 1 == 2)) {

						try {
							String query = "insert into ColdDrink (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					// if drink radio button=true and hot drink is selected
					if ((drinkRadioButton.isSelected())
							&& (drinksComboBox.getSelectedIndex() + 1 == 3)) {

						try {
							String query = "insert into HotDrink (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if dessert radio button=true and baked drink is selected
					if ((dessertRadioButton.isSelected())
							&& (dessertComboBox.getSelectedIndex() + 1 == 2)) {

						try {
							String query = "insert into Baked (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if dessert radio button=true and ice cream is selected
					if ((dessertRadioButton.isSelected())
							&& (dessertComboBox.getSelectedIndex() + 1 == 3)) {

						try {
							String query = "insert into IceCream (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and starters is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 2)) {

						try {
							String query = "insert into Starters (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and soup is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 3)) {

						try {
							String query = "insert into Soup (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and salads is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 4)) {

						try {
							String query = "insert into Salads (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and vegetarian is
					// selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 5)) {

						try {
							String query = "insert into Vegetarian (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and chicken is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 6)) {

						try {
							String query = "insert into Chicken (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and Italian is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 7)) {

						try {
							String query = "insert into Italian (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and pizza is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 8)) {

						try {
							String query = "insert into Pizza (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and beef is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 9)) {

						try {
							String query = "insert into Beef (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and kids meal is
					// selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 10)) {

						try {
							String query = "insert into Kids (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and pizza is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 11)) {

						try {
							String query = "insert into BBQ (ProductID,Description,Rate_R) values (?,?,?)";
							pst = connection.prepareStatement(query);
							pst.setString(1, productIDTextField.getText());
							pst.setString(2, descriptionTextField.getText());
							// converts from string to double
							pst.setDouble(3,
									Double.parseDouble(rateTextField.getText()));
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					savedLabel.setForeground(Color.WHITE);
					savedLabel.setText("Data saved");

					productIDTextField.setText(null);
					descriptionTextField.setText(null);
					rateTextField.setText(null);

				} else if (addSalesRdbtn.isSelected()
						&& productIDTextField.getText().length() == 0
						&& descriptionTextField.getText().length() == 0
						&& rateTextField.getText().length() == 0) {
					Toolkit.getDefaultToolkit().beep();
					savedLabel.setForeground(Color.RED);
					savedLabel.setText("Data not saved, empty fields");
				}
				// ADD END

				// UPDATE BEGIN
				if ((updateSalesRdbtn.isSelected())
						&& (productIDTextField.getText().length() > 0)
						&& (descriptionTextField.getText().length() > 0)
						&& (rateTextField.getText().length() > 0)) {

					// if drink radio button=true and cold drink is selected
					if ((drinkRadioButton.isSelected())
							&& (drinksComboBox.getSelectedIndex() + 1 == 2)) {
						try {
							String query = "Update ColdDrink set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();

						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					// if drink radio button=true and hot drink is selected
					if ((drinkRadioButton.isSelected())
							&& (drinksComboBox.getSelectedIndex() + 1 == 3)) {

						try {
							String query = "Update HotDrink set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if dessert radio button=true and baked is selected
					if ((dessertRadioButton.isSelected())
							&& (dessertComboBox.getSelectedIndex() + 1 == 2)) {

						try {
							String query = "Update Baked set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if dessert radio button=true and ice cream drink is
					// selected
					if ((dessertRadioButton.isSelected())
							&& (dessertComboBox.getSelectedIndex() + 1 == 3)) {

						try {
							String query = "Update IceCream set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and starters is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 2)) {

						try {
							String query = "Update Starters set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and soup is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 3)) {

						try {
							String query = "Update Soup set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and salads is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 4)) {

						try {
							String query = "Update Salads set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and vegetarian is
					// selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 5)) {

						try {
							String query = "Update Vegetarian set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and chicken is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 6)) {

						try {
							String query = "Update Chicken set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and Italian is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 7)) {

						try {
							String query = "Update Italian set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and pizza is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 8)) {

						try {
							String query = "Update Pizza set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and beef is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 9)) {

						try {
							String query = "Update Beef set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and kids meal is
					// selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 10)) {

						try {
							String query = "Update Kids set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					// if main course radio button=true and BBQ is selected
					if ((mainCoRadioButton.isSelected())
							&& (mainCoComboBox.getSelectedIndex() + 1 == 11)) {

						try {
							String query = "Update BBQ set ProductID='"
									+ productIDTextField.getText()
									+ " ' ,Description= '"
									+ descriptionTextField.getText()
									+ " ', Rate_R= '"
									+ Double.parseDouble(rateTextField
											.getText()) + "' where ProductID='"
									+ productIDTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// close the DB
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					// display a success message below the save button
					savedLabel.setForeground(Color.WHITE);
					savedLabel.setText("Data updated");

					// clears the text fields after a successful save
					productIDTextField.setText(null);
					descriptionTextField.setText(null);
					rateTextField.setText(null);

				}
				// else if condition for updating
				else if (updateSalesRdbtn.isSelected()
						&& (productIDTextField.getText().length() == 0)
						&& (descriptionTextField.getText().length() == 0)
						&& (rateTextField.getText().length() == 0)) {
					Toolkit.getDefaultToolkit().beep();
					savedLabel.setForeground(Color.RED);
					savedLabel.setText("Data not updated, empty fields");
				}
				// end update

				// delete start

				if (deleteSalesRdbtn.isSelected()
						&& productIDTextField.getText().length() > 0) {

					int action = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to delete the item?",
							"Delete", JOptionPane.YES_NO_OPTION);
					if (action == 0) {
						if (drinkRadioButton.isSelected()
								&& drinksComboBox.getSelectedIndex() + 1 == 2) {
							try {
								String query = "delete from ColdDrink where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

						if (drinkRadioButton.isSelected()
								&& drinksComboBox.getSelectedIndex() + 1 == 3) {
							try {
								String query = "delete from HotDrink where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

						if (dessertRadioButton.isSelected()
								&& dessertComboBox.getSelectedIndex() + 1 == 2) {
							try {
								String query = "delete from Baked where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

						if (dessertRadioButton.isSelected()
								&& dessertComboBox.getSelectedIndex() + 1 == 3) {
							try {
								String query = "delete from IceCream where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 2) {
							try {
								String query = "delete from Starters where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 3) {
							try {
								String query = "delete from Soup where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 4) {
							try {
								String query = "delete from Salads where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 5) {
							try {
								String query = "delete from Vegetarian where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 6) {
							try {
								String query = "delete from Chicken where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 7) {
							try {
								String query = "delete from Italian where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 8) {
							try {
								String query = "delete from Pizza where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 9) {
							try {
								String query = "delete from Beef where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 10) {
							try {
								String query = "delete from Kids where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						if (mainCoRadioButton.isSelected()
								&& mainCoComboBox.getSelectedIndex() + 1 == 11) {
							try {
								String query = "delete from BBQ where ProductID='"
										+ productIDTextField.getText() + "' ";
								pst = connection.prepareStatement(query);
								pst.execute();

								// close the DB
								pst.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}

						// display a success message below the save button
						savedLabel.setForeground(Color.WHITE);
						savedLabel.setText("Data deleted");

						// clears the text fields after a successful delete
						productIDTextField.setText(null);
						descriptionTextField.setText(null);
						rateTextField.setText(null);
					}
				}

				// else if condition for deleting
				else if (deleteSalesRdbtn.isSelected()
						&& (productIDTextField.getText().length() == 0)) {
					Toolkit.getDefaultToolkit().beep();
					savedLabel.setForeground(Color.RED);
					savedLabel
							.setText("Data not deleted, select data to be deleted");

				}
				refreshTable();

			}
		});
		saveSalesButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		saveSalesButton.setIcon(new ImageIcon(img2));
		saveSalesButton.setBounds(246, 387, 136, 30);
		editSalesPanel.add(saveSalesButton);

		savedLabel = new JLabel("");
		savedLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		savedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		savedLabel.setBounds(20, 429, 362, 20);
		editSalesPanel.add(savedLabel);

		JScrollPane EditscrollPane = new JScrollPane();
		EditscrollPane.setBounds(392, 93, 524, 356);
		editSalesPanel.add(EditscrollPane);

		editTable = new JTable();
		editTable.setDefaultEditor(Object.class, null);
		editTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if ((updateSalesRdbtn.isSelected())
						|| deleteSalesRdbtn.isSelected()) {
					if ((drinkRadioButton.isSelected())
							&& ((drinksComboBox.getSelectedIndex() + 1) == 2)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from ColdDrink where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if ((drinkRadioButton.isSelected())
							&& ((drinksComboBox.getSelectedIndex() + 1) == 3)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from HotDrink where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((dessertRadioButton.isSelected())
							&& ((dessertComboBox.getSelectedIndex() + 1) == 2)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Baked where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if ((dessertRadioButton.isSelected())
							&& ((dessertComboBox.getSelectedIndex() + 1) == 3)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from IceCream where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 2)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Starters where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 3)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Soup where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 4)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Salads where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 5)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Vegetarian where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 6)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Chicken where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 7)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Italian where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 8)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Pizza where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 9)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Beef where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 10)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Kids where ProductID= '"
									+ productID_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if ((mainCoRadioButton.isSelected())
							&& ((mainCoComboBox.getSelectedIndex() + 1) == 11)) {
						try {
							int row = editTable.getSelectedRow();
							String productID_ = (editTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from BBQ where ProductID= '"
									+ productID_ + "'  ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteSalesRdbtn.isSelected()) {
									productIDTextField.setText(rs
											.getString("productID"));
								} else {
									productIDTextField.setText(rs
											.getString("productID"));
									descriptionTextField.setText(rs
											.getString("Description"));
									rateTextField.setText(rs
											.getString("Rate_R"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}

			}
		});
		EditscrollPane.setViewportView(editTable);

		addSalesRdbtn = new JRadioButton("Add");
		addSalesRdbtn.setVisible(false);
		addSalesRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveSalesButton.setText("Save");
				if (addSalesRdbtn.isSelected()) {
					saveSalesButton.setEnabled(true);
				} else {
					saveSalesButton.setText(null);
					saveSalesButton.setEnabled(false);
				}

				savedLabel.setText(null);
				productIDTextField.setEditable(true);
				descriptionTextField.setEnabled(true);
				rateTextField.setEnabled(true);

				updateSalesRdbtn.setSelected(false);
				deleteSalesRdbtn.setSelected(false);
				int co = 0;
				co++;
				if (co == 1) {
					productIDTextField.setText(null);
					descriptionTextField.setText(null);
					rateTextField.setText(null);
				}

			}
		});
		addSalesRdbtn.setSelected(true);
		addSalesRdbtn.setBackground(new Color(153, 204, 255));
		addSalesRdbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		addSalesRdbtn.setBounds(116, 132, 66, 37);
		editSalesPanel.add(addSalesRdbtn);

		updateSalesRdbtn = new JRadioButton("Update");
		updateSalesRdbtn.setVisible(false);
		updateSalesRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveSalesButton.setText("Update");
				if (updateSalesRdbtn.isSelected()) {
					saveSalesButton.setEnabled(true);
				} else {
					saveSalesButton.setText(null);
					saveSalesButton.setEnabled(false);
				}

				savedLabel.setText(null);
				productIDTextField.setEditable(true);
				descriptionTextField.setEnabled(true);
				rateTextField.setEnabled(true);

				addSalesRdbtn.setSelected(false);
				deleteSalesRdbtn.setSelected(false);
				int co = 0;
				co++;
				if (co == 1) {
					productIDTextField.setText(null);
					descriptionTextField.setText(null);
					rateTextField.setText(null);
				}

			}
		});
		updateSalesRdbtn.setBackground(new Color(153, 204, 255));
		updateSalesRdbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateSalesRdbtn.setBounds(188, 132, 85, 37);
		editSalesPanel.add(updateSalesRdbtn);

		deleteSalesRdbtn = new JRadioButton("Delete");
		deleteSalesRdbtn.setVisible(false);
		deleteSalesRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveSalesButton.setText("Delete");
				if (deleteSalesRdbtn.isSelected()) {
					saveSalesButton.setEnabled(true);
				} else {
					saveSalesButton.setText(null);
					saveSalesButton.setEnabled(false);
				}

				savedLabel.setText(null);
				productIDTextField.setEditable(false);
				descriptionTextField.setEnabled(false);
				rateTextField.setEnabled(false);

				addSalesRdbtn.setSelected(false);
				updateSalesRdbtn.setSelected(false);
				int co = 0;
				co++;
				if (co == 1) {
					productIDTextField.setText(null);
					descriptionTextField.setText(null);
					rateTextField.setText(null);
				}

			}
		});
		deleteSalesRdbtn.setBackground(new Color(153, 204, 255));
		deleteSalesRdbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		deleteSalesRdbtn.setBounds(290, 132, 92, 36);
		editSalesPanel.add(deleteSalesRdbtn);

		JLabel lblOperation = new JLabel("Operation");
		lblOperation.setForeground(Color.WHITE);
		lblOperation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOperation.setBounds(10, 130, 100, 35);
		editSalesPanel.add(lblOperation);

		JPanel dropDownMenuPnel = new JPanel();
		dropDownMenuPnel.setBackground(new Color(250, 250, 210));
		dropDownMenuPnel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		dropDownMenuPnel.setBounds(10, 11, 157, 717);
		frame.getContentPane().add(dropDownMenuPnel);
		dropDownMenuPnel.setLayout(null);

		dineInbutton = new JButton("");
		Image dineInimg = new ImageIcon(this.getClass().getResource(
				"/dineIn.png")).getImage();
		dineInbutton.setIcon(new ImageIcon(dineInimg));
		dineInbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// items in edit sales
				productIDTextField.setVisible(false);
				descriptionTextField.setVisible(false);
				rateTextField.setVisible(false);
				drinksComboBox.setVisible(false);
				dessertComboBox.setVisible(false);
				mainCoComboBox.setVisible(false);

				editSalesPanel.setVisible(false);
				checkTablepanel.setVisible(false);
				reservationPanel.setVisible(false);
				addEmployeespanel.setVisible(false);
				dinePanel.setVisible(true);
				saveSalesButton.setVisible(false);
			}
		});
		dineInbutton.setForeground(new Color(255, 255, 255));
		dineInbutton.setBackground(new Color(0, 0, 0));
		dineInbutton.setBounds(45, 132, 59, 48);
		dropDownMenuPnel.add(dineInbutton);

		JLabel label_1 = new JLabel("Dine In");
		label_1.setForeground(new Color(46, 139, 87));
		label_1.setBackground(new Color(0, 128, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(45, 182, 58, 15);
		dropDownMenuPnel.add(label_1);
		new ImageIcon(this.getClass().getResource("/delivery.png")).getImage();

		JButton checkTableButton = new JButton("");
		Image checkTableImg = new ImageIcon(this.getClass().getResource(
				"/table.png")).getImage();
		checkTableButton.setIcon(new ImageIcon(checkTableImg));
		checkTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// items in edit sales
				productIDTextField.setVisible(false);
				descriptionTextField.setVisible(false);
				rateTextField.setVisible(false);
				// items in edit sales
				drinksComboBox.setVisible(false);
				dessertComboBox.setVisible(false);
				mainCoComboBox.setVisible(false);

				dinePanel.setVisible(false);
				editSalesPanel.setVisible(false);
				reservationPanel.setVisible(false);
				checkTablepanel.setVisible(true);
				addEmployeespanel.setVisible(false);
				saveSalesButton.setVisible(false);

				try {
					String query = "select * from Serve";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					checkTabelsTable.setModel(DbUtils.resultSetToTableModel(rs));

					// close the DB
					pst.close();
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		checkTableButton.setBackground(new Color(255, 255, 255));
		checkTableButton.setBounds(45, 240, 59, 60);
		dropDownMenuPnel.add(checkTableButton);

		JLabel lblCheckTable = new JLabel("Check Tables");
		lblCheckTable.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCheckTable.setForeground(new Color(255, 0, 0));
		lblCheckTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckTable.setBounds(20, 301, 110, 15);
		dropDownMenuPnel.add(lblCheckTable);

		reservationButton = new JButton("");
		Image orderListImg = new ImageIcon(this.getClass().getResource(
				"/checklist.png")).getImage();
		reservationButton.setIcon(new ImageIcon(orderListImg));
		reservationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// to set the current to the time fields in resevervation panel
				arrival.getTimeField().setText(
						Integer.toString(hours) + Integer.toString(minutes)
								+ Integer.toString(second));
				depart.getTimeField().setText(
						Integer.toString(hours) + Integer.toString(minutes)
								+ Integer.toString(second));

				// items in edit sales
				productIDTextField.setVisible(false);
				descriptionTextField.setVisible(false);
				rateTextField.setVisible(false);
				// items in edit sales
				drinksComboBox.setVisible(false);
				dessertComboBox.setVisible(false);
				mainCoComboBox.setVisible(false);
				drinkRadioButton.setVisible(false);
				dessertRadioButton.setVisible(false);
				mainCoRadioButton.setVisible(false);

				dinePanel.setVisible(false);
				editSalesPanel.setVisible(false);
				checkTablepanel.setVisible(false);
				reservationPanel.setVisible(true);
				addEmployeespanel.setVisible(false);
				saveSalesButton.setVisible(false);

			}
		});
		reservationButton.setBackground(new Color(255, 255, 255));
		reservationButton.setBounds(46, 363, 59, 55);
		dropDownMenuPnel.add(reservationButton);

		JLabel lblOrderList = new JLabel("Reservations");
		lblOrderList.setForeground(new Color(139, 69, 19));
		lblOrderList.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOrderList.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderList.setBounds(20, 419, 110, 15);
		dropDownMenuPnel.add(lblOrderList);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_3.setBounds(20, 29, 110, 57);
		dropDownMenuPnel.add(panel_3);
		panel_3.setLayout(null);

		JLabel label_2 = new JLabel("MENU");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Segoe Script", Font.BOLD, 22));
		label_2.setBounds(10, 11, 90, 38);
		panel_3.add(label_2);

		editSalesButton = new JButton("");
		Image eidtListImg = new ImageIcon(this.getClass().getResource(
				"/edit.png")).getImage();
		editSalesButton.setIcon(new ImageIcon(eidtListImg));
		editSalesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				editSalesClearButton.setEnabled(true);
				saveSalesButton.setVisible(true);
				productIDTextField.setVisible(true);
				descriptionTextField.setVisible(true);
				rateTextField.setVisible(true);

				drinksComboBox.setVisible(true);
				dessertComboBox.setVisible(true);
				mainCoComboBox.setVisible(true);

				drinkRadioButton.setVisible(true);
				dessertRadioButton.setVisible(true);
				mainCoRadioButton.setVisible(true);

				dinePanel.setVisible(false);
				checkTablepanel.setVisible(false);
				reservationPanel.setVisible(false);
				addEmployeespanel.setVisible(false);
				editSalesPanel.setVisible(true);

				addSalesRdbtn.setVisible(true);
				updateSalesRdbtn.setVisible(true);
				deleteSalesRdbtn.setVisible(true);
			}
		});
		editSalesButton.setBackground(Color.WHITE);
		editSalesButton.setBounds(46, 485, 59, 55);
		dropDownMenuPnel.add(editSalesButton);

		JLabel lblEditSales = new JLabel("Edit Sales &\r\n Costs");
		lblEditSales.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditSales.setForeground(new Color(0, 0, 139));
		lblEditSales.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEditSales.setBounds(0, 541, 146, 15);
		dropDownMenuPnel.add(lblEditSales);

		AddOrDeleteEmpbutton = new JButton("");
		Image user = new ImageIcon(this.getClass().getResource("/user.png"))
				.getImage();
		AddOrDeleteEmpbutton.setIcon(new ImageIcon(user));
		AddOrDeleteEmpbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEmployeespanel.setVisible(true);
				// items in edit sales
				productIDTextField.setVisible(false);
				descriptionTextField.setVisible(false);
				rateTextField.setVisible(false);
				// items in edit sales
				drinksComboBox.setVisible(false);
				dessertComboBox.setVisible(false);
				mainCoComboBox.setVisible(false);

				dinePanel.setVisible(false);
				editSalesPanel.setVisible(false);
				reservationPanel.setVisible(false);
				checkTablepanel.setVisible(false);
				saveSalesButton.setVisible(false);

			}
		});
		AddOrDeleteEmpbutton.setBackground(Color.WHITE);
		AddOrDeleteEmpbutton.setBounds(46, 615, 59, 59);
		dropDownMenuPnel.add(AddOrDeleteEmpbutton);

		JLabel lblEditEmplyees = new JLabel("Add Users");
		lblEditEmplyees.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditEmplyees.setForeground(new Color(50, 205, 50));
		lblEditEmplyees.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEditEmplyees.setBounds(9, 676, 126, 15);
		dropDownMenuPnel.add(lblEditEmplyees);

		addEmployeespanel = new JPanel();
		addEmployeespanel.setBorder(new LineBorder(new Color(165, 42, 42), 4));
		addEmployeespanel.setVisible(false);
		addEmployeespanel.setBackground(new Color(153, 204, 255));
		addEmployeespanel.setBounds(0, 0, 926, 585);
		mainPanel.add(addEmployeespanel);
		addEmployeespanel.setLayout(null);

		JLabel lblAddAndEdit = new JLabel("ADD & EDIT USERS");
		lblAddAndEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAndEdit.setForeground(Color.WHITE);
		lblAddAndEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddAndEdit.setBounds(315, 11, 260, 38);
		addEmployeespanel.add(lblAddAndEdit);

		addUserRdbtn = new JRadioButton("Add User");
		addUserRdbtn.setSelected(true);
		addUserRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (addUserRdbtn.isSelected()) {

					addEmButton.setEnabled(true);
					addEmButton.setText("Add User");
					updateUserRdbtn.setSelected(false);
					deleteUserRdbtn.setSelected(false);

					// enables the fields
					addEmNamesTextField.setEditable(true);
					addEmUserNameTextField.setEditable(true);
					addEmUserPasswordTextField.setEditable(true);
					addEmUserPhoneNumbertextField.setEditable(true);
					addEmUserEmailtextField.setEditable(true);

					// clears the textFields as users toogles between radio
					// buttons
					addEmNamesTextField.setText(null);
					addEmUserNameTextField.setText(null);
					addEmUserPasswordTextField.setText(null);
					addEmUserPhoneNumbertextField.setText(null);
					addEmUserEmailtextField.setText(null);
				} else {
					addEmButton.setEnabled(false);
					addEmButton.setText(null);
					// disables the fields
					addEmNamesTextField.setEditable(false);
					addEmUserNameTextField.setEditable(false);
					addEmUserPasswordTextField.setEditable(false);
					addEmUserPhoneNumbertextField.setEditable(false);
					addEmUserEmailtextField.setEditable(false);
				}
			}
		});
		addUserRdbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		addUserRdbtn.setBackground(new Color(153, 204, 255));
		addUserRdbtn.setBounds(6, 71, 109, 23);
		addEmployeespanel.add(addUserRdbtn);

		updateUserRdbtn = new JRadioButton("Update User");
		updateUserRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (updateUserRdbtn.isSelected()) {

					addEmButton.setEnabled(true);
					addEmButton.setText("Update User");
					addUserRdbtn.setSelected(false);
					deleteUserRdbtn.setSelected(false);

					// clears the textFields as users toogles between radio
					// buttons
					addEmNamesTextField.setText(null);
					addEmUserNameTextField.setText(null);
					addEmUserPasswordTextField.setText(null);
					addEmUserPhoneNumbertextField.setText(null);
					addEmUserEmailtextField.setText(null);

					// enables the fields
					addEmNamesTextField.setEditable(true);
					addEmUserNameTextField.setEditable(true);
					addEmUserPasswordTextField.setEditable(true);
					addEmUserPhoneNumbertextField.setEditable(true);
					addEmUserEmailtextField.setEditable(true);
				} else {
					addEmButton.setEnabled(false);
					addEmButton.setText(null);
					// dasables the fields
					addEmNamesTextField.setEditable(false);
					addEmUserNameTextField.setEditable(false);
					addEmUserPasswordTextField.setEditable(false);
					addEmUserPhoneNumbertextField.setEditable(false);
					addEmUserEmailtextField.setEditable(false);
				}
			}
		});
		updateUserRdbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		updateUserRdbtn.setBackground(new Color(153, 204, 255));
		updateUserRdbtn.setBounds(117, 71, 132, 23);
		addEmployeespanel.add(updateUserRdbtn);

		deleteUserRdbtn = new JRadioButton("Delete User");
		deleteUserRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (deleteUserRdbtn.isSelected()) {

					addEmButton.setEnabled(true);
					addEmButton.setText("Delete User");
					updateUserRdbtn.setSelected(false);
					addUserRdbtn.setSelected(false);

					// dasables the fields
					addEmNamesTextField.setEditable(false);
					addEmUserNameTextField.setEditable(false);
					addEmUserPasswordTextField.setEditable(false);
					addEmUserPhoneNumbertextField.setEditable(false);
					addEmUserEmailtextField.setEditable(false);

					// clears the textFields as users toogles between radio
					// buttons
					addEmNamesTextField.setText(null);
					addEmUserNameTextField.setText(null);
					addEmUserPasswordTextField.setText(null);
					addEmUserPhoneNumbertextField.setText(null);
					addEmUserEmailtextField.setText(null);
				} else {
					addEmButton.setEnabled(false);
					addEmButton.setText(null);

					// enables the fields
					addEmNamesTextField.setEditable(true);
					addEmUserNameTextField.setEditable(true);
					addEmUserPasswordTextField.setEditable(true);
					addEmUserPhoneNumbertextField.setEditable(true);
					addEmUserEmailtextField.setEditable(true);
				}
			}
		});
		deleteUserRdbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		deleteUserRdbtn.setBackground(new Color(153, 204, 255));
		deleteUserRdbtn.setBounds(251, 71, 121, 23);
		addEmployeespanel.add(deleteUserRdbtn);

		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(Color.BLACK);
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRole.setBounds(23, 108, 46, 22);
		addEmployeespanel.add(lblRole);

		roleComboBox = new JComboBox();
		roleComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if ((roleComboBox.getSelectedIndex() + 1 == 1)) {
					try {
						String query = "select * from Employee";
						pst = connection.prepareStatement(query);
						rs = pst.executeQuery();
						userInfoTable.setModel(DbUtils
								.resultSetToTableModel(rs));

						// close the DB
						pst.close();
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				if ((roleComboBox.getSelectedIndex() + 1 == 2)) {
					try {
						String query = "select * from Manager where Username=?";
						pst = connection.prepareStatement(query);
						pst.setString(1, LoggedtextField.getText());
						rs = pst.executeQuery();

						userInfoTable.setModel(DbUtils.resultSetToTableModel(rs));

						// close the DB
						pst.close();


					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		});
		roleComboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		roleComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Employee", "Manager" }));
		roleComboBox.setBounds(219, 108, 100, 22);
		addEmployeespanel.add(roleComboBox);

		addEmButton = new JButton("Add User");
		Image addIm = new ImageIcon(this.getClass().getResource("/ok.png"))
				.getImage();
		addEmButton.setIcon(new ImageIcon(addIm));
		addEmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// ADD BGIN
				// checks if the edit fields are empty, data will be saved if
				// fields are not empty, else an error message will be displayed
				// if employee comboBox is selected
				if (addUserRdbtn.isSelected()
						&& addEmNamesTextField.getText().length() > 0
						&& addEmUserNameTextField.getText().length() > 0
						&& addEmUserPasswordTextField.getText().length() > 0
						&& addEmUserPhoneNumbertextField.getText().length() > 0
						&& addEmUserEmailtextField.getText().length() > 0
						&& (roleComboBox.getSelectedIndex() + 1 == 1)) {

					try {
						String query = "insert into Employee (Names, Username,Password,Phone_Number,Email_Address) values (?,?,?,?,?)";
						pst = connection.prepareStatement(query);
						pst.setString(1, addEmNamesTextField.getText());
						pst.setString(2, addEmUserNameTextField.getText());
						pst.setString(3, addEmUserPasswordTextField.getText());
						pst.setString(4,
								addEmUserPhoneNumbertextField.getText());
						pst.setString(5, addEmUserEmailtextField.getText());
						pst.execute();

						// display a success message below the save button
						errorMessageLable.setText("Employee Added");
						errorMessageLable.setForeground(Color.WHITE);

						// close the DB
						pst.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
					refreshUserInfoTable();
				}

				// checks if the edit fields are empty, data will be saved if
				// fields are not empty, else an error message will be displayed
				// if employee comboBox is selected
				if (addUserRdbtn.isSelected()
						&& addEmNamesTextField.getText().length() > 0
						&& addEmUserNameTextField.getText().length() > 0
						&& addEmUserPasswordTextField.getText().length() > 0
						&& addEmUserPhoneNumbertextField.getText().length() > 0
						&& addEmUserEmailtextField.getText().length() > 0
						&& (roleComboBox.getSelectedIndex() + 1 == 2)) {

					try {
						String query = "insert into Manager (Names, Username,Password,Phone_Number,Email_Address) values (?,?,?,?,?)";
						pst = connection.prepareStatement(query);
						pst.setString(1, addEmNamesTextField.getText());
						pst.setString(2, addEmUserNameTextField.getText());
						pst.setString(3, addEmUserPasswordTextField.getText());
						pst.setString(4,
								addEmUserPhoneNumbertextField.getText());
						pst.setString(5, addEmUserEmailtextField.getText());
						pst.execute();

						// display a success message below the save button
						errorMessageLable.setText("Manager Added");
						errorMessageLable.setForeground(Color.WHITE);

						// close the DB
						pst.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
					refreshUserInfoTable();
				} else if (addUserRdbtn.isSelected()
						&& ((roleComboBox.getSelectedIndex() + 1 == 1) || (roleComboBox
								.getSelectedIndex() + 1 == 2))
						&& addEmNamesTextField.getText().length() == 0
						&& addEmUserNameTextField.getText().length() == 0
						&& addEmUserPasswordTextField.getText().length() == 0
						&& addEmUserPhoneNumbertextField.getText().length() == 0
						&& addEmUserEmailtextField.getText().length() == 0) {
					Toolkit.getDefaultToolkit().beep();
					errorMessageLable.setForeground(Color.RED);
					errorMessageLable.setText("User not added, empty fields");

				}
				// ADD END

				// UPDATE BEGIN
				// if employee is selected
				if ((updateUserRdbtn.isSelected())
						&& (roleComboBox.getSelectedIndex() + 1 == 1)
						&& addEmNamesTextField.getText().length() > 0
						&& addEmUserNameTextField.getText().length() > 0
						&& addEmUserPasswordTextField.getText().length() > 0
						&& addEmUserPhoneNumbertextField.getText().length() > 0
						&& addEmUserEmailtextField.getText().length() > 0) {

					try {
						String query = "Update Employee set Names='"
								+ addEmNamesTextField.getText()
								+ " ' ,Username= '"
								+ addEmUserNameTextField.getText()
								+ " ', Password= '"
								+ addEmUserPasswordTextField.getText()
								+ "', Phone_Number= '"
								+ addEmUserPhoneNumbertextField.getText()
								+ "' , Email_Address= '"
								+ addEmUserEmailtextField.getText()
								+ "' where Names='"
								+ addEmNamesTextField.getText() + "' ";
						pst = connection.prepareStatement(query);
						pst.execute();

						// display a success message below the save button
						errorMessageLable.setForeground(Color.WHITE);
						errorMessageLable.setText("User Info updated");

						// close the DB
						pst.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
					refreshUserInfoTable();

				}

				// if manager is selected
				if ((updateUserRdbtn.isSelected())
						&& (roleComboBox.getSelectedIndex() + 1 == 2)
						&& addEmNamesTextField.getText().length() > 0
						&& addEmUserNameTextField.getText().length() > 0
						&& addEmUserPasswordTextField.getText().length() > 0
						&& addEmUserPhoneNumbertextField.getText().length() > 0
						&& addEmUserEmailtextField.getText().length() > 0) {

					try {
						String query = "Update Manager set Names='"
								+ addEmNamesTextField.getText()
								+ " ' ,Username= '"
								+ addEmUserNameTextField.getText()
								+ " ', Password= '"
								+ addEmUserPasswordTextField.getText()
								+ "', Phone_Number= '"
								+ addEmUserPhoneNumbertextField.getText()
								+ "' , Email_Address= '"
								+ addEmUserEmailtextField.getText()
								+ "' where Names='"
								+ addEmNamesTextField.getText() + "' ";
						pst = connection.prepareStatement(query);
						pst.execute();

						// display a success message below the save button
						errorMessageLable.setForeground(Color.WHITE);
						errorMessageLable.setText("User Info updated");

						// close the DB
						pst.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
					refreshUserInfoTable();

				}
				// else if condition for updating
				else if (updateUserRdbtn.isSelected()
						&& ((roleComboBox.getSelectedIndex() + 1 == 1) || (roleComboBox
								.getSelectedIndex() + 1 == 2))
						&& addEmNamesTextField.getText().length() == 0
						&& addEmUserNameTextField.getText().length() == 0
						&& addEmUserPasswordTextField.getText().length() == 0
						&& addEmUserPhoneNumbertextField.getText().length() == 0
						&& addEmUserEmailtextField.getText().length() == 0) {
					Toolkit.getDefaultToolkit().beep();
					errorMessageLable.setForeground(Color.RED);
					errorMessageLable.setText("Data not updated, empty fields");
				}
				// end update

				// delete start
				// if employee is selected
				if (deleteUserRdbtn.isSelected()
						&& roleComboBox.getSelectedIndex() + 1 == 1
						&& addEmNamesTextField.getText().length() > 0) {
					int action = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to delete the user?",
							"Delete", JOptionPane.YES_NO_OPTION);
					if (action == 0) {
						try {
							String query = "delete from Employee where Names='"
									+ addEmNamesTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// display a success message below the save
							errorMessageLable.setForeground(Color.WHITE);
							errorMessageLable.setText("User deleted");

							// close the DB
							pst.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						refreshUserInfoTable();
					}

				}

				// if manager is selected
				if (deleteUserRdbtn.isSelected()
						&& roleComboBox.getSelectedIndex() + 1 == 2
						&& addEmNamesTextField.getText().length() > 0) {
					int action = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to delete the user?",
							"Delete", JOptionPane.YES_NO_OPTION);
					if (action == 0) {

						try {
							String query = "delete from Manager where Names='"
									+ addEmNamesTextField.getText() + "' ";
							pst = connection.prepareStatement(query);
							pst.execute();

							// display a success message below the save
							errorMessageLable.setForeground(Color.WHITE);
							errorMessageLable.setText("User deleted");

							// close the DB
							pst.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						refreshUserInfoTable();
					}
				}
				// else if condition for deleting
				else if (deleteUserRdbtn.isSelected()
						&& ((roleComboBox.getSelectedIndex() + 1 == 1) || (roleComboBox
								.getSelectedIndex() + 1 == 2))
						&& addEmNamesTextField.getText().length() == 0) {
					Toolkit.getDefaultToolkit().beep();
					errorMessageLable.setForeground(Color.RED);
					errorMessageLable
							.setText("User not deleted, select data to be deleted from the table");
				}
				// clears the text fields after a successful save
				addEmNamesTextField.setText(null);
				addEmUserNameTextField.setText(null);
				addEmUserPasswordTextField.setText(null);
				addEmUserPhoneNumbertextField.setText(null);
				addEmUserEmailtextField.setText(null);

			}
		});
		addEmButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		addEmButton.setBounds(150, 321, 169, 30);
		addEmployeespanel.add(addEmButton);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(330, 113, 586, 151);
		addEmployeespanel.add(scrollPane_3);

		userInfoTable = new JTable();
		userInfoTable.setDefaultEditor(Object.class, null);
		userInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ((updateUserRdbtn.isSelected())
						|| deleteUserRdbtn.isSelected()) {

					// employee
					if ((roleComboBox.getSelectedIndex() + 1) == 1) {
						try {
							// gets selected row on table
							int row = userInfoTable.getSelectedRow();
							String Names_ = (userInfoTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Employee where Names= '"
									+ Names_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteUserRdbtn.isSelected()) {
									addEmNamesTextField.setText(rs
											.getString("Names"));
								} else {
									addEmNamesTextField.setText(rs
											.getString("Names"));
									addEmUserNameTextField.setText(rs
											.getString("Username"));
									addEmUserPasswordTextField.setText(rs
											.getString("Password"));
									addEmUserPhoneNumbertextField.setText((rs
											.getString("Phone_Number")));
									addEmUserEmailtextField.setText(rs
											.getString("Email_Address"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					if ((roleComboBox.getSelectedIndex() + 1) == 2) {
						try {
							int row = userInfoTable.getSelectedRow();
							String Names_ = (userInfoTable.getModel()
									.getValueAt(row, 0)).toString();

							String query = "select * from Manager where Names= '"
									+ Names_ + "' ";
							pst = connection.prepareStatement(query);
							rs = pst.executeQuery();

							while (rs.next()) {
								if (deleteUserRdbtn.isSelected()) {
									addEmNamesTextField.setText(rs
											.getString("Names"));
								} else {
									addEmNamesTextField.setText(rs
											.getString("Names"));
									addEmUserNameTextField.setText(rs
											.getString("Username"));
									addEmUserPasswordTextField.setText(rs
											.getString("Password"));
									addEmUserPhoneNumbertextField.setText(rs
											.getString("Phone_Number"));
									addEmUserEmailtextField.setText(rs
											.getString("Email_Address"));
								}
							}

							// close the DB
							pst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
			}
		});
		scrollPane_3.setViewportView(userInfoTable);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(22, 174, 80, 22);
		addEmployeespanel.add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(22, 207, 80, 22);
		addEmployeespanel.add(lblPassword);

		addEmUserNameTextField = new JTextField();
		addEmUserNameTextField.setBackground(Color.WHITE);
		addEmUserNameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c) || Character.isAlphabetic(c)
						|| c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();
				}
			}
		});
		addEmUserNameTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		addEmUserNameTextField.setBounds(183, 174, 136, 22);
		addEmployeespanel.add(addEmUserNameTextField);
		addEmUserNameTextField.setColumns(10);

		addEmUserPasswordTextField = new JTextField();
		addEmUserPasswordTextField.setBackground(Color.WHITE);
		addEmUserPasswordTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c) || Character.isAlphabetic(c)
						|| c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE || c != KeyEvent.VK_ALPHANUMERIC)
						|| (c == KeyEvent.VK_SPACE)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();
				}
			}
		});
		addEmUserPasswordTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		addEmUserPasswordTextField.setBounds(183, 207, 136, 22);
		addEmployeespanel.add(addEmUserPasswordTextField);
		addEmUserPasswordTextField.setColumns(10);

		JLabel lblPhonenumber = new JLabel("Phone Number");
		lblPhonenumber.setForeground(Color.BLACK);
		lblPhonenumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhonenumber.setBounds(22, 240, 109, 22);
		addEmployeespanel.add(lblPhonenumber);

		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setForeground(Color.BLACK);
		lblEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailAddress.setBounds(22, 273, 109, 22);
		addEmployeespanel.add(lblEmailAddress);

		addEmUserPhoneNumbertextField = new JTextField();
		addEmUserPhoneNumbertextField.setBackground(Color.WHITE);
		addEmUserPhoneNumbertextField
				.setFont(new Font("Tahoma", Font.BOLD, 14));
		addEmUserPhoneNumbertextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();

				if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();

				}
			}
		});
		addEmUserPhoneNumbertextField.setBounds(183, 240, 136, 22);
		addEmployeespanel.add(addEmUserPhoneNumbertextField);
		addEmUserPhoneNumbertextField.setColumns(10);

		addEmUserEmailtextField = new JTextField();
		addEmUserEmailtextField.setBackground(Color.WHITE);
		addEmUserEmailtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c) || Character.isAlphabetic(c)
						|| c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE || c != KeyEvent.VK_ALPHANUMERIC)
						|| c == KeyEvent.VK_SPACE) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();
				}
			}
		});
		addEmUserEmailtextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		addEmUserEmailtextField.setBounds(141, 273, 178, 22);
		addEmployeespanel.add(addEmUserEmailtextField);
		addEmUserEmailtextField.setColumns(10);

		errorMessageLable = new JLabel("");
		errorMessageLable.setForeground(Color.BLACK);
		errorMessageLable.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessageLable.setFont(new Font("Tahoma", Font.BOLD, 12));
		errorMessageLable.setBounds(22, 357, 393, 18);
		addEmployeespanel.add(errorMessageLable);

		JLabel lblNames = new JLabel("Names");
		lblNames.setForeground(Color.BLACK);
		lblNames.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNames.setBounds(23, 141, 80, 22);
		addEmployeespanel.add(lblNames);

		addEmNamesTextField = new JTextField();
		addEmNamesTextField.setBackground(Color.WHITE);
		addEmNamesTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE || c == KeyEvent.VK_SPACE)) {
					Toolkit.getDefaultToolkit().beep();
					arg0.consume();
				}
			}
		});
		addEmNamesTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		addEmNamesTextField.setColumns(10);
		addEmNamesTextField.setBounds(93, 141, 227, 22);
		addEmployeespanel.add(addEmNamesTextField);

		editEmpClearButton = new JButton("Clear");
		Image cleare = new ImageIcon(this.getClass().getResource("/clear1.png"))
				.getImage();
		editEmpClearButton.setIcon(new ImageIcon(cleare));
		editEmpClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				errorMessageLable.setText(null);
				addEmNamesTextField.setText(null);
				addEmUserNameTextField.setText(null);
				addEmUserEmailtextField.setText(null);
				addEmUserPasswordTextField.setText(null);
				addEmUserPhoneNumbertextField.setText(null);
			}
		});
		editEmpClearButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		editEmpClearButton.setBounds(23, 321, 110, 30);
		addEmployeespanel.add(editEmpClearButton);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(250, 250, 210));
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel1.setBounds(168, 11, 1182, 131);
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(165, 42, 42));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 6, true));
		panel_1.setBounds(423, 11, 325, 109);
		panel1.add(panel_1);
		panel_1.setLayout(null);

		restaurentLabel = new JLabel("");
		Image restaurenimg = new ImageIcon(this.getClass().getResource(
				"/restaurent.png")).getImage();
		restaurentLabel.setIcon(new ImageIcon(restaurenimg));
		restaurentLabel.setBounds(12, 15, 300, 80);
		panel_1.add(restaurentLabel);

		logoutButton = new JButton("");
		Image logoutimg = new ImageIcon(this.getClass().getResource(
				"/logout.png")).getImage();
		logoutButton.setIcon(new ImageIcon(logoutimg));
		logoutButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				desc.clear();
				price.clear();

				if ((pst == null && rs == null)) {

					Login login = new Login();
					frame.dispose();
					login.main(null);

				} else {

					try {

						pst.close();
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					// goes back to the login interface, login class
					Login login = new Login();
					frame.dispose();
					login.main(null);

				}

			}
		});
		logoutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logoutButton.setBounds(1130, 74, 33, 33);
		panel1.add(logoutButton);

		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogout.setBounds(1120, 106, 52, 16);
		panel1.add(lblLogout);

		dateTextArea = new JTextArea();
		dateTextArea.setForeground(Color.BLACK);
		dateTextArea.setBackground(new Color(250, 250, 210));
		dateTextArea.setLineWrap(true);
		dateTextArea.setEditable(false);
		dateTextArea.setBounds(10, 11, 200, 33);
		panel1.add(dateTextArea);
		
		LoggedtextField = new JTextField();
		LoggedtextField.setHorizontalAlignment(SwingConstants.CENTER);
		LoggedtextField.setFont(new Font("Tahoma", Font.BOLD, 15));
		LoggedtextField.setBackground(new Color(250, 250, 210));
		LoggedtextField.setEditable(false);
		LoggedtextField.setBounds(954, 100, 166, 22);
		panel1.add(LoggedtextField);
		LoggedtextField.setColumns(10);
		
		JLabel lblLoggedIn = new JLabel("Welcome");
		lblLoggedIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoggedIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoggedIn.setBounds(965, 69, 143, 20);
		panel1.add(lblLoggedIn);
	}
}
