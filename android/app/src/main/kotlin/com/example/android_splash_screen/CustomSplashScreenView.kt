package com.example.android_splash_screen

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewPropertyAnimator
import android.view.LayoutInflater
import android.widget.FrameLayout

class CustomSplashScreenView(context: Context) : FrameLayout(context) {
    private val transitionTimeInMills = 5000L
    private var onTransitionComplete: Runnable? = null
    private var fadeAnimator: ViewPropertyAnimator? = null

    init {
        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        addView(layoutInflater.inflate(R.layout.splash_view, this, false),
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.CENTER))
    }

    fun animatePlay(onTransitionComplete: Runnable?) {
        this.onTransitionComplete = onTransitionComplete
        fadeAnimator = animate()
                .alpha(0.0f)
                .setDuration(transitionTimeInMills)
                .setListener(transitionAnimatorListener)
        fadeAnimator?.start()
    }

    private val transitionAnimatorListener: Animator.AnimatorListener = object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator) {
            animation.removeAllListeners()
            if (onTransitionComplete != null) {
                onTransitionComplete?.run()
            }
        }
    }
}
