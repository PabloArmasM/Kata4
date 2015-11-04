package kata4;

import static com.oracle.jrockit.jfr.Transition.From;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Kata4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String name = "/Users/Loedded";
        File file = new File (name);
        
        String [] filesarray;
        filesarray = file.list();
        
        //for (Object files : filesarray) {
            //System.out.println(files);
        //}
        
        //print(file.listFiles(),"");
    
        String from = "/Users/Loedded/Desktop/CC-14-30.pdf";
        String to = "/Users/Loedded/Desktop/CC-14-31.pdf";
        
        
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File (from)));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(to)));
        
        
        Date date = new Date();
        while (true){
            int read = input .read();
            if(read < 0) break;
            output.write(read);
        }
        
        input.close();
        output.flush();
        output.close();
        
        System.out.println(new Date().getTime() - date.getTime()+ " msg");
    }

    private static void print(File[] listFiles, String ident) {
        if(listFiles == null) return;
        for (File listFile : listFiles) {
            System.out.println(ident+(listFile.isDirectory()?"+":" ")+listFile.getName());
            if(listFile.isFile() || listFile.isHidden()) continue;
            print (listFile.listFiles(),ident+" ");
        }
    }

}
