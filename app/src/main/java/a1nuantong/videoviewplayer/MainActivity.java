package a1nuantong.videoviewplayer;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 创建VideoView对象
         */
        videoView= (VideoView) findViewById(R.id.videoView);

        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"文件名称";
        /**
         *本地视频播放
         * path 本地路径
         */
        videoView.setVideoPath(path);

        String urlPath="网络地址";
        /**
         * 网络视频播放
         * urlPath 将网络地址path 转化为Uri
         */
        videoView.setVideoURI(Uri.parse(urlPath));

        /**
         *通过系统MediaController 播放 停止  暂停 视屏
         */
        MediaController mediaController=new MediaController(this);

        /**
         * 设置VideoView与MediaController关联
         */
        videoView.setMediaController(mediaController);

        /**
         * 设置MediaController与VideoView关联
         */
        mediaController.setMediaPlayer(videoView);
    }
}
