package com.xilo.grabit.respository;
import com.xilo.grabit.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    List<Category> findCategoryByTitle(String title);
}
