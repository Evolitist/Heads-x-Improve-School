package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.task8.ui.main.models.Film
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class FullFilmFragmentArgs(
  public val film: Film
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Film::class.java)) {
      result.putParcelable("film", this.film as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Film::class.java)) {
      result.putSerializable("film", this.film as Serializable)
    } else {
      throw UnsupportedOperationException(Film::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FullFilmFragmentArgs {
      bundle.setClassLoader(FullFilmFragmentArgs::class.java.classLoader)
      val __film : Film?
      if (bundle.containsKey("film")) {
        if (Parcelable::class.java.isAssignableFrom(Film::class.java) ||
            Serializable::class.java.isAssignableFrom(Film::class.java)) {
          __film = bundle.get("film") as Film?
        } else {
          throw UnsupportedOperationException(Film::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__film == null) {
          throw IllegalArgumentException("Argument \"film\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"film\" is missing and does not have an android:defaultValue")
      }
      return FullFilmFragmentArgs(__film)
    }
  }
}
