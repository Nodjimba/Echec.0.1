public class Pion extends Piece {

  public Pion() {}

  public Pion (String nom, String couleur, int ligne, int colonne) {
    super("Pion",couleur, colonne, ligne);
  }


  public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA) {
    if(this.caseValide(ligne, colonne, ligneA, colonneA) == false)
      return false;
    if ((ligneA==ligne+2 && colonne==colonneA) || (ligneA==ligne-2 && colonne==colonneA) && ((this.getLigne()==1) || (this.getLigne()==6)))
      return true;
    if ((ligneA==ligne+1 && colonne==colonneA ) || (ligneA==ligne-1 && colonne==colonneA))
      return true;
    return false;
  }


  public String dessiner() {
    String s;
    if (this.getCouleur()=="blanc") {
      s = "\u2659";
      return s;
    }
    if ((this.getCouleur()=="noir")) {
      s = "\u265F";
      return s;
    }
    return null;
  }
  }
