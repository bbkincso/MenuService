package com.feastplanner.menuservice.dao;

import com.feastplanner.menuservice.dto.MenuCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<MenuCard, Long> {
//    List<MenuCard>findAll();
    List<MenuCard>findByUserEmail(String userEmail);
    Optional<MenuCard> findById(Long id);
}
