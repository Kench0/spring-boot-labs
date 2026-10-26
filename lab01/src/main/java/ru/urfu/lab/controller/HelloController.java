package ru.urfu.lab.controller;


import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
  private ArrayList<String> array;
  private HashMap<Integer, String> map;

  @GetMapping("/hello")
  public String hello(@RequestParam(defaultValue = "World") String name) {
    return "Hello, " + name + "!";
  }

  @GetMapping("/update-array")
  public synchronized String updateArrayList(@RequestParam String s) {
    if (array == null) {
      array = new ArrayList<>();
      return "ArrayList initialized";
    }
    array.add(s);
    return "Added: " + s;
  }

  @GetMapping("/show-array")
  public synchronized List<String> showArrayList() {
    return array == null ? List.of() : new ArrayList<>(array);
  }

  @GetMapping("/update-map")
  public synchronized String updateHashMap(@RequestParam String s) {
    if (map == null) {
      map = new HashMap<>();
      return "HashMap initialized";
    }
    map.put(map.size() + 1, s);
    return "Added: " + s;
  }

  @GetMapping("/show-map")
  public synchronized Map<Integer, String> showHashMap() {
    return map == null ? Map.of() : new TreeMap<>(map);
  }

  @GetMapping("/show-all-lenght")
  public synchronized String showAllLenght() {
    return "ArrayList: "
        + (array == null ? 0 : array.size())
        + "; HashMap: "
        + (map == null ? 0 : map.size());
  }
}
