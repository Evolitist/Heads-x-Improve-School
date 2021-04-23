package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.task8.ui.main.models.Planet
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class FullPlanetFragmentArgs(
  public val planet: Planet
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Planet::class.java)) {
      result.putParcelable("planet", this.planet as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Planet::class.java)) {
      result.putSerializable("planet", this.planet as Serializable)
    } else {
      throw UnsupportedOperationException(Planet::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FullPlanetFragmentArgs {
      bundle.setClassLoader(FullPlanetFragmentArgs::class.java.classLoader)
      val __planet : Planet?
      if (bundle.containsKey("planet")) {
        if (Parcelable::class.java.isAssignableFrom(Planet::class.java) ||
            Serializable::class.java.isAssignableFrom(Planet::class.java)) {
          __planet = bundle.get("planet") as Planet?
        } else {
          throw UnsupportedOperationException(Planet::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__planet == null) {
          throw IllegalArgumentException("Argument \"planet\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"planet\" is missing and does not have an android:defaultValue")
      }
      return FullPlanetFragmentArgs(__planet)
    }
  }
}
