package com.ispectrum.crmclima.areas.error_handling.exception;

import com.ispectrum.crmclima.constants.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = Messages.SCHEDULE_ALREADY_CREATED)
public class ScheduleAlreadyCreatedException extends RuntimeException {
}
