/**
 * RecipeServices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.Services;

public interface RecipeServices extends java.rmi.Remote {
    public java.lang.String createRecipe(java.lang.String text, java.lang.String creationDate, int author) throws java.rmi.RemoteException;
    public java.lang.String deleteRecipe(int recipeId) throws java.rmi.RemoteException;
    public java.lang.String updateRecipe(int id, java.lang.String text, java.lang.String creationDate, int author) throws java.rmi.RemoteException;
    public com.Entites.Recipe[] getRecipesByID(int userid) throws java.rmi.RemoteException;
    public com.Entites.Recipe[] getRecipes() throws java.rmi.RemoteException;
    public com.Entites.Recipe getRecipeByID(int recipeId) throws java.rmi.RemoteException;
}
