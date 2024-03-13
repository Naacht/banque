package Banque;

import java.awt.Point;
import java.util.ArrayList ;
import java.util.ListIterator;

public class MonPortefeuille {

	// Attributs privés
	private ArrayList<Compte> MonPortefeuille ;
	private int NB ;
	
	// Constructeur de la Collection
	public MonPortefeuille()
	{
		MonPortefeuille = new ArrayList<Compte>() ;
		NB = Saisie.lire_int("Veuillez saisir le nombre de compte que vous souhaitez créer : ") ;
	}
	
	// Méthodes
public void remplirPortefeuille() {
	for (int i = 0; i < NB; i++) {
	        Compte nouveauCompte = new Compte();
	        MonPortefeuille.add(nouveauCompte);
	    }
	}

public void affichePortefeuille()
	{
		System.out.println("--------------------------------------Tous les comptes------------------------------------------------");
		ListIterator it = MonPortefeuille.listIterator();
	
		while(it.hasNext())
		{
			Object Obj = it.next();
			Compte nouveauCompte = (Compte) Obj;
			nouveauCompte.AfficheCompte();
		}
	}

public void testVide()
	{ 	
		boolean Test;
		Test = MonPortefeuille.isEmpty();
		if(Test==true) System.out.println("--------------------------------------Comptes Vide------------------------------------------------"); 
		else System.out.println("Les comptes ne sont pas vide !"); 
	}

public void soldeNegatif() {
		int n = 0, getSolde = 0;
		
		System.out.println("Voici les soldes négatifs : ");
		ListIterator it = MonPortefeuille.listIterator();
		
		while(it.hasNext())
		{
			Object Obj = it.next();
			Compte nouveauCompte = (Compte) Obj;
			double soldeBis = nouveauCompte.getSolde() ;
			if(soldeBis < 0)
			{
			nouveauCompte.AfficheCompte();
			n = n+1;
			}
		}
		System.out.println("Il y a " + n + " soldes négatifs");
	}


public void modifierDecouvert() {
    int Numero = Saisie.lire_int("Veuillez saisir le numéro d'un compte afin de modifier le montant découvert autorisé");
    ListIterator<Compte> it = MonPortefeuille.listIterator();

    boolean compteAJour = false;

    while (it.hasNext()) {
        Compte compte = it.next();
        if (compte.getNumBis() == Numero) {
            double nouveauDecouvert = Saisie.lire_double("Entrez le nouveau montant du découvert autorisé : ");
            if (nouveauDecouvert >= 0) {
                compte.setDecouvert();
                System.out.println("Découvert autorisé du compte numéro " + Numero + " modifié avec succès.");
            } else {
                System.out.println("Le montant du découvert doit être positif.");
            }
            compteAJour = true;
        }
    }

    if (!compteAJour) {
        System.out.println("Aucun compte trouvé avec le numéro " + Numero);
    }
}

public void videCollection()
		{
			int I, Nombre;
			Nombre = MonPortefeuille.size();
			for (I=0; I< Nombre; I++)
			{
		MonPortefeuille.remove(0);
		System.out.println("Les comptes ont été tous supprimés, il y avait : " + Nombre + " et maintenant " + MonPortefeuille.size());
			}
		}

public void supprimeCompte() {
	int Numero = Saisie.lire_int("Veuillez saisir le numéro d'un compte afin de le supprimer");

    ListIterator<Compte> it = MonPortefeuille.listIterator();
    boolean compteTrouve = false;

    while (it.hasNext()) {
        Compte compteCourant = it.next();
        if (compteCourant.getNum() == Numero) {
            it.remove(); // Supprime le compte de la liste
            compteTrouve = true;
            System.out.println("Le compte numéro " + Numero + " a été supprimé avec succès.");
        }
    }
        	  if (compteTrouve == false)
       System.out.println("Aucun compte trouvé avec le numéro " + Numero);
        
    }

public void rechercheCompte() {
	int Numero = Saisie.lire_int("Veuillez saisir le numéro d'un compte afin de le chercher");

    ListIterator<Compte> it = MonPortefeuille.listIterator();
    boolean compteTrouve = false;

    while (it.hasNext()) {
        Compte compte = it.next();
        if (compte.getNum() == Numero) {
            compteTrouve = true;
            System.out.println("Le compte numéro " + Numero + " a été trouver avec succès.");
            compte.AfficheCompte();
            
        }
    }
        	  if (compteTrouve == false)
       System.out.println("Aucun compte trouvé avec le numéro " + Numero);
        
    }

   

public void miseAJour() {
    System.out.println ("--------------------------------------Comptes Restants------------------------------------------------");
    for (Compte compte : MonPortefeuille) {
        compte.AfficheCompte();
    }
}

public void nouveauCompte()
{
	Compte nouveauCompte = new Compte();
    MonPortefeuille.add(nouveauCompte);
    System.out.println("Nouveau compte ajouté avec succès.");
    System.out.println ("-----------------------------------------------------------------------------------------------------------");

}

public void afficheComptesRestants() {
	System.out.println ("----------------------------------------Liste de compte à jour---------------------------------------------");
    for (Compte compte : MonPortefeuille) {
        compte.AfficheCompte();
    }
}

	}
