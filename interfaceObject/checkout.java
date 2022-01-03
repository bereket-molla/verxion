package interfaceObject;
import java.io.*; 
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class checkout{
    public static void checkoutBranch(String branch) throws Exception{
        
        // first check if the hash exists.(it is always a commit)
        File dirPath = new File(".verxion/heads");
        File filesList[] = dirPath.listFiles();
        File index = null;
        for(File file: filesList){
            if (file.getName().equals(branch)){
                File head = new File(".verxion/HEAD");
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File(".verxion/HEAD")));
                writer.write("heads/" + branch);
                writer.close();

                index = new File(".verxion/heads/" + branch);
            }
        }

        if(index == null){
            // It is a commit then. Not a branch!
            dirPath = new File(".verxion/objects/commits");
            filesList = dirPath.listFiles();
            for(File file: filesList){
                if(file.getName().equals(branch.substring(0,2))){
                    File head = new File(".verxion/HEAD");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(new File(".verxion/HEAD")));
                    writer.write(branch);
                    writer.close();

                    index = new File(".verxion/HEAD");
                }
            }
        }

        Scanner indexReader = new Scanner(index);
        String commit = null;
        if(indexReader.hasNextLine()){
            commit = indexReader.nextLine();
            
        }
        else{
            System.exit(-1);
        }
        String folderName = commit.substring(0,2);
        String commitName = commit.substring(2);
        String path = "commits/" + folderName + "/" + commitName;
        System.out.println(path);
        String commitDecompressed =
         stream.decompress(path);

        String treeHash = commitDecompressed.substring(5,45);
        folderName = treeHash.substring(0,2);
        String treeName = treeHash.substring(2);
        System.out.println("trees/" + folderName + "/" + treeName);
        String treeDecompressed =
         stream.decompress("trees/" + folderName + "/" + treeName);
        
        System.out.println(treeDecompressed);
        delete(new File("./"));
        createFiles(treeDecompressed);


    }

    public static void delete(File dirPath) throws Exception{
        
        File filesList[] = dirPath.listFiles();
            File index = new File(".verxion/index");
            Scanner reader = new Scanner(index);
            for(File file : filesList) {
                if(file.isFile()) {
                    if(!(file.getName().equals("Main.java")|| 
                            file.getName().equals("Main.class"))){
                                file.delete(); 
                            }
                }                
                else {
                    if(!(file.getName().equals(".verxion") ||
                        file.getName().equals("interfaceObject"))){
                     delete(file);   
                    }
                    
                }
            }
    }
    public static void createFiles(String treeDecompressed) throws Exception{
        HashMap<String, String> container = new HashMap<String, String>();
        File index = new File(".verxion/index");
        BufferedWriter writerIndex = new BufferedWriter(new FileWriter(index));
        writerIndex.write(treeDecompressed);
        writerIndex.close();
        BufferedReader br = new BufferedReader(new FileReader(index));
        String line;
        while ((line = br.readLine()) != null) {
            String nextLine = line;
            String filePath = nextLine.split(" ")[0];
            String stringHash = nextLine.split(" ")[1];
            container.put(filePath, stringHash);
        }
        BufferedWriter writer  = null;
        for(Map.Entry<String, String> entry : container.entrySet()){ 
            new File(entry.getKey()).createNewFile();  
            writer = new BufferedWriter(new FileWriter(new File(entry.getKey())));
            String folderName = entry.getValue().substring(0,2);
            String fileName = entry.getValue().substring(2);
            String content = stream.decompress("blobs/"+folderName + "/" +fileName);
            System.out.println(content);
            writer.write(content);
            writer.close();
        }
        
    }
}