package com.inventory.inventory.dao;

import com.inventory.inventory.modal.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventory.inventory.repository.UnitRepository;

@Service
public class UnitDao {

    private static final Logger logger = LoggerFactory.getLogger(UnitDao.class);

    @Autowired
    private UnitRepository unitRepository;

    public Unit save(Unit unit) throws Exception {
        try {
            logger.info("Saving unit: {}", unit);
            Unit savedUnit = unitRepository.save(unit);
            logger.info("Unit saved successfully: {}", savedUnit);
            return savedUnit;
        } catch (Exception e) {
            logger.error("Error saving unit: {}", e.getMessage());
            throw new Exception("Error saving unit: " + e.getMessage());
        }
    }

}
