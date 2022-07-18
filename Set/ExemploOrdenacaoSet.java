        /*
         * Serie 1 = Nome: Suits, Genero: Advogados, Tempo Episodio: 45
         * Serie 2 = Nome: The Witcher, Genero: Fantasia, Tempo Episodio: 60
         * Serie 3 = Nome: Lethal Weapon, Genero: Policial, Tempo Episodio: 45
         * */

        import java.util.*;

        public class ExemploOrdenacaoSet {
    public static void main(String[] args) {


        System.out.println("--\tOrdem de Inserção\t---");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("The Witcher", "Fantasia", 60));
            add(new Serie("Suits", "Advogados", 45));
            add(new Serie("Lethal Weapon", "Policial", 45));
        }};
        for (Serie serie: minhasSeries1
             ) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempo());
        }


        System.out.println("--\tOrdem aleatória\t---");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("The Witcher", "Fantasia", 60));
            add(new Serie("Suits", "Advogados", 45));
            add(new Serie("Lethal Weapon", "Policial", 45));
        }};
        for (Serie serie: minhasSeries
             ) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempo());
        }

        System.out.println("--\tOrdem Natural (Tempo)\t---");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries);
        for (Serie serie: minhasSeries2
        ) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempo());
        }
//
//        System.out.println("--\tOrdem Idade\t---");
//
//
//        System.out.println("--\tOrdem Cor\t---");


        System.out.println("--\tOrdem Nome/Genero/Tempo\t---");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempo());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie: minhasSeries3
        ) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempo());
        }

    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempo;

    public Serie(String nome, String genero, Integer tempo) {
        this.nome = nome;
        this.genero = genero;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempo() {
        return tempo;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempo=" + tempo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempo, serie.tempo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempo);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempo = Integer.compare(this.getTempo(), serie.getTempo());
        if(tempo != 0) return tempo;

        return this.getGenero().compareTo(serie.getGenero());
    }
}

class ComparatorNomeGeneroTempo implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempo(), s2.getTempo());
    }
}