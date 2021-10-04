package com.anushka.notesmanipulationservice.controllers;
import com.anushka.notesmanipulationservice.models.Notes;
import com.anushka.notesmanipulationservice.repositories.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class NotesController {


    @Autowired
    NotesRepo repo;

    @PostMapping(path = "/notes")
    public Notes addNote(@RequestBody Notes note)
    {
        repo.save(note);
        return note;
    }



    @DeleteMapping("/notes/{id}")
    public String delNote(@PathVariable String id)
    {
        repo.deleteById(id);
        return "done!";
    }



    @PutMapping(path="/notes/{id}")
    public Notes addOrUpdatenote(@PathVariable String id, @RequestBody Notes note)
    {
        Notes n = repo.findById(id).orElse(new Notes());
        n.setTitle(note.getTitle());
        n.setContent(note.getContent());

        repo.save(n);
        return n;
    }


}
