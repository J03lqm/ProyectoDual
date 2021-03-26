package src;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

abstract public class JSONConverter {

	
	static void VStudioTemplate(Set<File> files) {
		files.forEach(file -> {
			//ArrayList<String> modifiedContent = new ArrayList<String>();
			FileManager.read(file).forEach(line ->{
				System.out.println(line);
			});
			
			//FileManager.edit(file, );
			//FileManager.save(file, System.getProperty("user.home") + "/desktop/\"Visual Studio Generated Templates\"" + file.getName() + ".json");
	});
	}
}
