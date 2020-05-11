package projet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Gestion {
	
	private ArrayList<Gouvernorat> list_Gouvernorats;
	
	public Gestion()
	{
		list_Gouvernorats = new ArrayList<Gouvernorat>() ;
	}
	/*
	 * INITIALISATION
	 */
	public void init_gouvernorat() {
		String filePath = new File("").getAbsolutePath();
		String csvFile = filePath.concat("/files/initgouv.csv");
		
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] g = line.split(cvsSplitBy);
                Gouvernorat gouv = new Gouvernorat(g[0]) ;
                this.Ajouter_Gouvernorat(gouv);    
               
            }                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * Initialisation des centre
	 */
	
	public void init_centre() {
		String filePath = new File("").getAbsolutePath();
		String csvFile = filePath.concat("/files/initcentre.csv");
		
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] centre = line.split(cvsSplitBy);
                if(this.gouvernorat_existe(centre[2])) {
                   if(!this.cente_existe(Integer.parseInt(centre[0]))) {
                	 Gouvernorat g = this.get_Gouvernorat(centre[2]);
                	 Centre c = new Centre(Integer.parseInt(centre[0]),centre[1],centre[2],Integer.parseInt(centre[3])) ;                             
                	 g.ajouter_centre(c);                	 
                   }  
                }
            }                
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * Initialisation des chambre
	 */
	public void initchambre(String file, int numcentre) {
		String filePath = new File("").getAbsolutePath();
		String csvFile = filePath.concat(file);
		
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] chambre = line.split(cvsSplitBy);
                if(this.cente_existe(numcentre)) {
                	Centre c = this.get_cente(numcentre);               
	                if(c.getCapacite()<=c.getList_chambres().size()) {
	        			//System.out.println("Centre Complet");
	        		}
	                else {
	                	if(Integer.parseInt(chambre[3])==0) {
	                	  Chambre ch = new Chambre(Integer.parseInt(chambre[0]),Integer.parseInt(chambre[1]),
	                     		Integer.parseInt(chambre[2]),Integer.parseInt(chambre[3]));
	                	  c.ajout_chambres(ch); 
	                	}	                
	                	else {
	                		if(! c.personne_estPresent(Integer.parseInt(chambre[3]))) {
	                			/*System.out.println("Ce personne n'existe pas dans la liste sous le num de CIN "
	                					+Integer.parseInt(chambre[3])+" des personnes affectées aux centres");*/
	                			Chambre ch = new Chambre(Integer.parseInt(chambre[0]),Integer.parseInt(chambre[1]),
	                             		Integer.parseInt(chambre[2]));
	                			 ch.setEtat(0);
	                			 c.ajout_chambres(ch); 
	                		}
	                		else {
	                			Chambre ch = new Chambre(Integer.parseInt(chambre[0]),Integer.parseInt(chambre[1]),
	                             		Integer.parseInt(chambre[2]),Integer.parseInt(chambre[3]));
	                			Personne p = c.getPersonne(Integer.parseInt(chambre[3]));
	                			p.setNum_chambre(Integer.parseInt(chambre[0]));
	                			c.ajout_chambres(ch);  
	                		}
	                	}                                	
	                }
                }
                     
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
	 * Initialisation des personne
	 */
	public void initpersonne(String file, int numcentre) {
		String filePath = new File("").getAbsolutePath();
		String csvFile = filePath.concat(file);
		
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] personne = line.split(cvsSplitBy);
                if(this.cente_existe(numcentre)) {
                	Centre c = this.get_cente(numcentre);
	                Personne p = new Personne(Integer.parseInt(personne[0]),personne[1],personne[2],personne[3].charAt(0),personne[4]
	                		,personne[5], Integer.parseInt(personne[6]),personne[7],Integer.parseInt(personne[8]));    
	                c.ajouter_personne(p);
	            }
                     
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	
	// Debut Ajout Selon Gouvernorat
	public ArrayList <Centre> affectation_proposée(String nom,int nb) throws IOException {
		// Remplissage de la liste
        Gouvernorat g=this.get_Gouvernorat(nom);
        ArrayList <Centre> listecentreDispo = new ArrayList<Centre>();
        int[] tab = new int[nb];int j=0;
        //Liste centre disponible Dans 
        int b=0; // variable d'incrémentation jusqu'a le nombre demander atteint
       
        ArrayList <Centre>  listecentre =g.get_list_Centres();
        for(Centre c:  listecentre ){
            if((c.getCapacite()>c.nombre_chambre_libre_desinfecter())&&(b<nb)){
            	listecentreDispo.add(c) ;
            	if(b<=c.nombre_chambre_libre_desinfecter()) {
            		b+=c.nombre_chambre_libre_desinfecter();
            		tab[j]=c.nombre_chambre_libre_desinfecter();
            		j++;
            	}
            	else {
            		tab[j]=nb-b;
            		j++;
            		b+=nb-b;
            	}
             }
        }               
        if(b<nb){
          String[] t = g.Distance();
          int i=1;
          while(b<nb){
              Gouvernorat g1=this.get_Gouvernorat(t[i]);
              ArrayList <Centre>  lc=g1.get_list_Centres();
                       
              for(Centre c:  lc ){
                  if((c.getCapacite()>c.nombre_chambre_libre_desinfecter())&&(b<nb)){
                	  listecentreDispo.add(c) ;
                	  if(b<=c.nombre_chambre_libre_desinfecter()) {
                		b+=c.nombre_chambre_libre_desinfecter();
                  		tab[j]=c.nombre_chambre_libre_desinfecter();
                  		j++;
                	  }else {
                		tab[j]=nb-b;
                  		j++;
                  		b+=nb-b;	
                  	  }
                  }
              }
              i++; 
          }
       }
        // Affichage de la liste 
        System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
 		System.out.println(ConsoleColors.GREEN_BOLD+StringUtils.center("**********"+" Affectation Proposée "
 				+" **********"+ConsoleColors.RESET, 120 - 2));
 		System.out.println(ConsoleColors.GREEN+StringUtils.rightPad("+", 120 - 1, "-") + "+"+ConsoleColors.RESET);
 		String[][] table = new String[listecentreDispo.size()+1][3] ;
		table[0][0] = "Numéro Ref" ; table[0][1] = "Gouvernorat" ; table[0][2] ="Nombres Des Personne" ;
		int nbrcentre = 1;
		for(Centre c :listecentreDispo) {
			table[nbrcentre][0]=Integer.toString(c.getNumero_ref());
			table[nbrcentre][1]=c.getGouvernorat();
			table[nbrcentre][2]=Integer.toString(tab[nbrcentre-1]);
			nbrcentre++;
		}
 		tableConsole.tableWithLinesAndMaxWidth(table);
 		// retourner la liste 
 		return listecentreDispo ;
}

	public void entrezpersonne(Centre c,String gouv) {
		Scanner stringScanner = new Scanner(System.in);
		Scanner stringScanner2 = new Scanner(System.in);
		Scanner stringScanner3 = new Scanner(System.in);
		Scanner stringScanner4 = new Scanner(System.in);
		Scanner clavier = new Scanner(System.in) ; 
		
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
 		}while(!Test.isDate(date));
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
 			etat = clavier.nextInt();
 		}while(etat!=2 && etat!=3);
 		
 		Personne p = new Personne(numcin,nom,prenom,genre.charAt(0),date,gouv,type,etat);
 		c.ajouter_personne(p);
 		// Si ajouter c bn il faut l'affectée à une chambre
 		System.out.println(ConsoleColors.BLUE+"Liste des chambre disponibles "+ConsoleColors.RESET);
			ArrayList<Chambre> listcld = c.list_chambre_libre_desinfecter();
			String[][] table = tableConsole.changeformat_chambre(listcld);
			tableConsole.tableWithLinesAndMaxWidth(table);
			System.out.println(ConsoleColors.GREEN+"Entrez le num de chambre :"+ConsoleColors.RESET);
			int numch ;
			do {
				numch = clavier.nextInt();
			}while(!c.affecter_chambre(numch, p.getNum_cin()));
			System.out.println(ConsoleColors.GREEN+"Personne "+p.getNum_cin()+" affectée avec succée au chambre"
					+ "num "+numch+ConsoleColors.RESET);
	}
	public void ajoutpersonne(ArrayList <Centre> list ,int nb,String gouv) {
		int b =0;
		for(Centre c:  list ){
		while((c.getCapacite()>c.nombre_chambre_libre_desinfecter())&&(b<nb)) {
            System.out.println(ConsoleColors.BLUE+"Entrez les données de personne num "+(b+1)
            			+ConsoleColors.RESET);
            	this.entrezpersonne(c, gouv);
     			// c bn
     			b++;
			}
        }               
	}
	// Fin Ajout Selon Gouvernorat
	
	public boolean gouvernorat_existe(String ch)
	{
		for(Gouvernorat g  : list_Gouvernorats) {
			 { 
				 if (g.get_nom().equals(ch))
					 return true ;
			 }			
		}		
		return false ;
	}
	
	public boolean gouvernorat_existev2(String ch)
	{
		boolean ok = false ; 
		for(Gouvernorat g  : list_Gouvernorats) {
			 { 
				 if (g.get_nom().equals(ch))
					 ok = true ;
			 }			
		}
		if(!ok) {
			System.out.println(ConsoleColors.RED+"Gouvernorat "+ch+" n'existe pas "+ConsoleColors.RESET);
		}
		return ok ;
	}
	public boolean gouvernorat_existev3(String ch)
	{
		boolean ok = false ; 
		for(Gouvernorat g  : list_Gouvernorats) {
			 { 
				 if (g.get_nom().equals(ch))
					 ok = true ;
			 }			
		}
		if(ok) {
			System.out.println(ConsoleColors.RED+"Gouvernorat "+ch+" existe pas "+ConsoleColors.RESET);
		}
		return ok ;
	}
	
	public boolean cente_existe(int num) {
		for(Gouvernorat g  : list_Gouvernorats) {
			 { 
				 if (g.centre_existe(num))
					 return true ;
			 }			
		}
		return false;		
	}
	public Centre get_cente(int num) {
		for(Gouvernorat g  : list_Gouvernorats) {
			 { 
				 if (g.centre_existe(num))
					 return g.get_centre(num) ;
			 }			
		}
		return null;		
	}
	
	public Gouvernorat get_Gouvernorat(String nom) {
		if(gouvernorat_existe(nom)) {
			for(Gouvernorat g  : list_Gouvernorats) {
				 { 
					 if (g.get_nom().equals(nom))
						 return g ;
				 }			
			}
		}
		else {
			System.out.println(ConsoleColors.RED+"Gouvernorat sous le nom "+ nom +" n'existe pas"+ConsoleColors.RESET);			
		}
		return null;	
	}
	
	public void Ajouter_Gouvernorat(Gouvernorat g)
	{
		if (! gouvernorat_existe(g.get_nom()))
			this.list_Gouvernorats.add(g); 
		else 
			System.out.println("le gouvernorat existe déja \n");
	}
	
	public void Supprimer_gouvernorat(Gouvernorat g)
	{
		if (gouvernorat_existe(g.get_nom()))		
		{
			this.list_Gouvernorats.remove(g);
			System.out.println("le gouvernorat a été supprimé avec succé \n ");
		}
		else 
			System.out.println("le gouvernorat n'existe pas ");

	}
	public ArrayList<Gouvernorat> get_list_Gouvernorats()
	{
		return(this.list_Gouvernorats);
	}
	
	public int nbr_contamination()
	{
		ArrayList<Personne> L= new ArrayList<Personne>() ;
		int n=0 ;
		for (Gouvernorat g : list_Gouvernorats)
			{	
				for (Centre c : g.get_list_Centres())		
				{
					L = c.list_personne_selon_etat(2);
					n += L.size() ;
				}
			}
		return (n); 		
	}
	
	public int nbr_personnes_acceillies()
	{
		int n=0 ;
		for (Gouvernorat g : list_Gouvernorats)
		{	
			for (Centre c : g.get_list_Centres())
			{ 
				//n+= c.get_nbr_per_tot(); 
				n+=c.getNombre_personnes();
			}
		}
		return (n);
	}
	
	//pourcentage de contamination total
	public float pourcentage_contamination()
	{   float p=0;
		if(nbr_personnes_acceillies()!=0)
			 p=nbr_contamination()/nbr_personnes_acceillies()*100;
		return (p);
	}
	
	public Gouvernorat find_gouvernorat(String ch)
	{ 
		Gouvernorat f = null ;
		if (gouvernorat_existe(ch))
		{
			for ( Gouvernorat g :list_Gouvernorats )
				{
					if (g.get_nom().equals(ch))
						f=g ;
				} 
		}
		return (f);
	}
	
	// pourcentage de contamination par gouvernorat
	public float pourcentage_contamination_gouv(String ch)
	{
		if( gouvernorat_existe(ch) )
		{
			int n=0 ;
			int m=0 ;
			ArrayList <Personne> L= new ArrayList <Personne>() ;
			Gouvernorat g = find_gouvernorat(ch ) ;
			for (Centre c : g.get_list_Centres())			
			{
				L = c.list_personne_selon_etat(2);
				n += L.size () ;
				m+=c.get_nbr_per_tot();	
				if(m!=0) {
					return (n/m * 100);
				}
				else {
					System.out.println("Cette gouvernorat n'a aucun personne contaminées \n");
					return 0 ;
				}
			} 
		}
		else 
			System.out.println ("gouvernorat incorrect \n");
		    return(0);
	}
	
	
	//pourcentage contamination par centre
	public Centre find_Centre (int n)
	{ 
		Centre c = null ;
	    for ( Gouvernorat g :list_Gouvernorats ) {
			if ( g.centre_existe(n) )
			{	
				for (Centre d : g.get_list_Centres())
				{
					if (d.getNumero_ref()==n)
						c=d ;
					} 
				}
			else 
				System.out.println("centre n'existe pas \n");
	    }
		return (c);
	}
	
	public float pourcentage_contamination_cen(int n )
	{
		Centre c ;
		ArrayList <Personne> L= new ArrayList <Personne>() ;
		c=find_Centre(n);
		if(c!=null) {
			L = c.list_personne_selon_etat(2);
			int x= L.size() ;
			int y= c.get_nbr_per_tot() ;
			return (x/y *100);
		}
		return 0;
	}
	
	public void affiche_list_gouvernorat()
	{		
		for(Gouvernorat g:list_Gouvernorats)
		{
			System.out.println(g.get_nom());
			g.affiche_liste_centres();
		}
	}
}
