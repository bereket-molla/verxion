package interfaceObject;
// input output 
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
// compression and decompression
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;




public class status {

    public static void listHash(File dirPath) throws Exception{
            File filesList[] = dirPath.listFiles();
            File index = new File(".verxion/index");
            
            for(File file : filesList) {
                if(file.isFile()) {
                    if(!(file.getName().equals("Main.java") || 
                       file.getName().equals("Main.class"))){
                           String currentLine = file.getPath() + " "+ hash.getHash(file);
                           
                           if(!isThere(currentLine, index)){
                               System.out.println("Untracked file: "+ currentLine);
                           }


                     }
                }                
                else {
                    if(!(file.getName().equals(".verxion") ||
                        file.getName().equals("interfaceObject"))){
                     listHash(file);   
                    }
                    
                }
            }
        }

    public static boolean isThere(String name, File index) throws Exception{
        Scanner reader = new Scanner(index);
        while(reader.hasNextLine()){
            if(reader.nextLine().equals(name.substring(2))){
                return true;
            }
        }
        return false;

    }


        
}