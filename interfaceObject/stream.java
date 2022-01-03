package interfaceObject;
// input output 
import java.io.*;
import java.nio.file.Files;

// compression and decompression
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;


public class stream{

    public static String decompress(String filePath) throws Exception {
        InputStream input =new FileInputStream(".verxion/objects/" +filePath); 
        InflaterInputStream inflaterInput = new InflaterInputStream(input);
        ByteArrayOutputStream BinaryOutput =new ByteArrayOutputStream();
        int b;
        while ((b = inflaterInput.read()) != -1) {
            BinaryOutput.write(b);
        }
        inflaterInput.close();
        BinaryOutput.close();
        String output =new String(BinaryOutput.toByteArray());
        
        return output;
    }


     public static byte[] compress(String contentString) throws IOException{
        //File must be compressed

        byte[] content = contentString.getBytes();

        ByteArrayOutputStream compressWriter= new ByteArrayOutputStream();
        DeflaterOutputStream zip = new DeflaterOutputStream(compressWriter);
        zip.write(content,0,content.length);
        zip.close();

        byte[] compressedResult = compressWriter.toByteArray();
        System.out.println(compressedResult.length);
        return compressedResult;
   
        // File must be hashed

    }


    public static byte[] compress(File file) throws IOException{
        //File must be compressed

        byte[] content = Files.readAllBytes(file.toPath());

        ByteArrayOutputStream compressWriter= new ByteArrayOutputStream();
        DeflaterOutputStream zip = new DeflaterOutputStream(compressWriter);
        zip.write(content,0,content.length);
        zip.close();

        byte[] compressedResult = compressWriter.toByteArray();
        System.out.println(compressedResult.length);
        return compressedResult;
   
        // File must be hashed

    }






}
