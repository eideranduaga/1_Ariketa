/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author DM3-2-05
 */

// Import libraries
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Person;

public class Controller
{
    public static ObservableList <Person> datuakBatu()
    {
        return FXCollections.observableArrayList(
            new Person("Kimetz", "Ugarte", "kugarte@gmail.com", "605112485"),
            new Person("Maddalen", "Jauregi", "mjauregi@gmail.com", "654895412"),
            new Person("Aetz", "Mugaguren", "amugaguren@gmail.com", "658965214"),
            new Person("Amane", "Inza", "ainza@gmail.com", "655326558"),
            new Person("Jurgi", "Zumalde", "jzumalde@gmail.com", "612002857")
        );
    }  
}
