package sample;

import java.util.ArrayList;

public class TeacherAssistant extends TeachingStaff
{
    public static ArrayList<TeacherAssistant> TeacherAssistantsList=new ArrayList<> ();
    public TeacherAssistant()
    {

    }

    public TeacherAssistant(String name, String id,LecturerSubject sub)
    {
        super(name, id, sub);

    }

    public TeacherAssistant(String name,String id)
    {
        super(name,id);
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
    public String GetID()
    {
        return super.GetID ();
    }


}
