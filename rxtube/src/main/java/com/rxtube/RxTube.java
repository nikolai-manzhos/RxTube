package com.rxtube;

import com.rxtube.model.YtResponse;

import rx.Observable;

public interface RxTube {
    Observable<YtResponse> extract(String youTubeLink);
    Observable<YtResponse> extract(String youTubeLink, boolean parseDashManifest, boolean includeWebM);
}
