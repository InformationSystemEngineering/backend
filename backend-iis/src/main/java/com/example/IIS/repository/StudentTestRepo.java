package com.example.IIS.repository;
import com.example.IIS.domain.Student;
import com.example.IIS.domain.StudentTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentTestRepo extends JpaRepository<StudentTest, Long> {

    List<StudentTest> findStudentTestsByInternshipTest_Id(long id);

    @Query("SELECT st.student FROM StudentTest st WHERE st.internshipTest.id = :internshipTestId")
    List<Student> findStudentsByInternshipTestId(@Param("internshipTestId") Long internshipTestId);

}
