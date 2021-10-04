package com.anushka.notesmanipulationservice.repositories;



import com.anushka.notesmanipulationservice.models.Notes;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

@Configuration
public interface NotesRepo extends MongoRepository<Notes,String> {



}
