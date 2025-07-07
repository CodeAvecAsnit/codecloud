package com.codeavecasnit.passportmapper.passportcitizen.Repositories;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
