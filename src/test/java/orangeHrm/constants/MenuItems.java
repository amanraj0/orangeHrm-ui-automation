package orangeHrm.constants;

public enum MenuItems {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MYINFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");

    private final String label;

    MenuItems(String label){
        this.label = label;
    }

    public String getMenuItem(){
        return label;
    }

}
