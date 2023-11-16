package sample.dao;

import sample.LecturerSubject;
import sample.Subject;
import sample.TeacherAssistant;

import java.sql.*;

public class TaDaoImp
{
    public static void findALL()
    {

        Connection connection=DBConnection.getConnection ();


        if (connection==null)
        {
            return;
        }

        String query="SELECT * FROM ta";

        try
        {
            Statement statement=connection.createStatement ();
            ResultSet resultSet= statement.executeQuery (query);

            while (resultSet.next ())
            {

                String name=resultSet.getString ("name");
                String id=resultSet.getString ("taid");
                String subname=resultSet.getString ("subName");

                for (int i=0;i< LecturerSubject.LecturerSubjects.size ();i++)
                {
                    if(LecturerSubject.LecturerSubjects.get(i).GetName ().equals (subname))
                    {
                        TeacherAssistant teacherAssistant=new TeacherAssistant (name,id,LecturerSubject.LecturerSubjects.get (i));
                        TeacherAssistant.TeacherAssistantsList.add (teacherAssistant);
                    }
                }





            }
        }
        catch (SQLException e)
        {
            e.printStackTrace ();
        }
        finally
        {
            try
            {
                connection.close ();
            }
            catch (SQLException exception)
            {
                exception.printStackTrace ();
            }
        }


    }


    public static void save(TeacherAssistant teacherAssistant)
    {
        String Subname=teacherAssistant.GetNameOfSub ();

        Connection connection=DBConnection.getConnection ();

        if(connection==null)
        {
            return;
        }

        String query= "INSERT INTO ta (name,taid,subName) VALUES (?,?,?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement (query);)
        {

            preparedStatement.setString (1,teacherAssistant.GetName ());
            preparedStatement.setString (2,teacherAssistant.GetID ());
            preparedStatement.setString (3,Subname);


            preparedStatement.executeUpdate ();

        }
        catch (SQLException e)
        {
            e.printStackTrace ();
        }
        finally {

            try
            {
                connection.close ();
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace ();
            }
        }


    }
}
