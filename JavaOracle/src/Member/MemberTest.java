package Member;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberTest {
	public static void main(String[] args) {
		System.out.println("Input ename...?");
		Scanner sc = new Scanner(System.in);
		String inp = sc.next();
		System.out.println(inp);
		sc.close();
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVo> list = dao.list(inp);
		
		for (int i = 0; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String empno = data.getEmpno();
			String ename = data.getEname();
			int sal = data.getsal();
			int comm = data.getcomm();
			
			System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + comm);
		}
	}
}
