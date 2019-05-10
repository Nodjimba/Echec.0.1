public abstract class Piece {

  protected String nom;
  protected String couleur;
  protected int ligne;
  protected int colonne ;

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

  public boolean caseValide(int ligne, int colonne, int ligneA, int colonneA){
    if(ligne == ligneA && colonne == colonneA)
      return false;
    if(ligneA < 0 || ligneA > 7 || colonneA < 0 || colonneA > 7 || ligne < 0 || ligne > 7 || colonne < 0 || colonne > 7)
      return false;
    return true;
  }

  public  boolean mouvementValide(int ligne, int colonne, int ligneA, int colonneA){
    return true;
  }

  public void deplacement(Echequier p, int ligne, int colonne, int ligneA,int colonneA) {
    if (mouvementValide(ligne, colonne, ligneA, colonneA)==true) {

      if ((p.getCase(ligneA,colonneA))==null){
        p.setCase(ligneA,colonneA,this);
        p.retirerPiece(ligne,colonne);
      }
      if ((p.getCase(ligneA, colonneA).getCouleur()!= this.couleur)) {
        p.setCase(ligneA,colonneA,this);
        p.retirerPiece(ligne,colonne);
      }
        }
    else{
    p.grille();
    System.out.println("Votre déplacement est impossible");
  }
}

  public abstract String dessiner() ;
}
