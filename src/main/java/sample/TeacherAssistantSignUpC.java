package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.dao.LSubjectDaoImp;
import sample.dao.TaDaoImp;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherAssistantSignUpC implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField ID;
    @FXML
    private ComboBox SemCombo;
    @FXML
    private ChoiceBox SubCombo;

    @FXML
    public void ComboOfSem(ActionEvent event)
    {
        SubCombo.getItems ().clear ();


        if(SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 1")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 1"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 2")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 2"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 3")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 3"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 4")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 4"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 5")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 5"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 6")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 6"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 7")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 7"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 8")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 8"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 9")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 9"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }
        else if (SemCombo.getSelectionModel ().getSelectedItem ()=="Semester 10")
        {
            for (int i=0;i<Subject.SubjectsList.size ();i++)
            {

                if (Subject.SubjectsList.get (i).getSemester ().equals ("Semester 10"))
                {
                    SubCombo.getItems().add (Subject.SubjectsList.get (i).Name);
                }
            }
        }

    }

    @FXML
    public void Save(ActionEvent event) throws Exception
    {
        if(Name.getText ().isEmpty () || ID.getText ().isEmpty () || SemCombo.getItems ().isEmpty () || SubCombo.getItems ().isEmpty ())
        {
            Alert alert1=new Alert (Alert.AlertType.ERROR);
            alert1.setTitle ("Error");
            alert1.setContentText ("Please fill in all the required fields.");
            alert1.showAndWait ();
        }
        else
        {
            boolean flagId=true;
            boolean flagSub=true;


            for (int i=0;i<TeacherAssistant.TeacherAssistantsList.size ();i++)
            {
                if(TeacherAssistant.TeacherAssistantsList.get (i).Id.equals (ID.getText ()))
                {
                    flagId=false;
                }
            }
            for(int i=0;i<TeacherAssistant.TeacherAssistantsList.size ();i++)
            {
                if(TeacherAssistant.TeacherAssistantsList.get(i).Sub.Name==SubCombo.getSelectionModel ().getSelectedItem ());
                {
                    flagSub=false;
                }
            }

            if (flagId==false)
            {
                Alert alert3=new Alert (Alert.AlertType.ERROR);
                alert3.setTitle ("Error");
                alert3.setContentText ("This ID is Already In Use.");
                alert3.showAndWait ();

            }
            else if (flagSub==false)
            {
                Alert alert3=new Alert (Alert.AlertType.ERROR);
                alert3.setTitle ("Error");
                alert3.setContentText ("This Subject is Already In Use.");
                alert3.showAndWait ();
            }
            else
                {
                    boolean flag=true;
                    int x=0;
                    for(int i=0;i<LecturerSubject.LecturerSubjects.size ();i++)
                    {
                        if(LecturerSubject.LecturerSubjects.get (i).GetName ().equals (SubCombo.getSelectionModel ().getSelectedItem ().toString ()))
                        {
                            flag=false;
                            x=i;
                            break;
                        }
                    }

                    if(flag)
                    {
                        LecturerSubject lecturerSubject =new LecturerSubject (SubCombo.getSelectionModel ().getSelectedItem ().toString (),SemCombo.getSelectionModel ().getSelectedItem ().toString ());
                        TeacherAssistant teacherAssistant=new TeacherAssistant (Name.getText (),ID.getText (),lecturerSubject);

                        //LecturerSubject.LecturerSubjects.add (lecturerSubject);
                        TeacherAssistant.TeacherAssistantsList.add (teacherAssistant);
                        LSubjectDaoImp.save (lecturerSubject);
                        TaDaoImp.save (teacherAssistant);
                    }
                    else
                    {
                        TeacherAssistant teacherAssistant=new TeacherAssistant (Name.getText (),ID.getText (),LecturerSubject.LecturerSubjects.get (x));
                        TeacherAssistant.TeacherAssistantsList.add (teacherAssistant);
                        TaDaoImp.save (teacherAssistant);
                    }







                    Alert alert2=new Alert (Alert.AlertType.CONFIRMATION);
                    alert2.setTitle ("Done");
                    alert2.setContentText ("Saved");
                    alert2.showAndWait ();

                }


            }


        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list= FXCollections.observableArrayList ("Semester 1","Semester 2","Semester 3",
                "Semester 4","Semester 5","Semester 6", "Semester 7","Semester 8","Semester 9","Semester 10");

        SemCombo.setItems (list);





    }



}
