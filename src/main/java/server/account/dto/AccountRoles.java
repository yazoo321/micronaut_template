package server.account.dto;

public enum AccountRoles {
    ROLE_USER("ROLE_USER");

    public final String role;

    AccountRoles(String role) {
        this.role = role;
    }
}
