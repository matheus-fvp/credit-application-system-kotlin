package edu.mfvp.credit.application.system.excepions

data class BusinessException(override val message: String?) : RuntimeException(message)
