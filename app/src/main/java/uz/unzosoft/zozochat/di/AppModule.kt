package uz.unzosoft.zozochat.di

import android.content.Context
import com.unzosoft.zozochat.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.getstream.chat.android.client.ChatClient
import javax.inject.Singleton


/**
 * Created by Abdurashidov Shahzod on 29/10/21 23:02.
 * company QQBank
 * shahzod9933@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideClient(@ApplicationContext context: Context) = ChatClient.Builder(
        context.getString(R.string.api_key),
        context
    ).build()
}