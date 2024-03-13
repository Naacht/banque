package Banque;

public class UtiliseCompte {

    public static void main(String[] args) {
        MonPortefeuille Coll = new MonPortefeuille();

        int choix;
        do {
            afficherMenu();
            choix = Saisie.lire_int("Veuillez choisir une option : ");

            switch (choix) {
                case 1:
                    Coll.remplirPortefeuille();
                    break;
                case 2:
                    Coll.affichePortefeuille();
                    break;
                case 3:
                    Coll.testVide();
                    break;
                case 4:
                    Coll.rechercheCompte();
                    break;
                case 5:
                    Coll.soldeNegatif();
                    break;
                case 6:
                    Coll.nouveauCompte();
                    break;
                case 7:
                    Coll.afficheComptesRestants();
                    break;
                case 8:
                    Coll.modifierDecouvert();
                    break;
                case 9:
                    Coll.supprimeCompte();
                    break;
                case 10:
                    Coll.videCollection();
                    break;
                case 11:
                    Coll.miseAJour();
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
        System.out.println("1. Remplir le portefeuille");
        System.out.println("2. Afficher le portefeuille");
        System.out.println("3. Tester si le portefeuille est vide");
        System.out.println("4. Rechercher un compte");
        System.out.println("5. Afficher les soldes négatifs");
        System.out.println("6. Ajouter un nouveau compte");
        System.out.println("7. Afficher les comptes restants");
        System.out.println("8. Modifier le découvert autorisé");
        System.out.println("9. Supprimer un compte");
        System.out.println("10. Vider la collection de comptes");
        System.out.println("11. Mise à jour des comptes");
        System.out.println("0. Quitter");
        System.out.println("================\n");
    }
}
