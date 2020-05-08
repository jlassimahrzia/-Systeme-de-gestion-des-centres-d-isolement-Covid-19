package projet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	        			System.out.println("Centre Complet");
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
