package com.rxtube.model;

import android.util.SparseArray;

import com.rxtube.VideoMeta;
import com.rxtube.YtFile;

public class YtResponse {

    private final SparseArray<YtFile> ytFiles;
    private final VideoMeta videoMeta;

    public YtResponse(SparseArray<YtFile> ytFiles, VideoMeta videoMeta) {
        this.ytFiles = ytFiles;
        this.videoMeta = videoMeta;
    }

    public SparseArray<YtFile> getYtFiles() {
        return ytFiles;
    }

    public VideoMeta getVideoMeta() {
        return videoMeta;
    }
}
