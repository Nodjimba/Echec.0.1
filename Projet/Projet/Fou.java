public class Fou extends Piece {

  public Fou() {}

  public Fou (String nom, String couleur, int ligne, int colonne) {
    super("Fou",couleur, colonne, ligne);
  }

  public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA) {
    if(!(this.caseValide(ligne, colonne, ligneA, colonneA)))
      return false;
    if(Math.abs(ligneA - ligne) == Math.abs(colonneA - colonne))
      return true;
    return false;
  }

  public String dessiner() {
    String s;
      if (this.getCouleur()=="blanc") {
        s = "\u2657";
        return s;
      }
      if ((this.getCouleur()=="noir")) {
        s = "\u265D";
        return s;
      }
    return null;
  }
}
