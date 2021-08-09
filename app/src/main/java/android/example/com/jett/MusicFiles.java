package android.example.com.jett;

import java.io.Serializable;

public class MusicFiles implements Serializable {
    private String title;

    public MusicFiles(String title) {
        this.title = title;
    }

    public MusicFiles() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
