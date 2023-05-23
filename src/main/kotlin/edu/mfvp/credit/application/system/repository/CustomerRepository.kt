package edu.mfvp.credit.application.system.repository

import edu.mfvp.credit.application.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}