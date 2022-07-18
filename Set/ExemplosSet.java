import java.util.*;

public class ExemplosSet {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7D, 8.5, 9.3, 5D, 7D, 0D, 3.6));
        System.out.println(notas.toString());
        /* REPARE QUE EM NOTAS IGUAIS (7) É ADICIONADO APENAS 1 VEZ */

        System.out.println("Exiba a posição da nota 5: " + "SEM POSSIBILIDADES COM SET");

        System.out.println("Adicione na lista a nota 8.0 na posição 4: " + "SEM POSSIBILIDADES COM SET");

        System.out.println("Substitua a nota 5.0 pela nota 6.0: " + "SEM POSSIBILIDADES COM SET");

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5D));

        System.out.println("Exiba a terceira nota adicionada: " + "SEM POSSIBILIDADES COM SET");

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Exiba a média das notas: " + (soma / notas.size()));

        System.out.println("Remova a nota 0: ");
        notas.remove(0D);
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0: " + "SEM POSSIBILIDADES COM SET");

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem que foram informados: ");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7D);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5D);
        notas2.add(7.0);
        notas2.add(0D);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo conjunto: ");
        notas.clear();

        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());

    }
}
