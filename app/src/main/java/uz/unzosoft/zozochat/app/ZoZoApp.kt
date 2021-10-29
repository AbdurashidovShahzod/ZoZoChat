package uz.unzosoft.zozochat.app

import android.app.Application
import com.unzosoft.zozochat.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.offline.ChatDomain
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 29/10/21 22:52.
 * company QQBank
 * shahzod9933@gmail.com
 */
@HiltAndroidApp
class ZoZoApp : Application() {
    @Inject
    lateinit var client: ChatClient

    override fun onCreate() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        super.onCreate()
        ChatDomain.Builder(
            client,
            applicationContext
        ).build()
        instance = this
    }

    companion object {
        lateinit var instance: ZoZoApp
    }
}