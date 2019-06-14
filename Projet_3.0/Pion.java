public class Pion extends Piece {

  public Pion() {}

  public Pion (String nom, String couleur, int ligne, int colonne) {
    super("Pion",couleur, ligne, colonne);
  }

  public Pion(Piece p){
    super(p);
  }


  public boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA) {
    if(this.caseValide(ligneA, colonneA) == false)
      return false;
    if(this.getCouleur() == "noir" && ligneA > ligne) {
      if ((ligneA == (ligne+2) && colonneA == colonne) && (ligne == 1))
        return true;
      if (ligneA == (ligne+1) && colonne == colonneA)
        return true;
      if (((ligne+1) == ligneA && colonneA == (colonne+1)) || ((ligne+1) == ligneA && colonneA == (colonne-1)))
      return true;
    }
    else if (this.getCouleur() == "blanc" && ligneA < ligne) {
      if ((ligneA == (ligne-2) && colonne == colonneA) && (ligne == 6))
        return true;
      if ((ligneA == (ligne-1) && colonne == colonneA))
        return true;
      if (((ligne-1) == ligneA && colonneA == (colonne-1)) || ((ligne-1) == ligneA && colonneA == (colonne+1)))
        return true;
    }
    return false;
  }


  public String dessiner() {
    String s;
    if (this.getCouleur().equals("blanc")) {
      s = "l";//"\u2659";
      return s;
    }
    if (this.getCouleur().equals("noir")) {
      s = "k";//"\u265F";
      return s;
    }
    return " ";
  }
  }
