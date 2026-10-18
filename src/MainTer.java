import java.util.Scanner;
public class MainTer {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        String TXT_file = "login.txt";
        


        //displaying that program is running
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nProgram starting...");


        //will get every username and password
        TxtReader.readTXT(TXT_file);


        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("\nProgram running!");



        System.out.println("\n\nWARRING: YOU CAN NOT USE \":\" IN PASSWORD OR USERNAME SECTION");


        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }




        //program will check if user wants to LOG IN or SIGN IN
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nType Log In or Sign In if you dont have an account.");
        System.out.print("\n»»");
        char choosing = scanner.next().toLowerCase().charAt(0);
        if(choosing == 'l'){






            //program display LOG IN
            System.out.println("\n\n\ndb       .d88b.   d888b       d888888b d8b   db \n88      .8P  Y8. 88' Y8b        `88'   888o  88 \n88      88    88 88              88    88V8o 88 \n88      88    88 88  ooo         88    88 V8o88 \n88booo. `8b  d8' 88. ~8~        .88.   88  V888 \nY88888P  `Y88P'   Y888P       Y888888P VP   V8P \n                                                ");

            scanner.nextLine();



            //user will be asked for username and password
            System.out.print("\n\n\n\n\n\nUsername: ");
            String username = scanner.nextLine();
            System.out.print("\n\nPassword: ");
            String password = scanner.nextLine();


            



            //HASHING THE PASSWORD
            password = Hash.sha256(password);




            //the program will check if the username and password is valid
            if(TxtChecker.checkTXT(username, password)){

                System.out.println("\n\n\nYou are successfully loged in!");

            }else{

                System.out.println("\n\n\nPassword/username invalid or account hasnt been created!");

            }
            


        }else if(choosing == 's'){


            //program display SIGN IN
            System.out.println("\n\n\n   _____ _____ _____ _   _   _____ _   _ \n  / ____|_   _/ ____| \\ | | |_   _| \\ | |\n | (___   | || |  __|  \\| |   | | |  \\| |\n  \\___ \\  | || | |_ | . ` |   | | | . ` |\n  ____) |_| || |__| | |\\  |  _| |_| |\\  |\n |_____/|_____\\_____|_| \\_| |_____|_| \\_|\n                                         \n                                         ");

            scanner.nextLine();



            //user will be asked to give the new username and password
            String username, sugg_username;
            
            
            while(true){

                //user will be asked for new username
                System.out.print("\n\n\n\n\n\nNew Username: ");
                username = scanner.nextLine();
                sugg_username = username;


                //program will check if username has : in it and if yes the program wont allowed it to continue
                if (username.indexOf(':') != -1) {
                    System.out.println("\n\n\n\nYOU CAN NOT USE \":\" IN YOURE USERNAME - - TRY AGAIN");


                }else{

                    break;
                }




            }
            







            //will check if user has already claimed that username and if yes the program will give the user a suggestion for a similar username
            while (TxtUsernameCheck.checkUserTXT(username)) {

                //program will try to get a unique username by checking and adding numbers to the already picked username
                while (TxtUsernameCheck.checkUserTXT(sugg_username)) {

                    sugg_username += "" + (int)(Math.random() * 10 + 1);

                }



                //program will suggest a user name and by typing no it will give the user to write their own

                System.out.println("\n\n\nUsername already taken\n\nBy typing 'yes' you will get a similar username: "+sugg_username);
                char sugg_checking = scanner.next().charAt(0);
                scanner.nextLine();

                if(sugg_checking == 'y'){  

                    username = sugg_username;
                    

                    try{
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    
                    break;

                }else{

                    //user will be asked for new username
                    System.out.print("\n\n\n\n\n\nNew Username: ");
                    username = scanner.nextLine();
                    sugg_username = username;

                }

        
                

                
                    
            }

            System.out.print("\n\n\n\nUsername has been set to: "+username+"\n\n\n\n");


            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.print("\n\n\n\n\n\nWARRING: PASSWORD MUST INCLUDE 4 SPECIAL CHARACTERS, 4 NUMBERS AND HAS TO BE MORE THAN 8 CHARACTERS LONG\n\n\n\n");


            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }



            //program will check if user has a strong password
            String password;
            while (true) {
                

            
                while (true) {
                
                    //program will ask for password
                    System.out.print("\n\nNew Password: ");
                    password = scanner.nextLine();


                    //program will check if password has : in it and if yes the program wont allowed it to continue
                    if (password.indexOf(':') != -1) {
                        System.out.println("\n\n\n\nYOU CAN NOT USE \":\" IN YOURE PASSWORD - - TRY AGAIN");


                    }else{

                        break;
                    }


                }

                //program starts by checking the lenght of password
                if (password.length() < 8) {
                    System.out.println("\n\n\n\n\nPASSWORD IS TOO SHORT (min. 12 charecters)\n\n");



                }
                //program will check how many signs and numbers are in password(min 4)
                else if (SignPassCheck.pass_CHECK(password)){

                    System.out.println("\n\n\n\n\nPASSWORD DOESNT HAVE MIN. 4 SPECIAL CHARACTERS AND NUMBERS\n\n");


                }else{
                    break;
                }


            }


            System.out.println("\n\n\nStoring...");

            //HASHING THE PASSWORD
            password = Hash.sha256(password);
            
            //program will add username and password to the end of the usenames and passowrds lists
            TxtReader.usernames.add(username);
            TxtReader.passwords.add(password);



            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }



            System.out.println("Updating...\n");

            //program will rewrite the text file with the new lists

            TxtWrite.write_TXT(TXT_file);

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("\n\n\nYou have successfully signed in\n");


            



        }else{

            System.out.println("\n\n\nYou chose nothing.");

            try{
                Thread.sleep(1500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Program closing...");
            
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
            



        


        


        



        

        scanner.close();
    }
}
