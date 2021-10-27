package sample.exercise1.domain;

public class Meal {
    Long id;
    String name;
    Double price;
    MealType type = MealType.NORMAL;
    MealStyle style = MealStyle.NORMAL;

    public Meal() {
    }

    public Meal(Long id, String name, Double price, MealType type, MealStyle style) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.style = style;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MealType getType() {
        return type;
    }

    public void setType(MealType type) {
        this.type = type;
    }

    public MealStyle getStyle() {
        return style;
    }

    public void setStyle(MealStyle style) {
        this.style = style;
    }
}
