package Banque;

public class UtiliseCompteCECC {

    public static void main(String[] args) {
        MonPortefeuilleCECC Coll = new MonPortefeuilleCECC();

        int choix;
        do {
            afficherMenu();
            choix = Saisie.lire_int("Veuillez choisir une option : ");

            switch (choix) {
                case 1:
                    Coll.nouveauCompte();
                    break;
                case 2:
                	Coll.afficherTousLesComptes();
                	break;
                case 3:
                	Coll.Transfert();
                	break;
                case 4:
                	Coll.rechercheCompte();
                	break;
                case 5:
                	Coll.supprimeCompte();
                	break;
                case 6:
                	Coll.soldeNegatif();
                	break;
                case 7:
                	Coll.augmenterTauxEpargneUtilisateur();
                	break;
                case 8:
                	Coll.afficherComptesDecouvert();
                	break;
                case 0:
                    System.out.println("Vous avez quitter le menu");
                    break;
                default:
                    System.out.println("Option inexistant. Veuillez choisir à nouveau.");
                    break;
            }

        } while (choix != 0);
    }

    private static void afficherMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Créer un nouveau compte");
        System.out.println("2. Affiche les comptes");
        System.out.println("3. Faire un transfert");
        System.out.println("4. Recherche un compte");
        System.out.println("5. Supprimer un compte");
        System.out.println("6. Vérifiez les soldes négatifs");
        System.out.println("7. Augmentez le taux");
        System.out.println("8. Affiche les comptes à découvert");
        System.out.println("0. Quitter");
        System.out.println("================\n");
    }
}
