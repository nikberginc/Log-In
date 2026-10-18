public class SignPassCheck {
    
    

    public static boolean pass_CHECK(String pass){
        int cha_check =0, num_check = 0;


        //profram will check how many special signs are in a word and how many numbers
        for(int i = pass.length()-1; i>=0; --i){
            char c = pass.charAt(i);

            if(!Character.isLetterOrDigit(c)){
                ++cha_check;

            }else if (c >=48 && c <= 57){
                ++num_check;

            }
        }   

        //if there is more than 4 of pecial signs and numbers than it return false
        if(cha_check >=4 && num_check >=4){

            return false;

        }else{

            return true;
        }




    }

    public static void main(String[] args){


    }
}
