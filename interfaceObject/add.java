// input output 
package interfaceObject;

import java.io.*;
import java.nio.file.Files;

    public class add{
        public static void addBlob(File path) throws Exception{
            byte[] compressedResult = stream.compress(path);
            String hashResult = hash.getHash(path);

            createBlob(compressedResult, hashResult);

        }


    private static void createBlob(byte[] compressedResult, String result) throws IOException{
        String folderName = result.substring(0,2);
        String blobName = result.substring(2);

        new File(".verxion/objects/blobs/" + folderName).mkdir();
        Files.write(new File(".verxion/objects/blobs/" + folderName+ "/" +blobName).toPath(), compressedResult);
        
        
        
    }
}