package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.dao.StudentDaoImp;

public class StudentSignUpC {

    @FXML
    private TextField Name;
    @FXML
    private TextField Reg;

    @FXML

    public void Save(ActionEvent event)
    {
        if(Name.getText ().isEmpty () || Reg.getText ().isEmpty ())
        {
            Alert alert1=new Alert (Alert.AlertType.ERROR);
            alert1.setTitle ("Error");
            alert1.setContentText ("Please fill in all the required fields.");
            alert1.showAndWait ();
        }
        else
        {
            boolean flag=true;
            for (int i=0;i<Student.StudentsList.size ();i++)
            {
                if(Student.StudentsList.get (i).Id.equals (Reg.getText ()))
                {
                    flag=false;
                }
            }

            if(flag)
            {
                Student student=new Student (Name.getText (),Reg.getText ());
                Student.StudentsList.add (student);
                StudentDaoImp.save (student);
                Alert alert2=new Alert (Alert.AlertType.CONFIRMATION);
                alert2.setTitle ("Done");
                alert2.setContentText ("Saved");
                alert2.showAndWait ();
            }
            else
            {
                Alert alert3=new Alert (Alert.AlertType.ERROR);
                alert3.setTitle ("Error");
                alert3.setContentText ("This Reg is Already In Use.");
                alert3.showAndWait ();
            }


        }
    }
}
