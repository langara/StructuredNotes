package pl.mareklangiewicz.notes.main

import android.content.Context
import io.reactivex.ObservableSource
import pl.mareklangiewicz.notes.logic.main.Screen
import pl.mareklangiewicz.notes.main.login.LoginScreenUi
import pl.mareklangiewicz.notes.main.splash.SplashScreenUi
import splitties.views.dsl.core.Ui

abstract class ScreenUi<UiContract : Ui>(protected val ui: UiContract) : Ui by ui {
    open fun <U> bindUntil(untilS: ObservableSource<U>, model: MainModelContract) = Unit
}

fun Context.createScreenUi(screen: Screen) = when(screen) {
    Screen.Splash -> SplashScreenUi(this)
    Screen.Register -> TODO()
    Screen.Login -> LoginScreenUi(this)
    Screen.Home -> TODO()
    Screen.Settings -> TODO()
    Screen.None -> null
}
