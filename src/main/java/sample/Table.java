package sample;

public class Table
{
    private String Subject;
    private int Seventh;
    private int Tw;
    private int Ten;
    private int Final;

    public Table(String subject,int seventh,int tw,int ten,int f)
    {
        this.Subject=subject;
        this.Seventh=seventh;
        this.Tw=tw;
        this.Ten=ten;
        this.Final=f;
    }

    public int getFinal() {
        return Final;
    }

    public int getTen() {
        return Ten;
    }

    public int getSeventh() {
        return Seventh;
    }

    public int getTw() {
        return Tw;
    }

    public String getSubject() {
        return Subject;
    }
}
