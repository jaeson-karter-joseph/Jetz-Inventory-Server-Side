package com.inventory.inventory.controller;
import com.inventory.inventory.constants.InventoryConstants;
import com.inventory.inventory.dto.GenericResponse;
import com.inventory.inventory.dto.iec.IecDto;
import com.inventory.inventory.dto.unit.UnitDto;
import com.inventory.inventory.modal.Iec;
import com.inventory.inventory.modal.Unit;
import com.inventory.inventory.service.IecService;
import com.inventory.inventory.service.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private IecService iecService;
    private final Logger logger = LoggerFactory.getLogger(UnitController.class);

    @PostMapping("/iec/saveiec")
    public ResponseEntity<GenericResponse<Iec>> saveIec(@RequestBody IecDto iecDto) {
        long startTime = System.currentTimeMillis();
        try {
            logger.info("IEC REQUEST :: {}", iecDto);
            Iec iec = iecService.saveIec(iecDto);
            logger.info("IEC REQUEST :: {}", iec);
            if (iec != null) {
                GenericResponse<Iec> response = new GenericResponse<>(InventoryConstants.SUCCESS_MESSAGE,"IEC saved successfully",
                        InventoryConstants.SUCCESS_CODE,iec);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                logger.error("Error saving IEC: IEC is null");
                GenericResponse<Iec> response = new GenericResponse<>(InventoryConstants.ERROR_MESSAGE, "Failed to save IEC", InventoryConstants.ERROR_CODE,null);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error("Error saving IEC: " + e.getMessage());
            GenericResponse<Iec> response = new GenericResponse<>(InventoryConstants.ERROR_MESSAGE, "Failed to save IEC", InventoryConstants.ERROR_CODE,null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            long endTime = System.currentTimeMillis();
            logger.info("Time taken to save unit: " + (endTime - startTime) + "ms");
        }
    }

    @PostMapping("/unit/saveunit")
    public ResponseEntity<GenericResponse<Unit>> saveUnit(@Valid @RequestBody UnitDto unitDto) {
        long startTime = System.currentTimeMillis();
        try {
            Unit unit = unitService.saveUnit(unitDto);
            if (unit != null) {
                GenericResponse<Unit> response = new GenericResponse<>(InventoryConstants.SUCCESS_MESSAGE,"Unit saved successfully",
                        InventoryConstants.SUCCESS_CODE,unit);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                logger.error("Error saving unit: Unit is null");
                GenericResponse<Unit> response = new GenericResponse<>(InventoryConstants.ERROR_MESSAGE, "Failed to save unit", InventoryConstants.ERROR_CODE,null);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error("Error saving unit: " + e.getMessage());
            GenericResponse<Unit> response = new GenericResponse<>(InventoryConstants.ERROR_MESSAGE, "Failed to save unit", InventoryConstants.ERROR_CODE,null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            long endTime = System.currentTimeMillis();
            logger.info("Time taken to save unit: " + (endTime - startTime) + "ms");
        }
    }
    }

