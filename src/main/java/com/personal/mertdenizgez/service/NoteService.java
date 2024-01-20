package com.personal.mertdenizgez.service;

import com.personal.mertdenizgez.model.Note;
import com.personal.mertdenizgez.repository.NoteRepository;
import com.personal.mertdenizgez.validation.NoteValidation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll() {
        return noteRepository.getAllNotes();
    }

    public void add(Note note) {
        NoteValidation.checkNoteExists(note);

        noteRepository.add(note);
    }

    public void delete(int index) {
        NoteValidation.checkIndex(index, this.isEmpty(), this.size());

        noteRepository.delete(index);
    }

    public void update(int index, Note note) {
        NoteValidation.checkIndex(index, this.isEmpty(), this.size());
        NoteValidation.checkNoteExists(note);

        noteRepository.update(index, note);
    }

    public Note get(int index) {
        NoteValidation.checkIndex(index, this.isEmpty(), this.size());

        return noteRepository.get(index);
    }

    public int size() {
        return noteRepository.size();
    }

    public boolean isEmpty() {
        return noteRepository.isEmpty();
    }

    public Note findNote(Note note) {
        NoteValidation.checkNoteExists(note);

        return noteRepository.findNote(note);
    }

    public void clear() {
        noteRepository.clear();
    }


}
