package com.biz.jdbc.exec;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class OracleExec_03 {

	
	public static void main(String[] args) {

		String jdbcDriver="oracle.jdbc.driver.OracleDriver";
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="user4";
		String password="1234";
		
		try {

			Class.forName(jdbcDriver);
			Connection con= DriverManager.getConnection(url, userName, password);
			System.out.println("오라클 연결 성공");
			
			
			PreparedStatement pStr=null;
			
			String sql=" SELECT * FROM tbl_student ";
			
			pStr=con.prepareStatement(sql);
			ResultSet rs=pStr.executeQuery();
			
			while(rs.next()) {
				for(int i=1; i<=9;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {

			System.out.println("JDBC Driver 실행 오류");
			
		} catch (SQLException e) {

			System.out.println("오라클에 연결할수 없음");
		}
		
		
	}

}
