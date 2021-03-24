import java.sql.*;
import javax.swing.*;

public class restoData {
	
	public static Connection ConnectDB()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Nishant\\eclipse-workspace\\SnackCounter\\entrydb.db");
			JOptionPane.showMessageDialog(null, "Connection Made");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "oops, Connection Error");
			return null;
		
		}
	}
}
