package org.example.dto;

import java.util.List;
import java.util.Objects;

public class Response {

    private static Response FAILED_RESPONSE = null;

    private Status status;
    private List<Action> actions;

    private Response(Status status){
        this.status = status;
    }

    public static Response success(List<Action> actions) {
        Response response = new Response(Status.SUCCESS);
        response.setActions(actions);
        return response;
    }

    public static Response failed() {
        if (FAILED_RESPONSE == null) {
            FAILED_RESPONSE = new Response(Status.FAILED);
            return FAILED_RESPONSE;
        }

        return FAILED_RESPONSE;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Response{"
                +
                "status="
                + status
                +
                ", actions="
                + actions
                +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null
                || getClass()
                != o.getClass()) return false;
        Response response = (Response) o;
        return status
                == response.status
                && Objects.equals(actions, response.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, actions);
    }
}
