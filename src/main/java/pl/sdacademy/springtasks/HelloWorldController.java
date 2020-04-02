package pl.sdacademy.springtasks;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/api/hellos")
public class HelloWorldController {

  private List<Hello> hellos = new ArrayList<>();

  @GetMapping
  public Hellos getAllHellos() {
    return new Hellos(hellos);
  }

  @GetMapping("/{idx}")
  public Hello getHelloByIndex(@PathVariable final Integer idx) {
    if (!hellos.isEmpty() && idx < hellos.size() && idx >= 0) {
      return hellos.get(idx);
    }
    return null;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Hello sayHi(@RequestBody final Hello hello) {
    hellos.add(hello);
    return hello;
  }

  @PutMapping("/{idx}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@RequestBody final Hello hello, @PathVariable final Integer idx) {
    if (!hellos.isEmpty() && idx < hellos.size() && idx >= 0) {
     hellos.get(idx).setMessage(hello.getMessage());
    }
  }

  @DeleteMapping("/{idx}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable final Integer idx) {
    if (!hellos.isEmpty() && idx < hellos.size() && idx >= 0) {
      hellos.remove((int)idx);
    }
  }
}
