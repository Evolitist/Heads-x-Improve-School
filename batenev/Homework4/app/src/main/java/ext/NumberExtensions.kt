package ext

import android.content.res.Resources

fun Int.toDp() = (this * Resources.getSystem().displayMetrics.density + 0.5F).toInt()