package com.retail.DB1.communication;


import java.io.Serializable;
import java.util.Objects;

public class Request implements Serializable {

    private String request;
    private String json;

    public Request(){

    }

    public Request(String request, String json)
    {
        this.request = request;
        this.json = json;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request1 = (Request) o;
        return Objects.equals(getRequest(), request1.getRequest()) &&
                Objects.equals(getJson(), request1.getJson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequest(), getJson());
    }

    @Override
    public String toString() {
        return "Request{" +
                "request='" + request + '\'' +
                ", json='" + json + '\'' +
                '}';
    }
}
