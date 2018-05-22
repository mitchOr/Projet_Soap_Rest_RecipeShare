package com.Services;

public class UserServicesProxy implements com.Services.UserServices {
  private String _endpoint = null;
  private com.Services.UserServices userServices = null;
  
  public UserServicesProxy() {
    _initUserServicesProxy();
  }
  
  public UserServicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initUserServicesProxy();
  }
  
  private void _initUserServicesProxy() {
    try {
      userServices = (new com.Services.UserServicesServiceLocator()).getUserServices();
      if (userServices != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)userServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)userServices)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (userServices != null)
      ((javax.xml.rpc.Stub)userServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.Services.UserServices getUserServices() {
    if (userServices == null)
      _initUserServicesProxy();
    return userServices;
  }
  
  public com.Entites.User getUserbyLogPass(java.lang.String login, java.lang.String pass) throws java.rmi.RemoteException{
    if (userServices == null)
      _initUserServicesProxy();
    return userServices.getUserbyLogPass(login, pass);
  }
  
  public java.lang.String updateUser(int id, java.lang.String fName, java.lang.String lName, java.lang.String birthDate, java.lang.String login, java.lang.String password) throws java.rmi.RemoteException{
    if (userServices == null)
      _initUserServicesProxy();
    return userServices.updateUser(id, fName, lName, birthDate, login, password);
  }
  
  public java.lang.String deleteUser(int userid) throws java.rmi.RemoteException{
    if (userServices == null)
      _initUserServicesProxy();
    return userServices.deleteUser(userid);
  }
  
  public com.Entites.User[] getUsers() throws java.rmi.RemoteException{
    if (userServices == null)
      _initUserServicesProxy();
    return userServices.getUsers();
  }
  
  public com.Entites.User getUser(int userid) throws java.rmi.RemoteException{
    if (userServices == null)
      _initUserServicesProxy();
    return userServices.getUser(userid);
  }
  
  public java.lang.String createUser(int id, java.lang.String fName, java.lang.String lName, java.lang.String birthDate, java.lang.String login, java.lang.String password) throws java.rmi.RemoteException{
    if (userServices == null)
      _initUserServicesProxy();
    return userServices.createUser(id, fName, lName, birthDate, login, password);
  }
  
  
}