package sample.dao;

import sample.Lecturer;
import sample.LecturerSubject;
import sample.TeacherAssistant;

import java.sql.*;

public class LecturerDaoImp
{
    public static void findALL()
    {

        Connection connection=DBConnection.getConnection ();


        if (connection==null)
        {
            return;
        }

        String query="SELECT * FROM lecturers";

        try
        {
            Statement statement=connection.createStatement ();
            ResultSet resultSet= statement.executeQuery (query);

            while (resultSet.next ())
            {

                String name=resultSet.getString ("lname");
                String id=resultSet.getString ("lid");
                String subname=resultSet.getString ("sName");

                for (int i = 0; i< LecturerSubject.LecturerSubjects.size (); i++)
                {
                    if(LecturerSubject.LecturerSubjects.get(i).GetName ().equals (subname))
                    {
                        Lecturer lecturer=new Lecturer (name,id,LecturerSubject.LecturerSubjects.get (i));
                        Lecturer.LecturersList.add (lecturer);
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


    public static void save(Lecturer lecturer)
    {
        String Subname=lecturer.GetNameOfSub ();

        Connection connection=DBConnection.getConnection ();

        if(connection==null)
        {
            return;
        }

        String query= "INSERT INTO lecturers (lname,lid,sName) VALUES (?,?,?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement (query);)
        {

            preparedStatement.setString (1,lecturer.GetName ());
            preparedStatement.setString (2,lecturer.GetID ());
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
