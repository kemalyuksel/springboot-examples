package com.kemalyuksel.repository;

import com.kemalyuksel.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
