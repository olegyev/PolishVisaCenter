package app.entities.enums;

public enum AdminPosition {
    OPERATOR ("Operator"),
    MANAGER ("Manager");

    private String title;

    AdminPosition(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static AdminPosition findByTitle(String title){
        for (AdminPosition constant : values()){
            if (title.equals(constant.getTitle())){
                return constant;
            }
        }

        return null;
    }
}