package com.crud.mmac_library.domainAndDto.copy;

import java.io.Serializable;

public enum CopyStatus implements Serializable {
    RENTED,
    AVAILABLE,
    DESTROYED;

    public String getStatus() {return this.name(); }
}