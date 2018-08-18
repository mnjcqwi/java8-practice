package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOperator {
  private List<Dish> menu =
      Arrays.asList(
          new Dish(false, "pork", 800, Dish.Type.MEAT),
          new Dish(false, "beef", 700, Dish.Type.MEAT),
          new Dish(false, "chicken", 400, Dish.Type.MEAT),
          new Dish(true, "french fires", 530, Dish.Type.MEAT),
          new Dish(true, "rice", 350, Dish.Type.MEAT),
          new Dish(true, "season fruit", 120, Dish.Type.OTHER),
          new Dish(true, "pizza", 550, Dish.Type.OTHER),
          new Dish(false, "prawns", 300, Dish.Type.FISH),
          new Dish(false, "salmon", 450, Dish.Type.FISH));

  // Filter out 3 food which has highest calories
  List<String> top3 =
      menu.stream()
          .filter(d -> d.getCalories() > 300)
          .map(Dish::getName)
          .limit(3)
          .collect(Collectors.toList());

  // Filter and Slice
  List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

  private List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 9, 2);

  public void findDistNum() {
    num.stream().filter(n -> n % 2 == 0).distinct().forEach(System.out::println);
  }

  List<Dish> dishes =
      menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList());

  // Map
  List<String> words = Arrays.asList("Java 8", "Lambda", "In", "Action");
  List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());

  List<String> uniqueChar =
      words
          .stream()
          .map(w -> w.split(""))
          .flatMap(Arrays::stream)
          .distinct()
          .collect(Collectors.toList());

  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
  List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());

  List<Integer> numbers1 = Arrays.asList(1, 2, 3);
  List<Integer> numbers2 = Arrays.asList(3, 4);
  List<int[]> pairs =
      numbers1
          .stream()
          .flatMap(i -> numbers2.stream().map(j -> new int[] {i, j}))
          .collect(Collectors.toList());

  // reducing
  int sum = numbers.stream().reduce(0, (a, b) -> a + b);
  //reducing need one Bioperation which extends bifunction<T,T,T>
  Optional<Integer> max = numbers.stream().reduce(Integer::max);


}
