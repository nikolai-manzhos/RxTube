package com.rxtube2;

import android.util.SparseArray;

import com.rxtube2.model.YtResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.httpclient.FakeHttp;

import io.reactivex.functions.Predicate;


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

    private void extract(String youtubeUrl, final int qualityTag) {
        RxTube rxTube = RxTubeFactory.create(RuntimeEnvironment.application);

        rxTube.extract(youtubeUrl)
                .test()
                .assertNoErrors()
                .assertValue(new Predicate<YtResponse>() {
                    @Override
                    public boolean test(YtResponse ytResponse) throws Exception {
                        SparseArray<YtFile> ytFiles = ytResponse.getYtFiles();
                        String url = ytFiles.get(qualityTag).getUrl();
                        return url != null && !url.isEmpty();
                    }
                });
    }
}
