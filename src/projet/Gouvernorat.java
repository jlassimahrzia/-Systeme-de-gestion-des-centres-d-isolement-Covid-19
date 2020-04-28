package projet;
import java.util.ArrayList;

public class Gouvernorat {
	
	String nom ;
	ArrayList<Centre> list_Centres ;
		
	public Gouvernorat(String ch)
	{ 
		this.nom = ch ;
	    this.list_Centres= new ArrayList<Centre>();
	}
	
	public boolean centre_existe(int n) {
		for(Centre c : this.list_Centres) {
				if (c.getNumero_ref() == n )
					return true ;
			}			
		return false ;
	}
		
	public void ajouter_centre ( Centre c )
	{	
		if (!centre_existe(c.getNumero_ref()))
		{
			this.list_Centres.add (c) ;
			System.out.println("Ajout de centre avec succée \n");
		}
		else
		{
			System.out.println("ce centre existe déja \n");
		}
	}
	
	public void supprimer_centre(Centre c)
	{
		if (centre_existe(c.getNumero_ref()))
		{
			this.list_Centres.remove(c);
			System.out.println("Suppression de centre numéro "+c.getNumero_ref()+" avec succée \n");
		}
		else 
			System.out.println("le centre n'existe pas \n");
	}
	
	public Centre get_centre(int numRefCentre)
	{
		for(Centre c : this.list_Centres) 
		{ 
			if (c.getNumero_ref() == numRefCentre )
				return c ;
		}			
			return null ;
	}
	
	public Personne get_Personne(int cin)
	{
		for (Centre c : list_Centres ) {
			if(c.personne_estPresent(cin))
				return c.getPersonne(cin) ;
		}
		return null ;	
	}
	
	public void affiche_liste_centres()
	{
		System.out.println("Liste des centre de la Gouvernorat "+this.nom+" \n");
		for(Centre c: list_Centres)
		{
			System.out.println(c);
		}
	}
	
	public String get_nom()
	{
		return (nom);
	}
	
	public ArrayList<Centre> get_list_Centres()
	{
		return (this.list_Centres);
	}
	
	
}
