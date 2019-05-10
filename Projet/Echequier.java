public class Echequier {

  protected Piece[][] plateau;

  public Echequier(){
    plateau = new Piece[8][8];
    for (int ligne=0;ligne<=7;ligne++)
      for (int colonne=0;colonne<=7;colonne++)
      plateau[ligne][colonne]= null;
  }


  public void miseEnPlaceEchequier(){
    int ligne = 7;
    String couleur = "noir";
    setCase(ligne,0 , new Tour("Tour",couleur,ligne,0));
		setCase(ligne,1, new Cavalier("Cavalier",couleur,ligne,1));
		setCase(ligne,2, new Fou("Fou",couleur,ligne,2));
		setCase(ligne,3, new Dame("Dame",couleur,ligne,3));
		setCase(ligne,4, new Roi("Roi",couleur,ligne,4));
		setCase(ligne,5, new Fou("Fou",couleur,ligne,5));
		setCase(ligne,6, new Cavalier("Cavalier",couleur,ligne,6));
    setCase(ligne,7, new Tour("Tour",couleur,ligne,7));
    ligne = 0;
    String couleur2 = "blanc";
    setCase(ligne,0, new Tour("Tour",couleur2,ligne,0));
		setCase(ligne,1, new Cavalier("Cavalier",couleur2,ligne,1));
		setCase(ligne,2, new Fou("Fou",couleur2,ligne,2));
		setCase(ligne,3, new Dame("Dame",couleur2,ligne,3));
		setCase(ligne,4, new Roi("Roi",couleur2,ligne,4));
		setCase(ligne,5, new Fou("Fou",couleur2,ligne,5));
	  setCase(ligne,6, new Cavalier("Cavalier",couleur2,ligne,6));
    setCase(ligne,7, new Tour("Tour",couleur2,ligne,7));

    for(int i = 0; i <= 7; i++){
			setCase( 1,i, new Pion("Pion","blanc",i, 1));
      setCase( 6,i, new Pion("Pion","noir",i, 6));
    }
  }


  public Piece getCase(int ligne, int colonne){
    if (ligne < 0 || ligne > 7){
      System.out.println("Erreur dans la coordonnee sur les lignes : ( "+ligne+","+colonne+")");
      return null;
    }
    if (colonne < 0 || ligne > 7){
      System.out.println("Erreur dans la coordonnee sur les colonnes : ("+ligne+","+colonne+")");
      return null;
    }
    return plateau[ligne][colonne];
  }


  public void setCase(int ligne, int colonne, Piece a){
    if (ligne < 0 || ligne > 7){
      System.out.println("Erreur dans la coordonnee sur les lignes : ("+ligne+","+colonne+")"+" : "+a.toString());
    }
    if (colonne < 0|| colonne > 7){
      System.out.println("Erreur dans la coordonnee sur les colonnes : ("+ligne+","+colonne+") : "+a.toString());
    }
    this.plateau[ligne][colonne]=a;
  }


  public void retirerPiece(int ligne ,int colonne) {
    this.plateau[ligne][colonne]=null;
  }


  public void grille() {

    System.out.println("  -----------------------------------------------------------------");

    for (int ligne = 0; ligne <8; ligne++) {
      System.out.println("  |       |       |       |       |       |       |       |       |");
      System.out.print(8 - ligne + " |");

      for (int colonne = 0; colonne <8; colonne++) {
        if (!(this.getCase(ligne,colonne)==null)){
          System.out.print("   " + this.getCase(ligne, colonne).dessiner()+"   |");
        }
        else {
          System.out.print("       |");
        }
      }

      System.out.println();
      System.out.println("  |       |       |       |       |       |       |       |       |");
      System.out.println("  -----------------------------------------------------------------");
    }

    System.out.println("      a       b       c       d       e       f       g       h");
  }


  public static void main (String [] args) {
    Echequier Senpai = new Echequier();
    Senpai.miseEnPlaceEchequier();
    Senpai.grille();
    Senpai.getCase(1,0).deplacement(Senpai,1,0,2,0);
    Senpai.getCase(6,0).deplacement(Senpai,6,0,4,0);
    Senpai.getCase(2,0).deplacement(Senpai,2,0,3,0);
    Senpai.getCase(4,0).deplacement(Senpai,4,0,3,0);
    Senpai.grille();

  }










}
