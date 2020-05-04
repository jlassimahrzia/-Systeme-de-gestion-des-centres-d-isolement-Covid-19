package projet;
import org.apache.commons.lang3.StringUtils;
public class Test {

	public static void main(String[] args) {
		
		int w = 120;
		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", w - 1, "-") + "+"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center("BIENVENUE A NOTRE APPLICATION CONSOLE", w - 2), w, "|")+
				ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", w - 1, "-") + "+"+ConsoleColors.RESET);
		
		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", w - 1, "-") + "+");
		System.out.println(ConsoleColors.BLUE_BOLD+"                   _____ ______      _______ _____        __  ___     _____           _            \r\n" + 
				"                  / ____/ __ \\ \\    / /_   _|  __ \\      /_ |/ _ \\   / ____|         | |           \r\n" + 
				"                 | |   | |  | \\ \\  / /  | | | |  | |______| | (_) | | |     ___ _ __ | |_ _ __ ___ \r\n" + 
				"                 | |   | |  | |\\ \\/ /   | | | |  | |______| |\\__, | | |    / _ \\ '_ \\| __| '__/ _ \\\r\n" + 
				"                 | |___| |__| | \\  /   _| |_| |__| |      | |  / /  | |___|  __/ | | | |_| | |  __/\r\n" + 
				"                  \\_____\\____/   \\/   |_____|_____/       |_| /_/    \\_____\\___|_| |_|\\__|_|  \\___|"
		+ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", w - 1, "-") + "+"+ConsoleColors.RESET);
        
        System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", w - 1, "-") + "+"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center("MENU", w - 2), w, "|")+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", w - 1, "-") + "+"+ConsoleColors.RESET);
        
        System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", w - 1, "-") + "+"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
        		  "1- A propos   "
        		+ "2- Centre     "
        		+ "3- Gouvernorat     "
        		+ "4- Gestion totale ", w - 2), w, "|")+ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", w - 1, "-") + "+"+ConsoleColors.RESET);
        
        System.out.println(ConsoleColors.RED_BOLD+ConsoleColors.RED_UNDERLINED+"Tapez le numéro de la section que vous voulez l'accéder :"+ConsoleColors.RESET);
	}

}
