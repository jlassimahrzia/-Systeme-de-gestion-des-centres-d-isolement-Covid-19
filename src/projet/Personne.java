package projet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personne {

	private int num_cin;
	private String nom;
	private String prenom;
	private char genre ;
	private String date_naissance;/* sous forme jj/mm/aaaa*/
	private String gouvernerat;
	private int num_chambre;
	private int etat;
	   /*
	     intialitation par defaut par 0
	      1:maladie confirmé eu des problèmes de santé:
	         les mesures nécessaires sont prises et les soins nécessaires sont 
	         apportés à cette personne
	         transférer à l’hôpital
	      2: personnes malades mais sans symptômes graves :
	         élargir la période de confinement jusqu'à le rétablissement total
	      3: personne n’a eu aucun symptôme  après 14 jours:
	         enregistrement de son sortie 
	    */
	private int type_contamination;
	    /*
	       0:un contact avec une personne malade 
	       1:venant de l'etranger
	     */
	private String date_entree;
	private String date_sortie;
	      
	  public Personne(int num_cin,String nom,String prenom,char genre,String date_naissance,
	           String gouvernerat,int type_contamination,String date_entree){
		  this.num_cin=num_cin;
		  this.nom=nom;
		  this.prenom=prenom;
		  this.genre=genre;
		  this.date_naissance=date_naissance;
		  this.gouvernerat=gouvernerat;
		  this.num_chambre=0;
		  this.etat=0;
		  this.type_contamination=type_contamination;
		  this.date_entree=date_entree;
		  //Calcule date de sortie 
		  date_sortie= calcul_date_sortie( );
	  }
	  
	  String calcul_date_sortie(){// jj/mm/aaaa
		  String jour= date_entree.substring(0, 2);
		  int  jj= Integer.parseInt(jour);
		  String mois= date_entree.substring(3, 5);
		  int  mm= Integer.parseInt(mois);
		  String annee= date_entree.substring(6);
		  int aaaa= Integer.parseInt(annee);
		  int nbjour = 0;
		  switch (mm) {
		  	case 1: case 3: case 5:case 7: case 8: case 10:case 12:  nbjour = 31; break;
		  	case 4: case 6:case 9: case 11: nbjour = 30; break;
		  	case 2:
		  		if (((aaaa % 4 == 0) && !(aaaa % 100 == 0))|| (aaaa % 400 == 0))
		  			nbjour = 29;
		  		else
		  			nbjour = 28;
		  		break;
		  }
		  if(jj+14<=nbjour){
			  jj+=14;
	                            
		  }else
		  {
			  jj=((jj+14)-nbjour);
			  if(mm!=12) mm++;
			  else {mm=1;aaaa++;}
		  }
		  String j= Integer.toString(jj);
		  String m=Integer.toString(mm);
		  String a=Integer.toString(aaaa);
		  if(jj<10) j="0"+j;
		  if(mm<10) m="0"+m;
		  date_sortie=j+"/"+m+"/"+a;
		  return date_sortie;
	  }
	         
	      public void changer_etat(int etat){
	            this.etat=etat;
	            if(etat==2){
	                String d=date_entree;
	                date_entree=date_sortie;
	                date_sortie=calcul_date_sortie();
	                date_entree=d;
	            }
	      }
	    
	        
	      public void affiche(){
	              System.out.printf("***********Information sur la personne************ \n");
	              System.out.printf("Numero de cin :" +num_cin+"\n");
	              System.out.printf("Nom et prenom :"+nom+"\t"+prenom+"\n");
	              if(genre=='f'||genre=='F')
	                System.out.printf("genre : féminin"+"\n");
	              else 
	                 System.out.printf("genre : Masculin"+"\n");
	                 System.out.printf("Date de naissance :"+date_naissance+"\n");
	                 System.out.printf("Gouvernorat :"+gouvernerat+"\n");
	                if(num_chambre==0){
	                  System.out.printf("Pas de chambre ."+"\n");
	                }
	                else 
	                    System.out.printf("Numéro de chambre :"+num_chambre+"\n");
	                
	                switch(etat){
	                    case 0:System.out.printf("Nouveau personne ne depasse pas 14 jour ."+"\n");break;
	                    case 1:System.out.printf("maladie confirmé eu des problèmes de santé:\n" +
	                                              " les mesures nécessaires sont prises et les soins nécessaires "
	                                               + "sont apportés à cette personne\n transférer à l’hôpital"+"\n");break;
	                    case 2:System.out.printf("personnes malades mais sans symptômes graves :\n" +
	                                             " élargir la période de confinement jusqu'à le rétablissement total"+"\n");break;
	                    case 3:System.out.printf("personne n’a eu aucun symptôme  après 14 jours:\n" +
	                                             " enregistrement de son sortie"+"\n");break;
	                }
	                    if(type_contamination==0)System.out.printf(" type_contamination :un contact avec une personne malade \n");
	                    else System.out.printf("type_contamination : venant de l'etranger \n");
	                    System.out.printf("Date d'entrée :"+date_entree+"\n");
	                    System.out.printf("Date de sortie :"+date_sortie+"\n");
	          }
	       


	/* Comparer la date de sortie par la date d'aujourd'hui calcule des jours restant*/
	public int nb_jour_restant(){
	    int res;
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");// current day
        Date dateobj = new Date();
        String dd = df.format(dateobj);
        
	    String jour= dd.substring(0, 2);
	    int  jj= Integer.parseInt(jour);        
	    String mois= dd.substring(3, 5);
	    int  mm= Integer.parseInt(mois);
	    String annee= dd.substring(6);
	    int aaaa= Integer.parseInt(annee);
	    
	    /*String jour= date_entree.substring(0, 2);
	    int  jj= Integer.parseInt(jour);        
	    String mois= date_entree.substring(3, 5);
	    int  mm= Integer.parseInt(mois);
	    String annee= date_entree.substring(6);
	    int aaaa= Integer.parseInt(annee);*/
 
	    
	    String jo= date_sortie.substring(0, 2);
	    int  j= Integer.parseInt(jo); 
	    String mo= date_sortie.substring(3, 5);
	    int  m= Integer.parseInt(mo);
	    String an= date_sortie.substring(6);
	    int a= Integer.parseInt(an);
        
	    if(mm!=m){
	    	int nbjour = 0;
	    	switch (mm) {
	    		case 1: case 3: case 5:case 7: case 8: case 10:case 12:  nbjour = 31; break;
	    		case 4: case 6:case 9: case 11: nbjour = 30; break;
	    		case 2:
	    			if (((aaaa % 4 == 0) && !(aaaa % 100 == 0))|| (aaaa % 400 == 0))
	    				nbjour = 29;
	    			else
	    				nbjour = 28;
	    				break;
	    			}
	    			res=(nbjour-jj)+j;
	    }
	    else{
	    	res=j-jj;
	    	if(res<0) {
	    		res = 0;
	    		System.out.println("dépasse ses 14 jours \n");
	    	}
	    }
	    return res ;                               
	}
	
	public int getNum_cin() {
		return num_cin;
	}

	public void setNum_cin(int num_cin) {
		this.num_cin = num_cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public char getGenre() {
		return genre;
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getGouvernerat() {
		return gouvernerat;
	}

	public void setGouvernerat(String gouvernerat) {
		this.gouvernerat = gouvernerat;
	}

	public int getNum_chambre() {
		return num_chambre;
	}

	public void setNum_chambre(int num_chambre) {
		this.num_chambre = num_chambre;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public int getType_contamination() {
		return type_contamination;
	}

	public void setType_contamination(int type_contamination) {
		this.type_contamination = type_contamination;
	}

	public String getDate_entree() {
		return date_entree;
	}

	public void setDate_entree(String date_entree) {
		this.date_entree = date_entree;
	}

	public String getDate_sortie() {
		return date_sortie;
	}

	public void setDate_sortie(String date_sortie) {
		this.date_sortie = date_sortie;
	}
	                    
}


