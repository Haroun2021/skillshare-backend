package com.skillshare.services;

import com.skillshare.entities.Category;
import com.skillshare.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Category save(Category category) {
        return repo.save(category);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Category getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
