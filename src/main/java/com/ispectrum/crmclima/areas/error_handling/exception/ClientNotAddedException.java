package com.ispectrum.crmclima.areas.error_handling.exception;

import com.ispectrum.crmclima.constants.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = Messages.CLIENT_NOT_ADDED)
public class ClientNotAddedException extends RuntimeException{
}
