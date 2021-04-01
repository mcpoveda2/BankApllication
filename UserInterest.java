/*
@Banking application - With the help of this application we can create new bank 
account and other banking operation's.
@Author      - Nitheesh G.
@Created at  - 02-11-2021
@Updated at  - 02-16-2021
@Reviewed by - Anto
*/
package bankapplication;
import java.util.Scanner;

public class UserInterest 
{
    Scanner input=new Scanner(System.in);
    public void calculatesimpleinterest()
    {
        double interestrate=2.70;
        System.out.println("Please enter your Principal(Loan) Amount :");
        double principalamount=input.nextDouble();
        System.out.println("Please enter the number of year's :");
        double years=input.nextDouble();
        double Simpleinterest=interestrate*principalamount*years;
        System.out.println("Your's Simple interest is :");
        System.out.println(Simpleinterest+"\n");        
        
    }

    public void calculatecompoundinterest()
    {
        double interestrate=1.00;
        System.out.println("Enter the Principal amount(Loan) amount :");
        double principalamount=input.nextDouble();
        double numberofyears=(0.06)/12;
        System.out.println("Please enter your Time period :");
        double timeperiods=input.nextDouble();
        double Compound_interest=principalamount*Math.pow(1+(interestrate/numberofyears),numberofyears*timeperiods);
        System.out.println("Your's Compound interest is :");
        System.out.println(Compound_interest+"\n");
    }
}