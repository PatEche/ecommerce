package category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "api/v1/categories")
public class CategoryController {

    private final CategoryService service;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>>getAllCategories(){
        return ResponseEntity.ok(service.getAllCategories());
    }

//    @GetMapping
//    public ResponseEntity<Integer> createCategory(CategoryRequest request){
//        return ResponseEntity.ok();
//
//    }

}
