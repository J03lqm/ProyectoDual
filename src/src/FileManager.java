package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFileChooser;

public abstract class FileManager {
	static Set<File> selectFiles() {
		JFileChooser fileChooser = new JFileChooser();
		
		int response = fileChooser.showOpenDialog(fileChooser);
		 //Comprobar si se ha pulsado Aceptar
	    if (response == JFileChooser.APPROVE_OPTION) {
	        //Crear un objeto File con el archivo elegido
	    	return Stream.of(fileChooser.getSelectedFiles()).collect(Collectors.toSet());
	    }else return null;
	}
	
	static boolean save(File file, String url) {
		
		return false;
	}
	
	static void edit(File file, ArrayList<String> lines) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fw);
            lines.forEach(line -> {
				try {
					out.write(line);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	static ArrayList<String> read(File file){
		ArrayList<String> lines = new ArrayList<String>();
		String line;
		
		try {
			FileReader fr = new FileReader(file);
		
	        BufferedReader br = new BufferedReader(fr);
	     
	        while ((line = br.readLine()) != null) {
	            if (line.contains("java"))
	                line = line.replace("java", " ");
	            lines.add(line);
	        }
	        fr.close();
	        br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return lines;
	}
   
}
