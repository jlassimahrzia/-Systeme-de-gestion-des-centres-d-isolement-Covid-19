package projet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Test Personne*/
		System.out.println("********** PERSONNE **************");
	    Personne p ,p1;
        p = new Personne( 11, "nourhene","larguech",'f',"07/08/1997","kairouan",1,"08/04/2020");
        p1 = new Personne( 12, "mahrzia","jlassi",'f',"07/08/1997","Bizerte",2,"23/04/2020");
        p.setNum_chambre(3);
        p.setNum_chambre(5);
        p.affiche();
        //p.changer_etat(2);
        System.out.println("le nombre de jour restant  "+p.nb_jour_restant()+"\n");
        
        /*Test Chambre*/
        System.out.println("********** CHAMBRE **************");
        Chambre c1 = new Chambre(1,0,1);
        System.out.println(c1);
        
        c1.affecter_chambre(11403758);
        System.out.println(c1);
        
        c1.libérer_chambre();
        c1.Nettoyer_chambre();
        
        c1.libérer_chambre();
        System.out.println(c1);
        
        /*TEST CENTRE*/
        System.out.println("********** CENTRE **************");
        Centre c = new Centre(132,"Bizerte ghar melh","Bizerte",5);
        c.ajouter_personne(p);
        c.ajouter_personne(p1);
        c.affiche_list_personnes();
        System.out.println("Nombre des personne est"+c.getNombre_personnes());
        c.personne_estPresent(114);
        
        c.ajout_chambres();
        c.affiche_list_chambres();
        c.changer_etat(11, 3);
        c.affiche_list_personnes();
        c.nbr_jour_restant_personne(11);
        System.out.println(c.getChambre(1));
        System.out.println("****** list_personne_selon_etat ***** ");
        c.list_personne_selon_etat(2);
        System.out.println("****** list_personnes_sortes aujourd'hui ***** ");
        c.list_personnes_sortes();
        System.out.println("****** list chambres libres infécter  ***** ");
        System.out.println("nombres des chambres libres et infécter "+c.nombre_chambre_libre_infecter());
        c.list_chambre_libre_infecter();
        System.out.println("****** list chambres libres déinfécter  ***** ");
        System.out.println("nombres des chambres libres et déinfécter "+c.nombre_chambre_libre_desinfecter());
        c.list_chambre_libre_desinfecter();
        System.out.println("****** list chambres occupées  ***** ");
        System.out.println("nombres des chambres occupées "+c.nombre_chambres_occupees());
        c.list_chambre_occupees();
        // Tous les test de sortie
        c.supprime_personne(5);
        //c.changer_etat(11, 2);
        c.changer_etat(11, 3);
        c.supprime_personne(11);
        p1.affiche();
        p1.changer_etat(3);
        c.supprime_personne(12);
        
        /*test Gouvernorat */
        
        System.out.println("********** Gouvernorat **************");
        Gouvernorat g,h;
        Centre ce;
        ce=new Centre(788,"sfax el jadida","sfax",7);
        g=new Gouvernorat("sfax");
        h=new Gouvernorat("nabeul");
        g.ajouter_centre(ce);
        System.out.println("******Liste des centres selon gouvernorat*****");
        g.affiche_liste_centres();
        //g.supprimer_centre(ce);
        System.out.println(g.get_nom());
       
        /*test Gestion */
        
        System.out.println("********** Gestion **************");
        Gestion ge;
        ge=new Gestion();
        ge.Ajouter_Gouvernorat(g);
        ge.Supprimer_gouvernorat(h);
        System.out.println("****liste des gouvernorat****");
        ge.affiche_list_gouvernorat();
        System.out.println("le nombre des conramination est "+ge.nbr_contamination()+"\n");
        System.out.println("le nombre des personnes accueuillies est "+ge.nbr_personnes_acceillies()+"\n");
        System.out.println("le pourcentage des contaminations pour le gouv sfax  est"+
        		ge.pourcentage_contamination_gouv("sfax")+"\n");
        System.out.println("le pourcentage de contamination pour le centre 555 est "+
        		ge.pourcentage_contamination_cen(555)+"\n");
	}

}
