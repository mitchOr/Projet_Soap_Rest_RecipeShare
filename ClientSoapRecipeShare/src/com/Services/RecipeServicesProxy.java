package com.Services;

public class RecipeServicesProxy implements com.Services.RecipeServices {
  private String _endpoint = null;
  private com.Services.RecipeServices recipeServices = null;
  
  public RecipeServicesProxy() {
    _initRecipeServicesProxy();
  }
  
  public RecipeServicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initRecipeServicesProxy();
  }
  
  private void _initRecipeServicesProxy() {
    try {
      recipeServices = (new com.Services.RecipeServicesServiceLocator()).getRecipeServices();
      if (recipeServices != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)recipeServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)recipeServices)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (recipeServices != null)
      ((javax.xml.rpc.Stub)recipeServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.Services.RecipeServices getRecipeServices() {
    if (recipeServices == null)
      _initRecipeServicesProxy();
    return recipeServices;
  }
  
  public java.lang.String createRecipe(java.lang.String text, java.lang.String creationDate, int author) throws java.rmi.RemoteException{
    if (recipeServices == null)
      _initRecipeServicesProxy();
    return recipeServices.createRecipe(text, creationDate, author);
  }
  
  public java.lang.String deleteRecipe(int recipeId) throws java.rmi.RemoteException{
    if (recipeServices == null)
      _initRecipeServicesProxy();
    return recipeServices.deleteRecipe(recipeId);
  }
  
  public java.lang.String updateRecipe(int id, java.lang.String text, java.lang.String creationDate, int author) throws java.rmi.RemoteException{
    if (recipeServices == null)
      _initRecipeServicesProxy();
    return recipeServices.updateRecipe(id, text, creationDate, author);
  }
  
  public com.Entites.Recipe getRecipeByID(int recipeId) throws java.rmi.RemoteException{
    if (recipeServices == null)
      _initRecipeServicesProxy();
    return recipeServices.getRecipeByID(recipeId);
  }
  
  public com.Entites.Recipe[] getRecipes() throws java.rmi.RemoteException{
    if (recipeServices == null)
      _initRecipeServicesProxy();
    return recipeServices.getRecipes();
  }
  
  public com.Entites.Recipe[] getRecipesByID(int userid) throws java.rmi.RemoteException{
    if (recipeServices == null)
      _initRecipeServicesProxy();
    return recipeServices.getRecipesByID(userid);
  }
  
  
}