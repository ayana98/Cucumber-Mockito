package com.lxisoft.school.service;

import com.lxisoft.school.service.dto.SchoolDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.lxisoft.school.domain.School}.
 */
public interface SchoolService {

    /**
     * Save a school.
     *
     * @param schoolDTO the entity to save.
     * @return the persisted entity.
     */
    SchoolDTO save(SchoolDTO schoolDTO);

    /**
     * Get all the schools.
     *
     * @return the list of entities.
     */
    List<SchoolDTO> findAll();


    /**
     * Get the "id" school.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SchoolDTO> findOne(Long id);

    /**
     * Delete the "id" school.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
