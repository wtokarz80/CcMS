package com.m3w.interfaces;

import java.util.List;

public interface Viewable<T> {

    List<T> viewById(int Id);
}
