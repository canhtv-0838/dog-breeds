package com.sun.dogbreeds.utils

import androidx.fragment.app.FragmentActivity

object ScreenNavigator {
    @JvmStatic
    fun getCurrentFragment(fragmentActivity: FragmentActivity, resId: Int) =
        fragmentActivity.supportFragmentManager.findFragmentById(resId)

    @JvmStatic
    fun backToFirstScreen(fragmentActivity: FragmentActivity) = with(fragmentActivity.supportFragmentManager) {
        for (counter in 0 until backStackEntryCount) popBackStack()
    }
}
