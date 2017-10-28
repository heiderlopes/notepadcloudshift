package br.com.heiderlopes.notepadcloud.controller;

import br.com.heiderlopes.notepadcloud.component.NotaComponent;
import br.com.heiderlopes.notepadcloud.model.Nota;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

    private NotaComponent notaComponent;

    public NotaController(NotaComponent notaComponent) {
        this.notaComponent = notaComponent;
    }

    @GetMapping
    private List<Nota> findAll() {
        return notaComponent.findAll();
    }

    @PostMapping
    private void save(@RequestBody Nota nota) {
        notaComponent.salvar(nota);
    }

    @DeleteMapping
    private void deleteAll() {
        notaComponent.deleteAll();
    }
}