package sample;

public class Person
{
    protected String Name;
    protected String Id;

    public Person()
    {

    }

    public Person(String name,String id)
    {
        this.Name=name;
        this.Id=id;

    }

    public String GetID()
    {
        return this.Id;
    }

    public String GetName()
    {
        return this.Name;
    }
}
