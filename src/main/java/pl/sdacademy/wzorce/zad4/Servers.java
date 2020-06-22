package pl.sdacademy.wzorce.zad4;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum Servers {
  INSTANCE;

  private final List<String> serverList;

  Servers() {
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
