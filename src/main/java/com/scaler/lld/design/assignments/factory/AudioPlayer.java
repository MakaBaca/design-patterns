package com.scaler.lld.design.assignments.factory;

public abstract class AudioPlayer {
    int volume;
    double playBackRate;
    public abstract MediaFormat supportsType();

    public abstract void play();

    public abstract void pause();

    public abstract void stop();

}