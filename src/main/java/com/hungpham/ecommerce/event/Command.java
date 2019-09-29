package com.hungpham.ecommerce.event;


import org.springframework.data.repository.CrudRepository;

public class Command<T, P extends CrudRepository> {
    private int type;
    private T body;
    private P persistent;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public P getPersistent() {
        return persistent;
    }

    public void setPersistent(P persistent) {
        this.persistent = persistent;
    }
}
