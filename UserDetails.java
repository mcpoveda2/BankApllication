/*
@Banking application - With the help of this application we can create new bank 
account and other banking operation's.
@Author      - Nitheesh G.
@Created at  - 02-11-2021
@Updated at  - 02-16-2021
@Reviewed by - Anto
*/
package bankapplication;
import java.util.LinkedList;
import java.util.Queue;

public class UserDetails {
    static long uniquenumber=1010106001;
    private String firstname;
    private String lastname;
    private int age,balanceamount;
    private String mobilenumber;
    private String aadharnumber;
    static long accountnumber;
    Queue<History>TransactionHistory;

    UserDetails() 
    {
        this.TransactionHistory = new LinkedList<>();
    }
    public void setAccountnumber()
    {
        UserDetails.accountnumber=uniquenumber;
        uniquenumber++;
    }
    public long getAccountnumber()
    {
        return accountnumber;
    }
    public void setBalanceamount(int balanceamount)
    {
        this.balanceamount=balanceamount;
    }
    public int getBalanceamount()
    {
        return balanceamount;
    }
    public String getFirstname()
    {
        return firstname;
    }
    public void setFirstname(String firstname)
    {
        this.firstname=firstname;
    }
    public String getLastname()
    {
        return lastname;
    }
    public void setLastname(String lastname)
    {
        this.lastname=lastname;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public String getMobilenumber()
    {
        return mobilenumber;
    }
    public void setMobilenumber(String mobilenumber)
    {
        this.mobilenumber=mobilenumber;
    }
    public String getAadharnumber()
    {
        return aadharnumber;
    }
    public void setAadharnumber(String aadharnumber)
    {
        this.aadharnumber=aadharnumber;
    }
}