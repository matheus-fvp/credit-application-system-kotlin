package edu.mfvp.credit.application.system.dto

import edu.mfvp.credit.application.system.entity.Credit
import edu.mfvp.credit.application.system.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid Input") val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid Input") val customerId: Long
) {

    fun toEntity() = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )

}
