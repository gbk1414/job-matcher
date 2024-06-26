package com.example.jobmatcher.Model.Enum;


public enum UserRoleEnum {
    ADMIN(Authority.ADMIN),  // 사용자 권한
    USER(Authority.USER);  // 관리자 권한

    private final String authority;

    UserRoleEnum(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String USER = "ROLE_USER";
    }
}