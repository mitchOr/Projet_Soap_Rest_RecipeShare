package com.RecipesUsers.Entities;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

/**
 * Class Recipe
 * @author MariamKonate
 *
 */
@XmlRootElement(name = "recipe")
public class Recipe implements Serializable{

	 private static final long serialVersionUID = 1L;
	 private int id;
	 private String text;
	 private String creationDate;
	 private int Author;
	 
	 /**
	  * Constructor
	  */
	 public Recipe() {}
	 
	 /**
	  * Constructors
	  * @param id
	  * @param text
	  * @param creationDate
	  * @param author
	  */
	 public Recipe(int id, String text, String creationDate, int author) {
		 super();
		this.id = id;
		this.text = text;
		this.creationDate = creationDate;
		Author = author;
	}
	 
	 /**
	  * Constructors
	  * @param text
	  * @param creationDate
	  * @param author
	  */
	 public Recipe( String text, String creationDate, int author) {
		this.text = text;
		this.creationDate = creationDate;
		Author = author;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	@XmlElement
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	@XmlElement
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the author
	 */
	public int getAuthor() {
		return Author;
	}

	/**
	 * @param author the author to set
	 */
	@XmlElement
	public void setAuthor(int author) {
		Author = author;
	}
	
	/**
	 * Method Equals
     */
   public boolean equals(Object object){
      if(object == null){
         return false;
      }else if(!(object instanceof Recipe)){
         return false;
      }else {
    	  	Recipe recipe = (Recipe)object;
         if(id == recipe.getId()
            && text.equals(recipe.getText())
            && creationDate.equals(recipe.getCreationDate())
            && Author==recipe.getAuthor()
         ){
            return true;
         }			
      }
      return false;
   }	
}
