package com.fc.rd.module1.crud.util;


import java.util.HashMap;
import java.util.Map;

public enum GenericErrorCode {

    ERR_01(500, "FAILED"),
	SUCCESS(200,"SUCCESS"),
	CREATED(201,"CREATED");

    private static final Map<Integer, GenericErrorCode> LOOKUP = new HashMap<Integer, GenericErrorCode>();

    static {
        for (final GenericErrorCode enumeration : GenericErrorCode.values()) {
            LOOKUP.put(enumeration.getCode(), enumeration);
        }
    }

    private int code;

    private final String defaultMessage;

    private GenericErrorCode(final int code, final String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

	
	public int getCode() {
		// TODO Auto-generated method stub
		return code;
	}

	
	public String getDefaultMessage() {
		// TODO Auto-generated method stub
		return defaultMessage;
	}

    

    
}
