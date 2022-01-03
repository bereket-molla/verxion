package interfaceObject;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.io.*;
import java.nio.file.Files;

public class hash{

    public static String getHash(File file ) throws IOException{
        
        byte[] content = Files.readAllBytes(file.toPath());
        byte hashBytes[] = null;
        MessageDigest digest  = null;
        try {
            digest =  MessageDigest.getInstance("SHA-1");
            hashBytes = digest.digest(content);
        }catch(Exception e){ }
        String result = "";
        for (int i=0; i < hashBytes.length; i++) {
            result +=
                Integer.toString( ( hashBytes[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }


    public static String getHash(String contentString ) throws IOException{
        
        byte[] content = contentString.getBytes();
        byte hashBytes[] = null;
        MessageDigest digest  = null;
        try {
            digest =  MessageDigest.getInstance("SHA-1");
            hashBytes = digest.digest(content);
        }catch(Exception e){ }
        String result = "";
        for (int i=0; i < hashBytes.length; i++) {
            result +=
                Integer.toString( ( hashBytes[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }
}