package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.model.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepo noteRepo;


    public Object saveParam(Note note) {
        return noteRepo.save(note);
    }


    public List<Note> findAll() {
        return noteRepo.findAll();
    }

    public Optional<Note> findById(Long id) {
        return noteRepo.findById(id);
    }

    public void deleteById(Long id) {
        noteRepo.deleteById(id);
    }

}
