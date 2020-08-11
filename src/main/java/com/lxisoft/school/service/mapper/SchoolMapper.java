package com.lxisoft.school.service.mapper;

import com.lxisoft.school.domain.*;
import com.lxisoft.school.service.dto.SchoolDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link School} and its DTO {@link SchoolDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SchoolMapper extends EntityMapper<SchoolDTO, School> {


    @Mapping(target = "students", ignore = true)
    @Mapping(target = "removeStudent", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "removeTeacher", ignore = true)
    School toEntity(SchoolDTO schoolDTO);

    default School fromId(Long id) {
        if (id == null) {
            return null;
        }
        School school = new School();
        school.setId(id);
        return school;
    }
}
