import android.content.Context

import android.media.AudioDeviceInfo

import android.media.AudioManager

import android.content.pm.PackageManager

 

class AudioHelper(context: Context) {

 

    private val audioManager: AudioManager =
context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

 

    fun audioOutputAvailable(type: Int): Boolean {

        if (!
context.packageManager.hasSystemFeature(PackageManager.FEATURE_AU
DIO_OUTPUT)) {

            return false

        }

 

        return
audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS).any
{ it.type == type }

    }

}

 

// Exemplo de uso

fun main() {

    val audioHelper = AudioHelper(context) // Substitua 'context' pelo
contexto atual do seu aplicativo

 

    val isSpeakerAvailable =
audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKE
R)

    // True if the device has a speaker

 

    val isBluetoothHeadsetConnected =
audioHelper.audioOutputAvailable(AudioDeviceInfo.TYPE_BLUETOOTH_A2D
P)

    // True if a Bluetooth headset is connected

}