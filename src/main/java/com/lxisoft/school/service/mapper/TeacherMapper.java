package com.lxisoft.school.service.mapper;

import com.lxisoft.school.domain.*;
import com.lxisoft.school.service.dto.TeacherDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Teacher} and its DTO {@link TeacherDTO}.
 */
@Mapper(componentModel = "spring", uses = {SchoolMapper.class})
public interface TeacherMapper extends EntityMapper<TeacherDTO, Teacher> {

    @Mapping(source = "school.id", target = "schoolId")
    TeacherDTO toDto(Teacher teacher);

    @Mapping(source = "schoolId", target = "school")
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "removeStudent", ignore = true)
    Teacher toEntity(TeacherDTO teacherDTO);

    default Teacher fromId(Long id) {
        if (id == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setId(id);
        return teacher;
    }
}
