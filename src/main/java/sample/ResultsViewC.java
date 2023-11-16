package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultsViewC implements Initializable
{
    @FXML
    private Label GpaLabel;

    @FXML
    private TableView<Table> Table;

    @FXML
    private TableColumn<Table,String> Subject;

    @FXML
    private TableColumn<Table,Integer> Seventh;

    @FXML
    private TableColumn<Table,Integer> Tw;

    @FXML
    private TableColumn<Table,Integer> Ten;

    @FXML
    private TableColumn<Table,Integer> Final;


    @FXML
    public void Calc() throws IOException
    {
        for (int i=0;i<Student.StudentsList.size ();i++)
        {
            if(Student.StudentsList.get (i).Id.equals (MainView.LogReg))
            {
                GpaLabel.setText (String.valueOf (Student.StudentsList.get (i).CalcGPA ()));



            }
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        GpaLabel.setText ("");

        Subject.setCellValueFactory (new PropertyValueFactory<> ("Subject"));
        Seventh.setCellValueFactory (new PropertyValueFactory<> ("Seventh"));
        Tw.setCellValueFactory (new PropertyValueFactory<> ("Tw"));
        Ten.setCellValueFactory (new PropertyValueFactory<> ("Ten"));
        Final.setCellValueFactory (new PropertyValueFactory<> ("Final"));





        for (int i=0;i<LectureDegrees.LDList.size ();i++)
        {


            if(LectureDegrees.LDList.get (i).Reg.equals (MainView.LogReg))
            {
                for(int j=0;j<SectionDegrees.ListOfSD.size ();j++)
                {
                    if(SectionDegrees.ListOfSD.get (j).Reg.equals (MainView.LogReg) && SectionDegrees.ListOfSD.get (j).SubName.equals (LectureDegrees.LDList.get (i).SubName))
                    {
                        Table table=new Table (LectureDegrees.LDList.get (i).SubName,
                                LectureDegrees.LDList.get (i).getSeventh20 ()+SectionDegrees.ListOfSD.get (j).getSeventh10 (),
                                LectureDegrees.LDList.get (i).getTwelfth15 ()+SectionDegrees.ListOfSD
                                        .get (j).getTwelfth5 (),
                                LectureDegrees.LDList.get (i).getTen (),LectureDegrees.LDList.get (i).getFinal ());
                        Table.getItems ().add (table);
                    }
                }

            }

        }















    }
}
