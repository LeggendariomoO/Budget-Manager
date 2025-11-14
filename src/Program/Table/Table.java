package Program.Table;
import java.sql.*;

public class Table {
	String url;
	String sql;
	String insert;
	String selectAll;
	String dropTable;
	String deleteId;
	String selectSum;
	String orderByDate;
	public Table(){
		url="jdbc:sqlite:my.db";
		sql="Create table if not exists data("+"id integer primary key AUTOINCREMENT,\r\n"
				+ "cifra float,\r\n"
				+ "causale text not null,\r\n"
				+ "date text not null\r\n"
				+ ");";
		insert="insert into data (cifra, causale,date) values (?,?,?);\r\n";
		selectAll="select * from data order by date;";
		dropTable="drop table if exists data;\r\n";
		deleteId="delete from data where id = ?";
		selectSum="select sum(all cifra) from data";

	}

	public void createDatabase() {
		try(var conn=DriverManager.getConnection(url)){
			if (conn!=null) {
				var meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void createTable() {
		try(var conn=DriverManager.getConnection(url);
				var stmt=conn.createStatement()){
			stmt.execute(sql);

		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	public void insertValues(float number, String causal, String date) {
		try(var conn=DriverManager.getConnection(url);
				var pstmt=conn.prepareStatement(insert)){
			pstmt.setFloat(1, number);
			pstmt.setString(2, causal);
			pstmt.setString(3, date);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	/* Useless method
	  public void selectValue() {
		try (var conn = DriverManager.getConnection(url);
				var stmt = conn.createStatement();
				var rs = stmt.executeQuery(selectAll)) {
			System.out.printf("%.2f|%s",rs.getFloat("cifra"),rs.getString("causale"));

		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}*/
	public void selectAllValues() {
		try (var conn = DriverManager.getConnection(url);
				var stmt = conn.createStatement();
				var rs = stmt.executeQuery(selectAll)) {
			while (rs.next()) {
				System.out.printf("%d|%.2f|%s|%s\n",rs.getInt("id"),rs.getFloat("cifra"),rs.getString("causale"),rs.getString("date"));}

		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}}
	public void dropTable() {
		try (var conn = DriverManager.getConnection(url);
				var stmt = conn.createStatement()) {
			stmt.execute(dropTable);
			System.out.println("Tabella eliminata con successo.");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	public void deleteValue(int id) {
		try (var conn = DriverManager.getConnection(url);
				var pstmt = conn.prepareStatement(deleteId)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	public float printSum() {
		try (var conn = DriverManager.getConnection(url);
				var stmt = conn.createStatement();
				var rs = stmt.executeQuery(selectSum)) {
			return rs.getFloat(1);

		}catch(SQLException e) {
			return 0;
		}	
	}
}
