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

public class BankApplication {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
        BankingOperation bankingoperation=new BankingOperation();
        UserInterest userinterest=new UserInterest();
        UserTransactionHistory usertransactionhistory=new UserTransactionHistory();
        System.out.println("Welcome to the Nitheesh's online banking service's :");
        while(true)
        {
        try
        { 
        System.out.println("Enter the option for Banking operation");
        System.out.println("1.Create new Bank Account");
        System.out.println("2.Deposit Your Amount");
        System.out.println("3.Withraw Your Amount");
        System.out.println("4.To calculate Interest Amount for your Loan");
        System.out.println("5.To view Your Account Details");
        System.out.println("6.To view you're Transaction History");
        System.out.println("7.Exit the Banking operation");
        String Userchoice=input.next();
        switch(Userchoice)
        {
            case "1":
                bankingoperation.CreateNewBankAccount();
                break;
            case "2":
                bankingoperation.DepositeUserMoney();
                break;
            case "3":
                bankingoperation.WithdrawUserMoney();
                break;
            case "4":
                System.out.println("Please choose the Below option's :\n1.Simple Interest\n2.Compound Interest\n3.Main menu\n4.Exit\n");
                String InterestOption=input.next();
                switch(InterestOption)
                {
                    case "1":
                        userinterest.calculatesimpleinterest();
                        break;
                    case "2":
                        userinterest.calculatecompoundinterest();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.exit(0);
                }
                break;
            case "5":
                bankingoperation.DisplayUserAccountDetails();
                break;
            case "6":
                usertransactionhistory.usertransactionhistory();
                break;
            case "7":
                System.out.println("************ Thank you for using our service! Have a GREAT DAY **************");
                System.exit(0);
            default:
                throw new InValidInputException("Please Enter the correct choice.\n");
        }
            
    }
    catch(InValidInputException e)
    {
        System.out.println("You're enter the invalid choice.\n"+e);
    }
   }
 }
}