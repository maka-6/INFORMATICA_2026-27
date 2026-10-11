/*
Autore: Makaoui Youness
Classe: 5G
Data: 2/10/2026
Oggetto:
*/

class SchedaAnimale{
    String matricola;
    String nome;
    String razza;
    int anno_nascita;
    int anno_morte;


    SchedaAnimale(String matricola,String nome,String razza,int anno_nascita, int anno_morte){
        this.matricola = matricola;
        this.nome = nome;
        this.razza = razza;
        this.anno_nascita = anno_nascita;
        this.anno_morte = anno_morte;
    }

    SchedaAnimale(){
        matricola= "";
        nome = "";
        razza = "";
        anno_nascita = 0;
        anno_morte = 0;
    }


    public String toString() {
        return matricola + " "+ nome + " "+ razza + " "+ anno_nascita + " "+ anno_morte;
    }

}