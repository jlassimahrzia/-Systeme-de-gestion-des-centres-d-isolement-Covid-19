package projet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
//import java.util.logging.Logger;

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
	
	/**
	 * 
	 * Calcul distance
	 */
			public String[] Distance() throws IOException{
		        String filePath = new File("").getAbsolutePath();
		        String csvFile = filePath.concat("/files/gou.csv");
			
			    BufferedReader br = null;
			    String line = "";
			    String cvsSplitBy = ";";
			    String ch="";
			    String ch1="";
			    String res="";
			    String[] gouv=new String[24];
		   
			    int  dis_gouv[] = new int[24];
			    try {
		            br = new BufferedReader(new FileReader(csvFile));
		            line = br.readLine();
		            gouv = line.split(cvsSplitBy);
		            int b=0;
		            while (((line = br.readLine()) != null)&&(b==0)){
		                 String[] gou = line.split(cvsSplitBy);
		            if(nom. equals(gou[0])){
		                 b=1;
		                 String[] go = line.split(cvsSplitBy);
		                 for(int i=1;i<=24;i++){
		                   dis_gouv[i-1]=Integer.parseInt(go[i]);
		                   gouv[i-1]=gouv[i];
		                 } 
		            }
		         }
		         gouv[24]="";
		         int indice_max;
		         for(int i=24;i>1;i--){
		        	 indice_max=max(dis_gouv,i);
		        	 echanger(dis_gouv,i-1,indice_max);   
		        	 echanger2(gouv,i-1,indice_max);
		         }
		         /* for(int i=0; i<3;i++)
					{
						System.out.println(dis_gouv[i]);
		                System.out.println(gouv[i]);
		            } */	     
		     }
		     catch (FileNotFoundException ex) {
		            //Logger.getLogger(Gouvernorat.class.getName()).log(Level.SEVERE, null, ex);
		     }
		     return gouv;
		}
			
		public static int max(int tab[],int taille){		
		    int i=0,indice_max=0;		
		    while(i<taille){		
		        if(tab[i]>tab[indice_max])		
		            indice_max=i;		
		        i++;		
		    }		
		    return indice_max; 		
		}
		
		public static void echanger(int tab[],int i,int j){		
		    int tmp;		
		    tmp=tab[i];		
		    tab[i]=tab[j];		
		    tab[j]=tmp;		
		}
		
		public static void echanger2(String tab[],int i,int j){	
		   String tmp;	
		   tmp=tab[i];		
		   tab[i]=tab[j];		
		   tab[j]=tmp;		
		}
	
}
