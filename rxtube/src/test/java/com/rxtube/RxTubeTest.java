package com.rxtube;

import android.util.SparseArray;

import com.rxtube.model.YtResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.httpclient.FakeHttp;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class RxTubeTest {

    private static final int HD_VIDEO = 22;
    private static final int HD_STREAM = 95;

    @Before
    public void setup() {
        FakeHttp.getFakeHttpLayer().interceptHttpRequests(false);
    }

    @Test
    public void extractVideoLink() {
        extract("https://www.youtube.com/watch?v=Y2VF8tmLFHw", HD_VIDEO);
    }

    @Test
    public void extractStreamLink() {
        extract("http://www.youtube.com/watch?v=ddFvjfvPnqk", HD_STREAM);
    }

    private void extract(String youtubeUrl, int qualityTag) {
        RxTube rxTube = RxTubeFactory.create(RuntimeEnvironment.application);

        List<YtResponse> responseSequence =
                rxTube.extract(youtubeUrl)
                        .test()
                        .assertNoErrors()
                        .getOnNextEvents();

        SparseArray<YtFile> ytFiles = responseSequence.get(0).getYtFiles();
        YtFile ytFile = ytFiles.get(qualityTag);

        assertNotNull(ytFile);
        assertNotNull(ytFile.getUrl());
        assertFalse(ytFile.getUrl().isEmpty());
    }
}