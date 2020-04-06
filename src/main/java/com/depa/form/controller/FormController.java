package com.depa.form.controller;

import com.depa.form.dto.FormDTO;
import com.depa.form.model.form.Form;
import com.depa.form.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/form")
    public FormDTO createForm(@RequestBody FormDTO formDTO) {
        Form form = formService.toForm(formDTO);
        System.out.println(form);
        Form responseForm = formService.createForm(form);
        return formService.toFormDTO(responseForm);
    }

    @GetMapping("/form/{uid}")
    public FormDTO getFormByUid(@PathVariable String uid) {
        Form responseForm = formService.getFormByUid(uid);
        return formService.toFormDTO(responseForm);
    }

    @GetMapping("/forms")
    public List<FormDTO> getForms() {
        List<Form> forms = formService.getForms();

        List<FormDTO> responseForms = new ArrayList<>();
        forms.forEach(form -> {
            responseForms.add(formService.toFormDTO(form));
        });

        return responseForms;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
    }
}
