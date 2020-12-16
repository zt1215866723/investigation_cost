package com.xwkj.cost.common;

public enum ResponseResultEnum {
    SUCCESS(1), FAILURE(2);
    private int code;

    private ResponseResultEnum(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
