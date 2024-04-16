package com.studio.common;

public enum UserRole {
    ADMIN(1), CUSTOMER(2);

    private final int roleNumber;

    UserRole(final int roleNumber) {
        this.roleNumber = roleNumber;
    }

    public int getRoleNumber() {
        return roleNumber;
    }

    public static UserRole getUserRole(final int roleNumber) {
        if (roleNumber > 0) {
            for (UserRole role : UserRole.values()) {
                if (role.roleNumber == roleNumber) {
                    return role;
                }
            }
        }
        return UserRole.CUSTOMER;
    }

    public static boolean isAdminUser(final UserRole userRole) {
        return UserRole.ADMIN == userRole;
    }
}
