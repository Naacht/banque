package Banque;

public class CompteCourant extends Compte {
	//  Déclaration des attributs
	private double  Decouvert_Autorise;
// Déclaration du constructeur
	public CompteCourant()
	{
	super();
	Decouvert_Autorise= Saisie.lire_double("Quel est le montant ?");
	}
	
  // déclaration des autres méthodes
	public void Retirer(double somme)
	
	{
	  if ((Solde - somme ) < Decouvert_Autorise) System.out.println("Opération échouée, Solde insuffisant");
		 else 
			  {
		         Solde = Solde - somme;
		         System.out.println("Voici votre argent : " + Solde);
	          }
		
	}
	
	public void Consulte()
	{
		System.out.println ("Client : "+ Titulaire + " | Numéro de compte : "+ Num + " | Solde : " + Solde +"€ | Découvert autorisé " + Découvert + " €");
        System.out.println ("-----------------------------------------------------------------------------------------------------------");
	}
	

}