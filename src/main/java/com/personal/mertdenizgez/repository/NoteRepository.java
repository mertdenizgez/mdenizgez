package com.personal.mertdenizgez.repository;

import com.personal.mertdenizgez.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoteRepository {
    private List<Note> notes;

    public NoteRepository() {
        notes = new ArrayList<>();
    }


    public List<Note> getAllNotes() {
        return notes;
    }

    public void add(Note note) {
        notes.add(note);
    }

    public void delete(Note note) {
        notes.remove(note);
    }

    public void delete(int index) {
        notes.remove(index);
    }

    public void update(int index, Note note) {
        notes.set(index, note);
    }

    public Note get(int index) {
        return notes.get(index);
    }

    public int size() {
        return notes.size();
    }

    public boolean isEmpty() {
        return notes.isEmpty();
    }

    public Note findNote(Note note) {
        return notes.stream().filter(n -> n.getTitle().equals(note.getTitle()) && n.getContent().equals(note.getContent())).findFirst().orElse(null);
    }

    public void clear() {
        notes.clear();
    }

}
