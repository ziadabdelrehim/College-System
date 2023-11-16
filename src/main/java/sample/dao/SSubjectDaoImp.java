package sample.dao;

import sample.LecturerSubject;
import sample.StudentSubject;

import java.sql.*;

public class SSubjectDaoImp
{

    public static void findALL()
    {

        Connection connection=DBConnection.getConnection ();


        if (connection==null)
        {
            return;
        }

        String query="SELECT * FROM sSubjects";

        try
        {
            Statement statement=connection.createStatement ();
            ResultSet resultSet= statement.executeQuery (query);

            while (resultSet.next ())
            {

                String name=resultSet.getString ("sSubName");
                String reg=resultSet.getString ("sSubReg");


                StudentSubject studentSubject =new StudentSubject (name,reg);


                StudentSubject.StudentSubjects.add (studentSubject);



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


    public static void save(StudentSubject studentSubject)
    {

        Connection connection=DBConnection.getConnection ();

        if(connection==null)
        {
            return;
        }

        String query= "INSERT INTO sSubjects (sSubName,sSubReg) VALUES (?,?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement (query);)
        {

            preparedStatement.setString (1,studentSubject.GetName ());
            preparedStatement.setString (2,studentSubject.getReg ());


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
