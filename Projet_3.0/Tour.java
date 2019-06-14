public class Tour extends Piece {

  public Tour() {}

  public Tour (String nom, String couleur, int ligne, int colonne) {
    super("Tour",couleur, ligne, colonne);
  }

  public Tour(Piece p){
    super(p);
  }

  public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA) {
    if(this.caseValide(ligneA, colonneA) == false)
      return false;
    if(ligne == ligneA) {
      return true;
    }
    if(colonne == colonneA) {
      return true;
    }
    return false;
  }

  public String dessiner() {
    String s;
    if (this.getCouleur().equals("blanc")) {
      s = "f";//"\u2656";
      return s;
    }
    if (this.getCouleur().equals("noir")) {
      s = "a";//"\u265C";
      return s;
    }
    return " ";
  }
}
