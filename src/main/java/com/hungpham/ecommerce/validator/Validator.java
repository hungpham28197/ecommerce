package com.hungpham.ecommerce.validator;

import com.hungpham.ecommerce.exception.ValidateException;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class Validator {

    static void requireNull(Object value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value != null) {
            throw exceptionSupplier.get();
        }
    }

    static void requireEmptyString(String value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value != null && !"".equals(value)) {
            throw exceptionSupplier.get();
        }
    }

    static void requireEmptyCollection(Collection value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value != null && !value.isEmpty()) {
            throw exceptionSupplier.get();
        }
    }

    static void requireNonNull(Object value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null) {
            throw exceptionSupplier.get();
        }
    }

    static void requireNonEmpty(String value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || "".equals(value)) {
            throw exceptionSupplier.get();
        }
    }

    static void requireNonEmpty(Collection<?> value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value.isEmpty()) {
            throw exceptionSupplier.get();
        }
    }

    static void requireNonNegative(Integer value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value < 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requireNonNegative(Long value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value < 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requireNonNegative(Float value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value < 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requireNonNegative(Double value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value < 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requireNonNegative(BigDecimal value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requirePositive(Integer value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value <= 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requirePositive(Long value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value <= 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requirePositive(Float value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value <= 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requirePositive(Double value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value <= 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requirePositive(BigDecimal value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw exceptionSupplier.get();
        }
    }

    static void requireZero(BigDecimal value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (value == null || value.compareTo(BigDecimal.ZERO) != 0) {
            throw exceptionSupplier.get();
        }
    }

    static void mustBeIn(String term, List<String> tartets, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if (!tartets.contains(term)) {
            throw exceptionSupplier.get();
        }
    }

    static void requireNonFraction(BigDecimal value, Supplier<ValidateException> exceptionSupplier) throws ValidateException {
        if(value == null || value.scale() > 0 ) {
            throw exceptionSupplier.get();
        }
    }
}
