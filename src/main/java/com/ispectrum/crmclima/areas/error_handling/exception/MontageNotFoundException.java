package com.ispectrum.crmclima.areas.error_handling.exception;

import com.ispectrum.crmclima.constants.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.MessageDigest;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = Messages.MONTAGE_NOT_FOUND)
public class MontageNotFoundException extends RuntimeException{
}
