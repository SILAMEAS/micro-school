package com.LACY.school.controller;

import com.LACY.school.dto.FullSchoolResponse;
import com.LACY.school.model.School;
import com.LACY.school.service.SchoolService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {
  private final SchoolService schoolService;

  public SchoolController(SchoolService schoolService) {
    this.schoolService = schoolService;
  }

  @GetMapping
  ResponseEntity<List<School>> getAllStudents() {
    return new ResponseEntity<>(this.schoolService.list(), HttpStatus.OK);
  }

  @PostMapping
  ResponseEntity<?> createStudent(@RequestBody School school) {
    this.schoolService.save(school);
    return new ResponseEntity<>("save school success", HttpStatus.OK);
  }

  @GetMapping("/{schoolId}/students")
  ResponseEntity<FullSchoolResponse> getAllStudentsInSchool(@PathVariable Long schoolId) {
    return new ResponseEntity<>(
        this.schoolService.listAllStudentBySchoolId(schoolId), HttpStatus.OK);
  }
}
