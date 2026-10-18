import java.io.FileWriter;
import java.io.IOException;

public class TxtWrite {


    public static void write_TXT(String txt){

        try{

            //program will clear the txt file
            FileWriter fw = new FileWriter(txt);

            //goes throu every line and lists and combiens username and password together
            for(int i = 0; i < TxtReader.usernames.size(); ++i){

                //program will write in txt file username:password
                fw.write(TxtReader.usernames.get(i) + ":" + TxtReader.passwords.get(i) + "\n");
            }

            fw.close();
            
        }catch (IOException e) {
            e.printStackTrace(); // in case something goes wrong
        }


    }

}
