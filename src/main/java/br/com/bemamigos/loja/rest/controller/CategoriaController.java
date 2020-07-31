package br.com.bemamigos.loja.rest.controller;

import br.com.bemamigos.loja.model.entity.Categoria;
import br.com.bemamigos.loja.model.entity.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("loja/categoria")
public class CategoriaController {
    private final String CATEGORIA_NAO_ENCONTRADA = "Categoria não encontrada";
    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvarCategoria (@RequestBody @Valid Categoria categoria){
        return repository.save(categoria);
    }

    @GetMapping("/{id}")
    public  Categoria buscarCategoria(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, CATEGORIA_NAO_ENCONTRADA));

    }

    @GetMapping
    public List<Categoria> listCategoria(){
        return repository
                .findAll();

    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  Categoria atualizarCategoria(@RequestBody @Valid Categoria categoriaAtualizada){
        return repository
                .findById(categoriaAtualizada.getId())
                .map(categoria -> {
                    return repository.save(categoriaAtualizada);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, CATEGORIA_NAO_ENCONTRADA));

    }

    @DeleteMapping("{id}")
    public void deletaCategoria(@PathVariable Integer id){
         repository
                .findById(id)
                .map(categoria -> {
                    repository.delete(categoria);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, CATEGORIA_NAO_ENCONTRADA));

    }

}
