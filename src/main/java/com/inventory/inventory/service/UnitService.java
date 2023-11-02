package com.inventory.inventory.service;

import com.inventory.inventory.dao.UnitDao;
import com.inventory.inventory.dto.UnitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {

    @Autowired
    private UnitDao unitDao;

    public void saveUnit(UnitDto unitDto){
        try {

        }catch (Exception e){

        }
    }
}
