package org.koushik.javabrains.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by van on 6/18/15.
 */
public class ProductServiceImpl {
    List<String> bookList = new ArrayList<>();
    List<String> musicList = new ArrayList<>();
    List<String> movieList = new ArrayList<>();

    public ProductServiceImpl() {
        bookList.add("Java");
        bookList.add("Python");
        bookList.add("Servlet");

        musicList.add("Beegee");
        musicList.add("Abba");
        musicList.add("Boney M");

        movieList.add("Avatar");
        movieList.add("Interstella");
        movieList.add("Star War");
    }

    public List<String> getProducts(String category){
        switch (category.toLowerCase()){
            case "books":
                return bookList;
            case "musics":
                return musicList;
            case "movies":
                return movieList;
        }
        return null;
    }

    public boolean addProduct(String category, String product){
        switch(category.toLowerCase()){
            case "books":
                bookList.add(product);
                break;
            case "musics":
                musicList.add(product);
                break;
            case "movies":
                movieList.add(product);
                break;
            default:
                return false;


        }
        return true;
    }

    public List<String> getProductCategories(){
        List<String> categories = new ArrayList<String>();
        categories.add("Books");
        categories.add("Music");
        categories.add("Movies");

        return categories;
    }


}
