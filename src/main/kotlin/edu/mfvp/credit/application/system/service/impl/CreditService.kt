package edu.mfvp.credit.application.system.service.impl

import edu.mfvp.credit.application.system.entity.Credit
import edu.mfvp.credit.application.system.excepions.BusinessException
import edu.mfvp.credit.application.system.repository.CreditRepository
import edu.mfvp.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val custumerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = custumerService.findById(credit.customer?.id!!)
        }
        return creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("Creditcode $creditCode not found")
        return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact admin")
    }
}