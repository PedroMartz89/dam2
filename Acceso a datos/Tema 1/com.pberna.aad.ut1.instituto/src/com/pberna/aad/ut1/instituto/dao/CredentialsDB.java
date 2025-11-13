package com.pberna.aad.ut1.instituto.dao;

public class CredentialsDB {
	public static String getConnection() {
		return "jdbc:mysql://localhost/instituto";
	}
	
	public static String getUser() {
		return "root";
	}
	
	public static String getPassword() {
		return "1234";
	}
}
