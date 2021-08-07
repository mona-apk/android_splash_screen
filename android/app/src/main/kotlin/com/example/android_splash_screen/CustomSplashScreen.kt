package com.example.android_splash_screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import io.flutter.embedding.android.SplashScreen

class CustomSplashScreen : SplashScreen {
    private var splashView: CustomSplashScreenView? = null
    override fun createSplashView(context: Context, savedInstanceState: Bundle?): View? {
        if (splashView == null) {
            splashView = CustomSplashScreenView(context)
        }
        return splashView
    }

    override fun transitionToFlutter(onTransitionComplete: Runnable) {
        if (splashView != null) {
            splashView?.animatePlay(onTransitionComplete);
        }
        else {
            onTransitionComplete.run();
        }
    }
}