package semesterProject;

import java.sql.*;
import javax.swing.*;
public class SqliteCon {
	
	Connection conn=null;

	public static Connection dbConnector(){
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			// path for data base
			// path have to be changed every time a different computer is used
			//Connection conn =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\MAOTO M\\Desktop\\JavaPrograms\\BOP311SemesterProject\\DB\\Login.sqlite");
			Connection conn =DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\DB\\Login.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection succesful");
			return conn;
		} catch (Exception e) {
			// if connection is unsuccessful 
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
