package projet;
import java.io.Console;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Test {	
	
	public static boolean isDate(String date) {
	    if ((date.charAt(2) != '/') || (date.charAt(5) != '/') || (date.length() != 10))
			return false;
	    else
			return true;
	}
	
	public static String currentday() {
	 	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");// current day
        Date dateobj = new Date();
        String dd = df.format(dateobj);
        return dd ;
	}
	
	public static int choix_menu() {
		Scanner clavier = new Scanner(System.in) ; 
		int n ;
		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	    System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center("MENU", 120 - 2), 120, "|")+ConsoleColors.RESET);
	    System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        
	    System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	    System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	        		  "1- A propos   "
	        		+ "2- Centre     "
	        		+ "3- Gouvernorat     "
	        		+ "4- Gestion totale ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	    System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        
		do {
        	System.out.println(ConsoleColors.RED_BOLD+"Tapez un numéro entre 1 et 5 :"+ConsoleColors.RESET);
        	n=clavier.nextInt();
        }while(n<1||n>5);
		return n ;
	}
	public static void traitement(Gestion ges)
	{
		int n ;
		n = choix_menu();
		Scanner stringScanner = new Scanner(System.in);
		Scanner stringScanner2 = new Scanner(System.in);
		Scanner stringScanner3 = new Scanner(System.in);
		Scanner stringScanner4 = new Scanner(System.in);
		Scanner clavier = new Scanner(System.in) ; 
	        switch(n) { 
	        // A propos
	        case 1:{
	        	 System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center("A Propos l'application", 120 - 2), 120, "|")+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	             
	             System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center(StringUtils.center("Présentation", 120 - 2), 120, "|")+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	            
	             System.out.println(StringUtils.rightPad("+", 120 - 1, "-") + "+");
	             System.out.println(StringUtils.center(StringUtils.center("Dans le contexte actuel, l’isolement des personnes susceptibles d’être contaminées est une action clé\r\n" + 
	             		"dans la stratégie de lutte contre la propagation du coronavirus qui nous permet de limiter\r\n" + 
	             		"considérablement la contamination et donc le nombre de victimes. Même après le confinement\r\n" + 
	             		"général, l’isolement sera exécuté et ce jusqu’à disparition totale du virus dans le pays et dans"
	             		+ " le monde entier \r\n.Compte tenu de l’importance de cette action,"
	             		+ " notre application facilite la procédure de \r\n "
	             		+ "l'organisation des centres d'isolement dans un mémes interfaces .", 120 - 2), 120, "|"));
	             System.out.println(StringUtils.rightPad("+", 120 - 1, "-") + "+");
	             
	             System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center(StringUtils.center("Nos Services", 120 - 2), 120, "|")+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	            
	             System.out.println(StringUtils.rightPad("+", 120 - 1, "-") + "+");
	             System.out.println(ConsoleColors.BLACK_BOLD+StringUtils.center(StringUtils.center("1- Centres ", 120 - 2),
	            		 120, "|")+ConsoleColors.RESET);
	             System.out.println(StringUtils.center(StringUtils.center("Ce service permet de modéliser les centres"
	             		+ "ainsi que la gestion de leurs chambres et la gestion \r\ndes personnes dés leur acceuil à la "
	             		+ "date de sortie avec une affichages convenable claire avec tous \r\nles différents détails et filtres"
	             		+ "et statistique sont disponible", 120 - 2), 120, "|"));
	             System.out.println(StringUtils.rightPad("+", 120 - 1, "-") + "+");
	             
	             System.out.println(StringUtils.rightPad("+", 120 - 1, "-") + "+");
	             System.out.println(ConsoleColors.BLACK_BOLD+StringUtils.center(StringUtils.center("2- Gouvernorat ", 120 - 2),
	            		 120, "|")+ConsoleColors.RESET);
	             System.out.println(StringUtils.center(StringUtils.center("Chaque gouvernorat dispose "
	             		+ "d’un ou de plusieurs centres d’isolement avec ce services vous pouvez \r\nvisualisée"
	             		+ "les centres de chaque gouvernorat", 120 - 2), 120, "|"));
	             System.out.println(StringUtils.rightPad("+", 120 - 1, "-") + "+");
	             
	             System.out.println(StringUtils.rightPad("+", 120 - 1, "-") + "+");
	             System.out.println(ConsoleColors.BLACK_BOLD+StringUtils.center(StringUtils.center("3- Gestion Globale ", 120 - 2),
	            		 120, "|")+ConsoleColors.RESET);
	             System.out.println(StringUtils.center(StringUtils.center("Cette partie englobe tous les gouvernorats"
	             		+ "vous pouvez les manipuler et avoir une vision globale sur \r\ntouts les centres de toute la pays", 120 - 2), 120, "|"));
	             System.out.println(StringUtils.rightPad("+", 120 - 1, "-") + "+");
	             
	             traitement(ges);
          		 break ;
	        }
	        //Centre
	        case 2:{
	        	 System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center("Centre", 120 - 2), 120, "|")+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	             
	             System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	             		  "1- Ajout   "
	            		+ "2- Affichage   "
	            		+ "3- Personne   "
	             		+ "4- Chambre     "
	             		+ "5- Statistique ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	             System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	             int n2;
	             do {
	             	System.out.println(ConsoleColors.RED_BOLD+"Tapez un numéro entre 1 et 6 :"+ConsoleColors.RESET);
	             	n2=clavier.nextInt();
	             }while(n2<1||n2>5);
	             switch(n2) {
	             	// Ajout
	             	case 1 :{	             		
	             		System.out.println(ConsoleColors.GREEN+"Donnez les caractéristique de centre à ajouter"+ConsoleColors.RESET);        		             		
	             		System.out.println("Gouvernorat :"); 
	             		String gouvernorat ;
	             		do {
	             			gouvernorat= stringScanner.nextLine();
	             		}while(!ges.gouvernorat_existev2(gouvernorat)); 
	             		Gouvernorat go = ges.get_Gouvernorat(gouvernorat);      		
	             		System.out.println("Num de Ref :");
	             		int num ;
	             		do {
	             			num =clavier.nextInt();	             				             			
	             		}while(go.centre_existev2(num)==true);             		
	             		System.out.println("adresse :");
	             		String adresse = stringScanner.nextLine() ;
	             		System.out.println("Capacite :");
	             		int capacite =clavier.nextInt() ; 
	             		           	             		
	             		Centre c = new Centre(num,adresse,gouvernorat,capacite);            		
	             		
	             		if(go!=null) {
	             			go.ajouter_centre(c);
	             			System.out.println("Le "+c+ConsoleColors.GREEN+" Ajoutée avec succées"+ConsoleColors.RESET);                		
	             		}      	             		
	             		traitement(ges);
	             		break ;
	             	}
	             	// Affichage
	             	case 2 :{
	             		System.out.println(ConsoleColors.GREEN+"Donnez le num de centre "+ConsoleColors.RESET);        		             		
	             		int num ;
	             		num =clavier.nextInt();	 
	             		if(!ges.cente_existe(num)) {
	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"Centre n'existe pas"+ConsoleColors.RESET);
	             		}
	             		else {
	             			 System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	        	             		  "1- Information  "
	        	            		+ "2- Liste Chambres   "
	        	             		+ "3- Liste Personnes  ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	        	             System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             int n3;
	        	             do {
	        	             	System.out.println(ConsoleColors.RED_BOLD+"Tapez un numéro entre 1 et 3 :"+ConsoleColors.RESET);
	        	             	n3=clavier.nextInt();
	        	             }while(n3<1||n3>3);
	        	             Centre c = ges.get_cente(num);
	        	             switch(n3) {
	        	             // Caractéristique
	        	             	case 1 :	        	          		
	        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("********** Centre Num "+c.getNumero_ref()+
	        	             				" **********"+ConsoleColors.RESET, 120 - 2));
	        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             		System.out.println(ConsoleColors.BLACK_BOLD+ConsoleColors.BLACK_UNDERLINED+"Adresse :"+ConsoleColors.RESET+
	        	             				" "+c.getAdresse());
	        	             		System.out.println(ConsoleColors.BLACK_BOLD+ConsoleColors.BLACK_UNDERLINED+"Gouvernorat :"+ConsoleColors.RESET+
	        	             				" "+c.getGouvernorat());
	        	             		System.out.println(ConsoleColors.BLACK_BOLD+ConsoleColors.BLACK_UNDERLINED+"Capacité :"+ConsoleColors.RESET+
	        	             				" "+c.getCapacite());
	        	             		System.out.println(ConsoleColors.BLACK_BOLD+ConsoleColors.BLACK_UNDERLINED+"Nombres des personnes accueillies :"+ConsoleColors.RESET+
	        	             				" "+c.getNombre_personnes());
	        	             		int x = c.getCapacite()-c.getNombre_personnes();
	        	             		System.out.println(ConsoleColors.BLACK_BOLD+ConsoleColors.BLACK_UNDERLINED+"Nombres des places disponible :"+ConsoleColors.RESET+
	        	             				" "+x);
	        	             		traitement(ges);
	        	             		break ;
	        	             // Liste Chambres
	        	             	case 2 :
	        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("**********Liste des Chambres du Centre Num "+c.getNumero_ref()+
	        	             				" **********"+ConsoleColors.RESET, 120 - 2));
	        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             		ArrayList <Chambre> Listc=new ArrayList<Chambre>() ;
	        	             		Listc =c.getList_chambres();
	    	        				String[][] tab1 = tableConsole.changeformat_chambre(Listc);
	    	        				tableConsole.tableWithLinesAndMaxWidth(tab1);
	        	             		traitement(ges);
	        	             		break ;
	        	            // liste personnes
	        	             	case 3 :
	        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("**********Liste des personnes du Centre Num "+c.getNumero_ref()+
	        	             				" **********"+ConsoleColors.RESET, 120 - 2));
	        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             		ArrayList <Personne> Listp=new ArrayList<Personne>() ;
	        	             		Listp =c.getList_personnes();
	    	        				String[][] tab2 = tableConsole.changeformat_personne(Listp);
	    	        				tableConsole.tableWithLinesAndMaxWidth(tab2);
	        	             		traitement(ges);
	        	             		break ;
	        	             }
	             		}
	             		traitement(ges);
	             		break ;
	             	}
	             	// Personne
	             	case 3 : {
	             		System.out.println(ConsoleColors.GREEN+"Donnez le num de centre "+ConsoleColors.RESET);        		             		
	             		int num ;
	             		num =clavier.nextInt();	 
	             		if(!ges.cente_existe(num)) {
	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"Centre n'existe pas"+ConsoleColors.RESET);
	             		}
	             		else {
	             			 System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	        	             		  "1- Liste  "
	        	            		+ "2- Affiche personne   "
	        	             		+ "3- Ajout  "
	        	            		+ "4- Enregistrement départ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	        	             System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             int n3;
	        	             do {
	        	             	System.out.println(ConsoleColors.RED_BOLD+"Tapez un numéro entre 1 et 4 :"+ConsoleColors.RESET);
	        	             	n3=clavier.nextInt();
	        	             }while(n3<1||n3>4);
	        	             Centre c = ges.get_cente(num);
	        	             switch(n3) {
	        	             	//1-Liste
	        	             	case 1 :{
	        	             		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		   	        	            System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
		   	        	             		  "1- Tout  "
		   	        	            		+ "2- personnes sortants ce jour  "
		   	        	             		+ "3- Personnes Malades  "
		   	        	            		+ "4- Personnes Contaminées"
		   	        	             		+ "5- Personnes Sans Symptomes", 120 - 2), 120, "|")+ConsoleColors.RESET);
		   	        	            System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		   	        	            int np;
		   	        	            do {
		   	        	            	System.out.println(ConsoleColors.RED_BOLD+"Entrez un num entre 1 et 5"+ConsoleColors.RESET);
		   	        	            	np = clavier.nextInt();
		   	        	            }while(np<1||np>5);
		   	        	            switch(np) {
		   	        	            	case 1:{
		   	        	            		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("**********Liste des personnes du Centre Num "+c.getNumero_ref()+
			        	             				" **********"+ConsoleColors.RESET, 120 - 2));
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		ArrayList <Personne> Listp=new ArrayList<Personne>() ;
			        	             		Listp =c.getList_personnes();
			    	        				String[][] tab2 = tableConsole.changeformat_personne(Listp);
			    	        				tableConsole.tableWithLinesAndMaxWidth(tab2);
			        	             		traitement(ges);
			        	             		break ;
		   	        	            	}
		   	        	            	case 2 :{
		   	        	            	    // Affichge Liste des personnes qui vont sortir ce jour
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("**********"+" Liste des personnes qui vont sortir ce jour"
			        	             				+ currentday() +" **********"+ConsoleColors.RESET, 120 - 2));
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		ArrayList<Personne> list = c.list_personnes_sortes();
			        	             		String[][] table = tableConsole.changeformat_personne(list);
			        	             		tableConsole.tableWithLinesAndMaxWidth(table);
			        	             		
		   	        	            	}
		   	        	            	case 3 :{
		   	        	            		// Liste personne malades
		   	        	            		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("**********"+" Liste des personnes Malades"
			        	             				+" **********"+ConsoleColors.RESET, 120 - 2));
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		ArrayList<Personne> list = c. list_personne_selon_etat(2);
			        	             		String[][] table = tableConsole.changeformat_personne(list);
			        	             		tableConsole.tableWithLinesAndMaxWidth(table);
		   	        	            	}
		   	        	            	case 4 :{
		   	        	            		// Liste personne Contaminées
		   	        	            		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("**********"+" Liste des personnes Contaminées"
			        	             				+" **********"+ConsoleColors.RESET, 120 - 2));
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		ArrayList<Personne> list = c. list_personne_selon_etat(1);
			        	             		String[][] table = tableConsole.changeformat_personne(list);
			        	             		tableConsole.tableWithLinesAndMaxWidth(table);
		   	        	            	}
		   	        	            	case 5 :{
		   	        	            		// Liste personne n’a eu aucun symptôme
		   	        	            		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("**********"+" Liste des personnes Contaminées"
			        	             				+" **********"+ConsoleColors.RESET, 120 - 2));
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		ArrayList<Personne> list = c.list_personne_selon_etat(3);
			        	             		String[][] table = tableConsole.changeformat_personne(list);
			        	             		tableConsole.tableWithLinesAndMaxWidth(table);
		   	        	            	}
		   	        	            }
	        	             		traitement(ges);
	        	             		break ;
	        	             	}
	        	             	// Affiche personne
	        	             	case 2 :{
	        	             		int cin ;
	        	             		System.out.println(ConsoleColors.GREEN+"Donnez le num de CIN de personne"+ConsoleColors.RESET);        		             		
	        	             		
	        	             		cin =clavier.nextInt();	
	        	             		
	        	             		if(!c.personne_estPresent(cin)) {
	        	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"Personne du num cin "
	        	             					+cin +" n'existe pas"+ConsoleColors.RESET);
	        	             		}
	        	             		else {
	        	             			Personne p = c.getPersonne(cin);
		        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("********** Personne Num CIN "+p.getNum_cin()+
		        	             				" **********"+ConsoleColors.RESET, 120 - 2));
		        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		        	             		p.affiche();
	        	             		}
		        	             	traitement(ges);
	        	             		break ;
	        	             	}
	        	             	// Ajout
	        	             	case 3 :{
	        	             		// 1- Entrez les données du personne à ajoutée
	        	             		System.out.println("Num de cin : ");
	        	             		int numcin;
	        	             		do {
	        	             			numcin = clavier.nextInt() ;
	        	             		}while(c.personne_estPresentv2(numcin));
	        	             		System.out.println("Nom : ");
	        	             		String nom = stringScanner.nextLine();
	        	             		System.out.println("Prénom : ");
	        	             		String prenom = stringScanner2.nextLine();
	        	             		System.out.println("Genre :");
	        	             		String genre ;
	        	             		do {
	        	             			System.out.println(ConsoleColors.RED+"Entrez F ou M"+ConsoleColors.RESET);
	        	             			genre = stringScanner.next();
	        	             		}while(!genre.equals("F") && !genre.equals("M"));
	        	             		System.out.println("Date de naissance : ");
	        	             		String date ;
	        	             		do {
	        	             			System.out.println(ConsoleColors.RED+"Date sous forme jj/mm/aaaa"+ConsoleColors.RESET);
	        	             			date = stringScanner2.nextLine() ;
	        	             		}while(!isDate(date));
	        	             		System.out.println("type_contamination :");
	        	             		System.out.println("Entrez "+ConsoleColors.BLACK_BOLD+" 0 "+ConsoleColors.RESET+" si un contact avec une personne malade");
	        	             		System.out.println("Entrez "+ConsoleColors.BLACK_BOLD+" 1 "+ConsoleColors.RESET+" si venant de l'etranger");
	        	             		int type ;
	        	             		do {
	        	             			type = stringScanner.nextInt();
	        	             		}while(type!=0 && type!=1);
	        	             		System.out.println("Etat :");
	        	             		System.out.println("Entrez "+ConsoleColors.BLACK_BOLD+" 2 "+ConsoleColors.RESET+" si personne malade mais sans symptômes graves");
	        	             		System.out.println("Entrez "+ConsoleColors.BLACK_BOLD+" 3 "+ConsoleColors.RESET+" si personne n’a eu aucun symptôme");
	        	             		int etat ;
	        	             		do {
	        	             			etat = stringScanner4.nextInt();
	        	             		}while(type!=2 && type!=3);
	        	             		System.out.println("Gouvernorat :"); 
	        	             		String gouvernorat ;
	        	             		do {
	        	             			gouvernorat= stringScanner3.nextLine();
	        	             		}while(!ges.gouvernorat_existev2(gouvernorat));
	        	             		
	        	             		Personne p = new Personne(numcin,nom,prenom,genre.charAt(0),date,gouvernorat,type,etat);
	        	             		// 2- Si il y'a une place disponible dans le centre si non on cherche le centre le plus proche
	        	             		if(c.getCapacite()<=c.nombre_chambre_libre_desinfecter()) {
	        	             			System.out.println(ConsoleColors.BLACK_BOLD+ConsoleColors.RED_BACKGROUND+
	        	             					"Centre Complet"+ConsoleColors.RESET);
	        	             			Gouvernorat g = ges.get_Gouvernorat(gouvernorat);// get gouvernorat de personne
	        	             			ArrayList <Centre>  listecentre = g.get_list_Centres();
	        	                        int b=0;           
	        	                        for(Centre c1:  listecentre ){
	        	                            if((c1.getCapacite()>c1.nombre_chambre_libre_desinfecter())&&(b==0)){
	        	            	                c1.ajouter_personne(p);
	        	            	                System.out.println(ConsoleColors.GREEN+"Personne ajoutée avec succée au centre "+
	        	            	                		c1.getNumero_ref()+ConsoleColors.RESET);
	    	        	             			p.affiche();	
	    	        	             			// Si ajouter c bn il faut l'affectée à une chambre
	    	        	             			ArrayList<Chambre> listcld = c1.list_chambre_libre_desinfecter();
	    	        	             			String[][] table = tableConsole.changeformat_chambre(listcld);
	    	        	             			tableConsole.tableWithLinesAndMaxWidth(table);
	    	        	             			System.out.println(ConsoleColors.GREEN+"Entrez le num de chambre :"+ConsoleColors.RESET);
	    	        	             			int numch ;
	    	        	             			do {
	    	        	             				numch = clavier.nextInt();
	    	        	             			}while(!c1.affecter_chambre(numch, p.getNum_cin()));
	    	        	             			System.out.println(ConsoleColors.GREEN+"Personne "+p.getNum_cin()+" affectée avec succée au chambre"
	    	        	             					+ "num "+numch+ConsoleColors.RESET);
	    	        	             		    b=1;
	        	                             }
	        	                        } 
	        	                        if(b==0){
											try {
												String[] t = g.Distance();
												int i=1;
		        	                            while(b==0){
			        	                            Gouvernorat g1=ges.get_Gouvernorat(t[i]);
			        	                            ArrayList <Centre>  lc=g1.get_list_Centres();
			        	                            for(Centre c1:  lc ){
			        	                                if((c1.getCapacite()>c1.nombre_chambre_libre_desinfecter())&&(b==0)){
			        	                                  c1.ajouter_personne(p); 
			        	                                  System.out.println(ConsoleColors.GREEN+"Personne ajoutée avec succée"
			        	                                  		+ " au centre "+c.getNumero_ref()+ConsoleColors.RESET);
			        	                                  p.affiche();
			        	                                  // Si ajouter c bn il faut l'affectée à une chambre
				    	        	             			ArrayList<Chambre> listcld = c1.list_chambre_libre_desinfecter();
				    	        	             			String[][] table = tableConsole.changeformat_chambre(listcld);
				    	        	             			tableConsole.tableWithLinesAndMaxWidth(table);
				    	        	             			System.out.println(ConsoleColors.GREEN+"Entrez le num de chambre :"+ConsoleColors.RESET);
				    	        	             			int numch ;
				    	        	             			do {
				    	        	             				numch = clavier.nextInt();
				    	        	             			}while(!c1.affecter_chambre(numch, p.getNum_cin()));
				    	        	             			System.out.println(ConsoleColors.GREEN+"Personne "+p.getNum_cin()+" affectée avec succée au chambre"
				    	        	             					+ "num "+numch+ConsoleColors.RESET);
			        	                                  b=1;
			        	                                }
			        	                            }
			        	                            i++;
		        	                            }
											} catch (IOException e) {
												System.out.println("Something went wrong");
											}
	        	                       }
	        	             		}
	        	             		else {
	        	             			c.ajouter_personne(p);
	        	             			System.out.println(ConsoleColors.GREEN+"Personne ajoutée avec succée au centre "+c.getNumero_ref()+ConsoleColors.RESET);
	        	             			p.affiche();       
	        	             		    // Si ajouter c bn il faut l'affectée à une chambre
	        	             			System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("**********"+" Liste des chambres libres et "
		        	             				+ "désinfectées **********"+ConsoleColors.RESET, 120 - 2));
		        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		        	             		
	        	             			ArrayList<Chambre> listcld = c.list_chambre_libre_desinfecter();
	        	             			String[][] table = tableConsole.changeformat_chambre(listcld);
	        	             			tableConsole.tableWithLinesAndMaxWidth(table);
	        	             			int numch ;
	        	             			do {
	        	             				System.out.println(ConsoleColors.GREEN+"Entrez le num de chambre :"+ConsoleColors.RESET);
	        	             				numch = clavier.nextInt();
	        	             			}while(!c.affecter_chambre(numch, p.getNum_cin()));
	        	             			System.out.println(ConsoleColors.GREEN+"Personne "+p.getNum_cin()+" affectée avec succée au chambre"
	        	             					+ "num "+numch+ConsoleColors.RESET);
	        	             		}
	        	             		traitement(ges);
	        	             		break ;
	        	             	}
	        	             	// Enregistrement de départ
	        	             	case 4 :{
	        	             		System.out.println(ConsoleColors.GREEN+"Donnez lu num de cin du personne :"+ConsoleColors.RESET);
	        	             		int cin = clavier.nextInt();
	        	             		c.supprime_personne(cin);
	        	             		traitement(ges);
	        	             		break ;
	        	             	}
	        	             }
	        	        }
	             		traitement(ges);
	             		break ;
	             	}
	             	// Chambre
	             	case 4:{
	             		System.out.println(ConsoleColors.GREEN+"Donnez le num de centre "+ConsoleColors.RESET);        		             		
	             		int num ;
	             		num =clavier.nextInt();	 
	             		if(!ges.cente_existe(num)) {
	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"Centre n'existe pas"+ConsoleColors.RESET);
	             		}
	             		else {
	             			 System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	        	             		  "1- Liste  "
	        	            		+ "2- Affiche Chambre  "
	        	             		+ "3- Nettoyer Chambre "
	        	            		+ "4- Affecter Chambre "
	        	             		+ "5- Libérer Chambre  ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	        	             System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             int n3;
	        	             do {
	        	             	System.out.println(ConsoleColors.RED_BOLD+"Tapez un numéro entre 1 et 5 :"+ConsoleColors.RESET);
	        	             	n3=clavier.nextInt();
	        	             }while(n3<1||n3>5);
	        	             Centre c = ges.get_cente(num);
	        	             switch(n3) {
	        	             	// liste
	        	             	case 1 :{
	        	             		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		   	        	            System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
		   	        	             		  "1- Tout  "
		   	        	            		+ "2- Chambres Disponibles  "
		   	        	             		+ "3- Chambres Occupées  "
		   	        	            		+ "4- Chambres Libres Inféctées", 120 - 2), 120, "|")+ConsoleColors.RESET);
		   	        	            System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		   	        	            int nc;
		   	        	            do {
		   	        	            	System.out.println(ConsoleColors.RED_BOLD+"Entrez un num entre 1 et 4"+ConsoleColors.RESET);
		   	        	            	nc = clavier.nextInt();
		   	        	            }while(nc<1||nc>5);
		   	        	            switch(nc) {
			   	        	         	case 1:{
		   	        	            		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("********** Liste des Chambres **********"+ConsoleColors.RESET, 120 - 2));
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		ArrayList <Chambre> Listc=new ArrayList<Chambre>() ;
			        	             		Listc =c.getList_chambres();
			    	        				String[][] tab2 = tableConsole.changeformat_chambre(Listc);
			    	        				tableConsole.tableWithLinesAndMaxWidth(tab2);
			        	             		traitement(ges);
			        	             		break ;
			   	        	            }
			   	        	         	case 2:{
		   	        	            		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("********** Liste des Chambres Disponibles **********"+ConsoleColors.RESET, 120 - 2));
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		ArrayList <Chambre> Listc=new ArrayList<Chambre>() ;
			        	             		Listc =c.list_chambre_libre_desinfecter();
			    	        				String[][] tab2 = tableConsole.changeformat_chambre(Listc);
			    	        				tableConsole.tableWithLinesAndMaxWidth(tab2);
			        	             		traitement(ges);
			        	             		break ;
			   	        	            }
			   	        	         	case 3:{
		   	        	            		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("********** Liste des Chambres Ocuppées **********"+ConsoleColors.RESET, 120 - 2));
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		ArrayList <Chambre> Listc=new ArrayList<Chambre>() ;
			        	             		Listc =c.list_chambre_occupees();
			    	        				String[][] tab2 = tableConsole.changeformat_chambre(Listc);
			    	        				tableConsole.tableWithLinesAndMaxWidth(tab2);
			        	             		traitement(ges);
			        	             		break ;
			   	        	            }
			   	        	         	case 4:{
		   	        	            		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("********** Liste des Chambres Libres Inféctées **********"+ConsoleColors.RESET, 120 - 2));
			        	             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
			        	             		ArrayList <Chambre> Listc=new ArrayList<Chambre>() ;
			        	             		Listc =c.list_chambre_libre_infecter();
			    	        				String[][] tab2 = tableConsole.changeformat_chambre(Listc);
			    	        				tableConsole.tableWithLinesAndMaxWidth(tab2);
			        	             		traitement(ges);
			        	             		break ;
			   	        	            }
		        	             	}
		   	        	            traitement(ges);
	        	             		break ;
	        	             	}
	        	             	// Affiche Chambre
	        	             	case 2 :{
	        	             		System.out.println(ConsoleColors.GREEN+"Donnez le num de chambre "+ConsoleColors.RESET);        		             		
	        	             		int numc ;
	        	             		numc =clavier.nextInt();	 
	        	             		if(!c.Chambre_existe(numc)) {
	        	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"Chambre n'existe pas"+ConsoleColors.RESET);
	        	             		}
	        	             		else {
	        	             			Chambre ch = c.getChambre(numc);
	        	             			System.out.println(ch);
	        	             		}
	        	             		traitement(ges);
	        	             		break ;
	        	             	}
	        	             	// Nettoyer Chambre
	        	             	case 3 :{
	        	             		System.out.println(ConsoleColors.GREEN+"Donnez le num de chambre "+ConsoleColors.RESET);        		             		
	        	             		int numc ;
	        	             		numc =clavier.nextInt();	 
	        	             		if(!c.Chambre_existe(numc)) {
	        	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"Chambre n'existe pas"+ConsoleColors.RESET);
	        	             		}
	        	             		else {
	        	             			Chambre ch = c.getChambre(numc);
	        	             			ch.Nettoyer_chambre();
	        	             		}
	        	             		traitement(ges);
	        	             		break ;
	        	             	}
	        	             	//Affecter Chambre
	        	             	case 4:{
	        	             		System.out.println(ConsoleColors.GREEN+"Donnez le num de chambre "+ConsoleColors.RESET);        		             		
	        	             		int numc ;
	        	             		numc =clavier.nextInt();	 
	        	             		if(!c.Chambre_existe(numc)) {
	        	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"Chambre n'existe pas"+ConsoleColors.RESET);
	        	             		}
	        	             		else{
	        	             			System.out.println(ConsoleColors.GREEN+"Donnez le num de cin de personne "+ConsoleColors.RESET);        		             		
	        	             			int cin ;
		        	             		cin =clavier.nextInt();	 
		        	             		if(!c.personne_estPresent(cin)) {
		        	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"personne n'existe pas"+ConsoleColors.RESET);
		        	             		}else {
		        	             			Chambre ch = c.getChambre(numc);
		        	             			c.affecter_chambre(numc, cin);
		        	             		}
	        	             		}
	        	             		
	        	             		traitement(ges);
	        	             		break ;
	        	             	}
	        	             	case 5:{
	        	             		System.out.println(ConsoleColors.GREEN+"Donnez le num de chambre "+ConsoleColors.RESET);        		             		
	        	             		int numc ;
	        	             		numc =clavier.nextInt();	 
	        	             		if(!c.Chambre_existe(numc)) {
	        	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"Chambre n'existe pas"+ConsoleColors.RESET);
	        	             		}
	        	             		else {
	        	             			Chambre ch = c.getChambre(numc);
	        	             			ch.libérer_chambre();
	        	             		}
	        	             		traitement(ges);
	        	             		break ;
	        	             	}
	        	             }
	             		}   
	             		traitement(ges);
	             		break ;
	             	}
	             	//Statistique
	             	case 5:{
	             		System.out.println(ConsoleColors.GREEN+"Donnez le num de centre "+ConsoleColors.RESET);        		             		
	             		int num ;
	             		num =clavier.nextInt();	 
	             		if(!ges.cente_existe(num)) {
	             			System.out.println(ConsoleColors.RED_BACKGROUND+ConsoleColors.BLACK_BOLD+"Centre n'existe pas"+ConsoleColors.RESET);
	             		}
	             		else {
	             			 System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	        	             		  "1- Statistique Chambre  "
	        	            		+ "2- Statistique Personne  ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	        	             System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        	             int n3;
	        	             do {
	        	             	System.out.println(ConsoleColors.RED_BOLD+"Tapez un numéro entre 1 et 2 :"+ConsoleColors.RESET);
	        	             	n3=clavier.nextInt();
	        	             }while(n3<1||n3>2);
	        	             Centre c = ges.get_cente(num);
	        	             switch(n3) {
		        	             case 2:{
		        	            	System.out.println(ConsoleColors.RED+"Nombre des personnes Contaminées "+
		        	            			ConsoleColors.RESET+ConsoleColors.BLACK_BOLD+c.list_personne_selon_etat(1).size()
		        	            			+ConsoleColors.RESET);
		        	            	System.out.println(ConsoleColors.BLUE+"Nombre des personnes malades "+
		        	            			ConsoleColors.RESET+ConsoleColors.BLACK_BOLD+c.list_personne_selon_etat(2).size()
		        	            			+ConsoleColors.RESET);
		        	            	System.out.println(ConsoleColors.GREEN+"Nombre des personnes n'ont aucun symptome "+
		        	            			ConsoleColors.RESET+ConsoleColors.BLACK_BOLD+c.list_personne_selon_etat(3).size()
		        	            			+ConsoleColors.RESET);
		        	            	traitement(ges);
		     	             		break ; 
		        	             }
		        	             case 1:{
		        	            	 System.out.println(ConsoleColors.RED+"Nombre des chambres libres désinfectée "+
			        	            			ConsoleColors.RESET+ConsoleColors.BLACK_BOLD+c.nombre_chambre_libre_infecter()
			        	            			+ConsoleColors.RESET);
			        	            	System.out.println(ConsoleColors.BLUE+"Nombre des chambres ocuppées "+
			        	            			ConsoleColors.RESET+ConsoleColors.BLACK_BOLD+c.nombre_chambres_occupees()
			        	            			+ConsoleColors.RESET);
			        	            	System.out.println(ConsoleColors.GREEN+"Nombre des chambres disponible "+
			        	            			ConsoleColors.RESET+ConsoleColors.BLACK_BOLD+c.nombre_chambre_libre_desinfecter()
			        	            			+ConsoleColors.RESET);
		        	            	traitement(ges);
		     	             		break ;
		        	             }
	        	             }
	             		}
	             		traitement(ges);
	             		break ;
	             	}
	             }
	             ;break;
	        }        
	        //gouvernorat 
	        case 3 :     	
	        	{	
	        		System.out.println(ConsoleColors.GREEN+"Donnez le nom du gouvernorat "+ConsoleColors.RESET);
					String ch ;
					do {
             			ch= stringScanner.nextLine();
             		}while(!ges.gouvernorat_existev2(ch));
	        		Gouvernorat gouv=ges.get_Gouvernorat(ch);// Get gouvernorat
	        		
	        		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        		System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	          		  "1- Gestion des centres   "
	          		+ "2- Information     "
	          		+ "3- Statistique ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	        		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	          
	        		int p = clavier.nextInt();
	        	
	        		switch (p) {
	        		//Gestion des centres
	        		case 1 :
	        		{	
	        			System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	            		System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	              		  "1- Ajouter centre   "	
	              		+ "2- Suprimer centre ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	            		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	            		
	            		int i;
	            		do {
	            			System.out.println(ConsoleColors.RED_BOLD+"Entrez un num entre 1 et 2 :"+ConsoleColors.RESET);
	            			i = clavier.nextInt();
	            		}while(i<1||i>2);
	            		
	            		switch (i) {
	            		// Ajouter Centre
		            		case 1 :
			            	{	
			            		System.out.println(ConsoleColors.GREEN+"Donnez les caractéristique de centre à ajouter"+ConsoleColors.RESET);        		             		
			             		System.out.println("Num de Ref :");
			             		int num ;
			             		do {
			             			num =clavier.nextInt();	             				             			
			             		}while(gouv.centre_existev2(num)==true);             		
			             		System.out.println("adresse :");
			             		String adresse = stringScanner.nextLine() ;
			             		System.out.println("Capacite :");
			             		int capacite =clavier.nextInt() ; 
			             		           	             		
			             		Centre c = new Centre(num,adresse,ch,capacite);            		
			             		
			             		gouv.ajouter_centre(c);
			             		System.out.println("Le "+c+ConsoleColors.GREEN+" Ajoutée avec succées"+ConsoleColors.RESET);                		
			             		      	             		
			             		traitement(ges);
			             		break ;
		            		}
			            	// Supprimer centre
			            	case 2 :
		            		{	
		            				System.out.println (ConsoleColors.GREEN+"donner le num de ref du centre"+ConsoleColors.RESET);
									int num = clavier.nextInt();
									Centre C = gouv.get_centre(num);
									gouv.supprimer_centre(C);
									System.out.println(ConsoleColors.GREEN+"Centre Supprimée avec succée");
									traitement(ges);
				             		break ;
							}
	            		}
	            		traitement(ges);
	             		break ;
	        		}
	        		// Information
	        		case 2 :
	        		{      	
		        			System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("********** Liste des Centres du "
		             				+gouv.get_nom() +" **********"+ConsoleColors.RESET, 120 - 2));
		             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
		             		
	        				ArrayList <Centre> L=new ArrayList<Centre>() ;
	        				L =gouv.get_list_Centres();
	        				String[][] m = tableConsole.changeformat_centre(L);
	        				tableConsole.tableWithLinesAndMaxWidth(m);
	        				traitement(ges);
		             		break ;
	        		}
	        		// S
	        		case 3 :
	        			{
	        				float pourcentage = ges.pourcentage_contamination_gouv(ch);
		        			System.out.println(ConsoleColors.RED+"le poucentage de contamination est du "+
	        				gouv.get_nom()+" est " + pourcentage + "%"+ConsoleColors.RESET);
		        			traitement(ges);
		             		break ;
	        			}
	        		}
	        	traitement(ges);
	        	break ;
	        }        		
	        //gestion         	
	        case 4 :
	        {	
	        	System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	    		System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	      		  "1- Liste des gouvernorats "
	      		+ "2- Gestion des gouvernorats    "
	      		+ "3- Statistique  ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	    		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	    		int p = clavier.nextInt();
	        	
	    		switch (p) {
	    		// Liste des gouvernorats
	    		case 1 :
	    		{
	    			System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
             		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("********** Liste des Gouvernorats **********"+ConsoleColors.RESET, 120 - 2));
             		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
             		
	    			ArrayList <Gouvernorat> L=new ArrayList<Gouvernorat>() ;
					L =ges.get_list_Gouvernorats();
					String[][] m = tableConsole.changeformat_gouvernorat(L);
					tableConsole.tableWithLinesAndMaxWidth(m);
					traitement(ges);
					break ;
	    			
	    		}
	    		//Gestion des gouvernorats
	    		case 2:
	    		{
	    			System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        		System.out.println(ConsoleColors.BLUE_BOLD+StringUtils.center(StringUtils.center(
	          		  "1- Ajouter gouvernorat   "
	          		+ "2- Suprimer gouvernorat ", 120 - 2), 120, "|")+ConsoleColors.RESET);
	        		System.out.println(ConsoleColors.BLUE+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
	        		int i = clavier.nextInt();
	        		switch (i) {
	        		// Ajouter gouvernorat
		        		case 1 :
		        		{
		        			if(ges.get_list_Gouvernorats().size()<24) {
			        			System.out.println (ConsoleColors.GREEN+"Donnez le nom du gouvernorat "+ConsoleColors.RESET);
								String nom;
								do {
			             			nom= stringScanner.nextLine();
			             		}while(ges.gouvernorat_existev3(nom));
								Gouvernorat gouv = new Gouvernorat (nom);
								ges.Ajouter_Gouvernorat(gouv);
								System.out.println(ConsoleColors.GREEN+"Gouvernorat "+gouv.get_nom()+" ajoutées avec succée"
										+ConsoleColors.RESET);
							}
		        			else {
		        				System.out.println(ConsoleColors.RED+"Vous ne pouvez pas ajoutées d'autre gouvernorat"
		        						+ " il existe déja 24 gouvernorats ");
		        			}
							traitement(ges);
							break ;
						}
		        		//Supprimer gouvernorat
		        		case 2 :
		        		{	
		        			System.out.println (ConsoleColors.GREEN+"Donnez le nom du gouvernorat "+ConsoleColors.RESET);
							String nom;
							do {
		             			nom= stringScanner.nextLine();
		             		}while(!ges.gouvernorat_existev2(nom));
							Gouvernorat gouv = ges.find_gouvernorat(nom);
							ges.Supprimer_gouvernorat(gouv);
							System.out.println(ConsoleColors.GREEN+"Gouvernorat "+gouv.get_nom()+" supprimée avec succée "+
							ConsoleColors.RESET);
							traitement(ges);
							break ;
						}
	        		}
	    		}
	    		// Statistique
	    		case 3: 
	    		{   			   			
	    			int nombre = ges.nbr_personnes_acceillies() ;
	    			float pourcentage = ges.pourcentage_contamination() ;
	    			System.out.println(ConsoleColors.GREEN+"le nomre totale de personnes acceillies est "+ConsoleColors.RESET+ConsoleColors.BLACK_BOLD +nombre+ConsoleColors.RESET); 
	    			System.out.println(ConsoleColors.RED+"le poucentage de contamination est " +ConsoleColors.RESET+ConsoleColors.BLACK_BOLD +  pourcentage + "% "+ConsoleColors.RESET); 
	    			traitement(ges);
	    			break ;
	    		}
	    		     
	    	}
	    	}
	        
	     }//fin switch
       
	}
	
	
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in) ; 
		int w = 120;
		int n ;// choix menu
		
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
                    
        /*
         * Initialiser la liste des gouvernorat à partir de fichier initgouv.csv
         */
        Gestion ges = new Gestion(); //C'est notre systéme 
        ges.init_gouvernorat(); // tous les gouvernorat sont ajoutées au systéme
        ges.init_centre(); // initialisation des centres
        ges.initpersonne("/files/personneCentre1.csv",123);
        ges.initchambre("/files/chambreCentre1.csv", 123);
        
        Test.traitement(ges);
        
	}//fin main
}// fin classe

