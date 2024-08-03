package com.example.demo.model.dto;

import com.example.demo.model.Note;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteDto {
    private Long id;
    private String title;
    private String content;


    public static Note fromDtoParameter(String title, String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        return note;
    }

    public static Note fromDtoParameterUpdate(Long id, String title, String content) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        return note;
    }

}
