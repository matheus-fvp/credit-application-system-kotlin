package edu.mfvp.credit.application.system.excepions

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(e: MethodArgumentNotValidException): ResponseEntity<ExceptionDetails> {
        val erros: MutableMap<String, String?> = HashMap()
        e.bindingResult.allErrors.stream().forEach {
            erro: ObjectError ->
            val fieldName: String = (erro as FieldError).field
            val messageError: String? = erro.defaultMessage
            erros[fieldName] = messageError
        }
        return ResponseEntity(
            ExceptionDetails(title = "Bad Request - consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = e.javaClass.toString(),
                details = erros),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(e: DataAccessException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity(
            ExceptionDetails(title = "Bad Request - consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.CONFLICT.value(),
                exception = e.javaClass.toString(),
                details = mutableMapOf(e.cause.toString() to e.message)
            ),
            HttpStatus.CONFLICT
        )
    }

    @ExceptionHandler(BusinessException::class)
    fun handlerValidException(e: BusinessException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity(
            ExceptionDetails(title = "Bad Request - consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = e.javaClass.toString(),
                details = mutableMapOf(e.cause.toString() to e.message)
            ),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handlerValidException(e: IllegalArgumentException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity(
            ExceptionDetails(title = "Bad Request - consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = e.javaClass.toString(),
                details = mutableMapOf(e.cause.toString() to e.message)
            ),
            HttpStatus.BAD_REQUEST
        )
    }

}