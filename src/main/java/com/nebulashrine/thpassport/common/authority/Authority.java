package com.nebulashrine.thpassport.common.authority;

public enum Authority {

    USER("USER", "默认用户"),
    OAM("OAM", "运维"),
    ADMIN("ADMIN", "管理员");


    private final String authority;

    private final String description;

    private Authority(String authority, String description){
        this.authority = authority;
        this.description = description;
    }

    public String getAuthority() {
        return authority;
    }

    public String getDescription() {
        return description;
    }
}
