package br.com.triersistemas.delivery;

import java.math.BigDecimal;
import java.util.List;

public class BD {

    public static final List<Produto> produtos = List.of(
            new Produto("Shampoo Clear", BigDecimal.valueOf(8.99), 10),
            new Produto("Ração DogMil", BigDecimal.valueOf(17.99), 5),
            new Produto("Ração Gato", BigDecimal.valueOf(22.98), 8),
            new Produto("Arroz 1kg", BigDecimal.valueOf(5.99), 15),
            new Produto("Feijão 1kg", BigDecimal.valueOf(3.95), 7)
    );
}
