package projet;

public class Chambre {
	int num_chambre ;
	int etat ; /* 0:libre 1:occupé */
	int desinfecter ; /* 0:desinfecter 1:non */
	int num_personne ;/* c'est le numéro de CIN par défaut 0 */
	
	public Chambre(int num_chambre, int etat, int desinfecter) {
		this.num_chambre = num_chambre;
		this.etat = etat;
		this.desinfecter = desinfecter;
		this.num_personne=0;
	}
	public Chambre(int num_chambre, int etat, int desinfecter,int num_personne) {
		this.num_chambre = num_chambre;
		this.etat = etat;
		this.desinfecter = desinfecter;
		this.num_personne=num_personne;
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
	public int getNum_personne() {
		return num_personne;
	}
	public int getDesinfecter() {
		return desinfecter;
	}
	
	public void libérer_chambre() {
		if(this.desinfecter==0)
			this.etat=0;
		else
			System.out.println("Il faut désinfécter la chambre avant de le marquer libre \n");
	}
	
	public void affecter_chambre (int num_personne) {
		if(this.desinfecter==1)
			System.out.println("Chambre infectée \n");
		else if(this.etat==1)
			System.out.println("Chambre occupée \n");
		else 
			this.num_personne=num_personne;
			this.etat = 1 ;
			this.desinfecter = 1 ;
	}
	
	public void Nettoyer_chambre() {
		this.desinfecter=0;
		System.out.println("Chambre désinfecter");
	}

	public String toString() {
		String ch = "numéro de chambre : "+this.num_chambre+"\n";
		if(this.etat == 1)
			ch += "chambre occupée"+" num de personne : "+this.num_personne+"\n";
		if(this.etat==0 && this.desinfecter==1)
			ch += "chambre libre et infectée \n";
		if(this.etat==0 && this.desinfecter==0)
			ch+= "chambre libre et nettoyer \n";
		return ch;
	}
	
	

}
