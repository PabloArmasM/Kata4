package kata4;

import java.io.File;

public class Kata4 {

    public static void main(String[] args) {

        String name = "/Users/Loedded";
        File file = new File (name);
        
        String [] filesarray;
        filesarray = file.list();
        
        //for (Object files : filesarray) {
            //System.out.println(files);
        //}
        
        print(file.listFiles(),"");
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
