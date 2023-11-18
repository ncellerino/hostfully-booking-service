package com.hostfully.framework.entitybase;

import lombok.Value;

@Value
public class Identity {
    private final Long number;

    public static Identity nothing() {
        return new Identity(Long.MIN_VALUE);
    }

    public Long toNumber() {
        if(number != null) {
            return number;
        }
        return null;
    }
}
