import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MultipleFilesRead {
	public static void main(String[] args) throws IOException{  
        String srcDir = "D:/ReadFiles";

        File folder = new File(srcDir);
        File[] files = folder.listFiles();
        println files
                // Fetching all the files
        for (File file : files) {
            
                BufferedReader inputStream = new BufferedReader(new FileReader(file));
                def data=inputStream.text
                def post = new URL("https://c01-sg.integrate.boomi.com/ws/rest/personDetails/v1/personDetails/").openConnection();
                def message = data
                post.setRequestMethod("POST")
                post.setDoOutput(true)
                post.setRequestProperty("Content-Type", "application/json")
                post.setRequestProperty("Authorization", "Basic dHJhaW5pbmdhc2htaXRhc2F3YW50LUQ5UDhKNy5ZRzFGQTQ6OWJmZDM5NWUtMzYxZC00MWFkLTgxMDctMTU0ZjU5Mzg0MDJm")
                post.getOutputStream().write(message.getBytes("UTF-8"));
                def postRC = post.getResponseCode();
                println "Response Code : " + postRC;
                if(postRC.equals(200)) {
                    println post.getInputStream().getText();
                }


inputStream.close()
            }
        }
        
	}
