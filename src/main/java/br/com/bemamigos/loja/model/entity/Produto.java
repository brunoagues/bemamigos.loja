package br.com.bemamigos.loja.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "Produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 200)
    @NotEmpty(message = "")
    private String nome;

    @NotEmpty(message = "")
    private String tipo;

    @NotEmpty(message = "")
    private String descricao;




}
