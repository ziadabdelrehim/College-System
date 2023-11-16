package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.dao.SubjectDaoImp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class AdminViewC implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField Code;
    @FXML
    private TextField Hours;
    @FXML
    private ComboBox SemCombo;

    @FXML
    public void Add(ActionEvent event) throws IOException
    {
        if(Name.getText ().isEmpty () || Code.getText ().isEmpty ()|| Hours.getText ().isEmpty () || SemCombo.getItems ().isEmpty ())
        {
            Alert alert1=new Alert (Alert.AlertType.ERROR);
            alert1.setTitle ("Error");
            alert1.setContentText ("Please fill in all the required fields.");
            alert1.showAndWait ();
        }
        else
            {
            Subject subject = new Subject (Name.getText (), Code.getText (), Integer.parseInt (Hours.getText ()),
                    SemCombo.getSelectionModel ().getSelectedItem ().toString ());

            Subject.SubjectsList.add (subject);

            SubjectDaoImp.save (subject);

            Alert alert2=new Alert (Alert.AlertType.CONFIRMATION);
            alert2.setTitle ("Done");
            alert2.setContentText ("Added");
            alert2.showAndWait ();
            }


    }

    @FXML
    public void SemCombo(ActionEvent event)
    {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<String> list= FXCollections.observableArrayList ("Semester 1","Semester 2","Semester 3",
                "Semester 4","Semester 5","Semester 6", "Semester 7","Semester 8","Semester 9","Semester 10");
        SemCombo.setItems (list);
    }



}
