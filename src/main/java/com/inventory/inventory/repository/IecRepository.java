package com.inventory.inventory.repository;

import com.inventory.inventory.modal.Iec;
import com.inventory.inventory.modal.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IecRepository extends JpaRepository<Iec,Long> {
}
