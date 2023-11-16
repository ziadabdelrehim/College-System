package sample;

public abstract class TeachingStaff extends Person
{
    protected LecturerSubject Sub;

    public TeachingStaff()
    {

    }

    public TeachingStaff(String name, String id,LecturerSubject sub)
    {
        super(name, id);
        this.Sub = sub;
    }

    public TeachingStaff(String name,String id)
    {
        this.Name=name;
        this.Id=id;
    }

    public String GetNameOfSub()
    {
        return Sub.GetName();
    }

    @Override
    public String GetName() {
        return super.GetName ();
    }

    @Override
    public String GetID() {
        return super.GetID ();
    }


}
