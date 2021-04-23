package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.task8.ui.main.models.Starship
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class FullShipFragmentArgs(
  public val starship: Starship
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Starship::class.java)) {
      result.putParcelable("starship", this.starship as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Starship::class.java)) {
      result.putSerializable("starship", this.starship as Serializable)
    } else {
      throw UnsupportedOperationException(Starship::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FullShipFragmentArgs {
      bundle.setClassLoader(FullShipFragmentArgs::class.java.classLoader)
      val __starship : Starship?
      if (bundle.containsKey("starship")) {
        if (Parcelable::class.java.isAssignableFrom(Starship::class.java) ||
            Serializable::class.java.isAssignableFrom(Starship::class.java)) {
          __starship = bundle.get("starship") as Starship?
        } else {
          throw UnsupportedOperationException(Starship::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__starship == null) {
          throw IllegalArgumentException("Argument \"starship\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"starship\" is missing and does not have an android:defaultValue")
      }
      return FullShipFragmentArgs(__starship)
    }
  }
}
