package entity;

public enum Role {
    CocoGoat("CocoGoat"),//mistake--
    Katheryne("Katheryne");//score++

    private String name;

    Role(String string) {
        name = string;
    }

    public String getName() {
        return name;
    }
}

