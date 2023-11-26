package com.inventory.inventory.repository;

import com.inventory.inventory.modal.Iecmaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IecMasterRepository extends JpaRepository<Iecmaster, Long>{
}
