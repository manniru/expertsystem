package com.habibu.expertsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Dao {
	Connection cn = null;
	//String dburl = "jdbc:sqlite:DATABASE.db";

	public static void main(String[] args) {
		String mobileno = "601123064474";
		String tag1 = "02AA7921";
		String tag2 = "72DDD724";
		String tag3 = "D2B1D624";
		//Dao dao = new Dao("sqlite");
		Dao dao = new Dao("mysql");
		User user = dao.getUser("601123064474");
		System.out.println(new Gson().toJson(user));
		//User user = dao.userLogin("auwal", "auwal");
		
		
		
		// test add
		//User user = dao.user(4);
		//dao.addUser(user);
		
		// test login
		///System.out.println(dao.userLogin("auwal", "auwal"));
	
		
		//User user = dao.getUser(1);
		//
		
		/**
		Object[][] oo = dao.getData("accounts", "5");
		
		for(int i=0; i<oo.length;i++) {
			System.out.println(oo[i][0]+"=="+oo[i][1]);
		}
		*/
		// DELETE from TRANSACT
		///dao.generateTables();
		
		
		
		///User user = dao.getUser("601123064474");
		
		
		//System.out.println(user.getFullname());
		//dao.addAccount(1, "CR", "RELOAD CARD", 100);
		//System.out.println("CR="+user.getCr()+", DR="+user.getDr()+", BL="+user.getBl());
		///dao.addTransact(mobileno, tag1);
		///System.out.println("CR="+user.getCr()+", DR="+user.getDr()+", BL="+user.getBl());


		
		///System.out.println(user.getAmount());
		
		///System.out.println(user.getAmount());
		
		
		//dao.addTransact(mobileno, tag1);
		
	}
	
	public Dao(String dbtype) {
		if(dbtype.equals("sqlite")) {
			try { Class.forName("org.sqlite.JDBC");
			//cn = DriverManager.getConnection(dburl);
		    } catch ( Exception e ) { System.out.println(e); }
		}
		
		else if(dbtype.equals("mysql")) {
			try { Class.forName("org.sqlite.JDBC");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/nfcserver","root","");
			System.out.println("connected to mysql!");
		    } catch ( Exception e ) { System.out.println(e); }
		}
		
		else if(dbtype.equals("javadb")) {
			try { Class.forName("org.sqlite.JDBC");
			//cn = DriverManager.getConnection(dburl);
		    } catch ( Exception e ) { System.out.println(e); }
		}
	}
	
	public void generateTables() {
		Statement st = null;
	    try {
	    	//cn = DriverManager.getConnection(dburl);
	    	st = cn.createStatement();
	      
	      
	      
	      st.executeUpdate("CREATE TABLE USERS(ID INTEGER PRIMARY KEY   AUTOINCREMENT," +
                  " USERNAME           TEXT    NOT NULL, " + 
                  " PASSWORD           TEXT    NOT NULL, " + 
                  " EMAIL           TEXT    NOT NULL, " + 
                  " MOBILENO           TEXT    NOT NULL, " + 
                  " FULLNAME           TEXT)");
	      st.executeUpdate("CREATE TABLE PRICES(ID INTEGER PRIMARY KEY   AUTOINCREMENT, `FROM` TEXT, `TO` TEXT, PRICE INTEGER)");
	      st.executeUpdate("CREATE TABLE TRANSACT(ID INTEGER PRIMARY KEY   AUTOINCREMENT, MOBILENO TEXT, TAGID TEXT)");
	      st.executeUpdate("CREATE TABLE ACCOUNT(ID INTEGER PRIMARY KEY AUTOINCREMENT, UID INTEGER, TYPE TEXT, DESCRIPTION TEXT, AMOUNT INTEGER)");
	      
	      String sql2 = "INSERT INTO `prices` VALUES ('1', '02AA7921', '72DDD724', '10');"+
	      "INSERT INTO `prices` VALUES ('2', '02AA7921', 'D2B1D624', '15');"+
	      "INSERT INTO `prices` VALUES ('3', '72DDD724', '02AA7921', '13');"+
	      "INSERT INTO `prices` VALUES ('4', '72DDD724', 'D2B1D624', '25');"+
	      "INSERT INTO `prices` VALUES ('5', 'D2B1D624', '02AA7921', '14');"+
	      "INSERT INTO `prices` VALUES ('6', 'D2B1D624', '72DDD724', '16');";
	      st.executeUpdate(sql2);
	      st.close();
	      cn.close();
	    } catch (Exception e) { System.out.println(e); }
	    System.out.println("Tables created successfully");
	}
	
	public User user(int id) {
		User user = new User();
		user.setId(id);
		user.setUsername("user"+id);
		user.setPassword("user"+id);
		user.setEmail("user"+id+"@email.com");
		user.setMobileno("601123064474");
		user.setFullname("User Number "+id);		
		return user;
	}
	
	public void addUser(User user) {
		Statement st = null;
		try { //cn = DriverManager.getConnection(dburl);
			 st = cn.createStatement();
		      String sql = "INSERT INTO USERS (USERNAME, PASSWORD, EMAIL, MOBILENO, FULLNAME) " +
		                   "VALUES ('"+user.getUsername()+"', '"+user.getPassword()+"', '"+
		    		  user.getEmail()+"','"+user.getMobileno()+"', '"+user.getFullname()+"');"; 
		      st.executeUpdate(sql);
		      System.out.println("User inserted!");
		      st.close();
		      cn.close();
		} catch(Exception e) { System.out.println("addUser:"+e); }
	}
	
	public User getUser(int uid) {
		User user = new User();
		
		try { //cn = DriverManager.getConnection(dburl);
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM USERS WHERE ID="+uid); rs.next();
			String username = rs.getString("username");
			String password = rs.getString("password");
			String email = rs.getString("email");
			String mobileno = rs.getString("mobileno");
			String fullname = rs.getString("fullname");
			user.setId(uid);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setMobileno(mobileno);
			user.setFullname(fullname);
			//cn.close();
		} catch(Exception e) { System.out.println("e4:"+e); }
		
		try { //cn = DriverManager.getConnection(dburl);
		ResultSet rs = cn.createStatement().executeQuery("SELECT SUM(AMOUNT) AS CR FROM ACCOUNTS WHERE UID="+uid+" AND TYPE='CR'"); rs.next();
		user.setCr(Integer.parseInt(rs.getString("CR")));
		} catch(Exception e) {}
		
		try { //cn = DriverManager.getConnection(dburl);
			ResultSet rs = cn.createStatement().executeQuery("SELECT SUM(AMOUNT) AS DR FROM ACCOUNTS WHERE UID="+uid+" AND TYPE='DR'"); rs.next();
			user.setDr(Integer.parseInt(rs.getString("DR")));
			} catch(Exception e) {}
		
		try { //cn = DriverManager.getConnection(dburl);
			ResultSet rs = cn.createStatement().executeQuery("SELECT TAGID FROM TRANSACT WHERE mobileno='"+user.getMobileno()+"' ORDER BY id DESC LIMIT 1,1"); rs.next();
			user.setLrt1(lrt(rs.getString("tagid")));
			} catch(Exception e) {}
		
		try { //cn = DriverManager.getConnection(dburl);
			ResultSet rs = cn.createStatement().executeQuery("SELECT TAGID FROM TRANSACT WHERE mobileno='"+user.getMobileno()+"' ORDER BY id DESC LIMIT 1"); rs.next();
			user.setLrt2(lrt(rs.getString("tagid")));
			} catch(Exception e) {}
		
		
		user.setBl(user.getCr() - user.getDr());
		user.setCharge(price(user.getMobileno()));
		user.setAmount(user.getCr() - user.getDr());
		user.setBalance(user.getBl()-user.getCharge());
		
		return user;
	}
	
	public User getUser(String mobileno) {
		User user = new User();		
		try { //cn = DriverManager.getConnection(dburl);
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM USERS WHERE MOBILENO='"+mobileno+"'"); rs.next();
			int uid = rs.getInt("id");
			Dao dao = new Dao("mysql");
			user = dao.getUser(uid);
		} catch(Exception e) { System.out.println(e); }
		
		try {
			//
		} catch(Exception e) { System.out.println(e); }
		
		
		return user;
	}
	
	public User userLogin(String user1, String pass1) {
		User user = new User();		
		try { //cn = DriverManager.getConnection(dburl);
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM USERS WHERE USERNAME='"+user1+"' AND password='"+pass1+"'"); rs.next();
			int id = Integer.parseInt(rs.getString("ID"));
			String username = rs.getString("username");
			String password = rs.getString("password");
			String email = rs.getString("email");
			String mobileno = rs.getString("mobileno");
			String fullname = rs.getString("fullname");
			
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setMobileno(mobileno);
			user.setFullname(fullname);			
			//cn.close();
		} catch(Exception e) { System.out.println(e); }
		
		return user;	
	}
	
	public void addTransact(String mobileno, String tagid) {
		Statement st = null;
		//try { cn.close(); } catch(Exception e) { }
		//try { cn = DriverManager.getConnection(dburl); } catch(Exception e) { }
		try { //cn.close();
			//cn = DriverManager.getConnection(dburl);
			 st = cn.createStatement();
		      st.executeUpdate("INSERT INTO TRANSACT (MOBILENO, TAGID) VALUES ('"+mobileno+"', '"+tagid+"')");
		      Dao dao = new Dao("mysql");
		      User user = dao.getUser(mobileno);
			dao .addAccount(user.getId(), "DR", "USE AT LRT", user.getCharge());
		      System.out.println("Transact inserted!");
		      //st.close();
		      //cn.close();
		} catch(Exception e) { System.out.println("addUser:"+e); }
	}
	
	public int price(String mobileno) {
		int price = 0;
		String l1 = "";
		String l2 = "";
		List<String> ls = new ArrayList<String>();
		
		try {//cn.close(); 
			//cn = DriverManager.getConnection(dburl);
		String sql = "SELECT price FROM PRICES WHERE `from`=(SELECT TAGID FROM TRANSACT WHERE mobileno='"+mobileno+"' ORDER BY id DESC LIMIT 1,1) AND `to`=(SELECT TAGID FROM TRANSACT WHERE mobileno='"+mobileno+"' ORDER BY id DESC LIMIT 1)";
			ResultSet rs = cn.createStatement().executeQuery(sql); rs.next();
			price = Integer.parseInt(rs.getString("price"));
			/**
			while(rs.next()){
				System.out.println(rs.getString("tagid"));
				ls.add(rs.getString("tagid")); }
	
			
			ResultSet rs2 = cn.createStatement().executeQuery("SELECT price FROM PRICES WHERE `from`='"+ls.get(0)+"' AND `to`='"+ls.get(0)+"'"); rs2.next();
			price= Integer.parseInt(rs2.getString("price"));
			ls.add(price+"");
			*/
			//System.out.println(ls.get(0));
			//System.out.println(ls.get(1));
			//System.out.println(price);
//			/cn.close();
			
		} catch(SQLException e) { System.out.println("e3="+e); }
		
		return price;
	}
	
	public void addAccount(int uid, String type, String desc, int amount) {
		Statement st = null;
		try { //cn = DriverManager.getConnection(dburl);
			 st = cn.createStatement();
		      st.executeUpdate("INSERT INTO ACCOUNTS(UID, TYPE, DESCRIPTION, AMOUNT) VALUES ("+uid+", '"+type+"','"+desc+"',"+amount+")");
		      System.out.println("Account Added!");
		      st.close();
		      //cn.close();
		} catch(Exception e) { System.out.println(e); }
	}
	
	public String lrt(String tagid) {
		String rt = "";
		if(tagid.equals("02AA7921")) { rt = "Bukit Jalil LRT"; }
		if(tagid.equals("D2B1D624")) { rt = "Masjid Jamek LRT"; }
		if(tagid.equals("72DDD724")) { rt = "KLCC LRT"; }
		
		return rt;
	}
	
	public Object[][] getData(String tb, String uid) {
		System.out.println("mm:"+uid);
		Object[][] oo = null;
	
		try {
		Statement st2 = cn.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT * FROM "+tb+" WHERE uid="+uid);
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
			row = new Object[colCount];
			for (int a = 0; a < colCount; a++) {
				row[a] = r3.getObject(a + 1);
			}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getObjects()"+e3);
		
		}
		return oo;
	}


}
