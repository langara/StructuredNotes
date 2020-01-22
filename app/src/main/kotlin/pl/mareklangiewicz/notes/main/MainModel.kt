package pl.mareklangiewicz.notes.main

import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.functions.Consumer
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import pl.mareklangiewicz.notes.logic.main.*

interface MainModelContract {
    val state: MainState
    val actionS: Consumer<MainAction>
}

class MainModel : MainModelContract {

    override val state = MainState()

    override val actionS = PublishRelay.create<MainAction>()

    @Suppress("EXPERIMENTAL_API_USAGE")
    private val scope = MainScope()

    init {
        println("notes MainModel.init") // TODO: implement and use abstract logger (for debug mode)
        scope.launch { MainLogic(actionS, state) }
    }
}