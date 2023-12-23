package com.mx.weather.config.handler;

import com.mx.weather.exception.BadRequestException;
import com.mx.weather.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	private final MessageSource messageSource;

	private static final String ARGS_NOT_VALID = "ArgumentNotValid";
	private static final String BIND_EXCEPTION = "BindException";
	private static final String TYPE_MISMATCH = "TypeMismatch";

	private static final String MISSING_SERVLET_REQ_PART = "MissingServletRequestPart";
	private static final String MISSING_SERVLET_REQ_PARAM = "MissingServletRequestParameter";

	private static final String NO_HANDLER_FOUND_EXCEPTION = "NoHandlerFoundException";
	private static final String REQ_METHOD_NOT_SUPPORTED = "RequestMethodNotSupported";
	private static final String MEDIA_TYPE_NOT_SUPPORTED = "MediaTypeNotSupported";
	private static final String ENTITY_NOT_FOUND = "EntityNotFound";

	@ExceptionHandler({ItemNotFoundException.class})
	public ResponseEntity<Error> itemNotFoundException(final Exception ex, final HttpServletRequest request) {
		logger.error("itemNotFoundException Occured:: URL " + request.getRequestURI() + getParameters(request));
		logger.error("Error detail:: ", ex.getMessage());
		Error responseError = createResponseError(
			HttpStatus.NOT_FOUND.toString(),
			Arrays.asList(ex.getMessage())
		);
		return new ResponseEntity<>(responseError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({BadRequestException.class})
	public ResponseEntity<Error> badRequestException(final Exception ex, final HttpServletRequest request) {
		logger.error("BadRequestException Occured:: URL " + request.getRequestURI() + getParameters(request));
		logger.error("Error detail:: ", ex.getCause());

		String message = (ex != null && ex.getCause() != null && ex.getCause().getMessage() != null) ? ex.getCause()
			.getMessage() : (ex != null) ? ex.getMessage() : "Mensaje predeterminado";

		Error responseError = createResponseError(
			HttpStatus.OK.toString(),
			Arrays.asList(message)
		);
		return new ResponseEntity<>(responseError, HttpStatus.OK);
	}


	private Error createResponseError(String httpStatusStr, List<String> errors) {

		logger.error("--- createResponseError ---  ");

		List<Error> errorList = errors.stream()
			.map(error -> Objects.nonNull(getError(error)) ? getError(error) : getError(httpStatusStr, error))
			.collect(Collectors.toList());

		return errorList.get(0);
	}

	private Error getError(String httpStatusStr, String error) {

		return Error.builder()
			.code(httpStatusStr)
			.description(httpStatusStr)
			.response(Boolean.FALSE.toString())
			.build();

	}

	private Error getError(String errorStr) {
		try {

			String title = messageSource.getMessage(errorStr, null, Locale.ENGLISH);
			String code = messageSource.getMessage(errorStr.concat(".code"), null, Locale.ENGLISH);
			String detail = messageSource.getMessage(errorStr.concat(".detail"), null, Locale.ENGLISH);
			return Error.builder()
				.code(code)
				.description(detail)
				.response(Boolean.FALSE.toString()).build();

		} catch(NoSuchMessageException nsme) {
			logger.error(nsme.getMessage());
			return Error.builder()
				.code(nsme.getLocalizedMessage())
				.description(nsme.getMessage())
				.response(Boolean.FALSE.toString()).build();
		}
	}

	private void imprimeError(Throwable ex) {
		logger.error("Clase ejecutada  " + ex.getClass().getName());
		logger.error("Exception handler executed  " + ex);
	}

	private String getParameters(HttpServletRequest request) {

		StringBuilder posted = new StringBuilder();
		Enumeration<?> e = request.getParameterNames();
		if(nonNull(e)) {
			posted.append("?");
		}
		String ipAddr = getRemoteAddr(request); // : ip;
		if(nonNull(ipAddr) && !ipAddr.equals("")) {
			posted.append("&_ip=" + ipAddr);
		}
		String auth = request.getHeader("Authorization");

		if((isNull(auth)) || !auth.startsWith("Basic ")) {
			final String userAgent = request.getHeader("User-Agent");
			posted.append("&User-Agent=" + userAgent);
		}
		else {
			posted.append("&Authorization =" + auth);
		}

		if(nonNull(e))
			while(e.hasMoreElements()) {
				Object objectParam = e.nextElement();
				String param = (String)objectParam;
				String value = request.getParameter(param);
				posted.append("&" + param + "=" + value);
			}
		return posted.toString();
	}

	// get the source IP address of the HTTP request
	private String getRemoteAddr(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
