package edu.mfvp.credit.application.system.dto

import edu.mfvp.credit.application.system.entity.Credit
import edu.mfvp.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numerOfInstallments: Int,
    val customerId: Long
) {

    fun toEntity() = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numerOfInstallments,
        customer = Customer(id = this.customerId)
    )

}
