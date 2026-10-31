import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Produto> produtos = Arrays.asList(
                new Produto("Teclado", 150.00),
                new Produto("Mouse", 80.00),
                new Produto("Monitor", 900.00),
                new Produto("Caderno", 25.00),
                new Produto("Headset", 120.00)
        );

        // 1. Filtrar produtos com preço maior que 100
        List<Produto> filtrados = produtos.stream()
                .filter(p -> p.getPreco() > 100)
                .collect(Collectors.toList());

        System.out.println("Produtos acima de R$ 100:");
        filtrados.forEach(System.out::println);

        // 2. Ordenar produtos por nome
        List<Produto> ordenados = produtos.stream()
                .sorted(Comparator.comparing(Produto::getNome))
                .collect(Collectors.toList());

        System.out.println("\nProdutos em ordem alfabética:");
        ordenados.forEach(System.out::println);

        // 3. Buscar um produto pelo nome
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o nome do produto: ");
        String nomeBusca = scanner.nextLine();

        Optional<Produto> encontrado = produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nomeBusca))
                .findFirst();

        // 4. Tratar o resultado com Optional
        encontrado.ifPresentOrElse(
                p -> System.out.println(
                        "Produto encontrado: " + p.getNome()
                                + " - R$ " + p.getPreco()
                ),
                () -> System.out.println("Produto não encontrado.")
        );

        scanner.close();
    }
}
