import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.StringTokenizer;




public class EchequierSauvegarde {

  private Piece[][] plateau;

  public EchequierSauvegarde(){
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

  public void sauvegarder(String nomFichier) {
      try
      {
      FileWriter fw = new FileWriter(nomFichier);
      BufferedWriter bw = new BufferedWriter(fw);
      for (int ligne=0;ligne<=7;ligne++)
        for (int colonne=0;colonne<=7;colonne++)
          if (this.getCase(ligne,colonne)!=null){
          bw.write(this.getCase(ligne,colonne).getNom()+"\t"+this.getCase(ligne,colonne).getCouleur()+"\t"+this.getCase(ligne,colonne).getLigne()+"\t"+this.getCase(ligne,colonne).getColonne()+"\n");
         }

          bw.close();
          fw.close();
          }catch (IOException e) {
      			System.err.println(e);
      		}
        }



    public void charger(String nomFichier){
      try{
      FileReader fr = new FileReader(nomFichier);
			BufferedReader br = new BufferedReader(fr);
      String line;
      line = br.readLine();
      while(line!=null){
        StringTokenizer st = new StringTokenizer(line,"\t");
        Piece p = new Piece();
        p.setNom(st.nextToken());
        p.setCouleur(st.nextToken());
        p.setLigne(Integer.parseInt(st.nextToken()));
        p.setColonne(Integer.parseInt(st.nextToken()));
    //    this.chargerPiece(p);
        line = br.readLine();
        }
        br.close();
        fr.close();
      }catch (IOException e) {
  			System.err.println(e);
  		}
    }
/*
    public void chargerPiece(Piece p){
      if (p.getNom()=="Pion") {
        this.setCase(p.getLigne(),p.getColonne(),new Pion(PieceSauvegarde p));}
      if (p.getNom()=="Dame") this.setCase(p.getLigne(),p.getColonne(),new Dame(PieceSauvegarde p)));
      if (p.getNom()=="Tour") this.setCase(p.getLigne(),p.getColonne(),new Tour(PieceSauvegarde p)));
      if (p.getNom()=="Fou") this.setCase(p.getLigne(),p.getColonne(),new Fou(PieceSauvegarde p)));
      else this.setCase(p.getLigne(),p.getColonne(),new Roi(PieceSauvegarde p)));

    }
*/

  public static void main (String [] args) {
    Echequier e = new Echequier();
    e.miseEnPlaceEchequier();
/*    e.getCase(1,0).deplacement(e,1,0,2,0);
    e.getCase(6,0).deplacement(e,6,0,4,0);
    e.getCase(2,0).deplacement(e,2,0,3,0);
    e.getCase(4,0).deplacement(e,4,0,3,0);
    e.getCase(0,1).deplacement(e,0,1,2,2);
    e.getCase(2,2).deplacement(e,2,2,3,0);
    e.getCase(7,0).deplacement(e,7,0,3,0);
*/
  /*  e.getCase(0,3).deplacement(e,0,3,7,3);
    e.getCase(7,4).deplacement(e,7,4,7,3);
    e.getCase(7,5).deplacement(e,7,5,4,2);
    e.getCase(4,2).deplacement(e,4,2,0,6);
    e.getCase(0,7).deplacement(e,0,7,0,6);
    e.getCase(0,2).deplacement(e,0,2,1,1);
  //  e.getCase(1,1).deplacement(e,1,1,7,7);
    e.getCase(1,1).deplacement(e,1,1,1,2);

*/

    e.grille();
    System.out.println(e.getCase(0,2).getLigne());
    System.out.println(e.getCase(0,2).getColonne());
    e.sauvegarder("test.txt");
    Echequier ez = new Echequier();
    ez.charger("test.txt");
    ez.grille();


  }










}
