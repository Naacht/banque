package Banque;

public class CompteEpargne extends Compte {
//  Déclaration des attributs
	private double  Taux;
	
// Déclaration du constructeur
	public CompteEpargne()
	{
	super();
	Taux = Saisie.lire_double("Quel est le taux ?");
	}
	
	// Autres méthodes
	public void Consulte()
	{
		System.out.println ("Client : "+ Titulaire + " | Numéro de compte : "+Num + " | Solde : " + Solde +"€ | Découvert autorisé : " + Découvert + " € | Taux : " + Taux + " %");
        System.out.println ("-----------------------------------------------------------------------------------------------------------");
	}
	
    public void Crediter(double montant) {
    	Solde += montant;
        System.out.println("Montant crédité avec succès.");
    }
	
	
	public void mise_a_jour()
	{
		
		Taux = Taux *1.2;
		System.out.println("Le nouveau taux vaut "+ Taux);
	}

	public double getTaux() {
		
		return Taux;
	}

	public void setTaux(double nouveauTaux) {
		
		Taux = nouveauTaux ;
	}
}