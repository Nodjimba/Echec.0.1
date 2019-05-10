public class Roi extends Piece {
  public Roi() {}

  public Roi(String nom,String couleur,int colonne, int ligne) {

      super("Roi",couleur, colonne, ligne);
    }



    public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA){
      if (!(this.caseValide(ligne, colonne, ligneA, colonneA)))
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
        if (this.getCouleur()=="blanc") {
          s = "\u2654";
          return s;
        }
        if (this.getCouleur()=="noir") {
          s = "\u265A";
          return s;
        }
        return null;
      }
}
