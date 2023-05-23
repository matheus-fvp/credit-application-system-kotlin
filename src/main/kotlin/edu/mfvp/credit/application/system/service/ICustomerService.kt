package edu.mfvp.credit.application.system.service

import edu.mfvp.credit.application.system.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(customerId: Long): Customer
    fun delete(customerId: Long)
}