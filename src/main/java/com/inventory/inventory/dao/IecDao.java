package com.inventory.inventory.dao;

import com.inventory.inventory.modal.Iec;
import com.inventory.inventory.modal.Unit;
import com.inventory.inventory.repository.IecRepository;
import com.inventory.inventory.repository.UnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IecDao {
    private static final Logger logger = LoggerFactory.getLogger(IecDao.class);

    @Autowired
    private IecRepository iecRepository;

    @Transactional
    public Iec save(Iec iec) throws Exception {
        try {
//            logger.info("Saving unit: {}", iec);
            Iec savedIec = iecRepository.save(iec);
//            logger.info("Unit saved successfully: {}", savedIec);
            return savedIec;
        } catch (Exception e) {
            logger.error("Error saving IEC: {}", e.getMessage());
            throw new Exception("Error saving IEC: " + e.getMessage());
        }
    }
}
