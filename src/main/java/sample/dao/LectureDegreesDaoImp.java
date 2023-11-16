package sample.dao;

import sample.LectureDegrees;
import sample.LecturerSubject;

import java.sql.*;

public class LectureDegreesDaoImp
{

    public static void findALL()
    {

        Connection connection=DBConnection.getConnection ();


        if (connection==null)
        {
            return;
        }

        String query="SELECT * FROM LD";

        try
        {
            Statement statement=connection.createStatement ();
            ResultSet resultSet= statement.executeQuery (query);

            while (resultSet.next ())
            {

                String id=resultSet.getString ("ldID");
                String sname=resultSet.getString ("ldSub");
                int s=resultSet.getInt ("ldS");
                int tw=resultSet.getInt ("ldTW");
                int ten=resultSet.getInt ("ldTen");
                int f=resultSet.getInt ("ldFinal");


                LectureDegrees lectureDegrees=new LectureDegrees (id,sname,s,tw,ten,f);


                LectureDegrees.LDList.add (lectureDegrees);



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


    public static void save(LectureDegrees lectureDegrees)
    {

        Connection connection=DBConnection.getConnection ();

        if(connection==null)
        {
            return;
        }

        String query= "INSERT INTO LD (ldID,ldSub,ldS,ldTW,ldTen,ldFinal) VALUES (?,?,?,?,?,?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement (query);)
        {

            preparedStatement.setString (1,lectureDegrees.getReg ());
            preparedStatement.setString (2,lectureDegrees.getSubName ());
            preparedStatement.setInt (3,lectureDegrees.getSeventh20 ());
            preparedStatement.setInt (4,lectureDegrees.getTwelfth15 ());
            preparedStatement.setInt (5,lectureDegrees.getTen ());
            preparedStatement.setInt (6,lectureDegrees.getFinal ());



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
