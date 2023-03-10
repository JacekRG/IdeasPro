package pl.jacekplacek.ideasPro.category.service;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jacekplacek.ideasPro.category.domain.model.Category;
import pl.jacekplacek.ideasPro.category.domain.repository.CategoryRepository;
import pl.jacekplacek.ideasPro.category.dto.CategoryWithStatisticsDto;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public Page<Category> getCategories(Pageable pageable) {
        return getCategories(null, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Category> getCategories(String search, Pageable pageable) {
        if (search == null) {
            return categoryRepository.findAll(pageable);
        } else {
            return categoryRepository.findByNameContainingIgnoreCase(search, pageable);
        }
    }

    @Transactional(readOnly = true)
    public Category getCategory(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow();
    }

    @Transactional
    public Category createCategory(@NotNull Category categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(UUID id, @NotNull Category categoryRequest) {
        Category category = categoryRepository.findById(id)
                .orElseThrow();
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<CategoryWithStatisticsDto> findAllWithStatistics() {
        return categoryRepository.findAllWithStatistics();
    }
}