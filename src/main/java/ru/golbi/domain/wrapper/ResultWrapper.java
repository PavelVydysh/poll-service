package ru.golbi.domain.wrapper;

import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.function.Supplier;

@Getter
public class ResultWrapper<T> {

    private final T value;

    private final ResultStatus status;

    public ResultWrapper() {
        this(ResultStatus.OK);
    }

    public ResultWrapper(T value) {
        this.value = value;
        status = ResultStatus.OK;
    }

    public ResultWrapper(ResultStatus status) {
        this.value = null;
        this.status = status;
    }

    public static <T> ResultWrapper<T> ofNullable(T value, ResultStatus status) {
        if (ObjectUtils.isEmpty(value)) {
            return new ResultWrapper<>(status);
        }
        return new ResultWrapper<>(value);
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (isSuccess()) {
            return value;
        }
        throw exceptionSupplier.get();
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public boolean isSuccess() {
        return ResultStatus.OK.equals(status);
    }

    public boolean isNotSuccess() {
        return !isSuccess();
    }

}
