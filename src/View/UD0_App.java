/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author DM3-2-05
 */

// Import the libraries
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Controller.Controller;
import Model.Person;

public class UD0_App extends Application
{
    // Define the attribute
    private final TableView <Person> tblPerson = new TableView<>();
    final HBox hb = new HBox();
    

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Define the attributes
        Scene sc = new Scene(new Group());
        ObservableList <Person> oblist = Controller.datuakBatu();
        
        // View-an ezaugarrixak
        primaryStage.setTitle("IAAF - International Association of Athletics Federations");
        primaryStage.setWidth(640);
        primaryStage.setHeight(550);
        final Label label = new Label("Atleten datuak");
        label.setFont(new Font("Berlin Sans", 20));
        
        tblPerson.setEditable(true);
        
        // Taulian zutabiak sortu
        TableColumn <Person, String> 
            zutIzena = new TableColumn <> ("Izena");
            zutIzena.setMinWidth(100);
            zutIzena.setCellValueFactory
            (
                new PropertyValueFactory <> ("izena")
            );
            zutIzena.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
            zutIzena.setOnEditCommit
            (
                (TableColumn.CellEditEvent<Person, String> t) -> 
                {
                    ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setIzena(t.getNewValue());
                }
            );
        
        TableColumn <Person, String> 
            zutAbizena = new TableColumn <> ("Abizena");
            zutAbizena.setMinWidth(100);
            zutAbizena.setCellValueFactory
            (
                new PropertyValueFactory <> ("abizena")
            );
            zutAbizena.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
            zutAbizena.setOnEditCommit
            (
                (TableColumn.CellEditEvent<Person, String> t) -> 
                {
                    ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAbizena(t.getNewValue());
                }
            );
            
        TableColumn <Person, String> 
            zutEmaila = new TableColumn<>("Emaila");
            zutEmaila.setMinWidth(200);
            zutEmaila.setCellValueFactory
            (
                new PropertyValueFactory<>("emaila")
            );
            zutEmaila.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
            zutEmaila.setOnEditCommit
            (
                (TableColumn.CellEditEvent<Person, String> t) -> 
                {
                    ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmaila(t.getNewValue());
                }
            );
            
        TableColumn <Person, String> 
            zutTlf = new TableColumn<>("Telefonoa");
            zutTlf.setMinWidth(200);
            zutTlf.setCellValueFactory
            (
                new PropertyValueFactory<>("telefonoa")
            );
            zutTlf.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
            zutTlf.setOnEditCommit
            (
                (TableColumn.CellEditEvent<Person, String> t) -> 
                {
                    ((Person) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEmaila(t.getNewValue());
                }
            ); 
            
        tblPerson.setItems(oblist);
        tblPerson.getColumns().addAll(zutIzena, zutAbizena, zutEmaila, zutTlf);
        
        // Datuak idazteko textField-ak sortu
        TextField tfIzena = new TextField();
        tfIzena.setPromptText("Izena");
        tfIzena.setMaxWidth(110);
        
        TextField tfAbizena = new TextField();
        tfAbizena.setPromptText("Abizena");
        tfAbizena.setMaxWidth(140);
        
        TextField tfEmaila = new TextField();
        tfEmaila.setMaxWidth(300);
        tfEmaila.setPromptText("Emaila");
        
        TextField tfTlf = new TextField();
        tfTlf.setMaxWidth(zutEmaila.getPrefWidth());
        tfTlf.setPromptText("Telefonoa");
            
        // Botoiak sortu
        final Button btnGehitu = new Button("Gehitu");        
        btnGehitu.setOnAction((ActionEvent e) -> 
        {
            Person per = new Person
            (
                tfIzena.getText(),
                tfAbizena.getText(),
                tfEmaila.getText(),
                tfTlf.getText()
            );
            oblist.add(per);
            
            tfIzena.clear();
            tfAbizena.clear();
            tfEmaila.clear();
            tfTlf.clear();
        });
        
        final Button btnEzabatu = new Button("Ezabatu");        
        btnEzabatu.setOnAction((ActionEvent e) -> 
        {
            Person person = tblPerson.getSelectionModel().getSelectedItem();    
            oblist.remove(person);
        });
        
        // 
        hb.getChildren().addAll(tfIzena, tfAbizena, tfEmaila, tfTlf, btnGehitu, btnEzabatu);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tblPerson, hb);
        ((Group) sc.getRoot()).getChildren().addAll(vbox);
        primaryStage.setScene(sc);
        primaryStage.show(); 
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
