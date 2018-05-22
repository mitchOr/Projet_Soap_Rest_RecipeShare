package com.Services;

public class AuthenticationServiceProxy implements com.Services.AuthenticationService {
  private String _endpoint = null;
  private com.Services.AuthenticationService authenticationService = null;
  
  public AuthenticationServiceProxy() {
    _initAuthenticationServiceProxy();
  }
  
  public AuthenticationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthenticationServiceProxy();
  }
  
  private void _initAuthenticationServiceProxy() {
    try {
      authenticationService = (new com.Services.AuthenticationServiceServiceLocator()).getAuthenticationService();
      if (authenticationService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authenticationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authenticationService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authenticationService != null)
      ((javax.xml.rpc.Stub)authenticationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.Services.AuthenticationService getAuthenticationService() {
    if (authenticationService == null)
      _initAuthenticationServiceProxy();
    return authenticationService;
  }
  
  public boolean connectionUser(java.lang.String login, java.lang.String password) throws java.rmi.RemoteException{
    if (authenticationService == null)
      _initAuthenticationServiceProxy();
    return authenticationService.connectionUser(login, password);
  }
  
  
}