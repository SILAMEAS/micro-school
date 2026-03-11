package com.LACY.school.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FullSchoolResponse {
  private String name;
  private String email;
  List<SchoolStudentResponse> students;
}
