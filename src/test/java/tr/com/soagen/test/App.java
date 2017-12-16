/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.soagen.test;

import java.util.ArrayList;
import java.util.List;
import tr.com.soagen.presentation.model.AuthorGenreEnum;

/**
 *
 * @author atacankullabci
 */
public class App {
    public static void main(String[] args) {
        List <AuthorGenreEnum> genre = new ArrayList<>();
        
        for(AuthorGenreEnum gnr : genre)
            System.out.println(gnr.getDeclaringClass().getName());
        
        
    }
}
