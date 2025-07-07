package com.codeavecasnit.passportmapper.passportcitizen.Repositories;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Long> {
}
