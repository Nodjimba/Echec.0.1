public class Dame extends Piece {
  public Dame() {}

  public Dame (String nom, String couleur, int ligne, int colonne) {
    super("Dame",couleur, colonne, ligne);
  }

  public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA){
    if (!(this.caseValide(ligne, colonne, ligneA, colonneA)))
      return false;
    if(colonneA - colonne == ligneA - colonneA)
      return true;
    if(colonneA == colonne)
      return true;
    if(ligne == ligneA)
      return true;
    return false;
  }

  public String dessiner() {
    String s;
    if (this.getCouleur()=="blanc") {
      s = "\u2655";
      return s;
    }
    if (this.getCouleur()=="noir") {
      s = "\u265B";
      return s;
    }
    return null;
  }
}
