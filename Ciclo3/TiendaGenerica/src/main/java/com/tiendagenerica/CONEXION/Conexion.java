package com.tiendagenerica.CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	static String bd = "tienda_generica";
	static String url = "jdbc:mysql://localhost:3306/" + bd;
	static String user = "root";
	static String password = "root";

	Connection connection = null;

	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Conexion a base de datos exitosa");
			} else {
				System.out.println("No se pudo conectar a la base de datos");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() {
		connection = null;
	}

}
