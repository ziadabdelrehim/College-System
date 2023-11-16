package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.dao.LectureDegreesDaoImp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class LecturerViewC implements Initializable
{
    @FXML
    private Label NameLabel;

    @FXML
    private Label IdLabel;

    @FXML
    private Label SubLabel;

    private String Sname;

    @FXML
    private ChoiceBox StudentBox;

    @FXML
    private TextField SText;

    @FXML
    private  TextField TText;

    @FXML
    private TextField TenText;

    @FXML
    private TextField FinalText;


    @FXML
    public void Print() throws IOException
    {
        if(StudentBox.getItems ().isEmpty ())
        {
            Alert alert=new Alert (Alert.AlertType.ERROR);
            alert.setTitle ("Error");
            alert.setContentText ("You Don't Have Any Students");
            alert.showAndWait ();
        }
        else
        {
            File file=new File ("StudentsFile.txt");

            try {
                PrintWriter w=new PrintWriter (file);

                for(int i=0;i<StudentBox.getItems ().size ();i++)
                {
                    w.println (StudentBox.getItems ().get (i));
                }

                w.close ();

            }
            catch (FileNotFoundException e)
            {
                System.out.println ("File Not Found");
            }
            Alert alert1=new Alert (Alert.AlertType.CONFIRMATION);
            alert1.setTitle ("Done");
            alert1.setContentText ("Printed");
            alert1.showAndWait ();

        }

    }




    @FXML
    public void Insert() throws IOException
    {
        if (StudentBox.getItems ().isEmpty () || SText.getText ().isEmpty () || TText.getText ().isEmpty () || TenText.getText ().isEmpty () || FinalText.getText ().isEmpty ())
        {
            Alert alert1=new Alert (Alert.AlertType.ERROR);
            alert1.setTitle ("Error");
            alert1.setContentText ("Please fill in all the required fields.");
            alert1.showAndWait ();
        }
        else if(Integer.parseInt (SText.getText ())>20 || Integer.parseInt (TText.getText ())>15 || Integer.parseInt (TenText.getText ()) >10 || Integer.parseInt (FinalText.getText ())>40)
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
                    LectureDegrees lectureDegrees = new LectureDegrees (ID,SubLabel.getText (),Integer.parseInt (SText.getText ()),
                            Integer.parseInt (TText.getText ()),Integer.parseInt (TenText.getText ()),Integer.parseInt (FinalText.getText ()));
                    LectureDegrees.LDList.add (lectureDegrees);

                    LectureDegreesDaoImp.save (lectureDegrees);

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
        TenText.clear ();
        TText.clear ();
        FinalText.clear ();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {



        for (int i=0;i<Lecturer.LecturersList.size ();i++)
        {
            if(Lecturer.LecturersList.get (i).Id.equals (MainView.LecturerId))
            {

                NameLabel.setText (Lecturer.LecturersList.get (i).Name);
                IdLabel.setText (Lecturer.LecturersList.get (i).Id);

                SubLabel.setText (Lecturer.LecturersList.get (i).Sub.Name);

                Sname=Lecturer.LecturersList.get (i).Sub.Name;



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
