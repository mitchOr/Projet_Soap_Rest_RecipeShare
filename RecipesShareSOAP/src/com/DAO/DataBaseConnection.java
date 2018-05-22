package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
		/**
		 * Les attributs 
		 */
		private static Connection myConnect = null ;
		
	     
	     /***
	      * les doon�es utiles 
	      */
	    private static final String driver = "com.mysql.jdbc.Driver";
	    private  static String url = "jdbc:mysql://127.0.0.1:3306/recipesshare";
	     
	   
		
		
		/**
		 * Cette methode permet l'intallation du pilote mysql connector pour que la base de donn�es 
		 * puis communiquer avec java
		 */
		 private static void installationPilote() {
	    	 /**
	         * Installation du pilote 
	         */
	        try {
	            Class.forName(driver);
	             
	        } catch (ClassNotFoundException e) {
	            System.out.println("Pilote non trouv�");
	            System.exit(1);
	        }
		}
		 
		 /***
		  * Cette methode permet la connection � une base de donn�es
		  * @throws SQLException
		  */
		 public static Connection connectionBaseDonnes() throws SQLException {
	    	 /**
	         * Connection � la base de donn�es 
	         */
	         
			 installationPilote();
	    	 /**
	         * Les informations de l'utilisateur 
	         */
	          Properties userInfo = new Properties();
	          userInfo.put("user", "root");
	          userInfo.put("password", "");
	    
	         myConnect = DriverManager.getConnection(url,userInfo);
	         return myConnect;
	       
		 }
		 /***
		  * Cette methode permet la deconnection � une base de donn�es 
		  * @throws SQLException
		  */
		 public static void deconnectionBaseDonnees() throws SQLException {
		    	/**
		         * Fermer la connection 
		         *
		         */
		        if(myConnect != null)
		        {
		                myConnect.close();
		            
		        }
			}
		

}
