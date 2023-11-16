package sample;
import java.sql.*;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.dao.DBConnection;
import sample.dao.SubjectDaoImp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class MainView implements Initializable {



  @FXML
  private TextField Reg;

  @FXML
  private TextField TaField;

  @FXML
  private TextField LecturerID;






    @FXML
    public void AdminWindow() throws IOException
    {

        Parent root = FXMLLoader.load(getClass().getResource("/AdminView.fxml"));
        Stage stage=new Stage ();
        stage.setTitle("Admin");
        stage.setScene(new Scene(root));
        stage.show();





    }



    @FXML
    public void SignUpLec() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/LecturerSignUp.fxml"));
        Stage stage=new Stage ();
        stage.setTitle("Create New Account");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void SignUpTA() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/TeacherAssistantSignUp.fxml"));
        Stage stage=new Stage ();
        stage.setTitle("Create New Account");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void SignUpStudent() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/StudentSignUp.fxml"));
        Stage stage=new Stage ();
        stage.setTitle("Create New Account");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static String LogReg;

    @FXML
    public void StudentLogin() throws IOException
    {

        boolean Flag= false;

        if(Reg.getText ().isEmpty ())
        {
            Alert alert1=new Alert (Alert.AlertType.ERROR);
            alert1.setTitle ("Error");
            alert1.setContentText ("Please fill in all the required fields.");
            alert1.showAndWait ();
        }
        else
        {

            for (int i=0;i<Student.StudentsList.size ();i++)
            {
                if(Student.StudentsList.get (i).Id.equals (Reg.getText ()))
                {
                   Flag=true;
                }
            }
            if(Flag)
            {
                LogReg=Reg.getText ();
                Parent root = FXMLLoader.load(getClass().getResource("/StudentView.fxml"));
                Stage stage=new Stage ();
                stage.setTitle("Student");
                stage.setScene(new Scene(root));
                stage.show();
            }
            else
            {
                Alert alert2=new Alert (Alert.AlertType.ERROR);
                alert2.setTitle ("Error");
                alert2.setContentText ("Wrong ID");
                alert2.showAndWait ();

            }
        }


    }

    public static String TeacherID;

    public void LoginAsTA() throws IOException
    {
        boolean Flag= false;

        if(TaField.getText ().isEmpty ())
        {
            Alert alert1=new Alert (Alert.AlertType.ERROR);
            alert1.setTitle ("Error");
            alert1.setContentText ("You Did Not Enter The ID.");
            alert1.showAndWait ();
        }
        else
        {

            for (int i=0;i<TeacherAssistant.TeacherAssistantsList.size();i++)
            {
                if(TeacherAssistant.TeacherAssistantsList.get (i).Id.equals (TaField.getText ()))
                {
                    Flag=true;
                }
            }
            if(Flag)
            {
                TeacherID=TaField.getText ();
                Parent root = FXMLLoader.load(getClass().getResource("/TeacherAssistantView.fxml"));
                Stage stage=new Stage ();
                stage.setTitle("Teacher Assistant");
                stage.setScene(new Scene(root));
                stage.show();
            }
            else
            {
                Alert alert2=new Alert (Alert.AlertType.ERROR);
                alert2.setTitle ("Error");
                alert2.setContentText ("Wrong ID");
                alert2.showAndWait ();

            }
        }
    }


    public static String LecturerId;

    public void LoginAsLecturer() throws IOException
    {
        boolean Flag= false;

        if(LecturerID.getText ().isEmpty ())
        {
            Alert alert1=new Alert (Alert.AlertType.ERROR);
            alert1.setTitle ("Error");
            alert1.setContentText ("Please fill in all the required fields.");
            alert1.showAndWait ();
        }
        else
        {

            for (int i=0;i<Lecturer.LecturersList.size ();i++)
            {
                if(Lecturer.LecturersList.get (i).Id.equals (LecturerID.getText ()))
                {
                    Flag=true;
                }
            }
            if(Flag)
            {
                LecturerId=LecturerID.getText ();
                Parent root = FXMLLoader.load(getClass().getResource("/LecturerView.fxml"));
                Stage stage=new Stage ();
                stage.setTitle("Lecturer");
                stage.setScene(new Scene(root));
                stage.show();
            }
            else
            {
                Alert alert2=new Alert (Alert.AlertType.ERROR);
                alert2.setTitle ("Error");
                alert2.setContentText ("Wrong ID");
                alert2.showAndWait ();

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}

