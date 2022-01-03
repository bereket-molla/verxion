package interfaceObject;

import java.io.*;
import java.nio.file.Files;

public class tree{
    // creates a file in tree folder
    // write hash of the blob or another tree
    // also their file names
    public static String createTree() throws Exception{
        File index = new File(".verxion/index");
        String treeHash = hash.getHash(index);

        String folderName = treeHash.substring(0,2);
        String treeName = treeHash.substring(2);

        new File(".verxion/objects/trees/" + folderName).mkdir();
        byte[] compressedTree = stream.compress(index);
        
        Files.write(new File(".verxion/objects/trees/" + folderName+ "/" +treeName).toPath(), compressedTree);
        return treeHash;
    }
}