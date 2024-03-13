package Banque;

public class Compte {
	
	// Liste des attributs
			 protected String Titulaire;
			 protected int Num;
			 protected double Solde;
			 protected double Découvert;
			
	// Déclaration du constructeur
			public Compte() 
			{
				Titulaire= Saisie.lire_String("Quel est le nom du client ?");
				Num= Saisie.lire_int("Quel est le numéro de ce compte ?");
				Solde= Saisie.lire_double("Quel est le solde intitial ?");
				Découvert= Saisie.lire_double("Quel est le montant du découvert autorisé ?");
			}
			
			public void Consulte() 
			{
				System.out.println("Le solde de votre compte est de " +Solde+ "€");
			}
			
			public void Depot (double Somme)
			{
				Solde = Solde +Somme;
				
			}
			public void Retrait (double Somme)
			{
				if ((Solde -Somme)< Découvert)
				{
					System.out.println("Retrait impossible");
				}
				else Solde= Solde-Somme;
				
				
			}
			
			public void AfficheCompte()
			{
				System.out.println ("Client : "+ Titulaire+ " | Numéro de compte : "+Num + " | Solde : " + Solde +"€ | Découvert autorisé :" + Découvert + " €");
		        System.out.println ("-----------------------------------------------------------------------------------------------------------");
			}
			
			public double getSolde()
			{
				return Solde ;
			}
			
			public double setSolde(double soldeBis)
			{
				return Solde ;
			}
			
			public double getNum()
			{
				return Num ;
			}
			
			
			public double setDecouvert() 
			{
				return Découvert ;	
			}

			public double getNumBis() {
				
				return Num;
			}
			
			
}