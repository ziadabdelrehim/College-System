package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.dao.SectionDegreesDaoImp;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherAssistantViewC implements Initializable {

    @FXML
    private Label NameLabel;

    @FXML
    private Label IdLabel;

    @FXML
    private ChoiceBox StudentBox;

    @FXML
    private Label SubLabel;

    @FXML
    private TextField SText;

    @FXML
    private  TextField TText;

    private String Sname;


    @FXML
    public void Insert() throws IOException
    {
        if (StudentBox.getItems ().isEmpty () || SText.getText ().isEmpty () || TText.getText ().isEmpty ())
        {
            Alert alert1=new Alert (Alert.AlertType.ERROR);
            alert1.setTitle ("Error");
            alert1.setContentText ("Please fill in all the required fields.");
            alert1.showAndWait ();
        }
        else if(Integer.parseInt (SText.getText ())>10 || Integer.parseInt (TText.getText ())>5)
        {
            Alert alert2=new Alert (Alert.AlertType.ERROR);
            alert2.setTitle ("Error");
            alert2.setContentText ("Out Of Range.");
            alert2.showAndWait ();
        }
        else
        {
            String ID;
            for(int i=0; i<Student.StudentsList.size ();i++)
            {
                if (Student.StudentsList.get (i).Name.equals (StudentBox.getSelectionModel ().getSelectedItem ()))
                {
                    ID=Student.StudentsList.get (i).Id;

                    SectionDegrees sectionDegrees=new SectionDegrees (ID,SubLabel.getText (),Integer.parseInt (SText.getText ()),
                            Integer.parseInt (TText.getText ()));
                    SectionDegrees.ListOfSD.add (sectionDegrees);

                    SectionDegreesDaoImp.save (sectionDegrees);

                    Alert alert2=new Alert (Alert.AlertType.CONFIRMATION);
                    alert2.setTitle ("Done");
                    alert2.setContentText ("Added.");
                    alert2.showAndWait ();
                    break;
                }

            }


        }
        StudentBox.getSelectionModel ().clearSelection ();
        SText.clear ();
        TText.clear ();

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {



        for (int i=0;i<TeacherAssistant.TeacherAssistantsList.size ();i++)
        {
            if(TeacherAssistant.TeacherAssistantsList.get (i).Id.equals (MainView.TeacherID))
            {

                NameLabel.setText (TeacherAssistant.TeacherAssistantsList.get (i).Name);
                IdLabel.setText (TeacherAssistant.TeacherAssistantsList.get (i).Id);
                SubLabel.setText (TeacherAssistant.TeacherAssistantsList.get (i).GetNameOfSub ());


                Sname=TeacherAssistant.TeacherAssistantsList.get (i).GetNameOfSub ();





            }
        }


        for (int j=0;j<StudentSubject.StudentSubjects.size ();j++)
        {

            if(StudentSubject.StudentSubjects.get (j).GetName ().equals (Sname))
            {

                for (int k=0;k<Student.StudentsList.size ();k++)
                {
                    if (Student.StudentsList.get (k).Id.equals (StudentSubject.StudentSubjects.get (j).getReg ()))
                    {

                        StudentBox.getItems ().add (Student.StudentsList.get (k).GetName ());
                    }
                }
            }
        }


    }
}
