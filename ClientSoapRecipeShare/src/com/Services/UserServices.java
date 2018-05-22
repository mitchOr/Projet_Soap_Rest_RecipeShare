/**
 * UserServices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.Services;

public interface UserServices extends java.rmi.Remote {
    public com.Entites.User getUserbyLogPass(java.lang.String login, java.lang.String pass) throws java.rmi.RemoteException;
    public java.lang.String updateUser(int id, java.lang.String fName, java.lang.String lName, java.lang.String birthDate, java.lang.String login, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String deleteUser(int userid) throws java.rmi.RemoteException;
    public com.Entites.User[] getUsers() throws java.rmi.RemoteException;
    public com.Entites.User getUser(int userid) throws java.rmi.RemoteException;
    public java.lang.String createUser(int id, java.lang.String fName, java.lang.String lName, java.lang.String birthDate, java.lang.String login, java.lang.String password) throws java.rmi.RemoteException;
}
