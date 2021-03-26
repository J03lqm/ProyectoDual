package src;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

abstract public class JSONConverter {

	
	static void VStudioTemplate(Set<File> files) {
		files.forEach(file -> {
			file.getName();
			FileManager.saveFile(file, System.getProperty("user.home") + "/desktop";
	});
	}
}
