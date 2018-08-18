package stream;

public class Dish {
  private boolean vegetarian;
  private String name;
  private final int calories;
  private final Type type;

  public Dish(boolean vegetarian, String name, int calories, Type type) {
    this.vegetarian = vegetarian;
    this.name = name;
    this.calories = calories;
    this.type = type;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public void setVegetarian(boolean vegetarian) {
    this.vegetarian = vegetarian;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCalories() {
    return calories;
  }

  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Dish{"
        + "vegetarian="
        + vegetarian
        + ", name='"
        + name
        + '\''
        + ", calories="
        + calories
        + ", type="
        + type
        + '}';
  }

  public enum Type {
    MEAT,
    FISH,
    OTHER
  };
}
