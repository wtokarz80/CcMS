package com.m3w.interfaces;

import com.m3w.models.StudentEvaluation;

import java.util.List;

public interface GradesViewable {

    List<StudentEvaluation> viewStudentGrades(int studentDetailId);
}
