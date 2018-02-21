package com.rxtube;

import android.content.Context;

public class RxTubeFactory {
    private RxTubeFactory() {}

    public static RxTube create(Context context) {
        return new RxTubeImpl(context);
    }
}
