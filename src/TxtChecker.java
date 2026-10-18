public class TxtChecker {

    public static boolean checkTXT(String username, String password){

        //it will go throu every username in txt file
        for(int i = 0; i<TxtReader.usernames.size(); ++i){

            //it will check if username and password are both true, if no it will return false
            if(TxtReader.usernames.get(i).equals(username)){
                if(TxtReader.passwords.get(i).equals(password)){

                    return true;
                }else{
                    return false;
                }
            }

        }
        return false; // if the user wasnt found


    }

    public static void main(String[] args){



    }

}
