package ru.develop.springrest.domain.view;

public final class Views {

    public interface Id {}

    public interface IdName extends Id{}

    public interface FullComment extends IdName {}

    public interface FullMessage extends IdName {}
}
