package collection;

import io.vavr.control.Option;
import basic.BasicTest;

import java.util.ArrayList;
import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {

  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    List<Double> values = new ArrayList<>();
    if (null != input && input.size() > 0) {
      for (Integer in : input) {
        values.add(Double.valueOf(calculateInputValue(in).get()));
      }
    }
    return values;
  }

  /**
   * @param x
   * @return Option<Integer>
   */
  private static Option<Integer> calculateInputValue(Integer x) {
    Integer calc = (x * 2) + 3;
    return BasicTest.power(calc, 5);
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    List<String> result = new ArrayList<>();
    if (null != input && input.size() > 0) {
      for (String ch : input) {
        String c = capitalizeFirstLetter(ch);
        result.add(c.concat(c));
      }
    }
    return result;
  }
/**
 * capitalize first letter of string
 * @param str
 * @return
 */
  public static String capitalizeFirstLetter(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }
}
