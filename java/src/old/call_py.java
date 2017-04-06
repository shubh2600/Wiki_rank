import java.io.IOException;

import java.lang.*;

public  class call_py  {

    public static void main(String[] args)throws java.lang.Exception  {
        try {
            // Execute command

            String command = "cmd /c cd Search_eng" +" & start cmd.exe /c python rank.py";
            Runtime.getRuntime().exec(command);


            // Get output stream to write from it




        } catch (IOException e) {
        }

    }
}