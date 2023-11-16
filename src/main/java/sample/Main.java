package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.dao.*;

import java.util.ArrayList;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        StudentDaoImp.findALL ();
        SubjectDaoImp.findALL ();
        LSubjectDaoImp.findALL ();
        SSubjectDaoImp.findALL ();

        LecturerDaoImp.findALL ();
        TaDaoImp.findALL ();



        LectureDegreesDaoImp.findALL ();
        SectionDegreesDaoImp.findALL ();




        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("College System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch(args);
    }
}
