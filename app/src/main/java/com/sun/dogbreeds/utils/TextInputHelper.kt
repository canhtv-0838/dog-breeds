package com.sun.dogbreeds.utils

import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import kotlinx.coroutines.*

private const val TOUCH_DELAY = 150L

fun EditText.showSoftKeyboard() = GlobalScope.launch {
    withContext(Dispatchers.Main) {
        dispatchTouch(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN)
        delay(TOUCH_DELAY)
        dispatchTouch(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_UP)
    }
    setSelection(text.length)
}

fun EditText.hideSoftKeyboard() {
    clearFocus()
    (context?.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager).run {
        hideSoftInputFromWindow(windowToken, 0)
    }
}

private fun View.dispatchTouch(downTime: Long, eventTime: Long, motionEvent: Int) =
    dispatchTouchEvent(MotionEvent.obtain(downTime, eventTime, motionEvent, 0f, 0f, 0))
