package com.ispectrum.crmclima.areas.error_handling.exception;


import com.ispectrum.crmclima.constants.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = Messages.SCHEDULE_NOT_FOUND)
public class ScheduleNotFound extends RuntimeException {
}
