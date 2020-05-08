package projet;

import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Centre {
	private int numero_ref ;
	private String adresse ;
	private String gouvernorat ;
	private int capacite ; 
	private int nombre_personnes ;
	private int nombre_per_tot;
	private ArrayList<Personne>  list_personnes ;
	private ArrayList<Chambre>  list_chambres ;
	
	public ArrayList<Personne> getList_personnes() {
		return list_personnes;
	}

	public ArrayList<Chambre> getList_chambres() {
		return list_chambres;
	}
	
	public int getNombre_per_tot() {
		return nombre_per_tot;
	}
		
	public Centre(int numero_ref, String adresse, String gouvernorat, int capacite) {
		this.numero_ref = numero_ref;
		this.adresse = adresse;
		this.gouvernorat = gouvernorat;
		this.capacite = capacite;
		list_personnes = new ArrayList<Personne>();
		this.nombre_personnes = list_personnes.size();	
		list_chambres = new ArrayList<Chambre>();
	}
	
	public String toString() {
		return "Centre "+this.numero_ref+"\n Adresse : "+this.adresse+
				"\n Gouvernorat : "+this.gouvernorat+" \n Capcité : "+this.capacite+" \n";
	}
	
	/**
	 * Getters And Setters
	 */
	
	public int getNumero_ref() {
		return numero_ref;
	}
	public void setNumero_ref(int numero_ref) {
		this.numero_ref = numero_ref;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getGouvernorat() {
		return gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	public int getCapacite() {
		return capacite;
	}
	public int getNombre_personnes() {
		return nombre_personnes ;
	}
	public int get_nbr_per_tot()
	{
		return nombre_per_tot;	
	}
	
	/**
	 * Gestion Des Personnes
	 */
	
	public void affiche_list_personnes() {
		for(Personne p : list_personnes) {
			p.affiche();
		}
	}
	
	public void ajouter_personne (Personne p) {
		if(this.capacite<=this.nombre_personnes) {
			System.out.println("Centre Complet");
		}
		else {
			this.list_personnes.add(p);
			this.nombre_personnes++;
		}
	}
	public void ajouter_personnev2(Personne p) throws IOException {
		if(this.capacite<=this.nombre_personnes) {			
			System.out.println("Centre Complet");
            Gouvernorat g=new Gouvernorat(gouvernorat);
            ArrayList <Centre>  listecentre;
            listecentre=g.get_list_Centres();
            int b=0;           
            for(Centre c:  listecentre ){
                if((c.capacite>c.nombre_personnes)&&(b==0)){
	                c.list_personnes.add(p);
				    c.nombre_personnes++;  
                    b=1;
                 }
            }               
            if(b==0){
              String[] t= g.Distance();
              int i=1;
              while(b==0){
              Gouvernorat g1=new Gouvernorat(t[i]);
              ArrayList <Centre>  lc;
              lc=g.get_list_Centres();
                       
              for(Centre c:  listecentre ){
                  if((c.capacite>c.nombre_personnes)&&(b==0)){
                    c.list_personnes.add(p);
			        c.nombre_personnes++;  
                    b=1;
                  }
              }
              i++; 
            }
           }
		}
		else {
			this.list_personnes.add(p);
			this.nombre_personnes++;
		}
	}


	// Vérifier l'existance de personne dans la centre
	public boolean personne_estPresent(int cin) {
		
		for(Personne p : list_personnes) {
			if(p.getNum_cin()==cin) {
				return true ;
			}			
		}
		return false ;
	}
	public boolean personne_estPresentv2(int cin) {
		boolean ok = false ;
		for(Personne p : list_personnes) {
			if(p.getNum_cin()==cin) {
				ok= true ;
			}			
		}
		if(ok) {
			System.out.println(ConsoleColors.RED+"Personne du num cin "+cin+" existe déja "+ConsoleColors.RESET);
		}
		return ok ;
	}
	
	public Personne getPersonne(int cin){
		if(personne_estPresent(cin)) {
			for(Personne p : list_personnes) {
				if(p.getNum_cin()==cin) {
					return p ;
				}			
			}
		}
		return null ;
	}
	
	//Changer état d'une personne de la centre 	
	public void changer_etat(int cin , int etat) {
		Personne p ;
		if(personne_estPresent(cin)) {
			p = this.getPersonne(cin);
			p.changer_etat(etat);
		}
		else {
			System.out.println("le personne de num de cin "+cin+" n'existe pas dans ce centre");
		}
	}
	//Le nombre de jours restant d'une personne dans la centre
	public void nbr_jour_restant_personne(int cin) {
		Personne p ;
		if(personne_estPresent(cin)) {
			p = this.getPersonne(cin);
			System.out.println("le nombre de jours restants de la personne de num cin "+cin+" est "
					+ p.nb_jour_restant()+" jour son date de sortie est "+p.getDate_sortie());
		}
		else {
			System.out.println("le personne de num de cin "+cin+" n'existe pas dans ce centre");
		}
	}
	
	// Enregistrement de dapart de personne de la centre
	public void supprime_personne(int cin) {
		Personne p ;
		if(!personne_estPresent(cin)) {
			System.out.println(ConsoleColors.RED+"le personne de num de cin "+cin+" n'existe pas dans ce centre"
					+ConsoleColors.RESET);
		}
		else {
			p = this.getPersonne(cin);
			if(p.getEtat()!=3) {
				if(p.getEtat()==2) {
					System.out.println(ConsoleColors.RED+"Personne de num de cin "+cin+" est malade mais sans symptômes"
							+ " graves ne peut pas sortir de la centre il faut élargir son période"+ConsoleColors.RESET);
				}
				else if(p.getEtat()==1) {
					this.list_personnes.remove(p);
					System.out.println(ConsoleColors.GREEN+"Suppressin avec succées"+ConsoleColors.RESET);
				}
			}
			else {
				if(p.nb_jour_restant()!=0) {
					System.out.println(ConsoleColors.RED+"le personne de num cin "+cin+" n'est finir ses 14 jours il le reste "
							+ p.nb_jour_restant()+" jour leur date de sortie est "+p.getDate_sortie()+ConsoleColors.RESET);
				}
				else {
					this.list_personnes.remove(p);
					System.out.println(ConsoleColors.GREEN+"Suppressin avec succées"+ConsoleColors.RESET);
				}
			}
		}
	}
	
	/**
	 * Gestion Des Chambres
	 */
	
	public void ajout_chambres(Chambre c) {
		this.list_chambres.add(c);
	}
	
	public void affiche_list_chambres() {
		for(Chambre c : list_chambres) {
			System.out.println(c);
		}
	}

	public Chambre getChambre(int num){		
		for(Chambre c : list_chambres) {
			if(c.getNum_chambre()==num) {
				return c ;
			}			
		}
		return null ;
	}
	public boolean Chambre_existe(int num){		
		for(Chambre c : list_chambres) {
			if(c.getNum_chambre()==num) {
				return true ;
			}			
		}
		return false ;
	}
	
	public boolean affecter_chambre(int numchambre ,int numpersonne) { 
		if(this.Chambre_existe(numchambre)) {
			Chambre c = this.getChambre(numchambre);
			if(this.personne_estPresent(numpersonne)) {
				return c.affecter_chambre(numpersonne);
			}
			else {
				System.out.println("n'existe pas dans la liste une personne sous le num de CIN "+
						numpersonne);		
				return false ;
			}
		}
		else {
			System.out.println("n'existe pas une chambre sous cette numéro \n");
			return false;
		}
	}
	
	/**
	 * Statistique Personnes
	 */
	
	// Return la liste des personnes qui vont sortir ce jour 
	public ArrayList<Personne> list_personnes_sortes(){
		ArrayList<Personne> list = new ArrayList<Personne>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");// current day
        Date dateobj = new Date();
        String dd = df.format(dateobj);
        for(Personne p : this.list_personnes) {
        	if(p.getDate_sortie().equals(dd)) {
        		list.add(p);
        	}
        }
		return list ;
	}
	
	public ArrayList<Personne> list_personne_selon_etat(int etat){
		ArrayList<Personne> list = new ArrayList<Personne>();
		for(Personne p : this.list_personnes) {
        	if(p.getEtat()==etat) {
        		list.add(p);
        	}
        }
		
		return list ;
	}
	
	/**
	 * Statistique Chambre
	 */
	public int nombre_chambre_libre_infecter() {
		int nbr = 0 ;
		for(Chambre c : list_chambres) {
			if(c.getEtat()==0 && c.getDesinfecter()==1) {
				nbr++;
			}
		}
		return nbr ;
	}
	public ArrayList<Chambre> list_chambre_libre_infecter() {
		ArrayList<Chambre> list = new ArrayList<Chambre>();
		for(Chambre c : list_chambres) {
			if(c.getEtat()==0 && c.getDesinfecter()==1) {
				list.add(c);
			}
		}
		return list ;
	}
	public int nombre_chambre_libre_desinfecter() {
		int nbr = 0 ;
		for(Chambre c : list_chambres) {
			if(c.getEtat()==0 && c.getDesinfecter()==0) {
				nbr++;
			}
		}
		return nbr ;
	}
	public ArrayList<Chambre> list_chambre_libre_desinfecter() {
		ArrayList<Chambre> list = new ArrayList<Chambre>();
		for(Chambre c : list_chambres) {
			if(c.getEtat()==0 && c.getDesinfecter()==0) {
				list.add(c);
			}
		}
		return list ;
	}

	public int nombre_chambres_occupees () {
		int nbr = 0 ;
		for(Chambre c : list_chambres) {
			if(c.getEtat()==1) {
				nbr++;
			}
		}
		return nbr ;
	}
	
	public ArrayList<Chambre> list_chambre_occupees() {
		ArrayList<Chambre> list = new ArrayList<Chambre>();
		for(Chambre c : list_chambres) {
			if(c.getEtat()==1) {
				list.add(c);
			}
		}
		return list ;
	}
}
