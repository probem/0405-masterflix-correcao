package br.com.mastertech.masterflix.MasterFlix.repository;

import br.com.mastertech.masterflix.MasterFlix.model.Filme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends CrudRepository<Filme, Long> {

    Optional<Filme> findByNome(String nome);

    @Override
    @Query("select f from Filme f where f.ativo=true")
    List<Filme> findAll();
}
