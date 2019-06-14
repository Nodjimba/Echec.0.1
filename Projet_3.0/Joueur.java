public class Joueur {

  private couleur;

  public Joueur(String couleur) {
    this.couleur = couleur;
  }

  public void Joueur(String couleur) {
    if () {

    }
  }



  public void Scanner() {
    Scanner input = new Scanner(System.in);
    int nb = input.nextInt();
  }





  public void sauvegarder(String nomFichier,Echequier p) {

    try {
      PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(nomFichier, false)));
      for (int ligne=0;ligne<=7;ligne++)
        for (int colonne=0;colonne<=7;colonne++) {
          if (p.plateau.getCase(ligne,colonne)!=null){
            writer.println(p.plateau.getCase(ligne,colonne).toString()); // créer le toString pour écrire dans le fichier
          }
      writer.close();
      }
    }

    catch(IOException e) {
      System.out.println(e);
    }
  }

  public void charger(String nomFichier) {
    try{
      while(this.size()!=0) {
        this.remove(0);
      }

      BufferedReader reader = new BufferedReader(new FileReader(nomF)) ;
      String ligne = reader.readLine();
      System.out.println(ligne);
      StringTokenizer str ;
      while(ligne!=null){
        str = new StringTokenizer(ligne);
        Piece e = new Piece(nom, couleur, ligne, colonne);
        e.setNom(str.nextToken());
        e.setCouleur(Float.parseFloat(str.nextToken()));
        e.setPosition(Float.parseFloat(str.nextToken()));
        System.out.println(ligne);
        this.add(e);
        ligne = reader.readLine();
        }
      c.close(); }
    catch(IOException e){
      System.out.println(e);
    }
  }

  public void init() {
    Scanner input = new Scanner(System.in);
    System.out.println("Saisir un mouvement valide");
  }






  public static void main(String [] args) {

  }




















}
