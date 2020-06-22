package pl.sdacademy.wzorce.zad2;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Servers {

  private static Servers instance;

  public Servers getInstance() {
    if (instance == null) {
      synchronized (Servers.class) {
        if (instance == null) {
          instance = new Servers();
        }
      }
    }
    return instance;
  }

  private final List<String> serverList;

  private Servers() {
    serverList = new ArrayList<>();
  }

  public boolean addServer(final String server) {
    if ((server.startsWith("http") || server.startsWith("https")) && !serverList.contains(server)) {
      return serverList.add(server);
    }
    return false;
  }

  public List<String> getHttpServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("http"))
        .collect(Collectors.toUnmodifiableList());
  }

  private List<String> getServersStartingWith(final String prefix) {
    return serverList.stream()
        .filter(server -> server.startsWith(prefix))
        .collect(Collectors.toUnmodifiableList());
  }

  public List<String> getHttpsServers() {
    return serverList.stream()
        .filter(server -> server.startsWith("https"))
        .collect(Collectors.toUnmodifiableList());
  }
}
