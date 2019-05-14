public abstract class Piece {

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

  public  boolean mouvementValide(int ligneA, int colonneA){
    return true;
  }

  public void deplacement(Echequier p, int ligneA,int colonneA) {
    if (mouvementValide(ligneA, colonneA)==true) {

      if ((p.getCase(ligneA,colonneA))==null){
        p.setCase(ligneA,colonneA,this);
        p.retirerPiece(this.getLigne(),this.getColonne());
      }
      if ((p.getCase(ligneA, colonneA).getCouleur()!= this.couleur)) {
        p.setCase(ligneA,colonneA,this);
        p.retirerPiece(this.getLigne(),this.getColonne());
      }
    }
    else{
    p.grille();
    System.out.println("Votre déplacement est impossible");
  }
}

  public abstract String dessiner() ;
}
