package br.com.bemamigos.loja.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

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

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "")
    private String tipo;

    @Column(nullable = true, length = 500)
    @NotEmpty(message = "")
    private String descricao;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name="id_categoria")
    private Categoria categoria;


    @PrePersist
    public void prePersist(){ setDataCadastro(LocalDate.now());}



}
