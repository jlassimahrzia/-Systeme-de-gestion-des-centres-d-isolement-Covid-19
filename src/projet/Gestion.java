package projet;
import java.util.ArrayList;

public class Gestion {
	
	private ArrayList<Gouvernorat> list_Gouvernorats;
	
	public Gestion()
	{
		list_Gouvernorats = new ArrayList<Gouvernorat>() ;
	}
	
	public boolean gouvernorat_existe(String ch)
	{
		for(Gouvernorat g  : list_Gouvernorats) {
			 { 
				 if (g.get_nom()== ch )
				 return true ;
			 }			
		}
		return false ;
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
				n+= c.get_nbr_per_tot(); 
			}
		}
		return (n);
	}
	
	//pourcentage de contamination total
	public float pourcentage_contamination()
	{   
		float p=nbr_contamination()/nbr_personnes_acceillies()*100;
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
			g.affiche_liste_centres();
		}
	}
}
