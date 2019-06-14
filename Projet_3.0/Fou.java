public class Fou extends Piece {

  public Fou() {}

  public Fou (String nom, String couleur, int ligne, int colonne) {
    super("Fou",couleur,ligne, colonne);
  }

  public Fou(Piece p){
    super(p);
  }

  public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA) {
    if(!(this.caseValide(ligneA, colonneA)))
      return false;
    if(Math.abs(ligneA - ligne) == Math.abs(colonneA - colonne))
      return true;
    return false;
  }

  public String dessiner() {
    String s;
      if (this.getCouleur().equals("blanc")) {
        s = "h";//"\u2657";
        return s;
      }
      if (this.getCouleur().equals("noir")) {
        s = "c";//"\u265D";
        return s;
      }
    return " ";
  }
}
