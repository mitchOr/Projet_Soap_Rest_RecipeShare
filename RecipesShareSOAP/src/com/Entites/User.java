package com.Entites;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int id;
		private String firstName;
	    private String lastName;
	    private String birthDate;
	    private String login;
	    private String password;
		
	    //contructeurs
	    /**
		 * @param id
		 * @param firstName
		 * @param lastName
		 * @param birthDate
		 * @param login
		 * @param password
		 */
		public User(int id, String firstName, String lastName, String birthDate, String login, String password) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.birthDate = birthDate;
			this.login = login;
			this.password = password;
		}
		/**
		 * 
		 * @param id
		 * @param firstName
		 * @param lastName
		 * @param birthDate
		 */
	   public User(int id, String firstName, String lastName,String birthDate){
		      this.id = id;
		      this.firstName = firstName;
		      this.lastName = lastName;
		      this.birthDate=birthDate;
		   }
	   /**
	    * 
	    */
	   public User()
	   {
		   
	   }
	   //méthodes
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getfirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getlastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	   
    
	
	    

}
