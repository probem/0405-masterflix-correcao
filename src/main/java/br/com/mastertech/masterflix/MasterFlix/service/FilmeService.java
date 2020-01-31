package br.com.mastertech.masterflix.MasterFlix.service;

import br.com.mastertech.masterflix.MasterFlix.model.Filme;
import br.com.mastertech.masterflix.MasterFlix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public Filme cadastrarFilme(Filme filme){
        return repository.save(filme);
    }

    public Iterable<Filme> listarTodos(){
        Iterable<Filme> filmes = repository.findAll();
        return filmes;
    }

    public Filme findByNome(String nome){
        Optional<Filme> filme = repository.findByNome(nome);
        if(filme.isPresent()){
            return filme.get();
        }
        return null;
    }

    public void excluirFilme(long id) {
        repository.deleteById(id);
    }

    public void desativar(long id) {
        Optional<Filme> filme = repository.findById(id);
        if(filme.get() != null){
            filme.get().setAtivo(false);
            repository.save(filme.get());
        }

    }
}
