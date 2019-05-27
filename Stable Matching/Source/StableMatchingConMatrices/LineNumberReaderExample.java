import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderExample
{
    public static void main(String[] args)
    {   
        
        try{
            
            File file =new File("/home/emiliano/Descargas/DIseño/TP Diseño/stable_matching/data.txt");
            
            if(file.exists()){
                
                FileReader fr = new FileReader(file);
                LineNumberReader lnr = new LineNumberReader(fr);
                
                int linenumber = 0;
                
                    while (lnr.readLine() != null){
                    linenumber++;
                    }
         
                    System.out.println("Total number of lines : " + linenumber);
         
                    lnr.close();
                
                 
            }else{
                 System.out.println("File does not exists!");
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
}

