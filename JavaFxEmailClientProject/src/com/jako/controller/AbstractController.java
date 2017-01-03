package com.jako.controller;

/**
 * Created by JaKotek on 03.01.2017.
 */
public class AbstractController
{

    private ModelAccess modelAccess;

    public AbstractController(ModelAccess modelAccess)
    {
        this.modelAccess = modelAccess;
    }

    public ModelAccess getModelAccess()
    {
        return modelAccess;
    }
}
