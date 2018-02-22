# RxTube
![CircleCI](https://circleci.com/gh/NikolayManzhos/RxTube/tree/master.svg?style=shield)
Reactive yotube parser. Supports RxJava and RxJava 2.
# Usage
```java
String youtubeLink = "http://youtube.com/watch?v=0IKHxjkgop4";

RxTube rxTube = RxTubeFactory.create(getApplicationContext());
rxTube.extract(youtubeLink)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(videoResponse -> {
            SparseArray<YtFile> ytFiles = videoResponse.getYtFiles();
            int itag = 22; // HD quality
            String downloadUrl = ytFiles.get(itag).getUrl();
            Log.d(TAG, "onExtractionComplete: " + downloadUrl);
        }, err -> Log.e(TAG, "", err));
```
# Gradle
RxJava dependecy
```gradle
implementation 'com.nikolaymanzhos:rxtube:1.0.0'
```
RxJava 2 dependency
```gradle
implementation 'com.nikolaymanzhos:rxtube2:1.0.0'
```
# Reference
Original parser implementation [YouTubeExtractor](https://github.com/HaarigerHarald/android-youtubeExtractor)
