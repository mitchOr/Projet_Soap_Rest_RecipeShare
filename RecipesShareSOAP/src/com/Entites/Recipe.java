package com.Entites;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.*;

/**
 * Class Recipe
 * @author MichelNGATIMO
 *
 */
@XmlRootElement
public class Recipe implements Serializable{

	 private static final long serialVersionUID = 1L;
	 private int id;
	 private String text;
	 private String creationDate;
	 private int Author;
	 
	 /**
	  * Constructors
	  * @param id
	  * @param text
	  * @param creationDate
	  * @param author
	  */
	 public Recipe(int id, String text, String creationDate, int author) {
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
		this.id=0;
		this.text = text;
		this.creationDate = creationDate;
		Author = author;
	}
	 /**
	  * constructeur
	  * @param text
	  */
	public Recipe(String text) {
		this.text = text;
	}
	
	


	/**
	 * contructeur
	 */
	public Recipe() {
		
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
