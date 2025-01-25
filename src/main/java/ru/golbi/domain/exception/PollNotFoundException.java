package ru.golbi.domain.exception;

/**
 * Выбрасывается, если не был найден опрос
 * */
public class PollNotFoundException extends BaseException{

    public PollNotFoundException(Object... args) {
        super(ErrorMessageKeys.POLL_NOT_FOUND_ERROR_KEY, args);
    }

}
