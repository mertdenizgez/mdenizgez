package com.personal.mertdenizgez.validation;

import com.personal.mertdenizgez.model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoteValidation {

    public static void checkIndex(int index, boolean isEmpty, int size) {
        if (isEmpty)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note list is empty");

        if (index >= size)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Index is out of bounds");

        if (index < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Index cannot be negative");
    }

    public static void checkNoteExists(Note note) {
        if (note == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Note not found");
    }
}
