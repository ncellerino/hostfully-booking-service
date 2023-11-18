package com.hostfully.booking.entities;

import com.hostfully.framework.entitybase.Identity;

public final class IdentityMapper {
    public static Long mapId(Identity id) {
        if(id != null && id.getNumber() != Long.MIN_VALUE) {
            return id.getNumber();
        }
        return null;
    }
}
