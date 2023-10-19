package OracleInsert;
import java.sql.*;

public class OracleInsert2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.56.1:1521:xe";
		String user = "c##green";
		String password = "green1234";

		try {
			Class.forName(driver);
			System.out.println("jodbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success. \n");
			Statement stmt = conn.createStatement();

			String sql = "select * from emp";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getString("empno") + "\t ");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "   \t");
				System.out.print(rs.getString("mgr") + "\t");
				System.out.print(rs.getString("hiredate") + "\t");
				System.out.print(rs.getString("sal") + "\t");
				System.out.print(rs.getString("comm") + "\t");
				System.out.println(rs.getString("deptno"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
