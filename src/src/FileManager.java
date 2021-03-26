package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFileChooser;

public abstract class FileManager {
	static Set<File> selectFiles() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);
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
					out.write(line + "\n");
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
	            lines.add(line);
	        }
	        fr.close();
	        br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return lines;
	}
	
	static void createDirectory(Path path) {
		try {
			if(!Files.exists(path))
			Files.createDirectory(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	static void createFile(Path path, String fileName, ArrayList<String> content) {
		
		createDirectory(path);

		File file =new File(path.toString() + "\\\\" + fileName);
		try {
			file.createNewFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		edit(file, content);
    }
	
   
}
