/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.model.pojo;

/**
 *
 * @author dmitry
 * @param <T>
 */
public interface Validable<T> {
    T validate();
}
