package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.task8.R
import com.example.task8.ui.main.models.Film
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class SmallFilmFragmentDirections private constructor() {
  private data class ActionSmallFilmFragmentToFullFilmFragment(
    public val film: Film
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_SmallFilmFragment_to_FullFilmFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
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
  }

  public companion object {
    public fun actionSmallFilmFragmentToFullFilmFragment(film: Film): NavDirections =
        ActionSmallFilmFragmentToFullFilmFragment(film)
  }
}
