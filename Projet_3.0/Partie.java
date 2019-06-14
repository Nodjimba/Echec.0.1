import java.util.Scanner;




public class Partie {

  private Echequier echequier;

  public Partie(Echequier echequier) {
    this.echequier = echequier;
  }

  public boolean verificationJoueur(Echequier echequier, int ligne, int colonne, String couleur) {
    if (echequier.getCase(ligne,colonne).getCouleur() == couleur) {return true;}
    else {return false;}
  }

  public void TourJoueur(Echequier echequier, String couleur) {
    Scanner input = new Scanner(System.in);
    System.out.print("Quelle piece voulez-vous deplacer ? ");
    int ligne = input.nextInt();
    int colonne = input.nextInt();
    if (verificationJoueur(echequier, ligne, colonne, couleur)) {
      System.out.print("Dans quelle case voulez-vous déplacer votre pièce ? ");
      int ligneA = input.nextInt();
      int colonneA = input.nextInt();
      echequier.getCase(ligne, colonne).deplacement(echequier, ligne, colonne, ligneA, colonneA);
    }
  }

//  public int[] demandeCase(Echequier p, String position) {
  //  if (p.ligne.equals("1")) {}
  //}

}
