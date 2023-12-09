public enum Location {
    LycheePark("LP"), TeachingBuilding("TB");

    private String name;

    Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
