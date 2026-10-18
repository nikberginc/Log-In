public class TxtUsernameCheck {

    public static boolean checkUserTXT(String username){

        //it will go throu every username in txt file and check if user is trying to get an used username when sign ining
        for(int i = 0; i<TxtReader.usernames.size(); ++i){

            //it will check if username is already in the list, if no it will return false
            if(TxtReader.usernames.get(i).equals(username)){
            
                return true;
                
            }

        }
        return false; // if the user wasnt found


    }

    public static void main(String[] args){



    }

}
