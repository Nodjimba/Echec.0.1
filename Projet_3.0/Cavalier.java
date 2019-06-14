public class Cavalier extends Piece {
  public Cavalier() {}

  public Cavalier(String nom,String couleur,int ligne, int colonne) {
      super("Cavalier",couleur, ligne, colonne);
    }

    public Cavalier(Piece p){
      super(p);
    }



    public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA) {
      if(this.caseValide(ligneA, colonneA) == false)
        return false;
      if (ligneA != ligne -1 && ligneA != ligne + 1 && ligneA != ligne -2 && ligneA != ligne + 2 )
        return false;
      if (colonneA != colonne -1 && colonneA != colonne + 1 && colonneA != colonne -2 && colonneA != colonne +2)
        return false;
      //if (Math.abs(ligneA-ligne)=Math.abs(colonneA-colonne))
        //return false;
      return true;



//      return false;
    }

    public String dessiner() {
      String s;
      if (this.getCouleur().equals("blanc")) {
        s = "g";//"\u2658";
        return s;
      }
      if (this.getCouleur().equals("noir")) {
        s = "b";//"\u265E";
        return s;
      }
      return " ";
    }


}
