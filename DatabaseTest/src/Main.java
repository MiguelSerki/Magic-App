import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) throws Exception {
		getConnection();
	}
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306";
			String username = "Serki";
			String password = "Lukekenobi7";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("You did it!");
			return con;
		}catch (Exception e){
			System.out.println(e);
		}
		
		return null;
	}

}
