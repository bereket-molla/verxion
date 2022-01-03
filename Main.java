import interfaceObject.*;
// input output 
import java.io.*;
import java.nio.file.Files;

// compression and decompression
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;



public class Main{

    private static void setup() throws IOException{

        // create the folders 
        new File(".verxion").mkdir();
        new File(".verxion/objects").mkdir();
        new File(".verxion/objects/commits").mkdir();
        new File(".verxion/objects/blobs").mkdir();
        new File(".verxion/objects/trees").mkdir();

        new File(".verxion/heads").mkdir();
        

        // create files
        new File(".verxion/heads/master").createNewFile();
        new File(".verxion/index").createNewFile();
        new File(".verxion/treeLog").createNewFile();
            // write into HEAD
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(".verxion/HEAD")));
        writer.write("heads/master");
        writer.close();
       
    }

   


    public static void main(String args[]) throws Exception{
         String command = args[0];
         ArrayList<String> paths = null;
       
        if(args.length >= 2 ){
          paths = new ArrayList<>();
          for(int i = 1; i < args.length; i ++){
              paths.add(0,args[i]);
          }
        }
        
        if(command.equals("setup")){
            setup();
        }
        if(command.equals("list-untracked")){
            File path = new File("./");
            status.listHash(path);
        }
        else if(command.equals("add")){
            HashMap<String, String> container = new HashMap<String, String>();
            File index = new File(".verxion/index");
            for(String path: paths){
                File file = new File(path);
                
                
                
                BufferedReader br = new BufferedReader(new FileReader(index));

                String line;
                while ((line = br.readLine()) != null) {
                    String nextLine = line;
                    String filePath = nextLine.split(" ")[0];
                    String stringHash = nextLine.split(" ")[1];
                    container.put(filePath, stringHash);
                }
                System.out.println(file.getPath() + " " + hash.getHash(file));
                container.put(file.getPath(), hash.getHash(file));
                add.addBlob(file);
            }
            //clear index file

            if(index.delete()){
                index.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(".verxion/index"), true));

            for(Map.Entry<String, String> entry : container.entrySet()){
                
                writer.write( entry.getKey() + " " + entry.getValue() );
                writer.newLine();
            }
        

            writer.close();
            
        }
        else if(command.equals("decompress")){
            System.out.println(stream.decompress(args[1]));
        }
         else if(command.equals("commit")){
            commit.createCommit();
        }
        else if(command.equals("checkout")){
            checkout.checkoutBranch(args[1]);
        }
        else if(command.equals("branch")){
            branch.branchCreate(args[1]);
        }
}

}