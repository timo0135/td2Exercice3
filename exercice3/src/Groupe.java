import java.util.*;


public class Groupe{


    List<Etudiant> classe = new ArrayList<>();
    Formation formation;

    public Groupe(Formation formation){
        this.formation = formation;
    }

    public void ajouterEtudiant(Etudiant etu){
        if(etu.getFormation().equals(this.formation)){
            classe.add(etu);
        }
    }

    public void supprimerEtudiant(Etudiant etu){
        classe.remove(etu);
    }

    public double calculerMoyenneMatiere(Matiere matiere){
        double somme = 0;
        int nbetu = 0;
        for(Etudiant etu : classe){
            somme += etu.calculerMoyenneMatiere(matiere);
            nbetu++;
        }
        return somme/nbetu;
    }

    public double calculerMoyGen(){
        double somme = 0;
        int nbetu = 0;
        for(Etudiant etu : classe){
            somme += etu.calculerMoyGen();
            nbetu++;
        }
        return somme/nbetu;
    }




    public void compareAlpha(){
        Collections.sort(this.classe);
    }

    public void compareAntiAlpha(){
        Collections.sort(this.classe, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                return -o1.compareTo(o2);
            }
        });
    }

    public void triParMerite(){
        Collections.sort(this.classe, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                return (int) (o1.calculerMoyGen() - o2.calculerMoyGen());
            }
        });

    }

    @Override
    public String toString() {
        String res = "Groupe :\n";
        for(Etudiant etu : this.classe){
            res += etu.getIdentite().getNom() + " " + etu.getIdentite().getPrenom() + "\n";
        }
        return res;
    }
}
