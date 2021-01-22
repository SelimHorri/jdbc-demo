package jdbc_pack;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Work {
// Begin Class
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet res = null;
	
	Work () {
		this.config();
		System.out.print("\n Connected yesssss!!!!! \n");
	}
	
// ************************************************config() method*****************************************************************************
	
	private void config () {
	// Begin config()
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/person_DB?user=Reese&password=Dashwood");
			statement = connect.createStatement();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	// End config()
	}
	
	void select () {
	// Begin select()
		
//		Scanner jin = new Scanner(System.in);
//		String sqll = jin.nextLine();
//		jin.close();
		
		try {
			
//			String sqll = "select ID,EMAIL,Password from person";
			String sqll = JOptionPane.showInputDialog("Enter SQL select statement :");
			ArrayList<String> ids = new ArrayList<String>();
			ArrayList<String> emails = new ArrayList<String>();
			ArrayList<String> passwds = new ArrayList<String>();
			
			res = statement.executeQuery(sqll);
			while (res.next()) {
				
				ids.add(res.getString("ID"));
				emails.add(res.getString("EMAIL"));
				passwds.add(res.getString("Password"));
				
			}
			
//			for (String str : ids)
//				System.out.print(str +"\t");
			System.out.println();
			
			for (String str : emails)
				System.out.print(str +"\t");
			System.out.println();
			
			for (String str : passwds)
				System.out.print(str +"\t");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	// End select()
	}
	
	
// End Class
}
