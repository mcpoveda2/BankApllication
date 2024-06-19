
import bankapplication.UserDetails;

public class UserValidator {
    boolean flag = false;

    public boolean isValidUserAge(UserDetails usterdetails, int age) {

       flag=true;  // Validating Age
        while(flag) {
        System.out.println("Enter your Age :");

        if(age >=18)
        {
            usterdetails.setAge(age);
            flag=false;
        }
        else if((age>=1) && (age<=17))
        {
            System.out.println("You're in under 18, so not eligible to create Bank Account. please Contact You're nearest branch.\n************ Thank you for using our service! Have a GREAT DAY **************");
        
        }
        else
        {
            flag=true;
            //throw new InvalidAgeException("Please provide the correct age.\n");
        }
            

    }
    return flag;
}   
}
