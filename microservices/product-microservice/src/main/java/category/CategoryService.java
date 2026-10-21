package category;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryMapper mapper;
    private final CategoryRepository repository;

     public List<CategoryResponse> getAllCategories() {
        return repository.findAll().stream()
                .map(mapper::toCategoryResponse)
                .toList();
    }


}
