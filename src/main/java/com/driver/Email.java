package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        int letterupper = 0,letterLower = 0,other = 0,digit = 0;
        if(oldPassword.equals(password))
        {
            if(newPassword.length() >=8)
            {
                for(Character c : newPassword.toCharArray())
                {
                    if(c>='a' && c<='z')
                    {
                        letterLower++;
                    }else if(c>='A' && c<='Z')
                    {
                        letterupper++;
                    }else if(c>='0' && c<='9')
                    {
                        digit++;
                    }else{
                        other++;
                    }
                }
                if(letterupper==0 || letterLower == 0 || other == 0 || digit == 0)
                {
                    return;
                }else{
                    password = newPassword;
                }
            }
        }
    }
}