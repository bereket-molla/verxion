package interfaceObject;
import java.io.*;
import java.util.Scanner;

public class branch {
    public static void branchCreate(String branchName) throws Exception{
        File file = new File(".verxion/heads/" + branchName);
        if(!file.isFile()){

            new File(file.getPath()).createNewFile();

        }
        BufferedWriter writer= new BufferedWriter(new FileWriter(new File(".verxion/HEAD")));
        writer.write("heads/" + branchName);
        writer.close();

    }
}