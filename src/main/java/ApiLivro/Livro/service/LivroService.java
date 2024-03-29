package ApiLivro.Livro.service;
import ApiLivro.Livro.util.BadRequestException;
import ApiLivro.Livro.entity.Livro;
import ApiLivro.Livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;


    public LivroService(LivroRepository livroRepository) {
        this.livroRepository= livroRepository;
    }
    public   List<Livro> list() {
        Sort sort = Sort.by(Direction.ASC, "id");


       return livroRepository.findAll(sort);
    }


    public List<Livro> create(Livro livro) {
       livroRepository.save(livro);
        return list();
    }

public List<Livro> update (Long id, Livro livro){
livroRepository.findById(id).ifPresentOrElse((ExistingLivro) ->{
    livro.setId(id);
    livroRepository.save(livro);
}, () -> {
    throw new BadRequestException(" o livro não existe!");

});
return  list();
}

public List<Livro>delete(Long id){
        livroRepository.findById(id).ifPresentOrElse((existingLivro) ->livroRepository.delete(existingLivro),
                () ->{
            throw new BadRequestException(" o livro não existe");
                });
        return list();
}

}


