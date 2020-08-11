package com.lxisoft.school.service.mapper;

import com.lxisoft.school.domain.*;
import com.lxisoft.school.service.dto.StudentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Student} and its DTO {@link StudentDTO}.
 */
@Mapper(componentModel = "spring", uses = {TeacherMapper.class, SchoolMapper.class})
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {

    @Mapping(source = "school.id", target = "schoolId")
    StudentDTO toDto(Student student);

    @Mapping(target = "removeTeacher", ignore = true)
    @Mapping(source = "schoolId", target = "school")
    Student toEntity(StudentDTO studentDTO);

    default Student fromId(Long id) {
        if (id == null) {
            return null;
        }
        Student student = new Student();
        student.setId(id);
        return student;
    }
}
