package sample.dao;

import sample.LecturerSubject;
import sample.Subject;

import java.sql.*;

public class LSubjectDaoImp
{
    public static void findALL()
    {

        Connection connection=DBConnection.getConnection ();


        if (connection==null)
        {
            return;
        }

        String query="SELECT * FROM lsubjects";

        try
        {
            Statement statement=connection.createStatement ();
            ResultSet resultSet= statement.executeQuery (query);

            while (resultSet.next ())
            {

                String name=resultSet.getString ("lsName");
                String sem=resultSet.getString ("lsSem");


                LecturerSubject lecturerSubject=new LecturerSubject (name,sem);


                LecturerSubject.LecturerSubjects.add (lecturerSubject);



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


    public static void save(LecturerSubject lecturerSubject)
    {

        Connection connection=DBConnection.getConnection ();

        if(connection==null)
        {
            return;
        }

        String query= "INSERT INTO lsubjects (lsName,lsSem) VALUES (?,?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement (query);)
        {

            preparedStatement.setString (1,lecturerSubject.GetName ());
            preparedStatement.setString (2,lecturerSubject.getSemester ());


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
