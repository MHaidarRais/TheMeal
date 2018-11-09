package com.rais.haidar.themeal.Main.Model.ModelCategory;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseCategory{

	@SerializedName("categories")
	private List<CategoriesItem> categories;

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	@Override
 	public String toString(){
		return 
			"ResponseCategory{" + 
			"categories = '" + categories + '\'' + 
			"}";
		}
}