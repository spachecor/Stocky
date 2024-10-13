package com.stocky.models.entities;

public abstract class Entidad<T extends Entidad> implements Comparable<T>{
    public abstract Integer getId();
}
