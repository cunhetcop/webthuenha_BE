package com.example.casestudythuenha_be.repository;

import com.example.casestudythuenha_be.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderStatusRepository extends JpaRepository<OrderStatus, Long> {
}
