package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojo.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    // Additional methods based on common use cases:

    Optional<Customer> findByPhoneNumber(String phoneNumber);

    List<Customer> findByNameContainingIgnoreCase(String name);

    void deleteByEmail(String email);

    // Enhanced query methods with performance and clarity focus:

    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findCustomerByEmailWithClearNaming(String email);

    @Query("SELECT c FROM Customer c WHERE c.phoneNumber = ?1")
    Optional<Customer> findCustomerByPhoneNumberWithClearNaming(String phoneNumber);

    @Query("SELECT c FROM Customer c WHERE upper(c.name) LIKE upper(?1)")
    List<Customer> findCustomersByNameIgnoreCaseWithEfficientQuery(String name);

    // Additional methods as needed:

    // Custom findByCriteria(SearchCriteria criteria);
    // ...

}
