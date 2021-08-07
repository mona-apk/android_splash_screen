package com.example.android_splash_screen

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.SplashScreen

class MainActivity: FlutterActivity() {
    override fun provideSplashScreen(): SplashScreen? = CustomSplashScreen()
}
