package com.inventory.inventory.service;

import com.inventory.inventory.dao.UnitDao;
import com.inventory.inventory.dto.unit.UnitDto;
import com.inventory.inventory.modal.Unit;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

    private static final Logger logger = LoggerFactory.getLogger(UnitService.class);

    @Autowired
    private UnitDao unitDao;

    @Autowired
    private ModelMapper modelMapper;

    public Unit saveUnit(UnitDto unitDto) {
        try {
            Unit unit = modelMapper.map(unitDto, Unit.class);
            Unit savedUnit = unitDao.save(unit);
            logger.info("Unit saved successfully: {}", savedUnit);
            return savedUnit;
        } catch (Exception e) {
            logger.error("Error saving unit: {}", e.getMessage());
            return null;
        }
    }

    public UnitDto convertToDto(Unit unit) {
        UnitDto unitDto = modelMapper.map(unit, UnitDto.class);
        logger.info("Unit converted to DTO successfully: {}", unitDto);
        return unitDto;
    }

    public Unit convertToEntity(UnitDto unitDto) {
        Unit unit = modelMapper.map(unitDto, Unit.class);
        logger.info("Unit converted to entity successfully: {}", unit);
        return unit;
    }
}
