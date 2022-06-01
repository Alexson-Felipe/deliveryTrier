package br.com.triersistemas.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Getter
@ToString
@AllArgsConstructor
public class Produto {

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;

}
