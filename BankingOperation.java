/*
@Banking application - With the help of this application we can create new bank 
account and other banking operation's.
@Author      - Nitheesh G.
@Created at  - 02-11-2021
@Updated at  - 02-16-2021
@Reviewed by - Anto
*/
package bankapplication;

import static java.lang.System.exit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

class BankingOperation implements Transaction
{
    boolean flag;
    Scanner input=new Scanner(System.in);
    static HashSet<UserDetails>UserDetailSet=new HashSet<>();
     void CreateNewBankAccount() // To creating new user bank account
    {
        UserDetails userdetails=new UserDetails();	
        System.out.println("---------------Enter Your Detail's------------------");
        flag=true; // Validating First Name
        while(flag)
        {
        try
        {
        System.out.println("Enter your first Name :");
        String firstname=input.next();
        if(Pattern.matches("[A-Za-z]*",firstname))
        {
             userdetails.setFirstname(firstname);
             flag=false;
        }
        else
        {
            flag=true;
            throw new InvalidFirstNameException("Please provide the correct First Name.\n");
        }
        }
        catch(InvalidFirstNameException e)
        {
            System.out.println("You're Entering the Invaild First Name.\n"+e);
        }
        }
        flag=true; // Validating Last Name
        while(flag)
        {
        try
        {
        System.out.println("Enter your Last Name :");
        String lastname=input.next();
        if(Pattern.matches("[A-Za-z]*",lastname))
        {
             userdetails.setLastname(lastname);
             flag=false;
        }
        else
        {
            flag=true;
            throw new InvalidLastNameException("Please provide the correct Last Name.\n");
        }
        }
        catch(InvalidLastNameException e)
        {
            System.out.println("You're Entering the Invaild Last Name.\n"+e);
        }
        }
        flag=true; // Validating Aadhar Number
        while(flag)
        {
        try
        {
        String AadharRegex = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$";
        System.out.println("Enter your Aadhar Number :");
        String Aadharnumber=input.next();
        if(Aadharnumber.matches(AadharRegex))
        {
           userdetails.setAadharnumber(Aadharnumber);
           flag=false;
        }
        else
        {
            flag=true;
            throw new InvalidAadharException("Please provide the correct Aadhar Number.\n");
        }
        }
        catch(InvalidAadharException e)
        {
            System.out.println("You're Entering the Invaild Aadhar Number.\n"+e);
        }
        }
        flag=true;  // Validating Age
        while(flag) 
        {
        System.out.println("Enter your Age :");
        int age=input.nextInt();
        try
        {
        if(age>=18)
        {
            userdetails.setAge(age);
            flag=false;
        }
        else if((age>=1) && (age<=17))
        {
            System.out.println("You're in under 18, so not eligible to create Bank Account. please Contact You're nearest branch.\n************ Thank you for using our service! Have a GREAT DAY **************");
            exit(0);
        }
        else
        {
            flag=true;
            throw new InvalidAgeException("Please provide the correct age.\n");
        }
        }
        catch(InvalidAgeException e)
        {
            System.out.println("You're Entering the Invaild age.\n"+e);
        }
        }
        flag=true; // Validating Mobile Number
        while(flag)
        {
        try
        {
        String MobileNumberregex = "[6-9]{1}[0-9]{9}"; //(0/91)?
        System.out.println("Enter your Mobile Number :");
        String mobilenumber=input.next();
        if(mobilenumber.length()==10 && mobilenumber.matches(MobileNumberregex))
        {
        userdetails.setMobilenumber(mobilenumber);
        flag=false;
        }
        else
        {
            flag=true;
            throw new InvalidMobileNumberException("Please provide the correct Mobile Number.\n");
        }
        }
        catch(InvalidMobileNumberException e)
        {
            System.out.println("You're Entering the Invaild MoblieNumber.\n"+e);
        }
        }
        //System.out.println("For new account opening, Please deposite the Minimum Balance Amount 1000 in your account:");
        userdetails.setBalanceamount(0);
        userdetails.setAccountnumber();
        UserDetailSet.add(userdetails);
        System.out.println(".....................Your's New Bank account was successfully created......................");
        System.out.println("Your Account Number is : "+userdetails.getAccountnumber());
        System.out.println("Your Account Balance is : "+userdetails.getBalanceamount());
        System.out.println("Your Account Balance is very low, So please depoite money for further transaction's.\n");
    }
    @Override
    public void DepositeUserMoney() //To deposite money
    {    	
    	int Depositeflag = 0;
    	//Pattern pattern=Pattern.compile("[a-zA-Z]*");
    	System.out.println("Enter Account number: ");
    	long accountNumber = input.nextLong();
    	String ConvertAccountNumber=String.valueOf(accountNumber);
    	if(!(Pattern.matches("[a-zA-Z]",ConvertAccountNumber)))
    	{
        Iterator<UserDetails> iterator = UserDetailSet.iterator();
        UserDetails userdetails;
        while(iterator.hasNext())
        {
            userdetails = (UserDetails) iterator.next();
            if(userdetails.getAccountnumber()== accountNumber)
            {
                Depositeflag = 1;
                System.out.println("Enter Deposit amount: ");
                int depositAmount = input.nextInt();
                userdetails.setBalanceamount(userdetails.getBalanceamount()+depositAmount);
                System.out.println("Successfully money deposited to your account number "+userdetails.getAccountnumber()+".\n");
                History history = new History();
                history.CreditAmount = depositAmount;
                history.TotalAmount = userdetails.getBalanceamount();
                if(userdetails.TransactionHistory.size()>=5)
                {
                    userdetails.TransactionHistory.remove();
                    userdetails.TransactionHistory.add(history);
                }
                else
                {         
                    userdetails.TransactionHistory.add(history);
                }
                break;
            }
        }
        if(Depositeflag == 0)
        {
            System.out.println("Account Number Not Created.\n");
        }
    	}
    	else
    	{
    		System.out.println("You're enter the invalid Account Number.\n");
    	}
    }
    @Override
     public void WithdrawUserMoney() //To withdraw money
    {
        int Withdrawflag = 0;
        System.out.println("Enter Account number: ");
        int accountNumber = input.nextInt();
        Iterator<UserDetails> iterator = UserDetailSet.iterator();
        UserDetails userdetails;
        while(iterator.hasNext())
        {
            userdetails = (UserDetails) iterator.next();
            if(userdetails.getAccountnumber()== accountNumber)
            {
                Withdrawflag = 1;
                System.out.println("Enter withdraw amount: ");
                int withdrawAmount = input.nextInt();
                if(userdetails.getBalanceamount()-withdrawAmount >= 600)
                {
                    userdetails.setBalanceamount(userdetails.getBalanceamount()-withdrawAmount);
                    System.out.println("----------------Successfully withdrawn, Please collect your Cash----------------\n");
                    History History = new History();
                    History.DebitAmount = withdrawAmount;
                    History.TotalAmount = userdetails.getBalanceamount();
                    if(userdetails.TransactionHistory.size()>=5)
                    {
                        userdetails.TransactionHistory.remove();
                        userdetails.TransactionHistory.add(History);
                    }
                    else
                    {
                        userdetails.TransactionHistory.add(History);
                    }
                }
                else
                {
                    System.out.println("Insufficient Balance\n");
                }
                break;
            }
        }
        if(Withdrawflag == 0)
        {
            System.out.println("Invalid Account Number\n");
        }        
    }
    @Override
    public void DisplayUserAccountDetails() //To display the userdetails
    {
        int Displayflag=0;
        System.out.println("Enter your Account number to display your bank details :");
        long AccountNumber=input.nextLong();
        Iterator<UserDetails> iterator=UserDetailSet.iterator();
        UserDetails userdetails;
        while(iterator.hasNext())
        {
            userdetails=(UserDetails)iterator.next();
            if(userdetails.getAccountnumber()==AccountNumber)
            {
                Displayflag=1;
                System.out.println("----------------Account Details-----------------");
                System.out.println("Account Number : "+userdetails.getAccountnumber());
                System.out.println("First Name : "+userdetails.getFirstname());
                System.out.println("Last Name : "+userdetails.getLastname());
                System.out.println("Age : "+userdetails.getAge());
                System.out.println("Phone Number: "+userdetails.getMobilenumber());
                //System.out.println("Aadhar Number: "+userdetails.getAadhar_number());
                System.out.println("Account Balance :"+userdetails.getBalanceamount()+"\n");
                break;
            }
        }
        if(Displayflag==0)
        {
            System.out.println("Invalid Account Number\n");
        }
    }
}