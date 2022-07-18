/*
* Autor = Hawking, Stephen - Livro = nome: Uma Breve História do Tempo - Páginas: 256
* Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito - Páginas: 408
* Autor = Harari, Yuval Noah - Livro = nome: 21 Lições Para o século 21 - Páginas: 432
* */

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {



        System.out.println("--\tOrdem Aleatória\t--");
        Map<String, Livros> meusLivros = new HashMap<>() {{
            put("Hawking, Stephen", new Livros("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livros("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livros("21 lições para o século 21", 432));
        }};

        for (Map.Entry<String, Livros> livros: meusLivros.entrySet()
             ) {
            System.out.println(livros.getKey() + " - " + livros.getValue());
        }


        System.out.println("--\tOrdem Inserção\t--");
        Map<String, Livros> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livros("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livros("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livros("21 lições para o século 21", 432));
        }};

        for (Map.Entry<String, Livros> livros: meusLivros1.entrySet()
        ) {
            System.out.println(livros.getKey() + " - " + livros.getValue());
        }

        System.out.println("--\tOrdem Alfabética autores\t--");
        Map<String, Livros> meusLivros2 = new TreeMap<>(meusLivros1);

        for (Map.Entry<String, Livros> livros: meusLivros2.entrySet()
        ) {
            System.out.println(livros.getKey() + " - " + livros.getValue());
        }


        System.out.println("--\tOrdem Alfabética nome dos livros\t--");
        Set<Map.Entry<String, Livros>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livros> livros: meusLivros3
        ) {
            System.out.println(livros.getKey() + " - " + livros.getValue());
        }
    }
}


class Livros {
    private String nome;
    private Integer paginas;

    public Livros(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livros livros = (Livros) o;
        return nome.equals(livros.nome) && paginas.equals(livros.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
};


class ComparatorNome implements Comparator<Map.Entry<String, Livros>> {

    @Override
    public int compare(Map.Entry<String, Livros> l1, Map.Entry<String, Livros> l2) {
       return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}
