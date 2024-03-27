package ApiLivro.Livro.controller;

import ApiLivro.Livro.entity.Livro;
import ApiLivro.Livro.repository.LivroRepository;
import ApiLivro.Livro.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
@RequiredArgsConstructor
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @Operation(summary = "criar Livro", description = "metodo que cria um dado", tags = "livros")
    ResponseEntity<List<Livro>> create(@Valid @RequestBody Livro todo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livroService.create(todo));
    }

@GetMapping
@Operation(summary = "Mostrar os dados", description = "metodo que mostra os dados", tags = "livros")

    List<Livro> list(){
        return livroService.list();
    }

@PutMapping("{id}")
@Operation(summary = "atualizar os dados", description = "metodo que atualiza os dados", tags = "livros")

    List<Livro>update(@PathVariable Long id, @RequestBody Livro livro){
        return livroService.update(id,livro);
}

@DeleteMapping("{id}")
@Operation(summary = "Deletar os dados", description = "metodo que deleta os dados", tags = "livros")

    List<Livro>delete(@PathVariable Long id){
        return livroService.delete(id);
}



}
