package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.dao.SSubjectDaoImp;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegestirationC implements Initializable {

    @FXML
    private ComboBox SemCombo;

    @FXML
    private ChoiceBox SubCombo;

    @FXML
    ListView SubjectsList;


    @FXML
    public void ComboOfSem()
    {
        SubCombo.getItems ().clear ();


        if(SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 1")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 1"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 2")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 2"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 3")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 3"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 4")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 4"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 5")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 5"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 6")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 6"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 7")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 7"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 8")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 8"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 9")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 9"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 10")
        {
            for (int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
            {

                if (LecturerSubject.LecturerSubjects.get (i).getSemester ().equals ("Semester 10"))
                {
                    SubCombo.getItems().add (LecturerSubject.LecturerSubjects.get (i).Name);


                }
            }
        }

    }

    @FXML
    public void Add(ActionEvent event) throws IOException
    {
        if(SemCombo.getItems ().isEmpty () || SubCombo.getItems ().isEmpty ())
        {
            Alert alert1=new Alert (Alert.AlertType.ERROR);
            alert1.setTitle ("Error");
            alert1.setContentText ("Please fill in all the required fields.");
            alert1.showAndWait ();
        }
        else
        {

            String Name=SubCombo.getSelectionModel ().getSelectedItem ().toString ();

            StudentSubject studentSubject = new StudentSubject (Name,MainView.LogReg);

            StudentSubject.StudentSubjects.add (studentSubject);

            SSubjectDaoImp.save (studentSubject);




            SubjectsList.getItems ().add (SubCombo.getSelectionModel ().getSelectedItem ());

            Alert alert2=new Alert (Alert.AlertType.CONFIRMATION);
            alert2.setTitle ("Done");
            alert2.setContentText ("Added");
            alert2.showAndWait ();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list= FXCollections.observableArrayList ("Semester 1","Semester 2","Semester 3",
                "Semester 4","Semester 5","Semester 6", "Semester 7","Semester 8","Semester 9","Semester 10");

        SemCombo.setItems (list);


    }
}
