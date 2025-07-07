package com.codeavecasnit.passportmapper.passportcitizen.Repositories;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
}
