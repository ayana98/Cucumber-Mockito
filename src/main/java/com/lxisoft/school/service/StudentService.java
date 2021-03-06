package com.lxisoft.school.service;

import com.lxisoft.school.service.dto.StudentDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.lxisoft.school.domain.Student}.
 */
public interface StudentService {

    /**
     * Save a student.
     *
     * @param studentDTO the entity to save.
     * @return the persisted entity.
     */
    StudentDTO save(StudentDTO studentDTO);

    /**
     * Get all the students.
     *
     * @return the list of entities.
     */
    List<StudentDTO> findAll();

    /**
     * Get all the students with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<StudentDTO> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" student.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StudentDTO> findOne(Long id);

    /**
     * Delete the "id" student.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
