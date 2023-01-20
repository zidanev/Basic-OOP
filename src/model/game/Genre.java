package model.game;

import java.io.Serializable;
import java.util.UUID;

public class Genre implements Serializable {
    private String genreName;
    private final String id;

    public Genre(String name) {
        this.id = UUID.randomUUID().toString();
        this.genreName = name;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getId() {
        return id;
    }
}
