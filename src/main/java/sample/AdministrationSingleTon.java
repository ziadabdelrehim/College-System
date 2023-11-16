package sample;

public class AdministrationSingleTon extends Person
{
    private static AdministrationSingleTon Admin;



    private AdministrationSingleTon(String name,String id)
    {
        super(name, id);
    }




    public static AdministrationSingleTon GetAdminstrationSingleTon()
    {
        if(Admin==null)
        {
            Admin=new AdministrationSingleTon ("Admin","0");
        }


        return Admin;
    }


}
