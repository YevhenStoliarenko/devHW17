package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.model.dto.NoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;
    private static final String MENU = "menu";
    private static final String FOUND_NOTE = "foundnote";
    private static final String LIST = "list";

    @GetMapping(value = "/menu")
    public ModelAndView getMenu() {
         return new ModelAndView(MENU);
    }

    @PostMapping(value = "/create")
    public ModelAndView crearteNote(@RequestParam(required = false) String title, String content) {
        ModelAndView result = new ModelAndView(MENU);
        Note note = NoteDto.fromDtoParameter(title, content);
        result.addObject("note", noteService.saveParam(note));
        return result;
    }

    @GetMapping(value = "/list")
    public ModelAndView getNote() {
        ModelAndView result = new ModelAndView(LIST);
        result.addObject("note", noteService.findAll());
        return result;
    }

    @GetMapping(value = "/find")
    public ModelAndView findById(@RequestParam(value = "id", defaultValue = "0", required = false) Long id) {
        ModelAndView result = new ModelAndView(FOUND_NOTE);
        result.addObject("note", noteService.findById(id));
        return result;
    }

    @PostMapping(value = "/update")
    public ModelAndView updateNote(@RequestParam(required = false) Long id, String title, String content) {
        ModelAndView result = new ModelAndView(MENU);
        Note note = NoteDto.fromDtoParameterUpdate(id, title, content);
        result.addObject("note", noteService.saveParam(note));
        return new ModelAndView("redirect:menu");
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteById(@RequestParam(value = "id", defaultValue = "0", required = false) Long id) {
        noteService.deleteById(id);
        return new ModelAndView("redirect:menu");
    }

}
