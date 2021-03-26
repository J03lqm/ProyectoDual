package src;

import java.util.Scanner;

abstract public class Menu {
	
	static void showMenu() {
		try(Scanner sc = new Scanner(System.in)){
			
			System.out.println("Seleccione una opción:");
			System.out.println("0. Salir");
			System.out.println("1. Generar plantilla JSON para VS Code.");
			
			switch(sc.nextInt()) {
				case 0:
					System.exit(0);
				case 1:
					JSONConverter.VStudioTemplate(FileManager.selectFiles());
					break;
				default:
					System.out.println("Opción no válida.");
					showMenu();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
