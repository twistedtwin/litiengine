package de.gurkenlabs.litiengine.sound;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import de.gurkenlabs.litiengine.Game;

public class Sound {
  private static final List<Sound> sounds = new CopyOnWriteArrayList<>();

  private final String name;
  private final String path;

  public Sound(final String path) {
    this.name = path;
    this.path = path;
    sounds.add(this);
  }

  public static Sound find(String name) {
    if (name == null || name.isEmpty()) {
      return null;
    }

    Optional<Sound> sound = sounds.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst();
    if (!sound.isPresent()) {
      return null;
    }

    return sound.get();
  }

  public String getPath() {
    return this.path;
  }

  public String getName() {
    return this.name;
  }

  public URL getUrl() {
    try {
      return new File(this.getPath()).toURI().toURL();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return null;
  }
}