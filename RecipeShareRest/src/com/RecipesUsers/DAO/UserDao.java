package com.RecipesUsers.DAO;

import java.sql.*;
import java.util.*;

import com.RecipesUsers.Entities.User;

/**
 * Class UserDao
 * 
 * @author MariamKonate
 *
 */
public class UserDao {

	/**
	 * Method to get All users
	 * 
	 * @return
	 */
	public List<User> getAllUsers() {
		String requete = "SELECT u.IdUser,NomUser,PrenomUser,DateNaissance,Login,Password FROM Users as u LEFT JOIN usersaccount on u.IdUser = usersaccount.IdUser ;";
		Connection myConnect;
		List<User> userList = new ArrayList<>();
		try {
			userList = new ArrayList<>();
			myConnect = DataBaseConnection.connectionBaseDonnes();
			Statement statement = myConnect.createStatement();
			ResultSet resultat = statement.executeQuery(requete);

			/* Récupération des données du résultat de la requête de lecture */

			while (resultat.next()) {
				int idUtilisateur = resultat.getInt("IdUser");
				String nomUtilisateur = resultat.getString("NomUser");
				String prenomUtilisateur = resultat.getString("PrenomUser");
				String dateNaissanceUtilisateur = resultat.getString("DateNaissance");
				String loginUtilisateur = resultat.getString("Login");
				String passwordUtilisateur = resultat.getString("Password");

				User user = null;
				if (loginUtilisateur == null || passwordUtilisateur == null) {
					user = new User(idUtilisateur, nomUtilisateur, prenomUtilisateur, dateNaissanceUtilisateur);
				} else {
					user = new User(idUtilisateur, nomUtilisateur, prenomUtilisateur, dateNaissanceUtilisateur,
							loginUtilisateur, passwordUtilisateur);
				}
				userList.add(user);
			}

			statement.close();
			myConnect.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * Method to get a user
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		List<User> users = getAllUsers();

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	/**
	 * Method to get the id of a user
	 * 
	 * @param pUser
	 * @return
	 */
	public int getIdUser(User pUser) {
		String requete = "SELECT IdUser,NomUser,PrenomUser,DateNaissance FROM Users WHERE NomUser = ? and PrenomUser = ? and DateNaissance = ?;";
		Connection myConnect;
		int idUtilisateur = -1;
		try {

			myConnect = DataBaseConnection.connectionBaseDonnes();
			PreparedStatement statement = myConnect.prepareStatement(requete);
			statement.setString(1, pUser.getfName());
			statement.setString(2, pUser.getlName());
			statement.setString(3, pUser.getBirthDate());
			ResultSet resultat = statement.executeQuery();

			while (resultat.next()) {
				idUtilisateur = resultat.getInt("IdUser");
			}

			statement.close();
			myConnect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return idUtilisateur;
	}

	/**
	 * Check if a user exist
	 * 
	 * @param pUser
	 * @return
	 */
	public boolean checkUser(User pUser) {
		String requete = "SELECT IdUser,NomUser,PrenomUser,DateNaissance FROM Users WHERE NomUser = ? and PrenomUser = ? and DateNaissance = ?;";
		String requete2 = "SELECT IdUser,NomUser,PrenomUser,DateNaissance FROM Users WHERE IdUser = ?;";
		Connection myConnect;
		boolean check = false;
		try {

			myConnect = DataBaseConnection.connectionBaseDonnes();

			PreparedStatement statement = null;
			if (pUser.getId() == 0) {
				statement = myConnect.prepareStatement(requete);
				statement.setString(1, pUser.getfName());
				statement.setString(2, pUser.getlName());
				statement.setString(3, pUser.getBirthDate());
			} else {
				statement = myConnect.prepareStatement(requete2);
				statement.setInt(1, pUser.getId());
			}

			ResultSet resultat = statement.executeQuery();

			check = resultat.next();

			statement.close();
			myConnect.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return check;
	}

	/**
	 * Method to add a user
	 * 
	 * @param pUser
	 * @return
	 */
	public int addUser(User pUser) {

		if (checkUser(pUser) == false) {
			String requete = "INSERT INTO `users` (`NomUser`, `PrenomUser`, `DateNaissance`) VALUES (?, ?, ?);";
			String requete2 = "INSERT INTO `usersaccount` (`IdUser`, `Login`, `Password`) VALUES (?, ?, ?);";
			Connection myConnect;
			int idUser = 0;
			try {

				myConnect = DataBaseConnection.connectionBaseDonnes();
				PreparedStatement statement = myConnect.prepareStatement(requete);
				statement.setString(1, pUser.getfName());
				statement.setString(2, pUser.getlName());
				statement.setString(3, pUser.getBirthDate());
				statement.executeUpdate();
				statement.close();
				myConnect.close();

				idUser = getIdUser(pUser);

				if (pUser.getLogin() != null && pUser.getPassword() != null) {
					myConnect = DataBaseConnection.connectionBaseDonnes();
					statement = myConnect.prepareStatement(requete2);
					statement.setInt(1, idUser);
					statement.setString(2, pUser.getLogin());
					statement.setString(3, pUser.getPassword());
					statement.executeUpdate();
					statement.close();
					myConnect.close();
				}
				return getIdUser(pUser);

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			return getIdUser(pUser);
		}
		return -1;
	}

	/**
	 * Method to update a user
	 * 
	 * @param pUser
	 * @return
	 */
	public int updateUser(User pUser) {

		if (checkUser(pUser) == true) {

			String requete = "UPDATE `users` SET `NomUser` = ?, `PrenomUser` = ?, `DateNaissance` = ? WHERE `users`.`IdUser` = ?;";
			String requete2 = "UPDATE `usersaccount` SET `Login` = ?, `Password` = ? WHERE `usersaccount`.`IdUserAccount` = ?;";
			Connection myConnect;
			try {

				myConnect = DataBaseConnection.connectionBaseDonnes();
				PreparedStatement statement = myConnect.prepareStatement(requete);
				statement.setString(1, pUser.getfName());
				statement.setString(2, pUser.getlName());
				statement.setString(3, pUser.getBirthDate());
				statement.setInt(4, pUser.getId());
				statement.executeUpdate();
				statement.close();
				myConnect.close();

				if (pUser.getLogin() != null && pUser.getPassword() != null) {
					myConnect = DataBaseConnection.connectionBaseDonnes();
					statement = myConnect.prepareStatement(requete2);
					statement.setString(1, pUser.getLogin());
					statement.setString(2, pUser.getPassword());
					statement.setInt(3, pUser.getId());
					statement.executeUpdate();
					statement.close();
					myConnect.close();
				}
				return pUser.getId();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			return addUser(pUser);
		}
		return -1;
	}

	/**
	 * Method to delete a user
	 * 
	 * @param id
	 * @return
	 */
	public int deleteUser(int id) {

		User pUser = getUser(id);
		if (pUser != null && checkUser(pUser) == true) {
			String requete = "DELETE FROM `users` WHERE IdUser = ?;";
			Connection myConnect;
			try {

				myConnect = DataBaseConnection.connectionBaseDonnes();
				PreparedStatement statement = myConnect.prepareStatement(requete);
				statement.setInt(1, id);

				statement.executeUpdate();

				statement.close();
				myConnect.close();

				return pUser.getId();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return -1;
	}

	/**
	 * Check if a login and password of a user is valid
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	public boolean isValidLogin(String login, String password) {
		List<User> listeUser = getAllUsers();
		for (User user : listeUser) {
			if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;

	}

}
