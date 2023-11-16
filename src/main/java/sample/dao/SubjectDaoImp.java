package sample.dao;

import sample.Subject;

import java.sql.*;



public class SubjectDaoImp {

    public static void findALL()
    {

        Connection connection=DBConnection.getConnection ();


        if (connection==null)
        {
            return;
        }

        String query="SELECT * FROM subjects";

        try
        {
            Statement statement=connection.createStatement ();
            ResultSet resultSet= statement.executeQuery (query);

            while (resultSet.next ())
            {

                String name=resultSet.getString ("subName");
                String code=resultSet.getString ("code");
                int h=resultSet.getInt ("hours");
                String s=resultSet.getString ("sem");


                Subject subject=new Subject (name,code,h,s);


                Subject.SubjectsList.add (subject);



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


    public static void save(Subject subject)
    {

        Connection connection=DBConnection.getConnection ();

        if(connection==null)
        {
            return;
        }

        String query= "INSERT INTO subjects (subName,code,hours,sem) VALUES (?,?,?,?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement (query);)
        {

            preparedStatement.setString (1,subject.GetName ());
            preparedStatement.setString (2,subject.getCode ());
            preparedStatement.setInt (3,subject.getCreditHours ());
            preparedStatement.setString (4,subject.getSemester ());

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
