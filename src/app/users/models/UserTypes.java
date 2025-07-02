package app.users.models;

public enum UserTypes {
    CLIENT ("CLIENT"),
    ADMIN ("ADMIN"),
    EMPLOYEE ("EMPLOYEE");

    private final String type;

    UserTypes(String type){
        this.type=type;
    }

}
