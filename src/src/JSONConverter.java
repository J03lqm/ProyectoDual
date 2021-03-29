package src;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;


abstract public class JSONConverter {
	
	static void VStudioTemplate(Set<File> files) {
		
		Scanner sc = new Scanner(System.in);
		files.forEach(file -> {
			
			ArrayList<String> content = new ArrayList<String>();

			content.add("{");
			System.out.println("Archivo: "+file.getName());
			System.out.println("Escribe un título:");
			content.add("    \"" + sc.nextLine() + "\": {");
			
			System.out.println("Escribe una abreviatura:");
			content.add("    \"prefix\": \"" + sc.nextLine() + "\",");

			content.add("    \"body\": [");
			
			FileManager.read(file).forEach(line ->{
				line = line.replaceAll("\\\\", "\\\\\\\\");
				line = line.replaceAll("    ","\\\\t");
				line = line.replaceAll("\t","\\\\t");
				line = line.replaceAll("\"", "\\\\\"");
				content.add("        \"" + line + "\",");
			});

			String lastContent= content.get(content.size() - 1).substring(0, content.get(content.size() - 1).length()-1);
			content.remove(content.size() - 1);
			content.add(lastContent);
			content.add("    ],");

			System.out.println("Escribe una descripción:");
			content.add("    \"description\": \"" + sc.nextLine() + "\"");
			content.add("    }\n}");
			String fileName = file.getName().substring(0,file.getName().lastIndexOf('.')) + ".json";
			
			Path path = Paths.get(System.getProperty("user.home") + "/desktop/Visual Studio Generated Templates/");
			
			FileManager.createFile(path, fileName, content);
	});
		sc.close();
		Menu.showMenu();
	}
}
