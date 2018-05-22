package com.service;

import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import com.model.*;

/**
 * Class to use UserService
 * 
 * @author MariamKonate
 *
 */
public class UserService {
	private Client client;
	private String REST_SERVICE_USERS_URL = "http://localhost:8080/RecipeShareRest/rest/UserService/users";
	private final String SUCCESS_RESULT = "<result>success</result>";
	private final String PASS = "pass";
	private final String FAIL = "fail";

	/**
	 * Method to initialize services
	 */
	public void init() {
		this.client = ClientBuilder.newClient();
	}

	/**
	 * testGetAllUsers
	 * 
	 * @return
	 */
	public List<User> testGetAllUsers() {
		GenericType<List<User>> list = new GenericType<List<User>>() {
		};
		List<User> users = client.target(REST_SERVICE_USERS_URL).request(MediaType.APPLICATION_XML).get(list);
		String result = PASS;
		if (users.isEmpty()) {
			result = FAIL;
		}
		System.out.println("Test case name: testGetAllUsers, Result: " + result);

		return users;
	}

	/**
	 * testGetUser
	 * 
	 * @param id
	 * @return
	 */
	public User testGetUser(int id) {
		User sampleUser = new User(id, "", "");

		User user = client.target(REST_SERVICE_USERS_URL).path("/{userid}").resolveTemplate("userid", id)
				.request(MediaType.APPLICATION_XML).get(User.class);
		String result = FAIL;
		if (sampleUser != null && sampleUser.getId() == user.getId()) {
			result = PASS;
		}
		System.out.println("Test case name: testGetUser, Result: " + result);
		return user;
	}

	/**
	 * testUpdateUser
	 * 
	 * @return
	 */
	public String testUpdateUser() {
		Form form = new Form();
		form.param("id", "5");
		form.param("fName", "suresh");
		form.param("lName", "clerk");
		form.param("birthDate", "clerk");
		form.param("login", "guess");
		form.param("password", "secret");

		String callResult = client.target(REST_SERVICE_USERS_URL).request(MediaType.APPLICATION_XML)
				.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testUpdateUser, Result: " + result);
		return result;
	}

	/**
	 * testAddUser
	 * 
	 * @param fName
	 * @param lName
	 * @param birthDate
	 * @param login
	 * @param password
	 * @return
	 */
	public String testAddUser(String fName, String lName, String birthDate, String login, String password) {
		Form form = new Form();
		form.param("fName", password);
		form.param("lName", lName);
		form.param("birthDate", birthDate);
		form.param("login", login);
		form.param("password", password);

		String callResult = client.target(REST_SERVICE_USERS_URL).request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testAddUser, Result: " + result);
		return result;
	}

	/**
	 * testDeleteUser
	 * 
	 * @param id
	 * @return
	 */
	public String testDeleteUser(int id) {
		String callResult = client.target(REST_SERVICE_USERS_URL).path("/{userid}").resolveTemplate("userid", id)
				.request(MediaType.APPLICATION_XML).delete(String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testDeleteUser, Result: " + result);
		return result;
	}

	public static void main(String[] args) {
		UserService tester = new UserService();
		// initialize the tester
		tester.init();
		// test get all users Web Service Method
		tester.testGetAllUsers();

		// test get user Web Service Method
		User u = tester.testGetUser(7);

		// test update user Web Service Method
		tester.testUpdateUser();

		// test add user Web Service Method
		tester.testAddUser(u.getfName(), u.getlName(), u.getBirthDate(), u.getLogin(), u.getPassword());

		// test delete user Web Service Method
		tester.testDeleteUser(8);

	}
}
