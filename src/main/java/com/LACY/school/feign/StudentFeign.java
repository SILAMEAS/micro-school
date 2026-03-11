package com.LACY.school.feign;


import com.LACY.school.dto.SchoolStudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service",url = "${application.config.students-url}")
public interface StudentFeign {
    @GetMapping("/school/{schoolId}")
    List<SchoolStudentResponse> findAllStudentBySchool(@PathVariable Long schoolId);

}
