package interfaceObject;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class commit{
    private static String author;
    private static String commiter;
    private static String parent;
    private static String currentHash;
    private static String containerString;

    private static File file;
    private static Scanner reader;

 
    


    public static void createCommit() throws Exception{
        file = new File(".verxion/heads/master");
        reader =  new Scanner(file);
        // FIXME:  check for status. check for added files.
        // check if master has a file contained in it.
        if(reader.hasNextLine()){
            parent = reader.nextLine();
        }
        else{
            parent = "";
        }
        
        //FIXME: ADD CONFIG FOR AUTHOR AND COMMITER
        currentHash = tree.createTree();
        commiter = "Bereket Molla";
        author = "Bereket Molla";

        containerString = "tree " + currentHash+ "\n"  + commiter + "\n"  + author ;
        System.out.println(containerString);
        String commitHash = hash.getHash(containerString);

        String folderName = commitHash.substring(0,2);
        String commitName = commitHash.substring(2);

        new File(".verxion/objects/commits/" + folderName).mkdir();
        byte[] compressedTree = stream.compress(containerString + "\n parent " + parent);
        
        Files.write(new File(".verxion/objects/commits/" + folderName+ "/" +commitName).toPath(), compressedTree);

        String branch = ".verxion/";
        BufferedReader reader = new BufferedReader(new FileReader(new File(".verxion/HEAD")));
        String line;
        while ((line = reader.readLine()) != null) { 
            branch += line;
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(branch)));
        writer.write(commitHash);
        writer.close();


    }

    

}
