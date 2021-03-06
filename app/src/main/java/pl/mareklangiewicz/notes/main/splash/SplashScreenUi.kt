package pl.mareklangiewicz.notes.main.splash

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import pl.mareklangiewicz.notes.R
import pl.mareklangiewicz.notes.main.ScreenUi
import pl.mareklangiewicz.notes.widgets.UiFrame
import splitties.dimensions.dip
import splitties.views.dsl.core.*
import splitties.views.imageResource
import splitties.views.padding
import splitties.views.setPaddingDp
import android.util.AttributeSet

class SplashScreenUi(ctx: Context) : ScreenUi<Ui>(SplashUi(ctx))

class SplashUi(override val ctx: Context) : Ui {
    override val root = verticalLayout {
        addImage(R.drawable.ic_round_account_tree_24) { setPaddingDp(end = 128) }
        addImage(R.drawable.ic_round_list_alt_24)
        addImage(R.drawable.ic_round_done_all_24) { setPaddingDp(start = 128) }
    }
}

private fun LinearLayout.addImage(@DrawableRes res: Int, initView: ImageView.() -> Unit = {}) =
    add(imageView { imageResource = res; padding = dip(16); initView() }, lParams(matchParent, weight = 1f))

@Suppress("unused") private class SplashPreview(ctx: Context, attrs: AttributeSet) : UiFrame(SplashScreenUi(ctx), attrs)
