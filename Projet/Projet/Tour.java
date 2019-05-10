public class Tour extends Piece {

  public Tour() {}

  public Tour (String nom, String couleur, int ligne, int colonne) {
    super("Tour",couleur, colonne, ligne);
  }

  public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA) {
    if(this.caseValide(ligne, colonne, ligneA, colonneA) == false)
      return false;
    if(ligne == ligneA)
      return true;
    if(colonne == colonneA)
      return true;
    return false;
  }

  public String dessiner() {
    String s;
    if (this.getCouleur()=="blanc") {
      s = "\u2656";
      return s;
    }
    if ((this.getCouleur()=="noir")) {
      s = "\u265C";
      return s;
    }
    return null;
  }
}
