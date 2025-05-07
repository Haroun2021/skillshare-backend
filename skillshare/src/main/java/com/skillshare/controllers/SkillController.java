package com.skillshare.controllers;

import com.skillshare.entities.Skill;
import com.skillshare.services.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @GetMapping
    public List<Skill> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Skill getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Skill create(@RequestBody Skill skill) {
        return service.save(skill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
