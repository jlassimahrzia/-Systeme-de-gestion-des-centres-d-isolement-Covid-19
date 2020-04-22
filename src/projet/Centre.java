package projet;

import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Centre {
	int numero_ref ;
	String adresse ;
	String gouvernorat ;
	int capacite ; 
	int nombre_personnes ;
	ArrayList<Personne>  list_personnes ;
	ArrayList<Chambre>  list_chambres ;
	
	public Centre(int numero_ref, String adresse, String gouvernorat, int capacite) {
		this.numero_ref = numero_ref;
		this.adresse = adresse;
		this.gouvernorat = gouvernorat;
		this.capacite = capacite;
		list_personnes = new ArrayList<Personne>();
		this.nombre_personnes = list_personnes.size();	
		list_chambres = new ArrayList<Chambre>();
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

	// Vérifier l'existance de personne dans la centre
	public boolean personne_estPresent(int cin) {
		for(Personne p : list_personnes) {
			if(p.getNum_cin()==cin) {
				return true ;
			}			
		}
		return false ;
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
					+ p.nb_jour_restant()+" jour son date de sortie est "+p.date_sortie);
		}
		else {
			System.out.println("le personne de num de cin "+cin+" n'existe pas dans ce centre");
		}
	}
	
	// Enregistrement de dapart de personne de la centre
	public void supprime_personne(int cin) {
		Personne p ;
		if(!personne_estPresent(cin)) {
			System.out.println("le personne de num de cin "+cin+" n'existe pas dans ce centre");
		}
		else {
			p = this.getPersonne(cin);
			if(p.getEtat()!=3) {
				if(p.getEtat()==2) {
					System.out.println("Personne de num de cin "+cin+" est malade mais sans symptômes"
							+ " graves ne peut pas sortir de la centre il faut élargir son période");
				}
				else if(p.getEtat()==1) {
					this.list_personnes.remove(p);
					System.out.println("Suppressin avec succées");
				}
			}
			else {
				if(p.nb_jour_restant()!=0) {
					System.out.println("le personne de num cin "+cin+" n'est finir ses 14 jours il le reste "
							+ p.nb_jour_restant()+" jour leur date de sortie est "+p.date_sortie);
				}
				else {
					this.list_personnes.remove(p);
					System.out.println("Suppressin avec succées");
				}
			}
		}
	}
	
	/**
	 * Gestion Des Chambres
	 */
	
	public void ajout_chambres() {
		String csvFile = "C:/Users/ASUS/Desktop/ENSI/S2/c++/java/projet/files/chambre.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] chambre = line.split(cvsSplitBy);
                if(this.capacite<=this.list_chambres.size()) {
        			System.out.println("Centre Complet");
        		}
                else {
                	 Chambre c = new Chambre(Integer.parseInt(chambre[0]),Integer.parseInt(chambre[1]),
                     		Integer.parseInt(chambre[2]),Integer.parseInt(chambre[3]));
                     this.list_chambres.add(c);                	
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
	
	public void affiche_list_chambres() {
		for(Chambre c : list_chambres) {
			System.out.println(c);
		}
	}

	public Chambre getChambre(int num){		
		for(Chambre c : list_chambres) {
			if(c.getNum_chambre()==num) {
				System.out.println("Personne existant");
				return c ;
			}			
		}
		return null ;
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
        for(Personne p : list) {
        	p.affiche();
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
		for(Personne p : list) {
        	p.affiche();
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
		for(Chambre c : list) {
			System.out.println(c);
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
		for(Chambre c : list) {
			System.out.println(c);
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
		for(Chambre c : list) {
			System.out.println(c);
		}
		return list ;
	}
}
