package com.codeavecasnit.passportmapper.passportcitizen.Repositories;

import com.codeavecasnit.passportmapper.passportcitizen.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
