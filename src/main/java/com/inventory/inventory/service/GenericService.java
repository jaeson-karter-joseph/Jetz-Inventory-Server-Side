package com.inventory.inventory.service;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericService {
    private static final Logger logger = LoggerFactory.getLogger(GenericService.class);
    @Autowired
    private ModelMapper modelMapper;

    public <T, D> D convertToDto(T entity, Class<D> dtoClass) {
        D dto = modelMapper.map(entity, dtoClass);
        logger.info("{} converted to DTO successfully: {}", entity.getClass().getSimpleName(), dto);
        return dto;
    }

    public <T> T convertToEntity(Object dto, Class<T> entityClass) {
        T entity = modelMapper.map(dto, entityClass);
        logger.info("Object converted to entity successfully: {}", entity);
        return entity;
    }
}
