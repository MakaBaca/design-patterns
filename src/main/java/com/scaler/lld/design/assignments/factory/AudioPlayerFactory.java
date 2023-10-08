package com.scaler.lld.design.assignments.factory;

public class AudioPlayerFactory {

    public static AudioPlayer createAudioPlayer(MediaFormat format, int volume, double playbackRate){

        return switch (format) {
            case FLAC -> new FLACPlayer(volume, playbackRate);
            case WAV -> new WAVPlayer(volume, playbackRate);
            default -> new MP3Player(volume, playbackRate);
        };

    }
}