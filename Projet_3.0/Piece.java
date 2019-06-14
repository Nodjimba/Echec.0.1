public class Piece {

  private String nom;
  private String couleur;
  private int ligne;
  private int colonne ;

  public Piece() {}

  public Piece(String nom, String couleur, int ligne, int colonne) {
    this.nom = nom;
    this.couleur = couleur;
    this.ligne=ligne;
    this.colonne=colonne;
  }

  public Piece(Piece p){
    this.nom=p.nom;
    this.couleur = p.couleur;
    this.ligne = p.ligne;
    this.colonne = p.colonne;
  }

  public String getNom() {
    return this.nom;
  }

  public String getCouleur() {
    return this.couleur;
  }

  public int getLigne(){
    return this.ligne;
  }

  public int getColonne(){
    return this.colonne;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setCouleur(String couleur) {
    if ((couleur == "blanc") || (couleur == "noir"))
    this.couleur = couleur;
  }

  public void setLigne(int ligne){
    this.ligne = ligne;
  }

  public void setColonne(int colonne){
    this.colonne = colonne;
  }

  public void setPosition(int ligne, int colonne){
    this.ligne = ligne;
    this.colonne = colonne;
  }

  public boolean caseValide(int ligneA, int colonneA){
    if(this.getLigne() == ligneA && this.getColonne() == colonneA)
      return false;
    if(ligneA < 0 || ligneA > 7 || colonneA < 0 || colonneA > 7 || this.getLigne() < 0 || this.getLigne() > 7 || this.getColonne() < 0 || this.getColonne() > 7)
      return false;
    return true;
  }

  public  boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA){
    return true;
  }

  public void deplacement(Echequier p,int ligne, int colonne, int ligneA,int colonneA) {
    if (mouvementValide(ligne, colonne, ligneA, colonneA) == true) {

      if (this.getNom() == "Pion") {
        if (colonne == colonneA) {
          if ((p.getCase(ligneA,colonneA)).getCouleur() == null)
            placementPiece(p, ligne, colonne, ligneA, colonneA);
        }
        else {
          if ((p.getCase(ligneA, colonneA).getCouleur() == this.couleur) || (p.getCase(ligneA, colonneA).getCouleur() == null))
            System.out.println("Votre déplacement est impossible");
          else {placementPiece(p, ligne, colonne, ligneA, colonneA);}
        }
      }

      if (this.getNom() != "Pion") {
        if (collision(p,ligne, colonne, ligneA, colonneA) == true) {
          if ((p.getCase(ligneA,colonneA))==new Piece())
            placementPiece(p, ligne, colonne, ligneA, colonneA);
          if ((p.getCase(ligneA, colonneA).getCouleur()!= this.couleur))
            placementPiece(p, ligne, colonne, ligneA, colonneA);
        }
      }
    }
    else{
      System.out.println("Votre déplacement est impossible");
    }
  }

  public void placementPiece(Echequier p, int ligne, int colonne, int ligneA,int colonneA) {
    p.setCase(ligneA,colonneA,this);
    p.retirerPiece(ligne,colonne);
  }

  public boolean collision(Echequier p,int ligne, int colonne, int ligneA, int colonneA) {
    if (collisionLigne(p,ligne, colonne, ligneA, colonneA) == true)
      return true;
    if (collisionColonne(p,ligne, colonne, ligneA, colonneA) == true)
      return true;

    if (collisionDiagonale(p, ligne, colonne, ligneA, colonneA) == true) {
      return true; }

    return false;
  }

  public boolean collisionLigne(Echequier p,int ligne, int colonne, int ligneA, int colonneA) {
    if(ligne == ligneA) {
      for (int i=1; i<Math.abs(colonne-colonneA) ; i++) {
        if((this.caseValide(ligne,Math.abs(colonne+i)) == true)) {
          if (p.getCase(ligne,Math.abs(colonne+i)).getCouleur() != null) {
            return false;}
        }
        if ((this.caseValide(ligne,Math.abs(colonne-i)) == true)) {
          if (p.getCase(ligne,Math.abs(colonne-i)).getCouleur() != null) {
            return false;}
        }
      }
      return true;
    }
    return false;
  }

  public boolean collisionColonne(Echequier p,int ligne, int colonne, int ligneA, int colonneA) {
    if(colonne == colonneA) {
      for (int i=1; i<Math.abs(ligne-ligneA) ; i++) {
        if((this.caseValide(Math.abs(ligne+i), colonne) == true)) {
          if (p.getCase(Math.abs(ligne+i),colonne).getCouleur() != null) {
            return false;}
        }
        if ((this.caseValide(Math.abs(ligne-i), colonne) == true)) {
          if (p.getCase(Math.abs(ligne-i),colonne).getCouleur() != null) {
            return false;}
        }
      }
      return true;
    }
    return false;
  }

  public boolean collisionDiagonale(Echequier p,int ligne, int colonne, int ligneA, int colonneA) {
    if(Math.abs(colonneA - colonne) == Math.abs(ligneA - ligne)) {
      for (int i=1; i<=(Math.abs(ligneA - ligne)-1); i++) {
        for (i=1; i<=(Math.abs(colonneA - colonne)-1) ; i++) {
          if((this.caseValide(Math.abs(ligne+i), Math.abs(colonne+i)) == true)) {
            if (p.getCase(Math.abs(ligne+i), Math.abs(colonne+i)).getCouleur() != null)
            return false;}
          if((this.caseValide(Math.abs(ligne-i), Math.abs(colonne-i)) == true)) {
            if (p.getCase(Math.abs(ligne-i), Math.abs(colonne-i)).getCouleur() != null)
            return false;}
          if((this.caseValide(Math.abs(ligne+i), Math.abs(colonne-i)) == true)) {
            if (p.getCase(Math.abs(ligne+i), Math.abs(colonne-i)).getCouleur() != null)
            return false;}
          if((this.caseValide(Math.abs(ligne-i), Math.abs(colonne+i)) == true)) {
            if (p.getCase(Math.abs(ligne-i), Math.abs(colonne+i)).getCouleur() != null)
            return false;}
        }
      }
      return true;
    }
    return false;
  }




  public String toString(){
    String s = this.getNom()+" "+
               this.getCouleur()+" "+
               String.valueOf(this.getLigne())+" "+
               String.valueOf(this.getColonne());
    return s;
  }

  public String dessiner() {
    return " ";
  }

  public String dessiner2(){ return "P";}

}










//
