
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class TxtReader {
    static List<String> usernames = new ArrayList<>();
    static List<String> passwords = new ArrayList<>();

    //will read all the usernames and passwords in login.txt and store tham in two sepret lists
    public static void readTXT(String place){

        //will clear the old lists if thay were checked before
        usernames.clear();
        passwords.clear();

        //two lists for usernames and passwords
        


        try{

        


            BufferedReader reader = new BufferedReader(new FileReader(place));


            //will go throu every line of the txt file
            String line;
            while ((line = reader.readLine()) != null) {
                
                //will clear any unwanted space before and after the words in txt file
                line = line.trim();

                //the username:password will be splited so thay can be inserted into there lists
                String[] parts = line.split(":");

                usernames.add(parts[0]);
                passwords.add(parts[1]);
                
            
            }





            reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        

        



    }

    public static void main(String[] args){


    }

}
