import java.util.Scanner;



public class Arbitre {

  private Echequier echequier;
  private Partie partie;


  public void promotion(Echequier p, int ligne, int colonne, Piece a) {
    if (a.getNom() == "Pion") {
      if ((ligne == 7) || (ligne == 0)) {
        Scanner input = new Scanner(System.in);
        System.out.println("Veuillez choisir la pièce de promotion : Dame, Cavalier, Fou, Tour");
        String str = input.nextLine();
        if (str.equals("Dame") || str.equals("dame"))
          p.setCase(ligne, colonne, new Dame("Dame",a.getCouleur(),ligne, colonne));
        if (str.equals("Cavalier") || str.equals("cavalier"))
          p.setCase(ligne, colonne, new Cavalier("Cavalier",a.getCouleur(), ligne, colonne));
        if (str.equals("Fou") || str.equals("fou"))
          p.setCase(ligne, colonne, new Fou("Fou",a.getCouleur(), ligne, colonne));
        if (str.equals("Tour") || str.equals("tour"))
          p.setCase(ligne, colonne, new Tour("Tour",a.getCouleur(),ligne, colonne));
      }
    }
  }








  public boolean verifierPat(Echequier p, int ligne, int colonne, int ligneA, int colonneA, Piece a) {
    if (a.getNom() == "Roi") {
      if (estEnEchec(p,ligne, colonne, ligneA, colonneA, a) == false) {
        for (int i=0; i<8; i++) {
          for (int j=0; i<8; i++) {
            a.deplacement(p, ligne, colonne, ligneA, colonneA);
            if (estEnEchec(p,ligne, colonne, ligneA, colonneA, a) == false) {
              p.setCase(ligne,colonne,a);
              p.retirerPiece(ligneA,colonneA);
              return false;
            }
            else { return true; }
          }
        }
      }
      return false;
    }
    return false;
  }


  public boolean verifierMat(Echequier p, int ligne, int colonne, int ligneA, int colonneA, Piece a) {
    if (a.getNom() == "Roi") {
      if (estEnEchec(p,ligne, colonne, ligneA, colonneA, a) == true) {
        a.deplacement(p, ligne, colonne, ligneA, colonneA);
        if (estEnEchec(p,ligne, colonne, ligneA, colonneA, a) == false) {
          p.setCase(ligne,colonne,a);
          p.retirerPiece(ligneA,colonneA);
          return false;
        }
        else { return true; }
      }
      return false;
    }
    return false;
  }

  public boolean estEnEchec(Echequier p, int ligne, int colonne, int ligneA, int colonneA, Piece a) {
    if (a.getNom() == "Roi") {
      p.getCase(ligne, colonne).deplacement(p, ligne, colonne, ligneA, colonneA);
      if (a.getCouleur() == "blanc") {
        if ()
      }
    }

    return true;
  }


  public void couleurRoi(Echequier echequier, Piece a, String couleur) {
    if (a.getNom() == "Roi") {
      return echequier.getCase(a.getLigne(), a.getColonne());
    }
    return null;
  }

  













}
