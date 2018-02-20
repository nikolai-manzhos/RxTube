package com.rxtube2;

import com.rxtube2.model.YtResponse;

import io.reactivex.Observable;

public interface RxTube {
    Observable<YtResponse> extract(String youTubeLink);
    Observable<YtResponse> extract(String youTubeLink, boolean parseDashManifest, boolean includeWebM);
}
