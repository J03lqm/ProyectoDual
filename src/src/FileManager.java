package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFileChooser;

public abstract class FileManager {
	static JFileChooser fileChooser = new JFileChooser();

	static Set<File> selectFiles() {
		int response = fileChooser.showOpenDialog(fileChooser);
		 //Comprobar si se ha pulsado Aceptar
	    if (response == JFileChooser.APPROVE_OPTION) {
	        //Crear un objeto File con el archivo elegido
	    	return Stream.of(fileChooser.getSelectedFiles()).collect(Collectors.toSet());
	    }
	    return null;
	}
	
	static boolean save(File file, String url) {
		
		return false;
	}
	
	static void edit(ArrayList<String> lines) {
	    String line;
	    
        try {
            File file = new File("d:/new folder/t1.htm");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains("java"))
                    line = line.replace("java", " ");
                lines.add(line);
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                 out.write(s);
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
   
}
