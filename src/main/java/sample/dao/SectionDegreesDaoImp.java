package sample.dao;

import sample.LectureDegrees;
import sample.SectionDegrees;

import java.sql.*;

public class SectionDegreesDaoImp
{
    public static void findALL()
    {

        Connection connection=DBConnection.getConnection ();


        if (connection==null)
        {
            return;
        }

        String query="SELECT * FROM SD";

        try
        {
            Statement statement=connection.createStatement ();
            ResultSet resultSet= statement.executeQuery (query);

            while (resultSet.next ())
            {

                String id=resultSet.getString ("sdID");
                String sname=resultSet.getString ("sdSub");
                int s=resultSet.getInt ("sdS");
                int tw=resultSet.getInt ("sdTW");


                SectionDegrees sectionDegrees=new SectionDegrees (id,sname,s,tw);

                SectionDegrees.ListOfSD.add (sectionDegrees);



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


    public static void save(SectionDegrees sectionDegrees)
    {

        Connection connection=DBConnection.getConnection ();

        if(connection==null)
        {
            return;
        }

        String query= "INSERT INTO SD (sdID,sdSub,sdS,sdTW) VALUES (?,?,?,?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement (query);)
        {

            preparedStatement.setString (1,sectionDegrees.getReg ());
            preparedStatement.setString (2,sectionDegrees.getSubName ());
            preparedStatement.setInt (3,sectionDegrees.getSeventh10 ());
            preparedStatement.setInt (4,sectionDegrees.getTwelfth5 ());


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
