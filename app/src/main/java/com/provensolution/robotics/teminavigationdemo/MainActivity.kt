package com.provensolution.robotics.teminavigationdemo

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.provensolution.robotics.teminavigationdemo.data.model.MapModel
import com.robotemi.sdk.NlpResult
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest
import com.robotemi.sdk.activitystream.ActivityStreamPublishMessage
import com.robotemi.sdk.listeners.OnBeWithMeStatusChangedListener
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener
import com.robotemi.sdk.listeners.OnLocationsUpdatedListener
import com.robotemi.sdk.listeners.OnRobotReadyListener

class MainActivity : AppCompatActivity(),
    Robot.NlpListener,
    OnRobotReadyListener,
    Robot.ConversationViewAttachesListener,
    Robot.WakeupWordListener,
    Robot.ActivityStreamPublishListener,
    Robot.TtsListener,
    OnBeWithMeStatusChangedListener,
    OnGoToLocationStatusChangedListener,
    OnLocationsUpdatedListener {

    private val robot = Robot.getInstance()

    lateinit var locationList : List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        robot.addOnRobotReadyListener(this)
        robot.addNlpListener(this)
        robot.addOnBeWithMeStatusChangedListener(this)
        robot.addOnGoToLocationStatusChangedListener(this)
        robot.addConversationViewAttachesListenerListener(this)
        robot.addWakeupWordListener(this)
        robot.addTtsListener(this)
        robot.addOnLocationsUpdatedListener(this)
        locationList = robot.locations
    }

    override fun onStop() {
        super.onStop()
        robot.removeOnRobotReadyListener(this)
        robot.removeNlpListener(this)
        robot.removeOnBeWithMeStatusChangedListener(this)
        robot.removeOnGoToLocationStatusChangedListener(this)
        robot.removeConversationViewAttachesListenerListener(this)
        robot.removeWakeupWordListener(this)
        robot.removeTtsListener(this)
        robot.removeOnLocationsUpdateListener(this)
    }

    override fun onRobotReady(isReady: Boolean) {
        if (isReady) {
            try {
                val activityInfo = packageManager.getActivityInfo(componentName, PackageManager.GET_META_DATA);
                robot.onStart(activityInfo);
                Log.e("LocationList", "$locationList")
            } catch (e : PackageManager.NameNotFoundException) {
                throw RuntimeException(e);
            }
        }
    }

    override fun onGoToLocationStatusChanged(
        location: String,
        status: String,
        descriptionId: Int,
        description: String
    ) {
        TODO("Not yet implemented")
    }

    override fun onLocationsUpdated(locations: List<String>) {
        TODO("Not yet implemented")
    }



    override fun onPublish(message: ActivityStreamPublishMessage) {
        TODO("Not yet implemented")
    }

    override fun onConversationAttaches(isAttached: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onNlpCompleted(nlpResult: NlpResult) {
        TODO("Not yet implemented")
    }

    override fun onTtsStatusChanged(ttsRequest: TtsRequest) {
        TODO("Not yet implemented")
    }

    override fun onWakeupWord(wakeupWord: String, direction: Int) {
        TODO("Not yet implemented")
    }

    override fun onBeWithMeStatusChanged(status: String) {
        TODO("Not yet implemented")
    }


}