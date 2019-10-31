package eVote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DAO {
	Connection conn;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;

	void connect() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
	}

	public boolean login(String un, String pw, String Usertype) throws Exception {
		connect();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(
				"select * from evs_tbl_user_Credentials where Userid='" + un + "' and password='" + pw + "'");
		if (rs.next()) {
			if (rs.getString("Usertype").equals(Usertype))
				return true;
		}
		return false;
	}

	public ResultSet fetch(String un) throws Exception {
		connect();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from evs_tbl_user_profile where Userid ='" + un + "'");
		return rs;
	}

	public boolean addparty(String Name, String Leader) throws Exception {
		connect();
		ps = conn.prepareStatement("update EVS_TBL_Party set Approve=1 where Name=? and Leader=?");
		ps.setString(1, Name);
		ps.setString(2, Leader);
		ps.executeUpdate();
		return true;
	}
}
