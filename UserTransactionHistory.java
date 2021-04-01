/*
@Banking application - With the help of this application we can create new bank 
account and other banking operation's.
@Author      - Nitheesh G.
@Created at  - 02-11-2021
@Updated at  - 02-16-2021
@Reviewed by - Anto
*/
package bankapplication;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
public class UserTransactionHistory {
    void usertransactionhistory()
    {
        @SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
        HashSet<UserDetails>TransactionDetailSet=BankingOperation.UserDetailSet;
        int flag = 0;
        System.out.println("Enter Account number: ");
        int accntNumber = input.nextInt();
        Iterator<UserDetails> iterator = TransactionDetailSet.iterator();
        UserDetails userdetails;
        while(iterator.hasNext())
        {
            userdetails = (UserDetails) iterator.next();
            if(userdetails.getAccountnumber()== accntNumber)
            {
                flag = 1;
                System.out.println("Credit | Debit | Total");
                for(History s : userdetails.TransactionHistory)
                {
                    System.out.println(s.CreditAmount + " | " + s.DebitAmount + " | " + s.TotalAmount+"\n");
                }
                break;
            }
        }
        if(flag == 0)
        {
            System.out.println("BankAccount Not Available\n");
        }
    }
}