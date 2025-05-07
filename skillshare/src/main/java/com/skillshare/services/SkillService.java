package com.skillshare.services;

import com.skillshare.entities.Skill;
import com.skillshare.repositories.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository repo;

    public SkillService(SkillRepository repo) {
        this.repo = repo;
    }

    public List<Skill> getAll() {
        return repo.findAll();
    }

    public Skill save(Skill skill) {
        return repo.save(skill);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Skill getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
