package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewC implements Initializable {

    @FXML
    Label NameLabel;

    @FXML
    Label RegLabel;

    @FXML
    public void RegB() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/Regestiration.fxml"));
        Stage stage=new Stage ();
        stage.setTitle("Registration");
        stage.setScene(new Scene (root));
        stage.show();
    }

    public void Results() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/ResultsView.fxml"));
        Stage stage=new Stage ();
        stage.setTitle("Results");
        stage.setScene(new Scene (root));
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i=0;i<Student.StudentsList.size ();i++)
        {
            if(Student.StudentsList.get (i).Id.equals (MainView.LogReg))
            {

                NameLabel.setText (Student.StudentsList.get (i).Name);
                RegLabel.setText (Student.StudentsList.get (i).Id);
            }
        }

    }
}
