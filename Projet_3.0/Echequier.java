import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;



public class Echequier {

  private Piece[][] plateau;

  public Echequier(){
    plateau = new Piece[8][8];
    for (int ligne=0;ligne<=7;ligne++)
      for (int colonne=0;colonne<=7;colonne++)
      plateau[ligne][colonne] = new Piece();
    }


  public void miseEnPlaceEchequier(){
    int ligne = 0;
    String couleur = "noir";
    setCase(ligne,0 , new Tour("Tour",couleur,ligne,0));
		setCase(ligne,1, new Cavalier("Cavalier",couleur,ligne,1));
		setCase(ligne,2, new Fou("Fou",couleur,ligne,2));
		setCase(ligne,3, new Dame("Dame",couleur,ligne,3));
		setCase(ligne,4, new Roi("Roi",couleur,ligne,4));
		setCase(ligne,5, new Fou("Fou",couleur,ligne,5));
		setCase(ligne,6, new Cavalier("Cavalier",couleur,ligne,6));
    setCase(ligne,7, new Tour("Tour",couleur,ligne,7));
    ligne = 7;
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
			setCase( 6,i, new Pion("Pion","blanc",6,i));
      setCase( 1,i, new Pion("Pion","noir",1,i));
    }
  }


  public Piece getCase(int ligne, int colonne){
    if (ligne < 0 || ligne > 7){
      System.out.println("Erreur dans la coordonnee sur les lignes : ("+ligne+","+colonne+")");
      return null;
    }
    if (colonne < 0 || colonne > 7){
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
    this.plateau[ligne][colonne]=new Piece();
  }



  public void grille() {

    System.out.println("  -----------------------------------------------------------------");

    for (int ligne = 0; ligne <8; ligne++) {
      System.out.println("  |       |       |       |       |       |       |       |       |");
      System.out.print(8 - ligne + " |");

      for (int colonne = 0; colonne <8; colonne++) {
        if (!(this.getCase(ligne,colonne)==new Piece())){
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

/*
    public Piece castPiece(StringTokenizer token){
      String name = token.nextToken();
      String couleur = token.nextToken();
      int ligne = Integer.parseInt(token.nextToken());
      int colonne = Integer.parseInt(token.nextToken());
      if (couleur.compareTo("blanc") == 0) {
        if(name.compareTo("Tour") == 0)
          return new Tour("Tour",couleur,ligne,colonne);
        else if(name.compareTo("Cavalier") == 0)
          return new Cavalier("Cavalier",couleur,ligne,colonne);
        else if(name.compareTo("Fou") == 0)
          return new Fou("Fou",couleur,ligne,colonne);
        else if(name.compareTo("Dame") == 0)
          return new Dame("Dame",couleur,ligne,colonne);
        else if(name.compareTo("Roi") == 0)
          return new Roi("Roi",couleur,ligne,colonne);
        else if(name.compareTo("Pion") == 0)
          return new Pion("Pion",couleur,ligne,colonne);
      }
      else if (couleur.compareTo("noir") == 0) {
        if(name.compareTo("Tour") == 0)
          return new Tour("Tour",couleur,ligne,colonne);
        else if(name.compareTo("Cavalier") == 0)
          return new Cavalier("Cavalier",couleur,ligne,colonne);
        else if(name.compareTo("Fou") == 0)
          return new Fou("Fou",couleur,ligne,colonne);
        else if(name.compareTo("Dame") == 0)
          return new Dame("Dame",couleur,ligne,colonne);
        else if(name.compareTo("Roi") == 0)
          return new Roi("Roi",couleur,ligne,colonne);
        else if(name.compareTo("Pion") == 0)
          return new Pion("Pion",couleur,ligne,colonne);
      }
      return new Piece();
    }
*/

    public void charger(String nomFichier){
      try{
      FileReader fr = new FileReader(nomFichier);
			BufferedReader br = new BufferedReader(fr);
      String line;
      line = br.readLine();
      while(line!=null){
        StringTokenizer st = new StringTokenizer(line,"\t");
      //  Piece p = castPiece(st);
        //System.out.println(p.getNom() + " "+ p.getCouleur()+ " " +p.getLigne()+ " " +p.getColonne());
        String str=st.nextToken();
        if (str.equals("Pion")) {
          Pion p = new Pion();
          p.setNom(str);
          p.setCouleur(st.nextToken());
          p.setLigne(Integer.parseInt(st.nextToken()));
          p.setColonne(Integer.parseInt(st.nextToken()));
          this.setCase(p.getLigne(),p.getColonne(),p);
        }
        if (str.equals("Dame")) {
          Dame p = new Dame();
          p.setNom(str);
          p.setCouleur(st.nextToken());
          p.setLigne(Integer.parseInt(st.nextToken()));
          p.setColonne(Integer.parseInt(st.nextToken()));
          this.setCase(p.getLigne(),p.getColonne(),p);
        }
        if (str.equals("Roi")) {
          Roi p = new Roi();
          p.setNom(str);
          p.setCouleur(st.nextToken());
          p.setLigne(Integer.parseInt(st.nextToken()));
          p.setColonne(Integer.parseInt(st.nextToken()));
          this.setCase(p.getLigne(),p.getColonne(),p);
        }
        if (str.equals("Tour")) {
          Tour p = new Tour();
          p.setNom(str);
          p.setCouleur(st.nextToken());
          p.setLigne(Integer.parseInt(st.nextToken()));
          p.setColonne(Integer.parseInt(st.nextToken()));
          this.setCase(p.getLigne(),p.getColonne(),p);
        }
        if (str.equals("Fou")) {
          Fou p = new Fou();
          p.setNom(str);
          p.setCouleur(st.nextToken());
          p.setLigne(Integer.parseInt(st.nextToken()));
          p.setColonne(Integer.parseInt(st.nextToken()));
          this.setCase(p.getLigne(),p.getColonne(),p);
        }
        if (str.equals("Cavalier")) {
          Cavalier p = new Cavalier();
          p.setNom(str);
          p.setCouleur(st.nextToken());
          p.setLigne(Integer.parseInt(st.nextToken()));
          p.setColonne(Integer.parseInt(st.nextToken()));
          this.setCase(p.getLigne(),p.getColonne(),p);
        }
        line = br.readLine();
      }
        br.close();
        fr.close();
                  for (int ligne = 0; ligne <8; ligne++) {
                    for (int colonne = 0; colonne <8; colonne++) {
                      System.out.println(this.getCase(ligne, colonne));}}
      }catch (IOException e) {
  			System.err.println(e);
  		}


    }



  public static void main (String [] args) {
    Echequier echequier = new Echequier();
    Partie p = new Partie(echequier);
    echequier.miseEnPlaceEchequier();



  /*  echequier.getCase(1,3).deplacement(echequier,1,3,2,3);
    echequier.getCase(2,3).deplacement(echequier,2,3,3,3);
    echequier.getCase(3,3).deplacement(echequier,3,3,4,3);
    echequier.getCase(4,3).deplacement(echequier,4,3,5,3);
    echequier.getCase(6,2).deplacement(echequier,6,2,5,3);
    echequier.getCase(5,3).deplacement(echequier,5,3,4,3);

*/




    echequier.grille();

  //  echequier.sauvegarder("Partie.txt");
//    Echequier p1 = new Echequier();
  //  p1.charger("test.txt");
    //p1.grille();
  }










}
