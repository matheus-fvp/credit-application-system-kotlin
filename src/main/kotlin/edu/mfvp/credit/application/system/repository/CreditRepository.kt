package edu.mfvp.credit.application.system.repository

import edu.mfvp.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository : JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit?

    @Query(value = "SELECT * FROM tb_credit WHERE customer_id = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>
}