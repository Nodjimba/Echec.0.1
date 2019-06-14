public class Dame extends Piece {
  public Dame() {}

  public Dame (String nom, String couleur, int ligne, int colonne) {
    super("Dame",couleur, ligne, colonne);
  }

  public Dame(Piece p){
    super(p);
  }

  public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA){
    if ((this.caseValide(ligneA, colonneA)) == false)
      return false;
    if(Math.abs(colonneA - colonne) == Math.abs(ligneA - ligne))
      return true;
    if(colonneA == colonne)
      return true;
    if(ligne == ligneA)
      return true;
    return false;
  }

  public String dessiner() {
    String s;
    if (this.getCouleur().equals("blanc")) {
      s = "i";//"\u2655";
      return s;
    }
    if (this.getCouleur().equals("noir")) {
      s = "d";//"\u265B";
      return s;
    }
    return " ";
  }
}
