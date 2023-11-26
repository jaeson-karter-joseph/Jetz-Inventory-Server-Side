package com.inventory.inventory.service;

import com.inventory.inventory.dao.IecDao;
import com.inventory.inventory.dao.UnitDao;
import com.inventory.inventory.dto.iec.IecDto;
import com.inventory.inventory.dto.unit.UnitDto;
import com.inventory.inventory.modal.Iec;
import com.inventory.inventory.modal.Unit;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IecService {

    private static final Logger logger = LoggerFactory.getLogger(IecService.class);

    @Autowired
    private IecDao iecDao;

    @Autowired
    private ModelMapper modelMapper;

    public Iec saveIec(IecDto iecDto) {
        try {
            Iec iec = modelMapper.map(iecDto, Iec.class);
            iec.getIecmasters().forEach(iecMaster -> iecMaster.setIec(iec));
            logger.info("IEC AFTER MAP : {}", iec);
            Iec savedIec = iecDao.save(iec);
            logger.info("IEC saved successfully: {}", savedIec);
            return savedIec;
        } catch (Exception e) {
            logger.error("Error saving IEC: {}", e.getMessage());
            return null;
        }
    }
}
