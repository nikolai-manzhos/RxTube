package com.rxtube;

import android.content.Context;

public class RxTubeFactory {
    public static RxTube create(Context context) {
        return new RxTubeImpl(context);
    }
}
