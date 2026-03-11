package com.LACY.school.service;

import com.LACY.school.dto.FullSchoolResponse;
import com.LACY.school.feign.StudentFeign;
import com.LACY.school.model.School;
import com.LACY.school.repository.SchoolRepository;
import jakarta.ws.rs.BadRequestException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchoolService {
  private final SchoolRepository schoolRepository;
  private final StudentFeign studentFeign;

  public SchoolService(SchoolRepository schoolRepository, StudentFeign studentFeign) {
    this.schoolRepository = schoolRepository;
    this.studentFeign = studentFeign;
  }

  @Transactional
  public void save(School student) {
    this.schoolRepository.save(student);
  }

  @Transactional(readOnly = true)
  public List<School> list() {
    return this.schoolRepository.findAll();
  }

  @Transactional(readOnly = true)
  public FullSchoolResponse listAllStudentBySchoolId(Long schoolId) {
    var school =
        this.schoolRepository
            .findById(schoolId)
            .orElseThrow(() -> new BadRequestException("School not found"));

    var students =
        studentFeign.findAllStudentBySchool(
            schoolId); // find all the students from the student service

    return FullSchoolResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();
  }
}
