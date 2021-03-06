package com.jocoos.flipflop.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jocoos.flipflop.FFAVPlayerListener
import com.jocoos.flipflop.FlipFlopException
import com.jocoos.flipflop.player.FFAVPlayer
import com.jocoos.flipflop.sample.util.FFAVPlayerLifecycleWrapper
import kotlinx.android.synthetic.main.avplayer_activity.*

class AVPlayerActivity : AppCompatActivity(), FFAVPlayerListener {
    private var player: FFAVPlayer? = null
    private var playerLifecycleWrapper: FFAVPlayerLifecycleWrapper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avplayer_activity)

        player = FlipFlopSampleApp.flipFlopInstance?.getAVPlayer(this, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")?.apply {
            listener = this@AVPlayerActivity
            prepare(this@AVPlayerActivity, playerView)
        }

        player?.let {
            playerLifecycleWrapper = FFAVPlayerLifecycleWrapper(lifecycle, it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        playerLifecycleWrapper = null
    }

    // FFAVPlayerListener
    override fun onPrepared(player: FFAVPlayer) {

    }

    override fun onStarted(player: FFAVPlayer) {

    }

    override fun onStopped(player: FFAVPlayer) {

    }

    override fun onCompleted(player: FFAVPlayer) {

    }

    override fun onSeek(player: FFAVPlayer, position: Long) {

    }

    override fun onBuffering(player: FFAVPlayer) {

    }

    override fun onError(player: FFAVPlayer, error: FlipFlopException) {

    }
}