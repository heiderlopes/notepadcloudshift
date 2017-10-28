package br.com.heiderlopes.notepadcloud.component;

import br.com.heiderlopes.notepadcloud.model.Nota;
import br.com.heiderlopes.notepadcloud.repository.NotaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotaComponent {

    @Autowired
    NotaRepository notaRepository;

    public Nota salvar(Nota nota) {
        List<Nota> notas = notaRepository.findByTitulo(nota.getTitulo());
        if (notas.size() > 0) {
            nota.setId(notas.get(0).getId());
        }
        return notaRepository.save(nota);
    }

    public List<Nota> findAll() {
        return notaRepository.findAll();
    }

    public void deleteAll() {
        notaRepository.deleteAll();
    }

    public Nota buscarNota(String titulo) {
        Nota nota;
        List<Nota> notas = notaRepository.findByTitulo(titulo);
        if (notas.isEmpty()) {
            return new Nota();
        } else {
            return notas.get(0);
        }
    }
}