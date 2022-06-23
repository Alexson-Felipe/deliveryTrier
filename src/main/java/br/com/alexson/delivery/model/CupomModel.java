package br.com.alexson.delivery.model;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class CupomModel {

   @NotNull
   private String nome;

   @NotNull
   private BigDecimal valorEmPontos;
   
   @NotNull
   private BigDecimal valorDesconto;
}
