package category;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;


}
