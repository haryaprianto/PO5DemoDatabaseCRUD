package com.example.a16022596.po5demodatabasecrud;

import java.io.Serializable;

public class Note implements Serializable {
    private int id;
    private String noteContent;

    public String getNoteContent() {
        return noteContent;
    }

    public int getId() {
        return id;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Note(int id, String noteContent) {
        this.id = id;
        this.noteContent = noteContent;

    }
    @Override
    public String toString() {
        return "ID:" + id + ", " + noteContent;
    }

}
