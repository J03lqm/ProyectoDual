package src;

import java.io.File;
import javax.swing.JFileChooser;

public abstract class FileManager {
	static JFileChooser fileChooser = new JFileChooser();
	
	static File[] selectFiles() {
		int response = fileChooser.showOpenDialog(fileChooser);
		 //Comprobar si se ha pulsado Aceptar
	    if (response == JFileChooser.APPROVE_OPTION) {
	        //Crear un objeto File con el archivo elegido
	        return fileChooser.getSelectedFiles();
	 
	    }
	    return null;
	}
   
}
