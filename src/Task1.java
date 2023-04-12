//Задача 1
//    Перепишите алгоритм бинарного поиска элемента в отсортированном по возрастанию списке целых
//    чисел (см. урок 56, задача 2) с использованием рекурсии.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task1 {

  /**
   * Поиск числа target в списке numbers
   *
   * @param numbers отсортированный по возрастанию список различных целых чисел
   * @param target  число, которое необходимо найти
   * @return индекс числа target в списке numbers или -1, если число не найдено
   */
  public static int indexOf(ArrayList<Integer> numbers, int target, int left,
      int right) { // O(1) по памяти

    if (left < right - 1) {
      int mid = (left + right) / 2;
      if (numbers.get(mid) == target) {
        return mid;
      }
      int a = numbers.get(mid);
      if (numbers.get(mid) < target) {
        left = mid + 1;
        return indexOf(numbers, target, left, right);
      } else {
        right = mid;
        return indexOf(numbers, target, left, right);
      }
    }
    if (left < numbers.size() && numbers.get(left) == target) {
      return left;
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Введите количество элементов: ");
    int n = Integer.parseInt(br.readLine());

    ArrayList<Integer> numbers = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) {
      numbers.add(Integer.parseInt(br.readLine()));
    }

    System.out.print("Введите число для поиска: ");
    int target = Integer.parseInt(br.readLine());
    int left = 0;
    int right = numbers.size();
    System.out.println("Результат: " + indexOf(numbers, target, left, right));
  }
}
