package edu.mfvp.credit.application.system.service.impl

import edu.mfvp.credit.application.system.entity.Customer
import edu.mfvp.credit.application.system.excepions.BusinessException
import edu.mfvp.credit.application.system.repository.CustomerRepository
import edu.mfvp.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer = customerRepository.save(customer)

    override fun findById(customerId: Long): Customer = customerRepository.findById(customerId).orElseThrow {
            throw BusinessException("Id $customerId not found")
    }

    override fun delete(customerId: Long) {
        val customer = this.findById(customerId)
        customerRepository.delete(customer)
    }

}