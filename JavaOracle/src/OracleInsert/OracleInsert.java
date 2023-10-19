package OracleInsert;
import java.sql.*;

public class OracleInsert {
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

			String sql1 = "select max(deptno) from dept";
			ResultSet rs1 = stmt.executeQuery(sql1);
			rs1.next();
			String strdeptno = rs1.getString("max(deptno)");
			System.out.println(strdeptno);
			
			int ideptno = Integer.parseInt(strdeptno);
			ideptno += 10;
			String sdname = "IT", sloc = "SEOUL";
			String sql3 ="insert into dept values('" + ideptno + "','" + sdname + "','" + sloc + "')";
					System.out.println(sql3);
					boolean b = stmt.execute(sql3);
					if (!b) {
						System.out.println("Insert success. \n");
						} else {
						System.out.println("Insert fail. \n");
					}
			
			String sql2 = "select * from dept";
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				System.out.print(rs.getString("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.println(rs.getString("loc") + " ");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
