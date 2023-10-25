package org.example.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SlackTokenPayload {

    @JsonProperty("actions")
    private List<Action> actions;


    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
