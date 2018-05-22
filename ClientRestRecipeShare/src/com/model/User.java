package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

/**
 * Class User
 * 
 * @author MariamKonate
 *
 */
@XmlRootElement(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String fName;
	private String lName;
	private String birthDate;
	private String login;
	private String password;

	/**
	 * Constructor
	 */
	public User() {
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param fName
	 * @param lName
	 */
	public User(int id, String fName, String lName) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.birthDate = null;
		this.login = "";
		this.password = "";

	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param fName
	 * @param lName
	 * @param birthDate
	 * @param login
	 * @param password
	 */
	public User(int id, String fName, String lName, String birthDate, String login, String password) {

		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.birthDate = birthDate;
		this.login = login;
		this.password = password;
	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param fName
	 * @param lName
	 * @param birthDate
	 */
	public User(int id, String fName, String lName, String birthDate) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.birthDate = birthDate;
	}

	/**
	 * Constructor
	 * 
	 * @param fName
	 * @param lName
	 * @param birthDate
	 * @param login
	 * @param password
	 */
	public User(String fName, String lName, String birthDate, String login, String password) {

		super();
		this.fName = fName;
		this.lName = lName;
		this.birthDate = birthDate;
		this.login = login;
		this.password = password;
	}

	/**
	 * Constructor
	 * 
	 * @param fName
	 * @param lName
	 * @param birthDate
	 */
	public User(String fName, String lName, String birthDate) {
		this.fName = fName;
		this.lName = lName;
		this.birthDate = birthDate;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	@XmlElement
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
	 * @param password
	 *            the password to set
	 */
	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName
	 *            the fName to set
	 */
	@XmlElement
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName
	 *            the lName to set
	 */
	@XmlElement
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	@XmlElement
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Method Equals
	 */
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof User)) {
			return false;
		} else {
			User user = (User) object;
			if (id == user.getId() && fName.equals(user.getfName()) && lName.equals(user.getlName())
					&& birthDate.equals(user.getBirthDate())) {
				return true;
			}
		}
		return false;
	}
}