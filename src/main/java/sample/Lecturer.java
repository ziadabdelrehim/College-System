package sample;

import java.util.ArrayList;

public class Lecturer extends TeachingStaff
{

    public static ArrayList<Lecturer> LecturersList=new ArrayList<> ();


    public Lecturer()
    {

    }

    public Lecturer(String name, String id,LecturerSubject sub)
    {
        super(name, id, sub);

    }


    public String GetNameOfSub()
    {
        return super.GetNameOfSub ();
    }

    @Override
    public String GetName() {
        return super.GetName ();
    }

    @Override
    public String GetID() {
        return super.GetID ();
    }

    public void Withdraw(Student student)
    {
        super.Sub.students.remove (student);
    }

}
