package com.xilo.grabit.respository;
import com.xilo.grabit.model.OrderCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCollectionRepository extends JpaRepository<OrderCollection, Long>{
}
