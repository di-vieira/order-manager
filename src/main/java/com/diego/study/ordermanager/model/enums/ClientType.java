package com.diego.study.ordermanager.model.enums;

public enum ClientType {

    B2B(1, "B2B"),
    B2C(2, "B2C");

    private Integer clientTypeCode;
    private String clientTypeDescription;

    ClientType(Integer clientTypeCode, String clientTypeDescription) {
        this.clientTypeCode = clientTypeCode;
        this.clientTypeDescription = clientTypeDescription;
    }

    public Integer getClientTypeCode() {
        return clientTypeCode;
    }

    public String getClientTypeDescription() {
        return clientTypeDescription;
    }

    public static ClientType toEnum(Integer clientTypeCode) {
        if (clientTypeCode == null){
            return null;
        }

        for (ClientType clientType : ClientType.values()){
            if (clientTypeCode.equals(clientType.getClientTypeCode())) {
                return clientType;
            }
        }
        throw new IllegalArgumentException("Invalid client type code");
    }
}
