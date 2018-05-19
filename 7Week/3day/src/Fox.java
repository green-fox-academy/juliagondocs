class Fox {
    String name;
    String color;
    String type;
    int age;

    public Fox(String name, String color, String type) {
        this.name = name;
        this.color=color;
        this.type = type;
    }
    public Fox() {
        this.name="Ravazdi";
        this.color="green";
        this.type="pallida";
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}