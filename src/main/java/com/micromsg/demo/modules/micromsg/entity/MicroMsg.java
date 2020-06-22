package com.micromsg.demo.modules.micromsg.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MicroMsg implements Serializable {
    @JsonProperty("id")
    private int id;

    @JsonProperty("command")
    private String command;

    @JsonProperty("result")
    private String result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MicroMsg{" +
                "id=" + id +
                ", command='" + command + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
