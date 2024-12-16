package dev.alejandro.orderservice.repository;

import dev.alejandro.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    int deleteOrderById(int id);
    Optional<Order> findOrderById(int id);
    @Modifying
    @Query(value = "update Order o set o.id = :#{#order.id}, o.name = :#{#order.name}, o.quantity =:#{#order.quantity},o.price =:#{#order.price} where o.id = :id")
    int updateOrderById(@Param("id") int id, @Param("order") Order order);
}

