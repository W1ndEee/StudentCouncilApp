package App;
import java.sql.*;
import java.io.*;
import java.util.Properties;
import java.lang.Integer.*;

public class TESSSST {

	public static void main(String[] args) {
		Connection c = null;
	    Statement stmt = null;
	    int batchSize = 20;
	    String filepath = "lib/Voters.csv";
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/daniel");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
//create table
	         /*
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE TESTCAND" +
	            "(STUDENTID INT PRIMARY KEY     NOT NULL," +
	            " NAME           TEXT    NOT NULL, " +
	            " YEARLEVEL            INT     NOT NULL, " +
	            " EMAIL        TEXT		NOT NULL, " +
	            " PASSWORD         TEXT		NOT NULL, " +
	            " VOTESTATUS	BOOLEAN		NOT NULL)";
	         stmt.executeUpdate(sql); */
	         
	         
//Insert data manually
	         
	         /*
	         stmt = c.createStatement();
	         String sql = "INSERT INTO TEST3 (STUDENTID,NAME,YEARLEVEL,VOTES,PICTURE) "
	            + "VALUES (130678776, 'Angel Wang', 13, 0, 'lib/130678776.jpg');";
	         stmt.execute(sql); 
	         */
	         
//EDIT VALUE
	         /*
	         stmt = c.createStatement();
	         String sql = "UPDATE TESTCAND SET VOTESTATUS = true WHERE EMAIL = '1@you.com'";
				stmt.executeUpdate(sql); */
	         
	         
//insert data with csv
	         /*
	         stmt = c.createStatement();
	         String sql = "insert into TESTCAND(STUDENTID,NAME,YEARLEVEL,EMAIL,PASSWORD,VOTESTATUS) values(?,?,?,?,?,?)";
	         
	         PreparedStatement statement = c.prepareStatement(sql);
	         
	         BufferedReader linereader = new BufferedReader(new FileReader(filepath));
	         
	         String linetext = null;
	         int count = 0;
	         
	         linereader.readLine();
	         
	         while ((linetext = linereader.readLine())!= null) {
	        	 String[] data=linetext.split(",");
	        	 
	        	 String STUDENTID = data[0];
	        	 String NAME = data[1];
	        	 String YEARLEVEL = data[2];
	        	 String EMAIL = data[3];
	        	 String PASSWORD = data[4];
	        	 String VOTESTATUS = data[5];
	        	 
	        	 statement.setInt(1, Integer.parseInt(STUDENTID));
	        	 statement.setString(2, NAME);
	        	 statement.setInt(3, Integer.parseInt(YEARLEVEL));
	        	 statement.setString(4, EMAIL);
	        	 statement.setString(5, PASSWORD);
	        	 statement.setBoolean(6, Boolean.getBoolean(VOTESTATUS));
	        	 statement.addBatch();
	        	 if(count%batchSize==0) {
	        		 statement.executeBatch();
	        	 }
	        	 
	        	 
	         } */
	         
	         
//show table    
	         
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM TEST3 ORDER BY STUDENTID ASC;" );
	         while ( rs.next() ) {
	            int studentid = rs.getInt("studentid");
	            String  name = rs.getString("name");
	            int yearlevel  = rs.getInt("yearlevel");
	            int  votes = rs.getInt("votes");
	            String picture = rs.getString("picture");
	            System.out.println( "STUDENTID = " + studentid );
	            System.out.println( "NAME = " + name );
	            System.out.println( "YEARLEVEL = " + yearlevel );
	            System.out.println( "VOTES = " + votes );
	            System.out.println( "PICTURE = " + picture );
	            System.out.println();
	         }
	         rs.close(); 
	         
	         //TEST
	         /*
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT NAME FROM TEST3 WHERE STUDENTID = '130589595';" );
	         rs.next();
	         String name = rs.getString("NAME");
	         System.out.println(name); */
	         
	         
	         // FOR INSERTING DATA
	         //linereader.close();
	         //statement.executeBatch();
	         stmt.close();
	         c.commit();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	   }

}

