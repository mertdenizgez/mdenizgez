package com.personal.mertdenizgez.controller;

import com.personal.mertdenizgez.model.Note;
import com.personal.mertdenizgez.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/note")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("all")
    public List<Note> getAllNotes() {
        return noteService.findAll();
    }

    @GetMapping("{index}")
    public Note getNoteByIndex(@PathVariable String index) {
        return noteService.get(Integer.parseInt(index));
    }

    @GetMapping()
    public Note getNoteByFilter(@RequestParam() Note note) {
        return noteService.findNote(note);
    }

    @PostMapping()
    public void add(@RequestBody Note note) {
        noteService.add(note);
    }

    @PutMapping("{index}")
    public void update(@PathVariable String index, @RequestBody Note note) {
        noteService.update(Integer.parseInt(index), note);
    }

    @DeleteMapping("{index}")
    public void delete(@PathVariable String index) {
        noteService.delete(Integer.parseInt(index));
    }

    @DeleteMapping("all")
    public void delete() {
        noteService.clear();
    }
}
