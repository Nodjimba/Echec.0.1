public class Roi extends Piece {
  public Roi() {}

  public Roi(String nom,String couleur,int ligne, int colonne) {
      super("Roi",couleur, ligne, colonne);
  }

  public Roi(Piece p){
    super(p);
  }


  public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA){
    if ((this.caseValide(ligneA, colonneA)) == false)
      return false;
    if(Math.abs(colonneA-colonne)==1 && Math.abs(ligneA-ligne)==1 )
      return true;
    if ((colonneA == colonne && ligneA == ligne + 1) || (colonneA == colonne && ligneA == ligne-1))
      return true;
    if((ligne == ligneA && colonneA == colonne + 1) || (ligne == ligneA && colonneA == colonne-1))
      return true;
    return false;
  }


  public String dessiner() {
    String s;
    if (this.getCouleur().equals("blanc")) {
      s = "j";//"\u2654";
      return s;
    }
    if (this.getCouleur().equals("noir")) {
      s = "e";//"\u265A";
      return s;
    }
    return " ";
  }
}
