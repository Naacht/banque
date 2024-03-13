package Banque;

import java.awt.Point;
import java.util.ArrayList ;
import java.util.ListIterator;

public class MonPortefeuilleCECC {

	// Attributs privés
	private ArrayList<CompteEpargne> MonPortefeuilleCE ;
	private ArrayList<CompteCourant> MonPortefeuilleCC ;
	
	private int NB ;
	
	// Constructeur de la Collection
	public MonPortefeuilleCECC()
	{
		NB = Saisie.lire_int("Entrez le nombre de comptes à créer : ");
		MonPortefeuilleCE = new ArrayList<CompteEpargne>() ;
		MonPortefeuilleCC = new ArrayList<CompteCourant>() ;
	}
	
	// Méthodes
public void remplirPortefeuilleCE() {
	for (int i = 0; i < NB; i++) {
		CompteEpargne CompteE = new CompteEpargne();
	        MonPortefeuilleCE.add(CompteE);
	    }
	}

public void remplirPortefeuilleCC() {
	for (int i = 0; i < NB; i++) {
		CompteCourant CompteC = new CompteCourant();
	        MonPortefeuilleCC.add(CompteC);
	    }
	}


public void nouveauCompte()
{
		String typeDeCompte = Saisie.lire_String("Quel compte souhaitez-vous créer ? C : Courant | E : Epargne");
		if(typeDeCompte.equals("C")) {
			CompteCourant CompteC = new CompteCourant();
			MonPortefeuilleCC.add(CompteC);
			System.out.println("Le compte courant à été créer avec succès !");
		}
		
		else if (typeDeCompte.equals("E")) {
			
			CompteEpargne CompteE = new CompteEpargne();
			MonPortefeuilleCE.add(CompteE);
			System.out.println("Le compte épargne à été créer avec succès !");

		}
}

public void afficherTousLesComptes() {
    System.out.println("--------------------------------------Tous les comptes------------------------------------------------");

    // Affichage des comptes d'épargne
    System.out.println("==== Comptes Epargne ====");
    ListIterator<CompteEpargne> itCE = MonPortefeuilleCE.listIterator();
    while (itCE.hasNext()) {
        CompteEpargne compteEpargne = itCE.next();
        compteEpargne.Consulte();
    }

    // Affichage des comptes courants
    System.out.println("==== Comptes Courant ====");
    ListIterator<CompteCourant> itCC = MonPortefeuilleCC.listIterator();
    while (itCC.hasNext()) {
        CompteCourant compteCourant = itCC.next();
        compteCourant.Consulte();
    }
}


public void rechercheCompte() {
    int numero = Saisie.lire_int("Veuillez saisir le numéro d'un compte afin de le chercher");

    // Recherche dans les comptes d'épargne
    ListIterator<CompteEpargne> itCE = MonPortefeuilleCE.listIterator();
    boolean compteTrouveCE = false;

    while (itCE.hasNext()) {
        CompteEpargne compteEpargne = itCE.next();
        if (compteEpargne.getNum() == numero) {
            compteTrouveCE = true;
            System.out.println("Le compte épargne numéro " + numero + " a été trouvé avec succès.");
            compteEpargne.Consulte();
        }
    }

    // Recherche dans les comptes courants
    ListIterator<CompteCourant> itCC = MonPortefeuilleCC.listIterator();
    boolean compteTrouveCC = false;

    while (itCC.hasNext()) {
        CompteCourant compteCourant = itCC.next();
        if (compteCourant.getNum() == numero) {
            compteTrouveCC = true;
            System.out.println("Le compte courant numéro " + numero + " a été trouvé avec succès.");
            compteCourant.Consulte();
        }
    }

    if (!compteTrouveCE && !compteTrouveCC) {
        System.out.println("Aucun compte trouvé avec le numéro " + numero);
    }
}

public void supprimeCompte() {
    int Numero = Saisie.lire_int("Veuillez saisir le numéro d'un compte afin de le supprimer");
    String typeCompte = Saisie.lire_String("Veuillez saisir le type de compte (C pour Courant / E pour Epargne) : ");

    boolean compteTrouve = false;

    // Vérifier le type de compte et supprimer le compte correspondant
    if (typeCompte.equals("C")) {
        ListIterator<CompteCourant> itCC = MonPortefeuilleCC.listIterator();
        compteTrouve = supprimerCompte(itCC, Numero);
    } else if (typeCompte.equals("E")) {
        ListIterator<CompteEpargne> itCE = MonPortefeuilleCE.listIterator();
        compteTrouve = supprimerCompte(itCE, Numero);
    } else {
        System.out.println("Type de compte non valide.");
    }

    if (!compteTrouve) {
        System.out.println("Aucun compte trouvé avec le numéro " + Numero + " et le type de compte " + typeCompte);
    }
}

private <T extends Compte> boolean supprimerCompte(ListIterator<T> it, int numero) {
    boolean compteTrouve = false;

    while (it.hasNext()) {
        T compte = it.next();
        if (compte.getNum() == numero) {
            it.remove(); // Supprime le compte de la liste
            compteTrouve = true;
            System.out.println("Le compte numéro " + numero + " a été supprimé avec succès.");
            break;  // Sortir de la boucle après la suppression
        }
    }

    return compteTrouve;
}

// Faire un transfert de solde
public void Transfert() {
	 int numeroCompteCourant = Saisie.lire_int("Entrez le numéro du compte courant : ");
	    int numeroCompteEpargne = Saisie.lire_int("Entrez le numéro du compte épargne : ");

	    CompteCourant compteCourant = trouverCompteCourantParNumero(numeroCompteCourant);
	    CompteEpargne compteEpargne = trouverCompteEpargneParNumero(numeroCompteEpargne);

	    if (compteCourant != null && compteEpargne != null) {
	        double montant = Saisie.lire_double("Entrez le montant du transfert : ");

	        if (compteCourant.getSolde() >= montant) {
	            compteCourant.Retirer(montant);
	            compteEpargne.Crediter(montant);
	            System.out.println("Transfert réussi.");
	        } else {
	            System.out.println("Le transfert a échoué. Solde insuffisant sur le compte courant.");
	        }
	    } else {
	        System.out.println("Compte courant ou compte épargne introuvable avec les numéros fournis.");
	    }
	}

	private CompteCourant trouverCompteCourantParNumero(int numero) {
	    for (CompteCourant compte : MonPortefeuilleCC) {
	        if (compte.getNum() == numero) {
	            return compte;
	        }
	    }
	    return null;
	}

	private CompteEpargne trouverCompteEpargneParNumero(int numero) {
	    for (CompteEpargne compte : MonPortefeuilleCE) {
	        if (compte.getNum() == numero) {
	            return compte;
	        }
	    }
	    return null;
	}


	public void soldeNegatif() {
	    int n = 0;

	    // Soldes négatifs pour les comptes courants
	    System.out.println("Voici les soldes négatifs pour les comptes courants : ");
	    ListIterator<CompteCourant> itCC = MonPortefeuilleCC.listIterator();
	    while (itCC.hasNext()) {
	        CompteCourant compteCourant = itCC.next();
	        if (compteCourant.getSolde() < 0) {
	            compteCourant.AfficheCompte();
	            n = n + 1;
	        }
	    }

	    // Soldes négatifs pour les comptes épargne
	    System.out.println("Voici les soldes négatifs pour les comptes épargne : ");
	    ListIterator<CompteEpargne> itCE = MonPortefeuilleCE.listIterator();
	    while (itCE.hasNext()) {
	        CompteEpargne compteEpargne = itCE.next();
	        if (compteEpargne.getSolde() < 0) {
	            compteEpargne.AfficheCompte();
	            n = n + 1;
	        }
	    }

	    System.out.println("Il y a " + n + " soldes négatifs");
	}

	public void augmenterTauxEpargneUtilisateur() {
		  double pourcentageAugmentation = Saisie.lire_double("Entrez le pourcentage d'augmentation du taux pour tous les comptes épargne : ");

	        ListIterator<CompteEpargne> itCE = MonPortefeuilleCE.listIterator();

	        while (itCE.hasNext()) {
	            CompteEpargne compteEpargne = itCE.next();
	            double nouveauTaux = compteEpargne.getTaux() * (1 + pourcentageAugmentation / 100);
	            compteEpargne.setTaux(nouveauTaux);
	            System.out.println("Le taux du compte épargne " + compteEpargne.getNum() + " a été augmenté à " + nouveauTaux + "%");
	        }
		
	}
	
	
	public void afficherComptesDecouvert() {
	    System.out.println("Liste des comptes à découvert :");
	    
	    // Parcours des comptes courants
	    for (CompteCourant compteCourant : MonPortefeuilleCC) {
	        if (compteCourant.getSolde() < 0) {
	            compteCourant.Consulte();
	        }
	    }

	    // Parcours des comptes d'épargne
	    for (CompteEpargne compteEpargne : MonPortefeuilleCE) {
	        if (compteEpargne.getSolde() < 0) {
	            compteEpargne.Consulte();
	        }
	    }
	}
	
	
}
