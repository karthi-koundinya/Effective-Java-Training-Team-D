package in.conceptarchitect.finance.jdbcAccountStore;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountStoreBo {
	
		public List<JdbcAccountStore> getAllMembers() throws Exception{
			List<JdbcAccountStore> li=new ArrayList<JdbcAccountStore>();


			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/genesis_nov", "root", "root");


			PreparedStatement ps=c.prepareStatement("select * from AccountStore");


			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				 li.add(new JdbcAccountStore(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4)));
			}
			
			c.close();
			return li;
		}
		
		public boolean addAccount(JdbcAccountStore m)throws Exception {
		boolean b=false; 
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/genesis_nov","root", "root");
		
		Statement stmt=c.createStatement();
		
		b=stmt.execute("insert into AccountStore values("+m.getAccountNumber()+",'"+m.getName()+"','"+m.getPassword()+"',"+m.getBalance()+")");
		c.close();
		return b;
		
	}
}
