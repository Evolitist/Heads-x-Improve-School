package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.task8.R
import com.example.task8.ui.main.models.Planet
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class SmallPlanetFragmentDirections private constructor() {
  private data class ActionSmallPlanetFragmentToFullPlanetFragment(
    public val planet: Planet
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_SmallPlanetFragment_to_FullPlanetFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
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
  }

  public companion object {
    public fun actionSmallPlanetFragmentToFullPlanetFragment(planet: Planet): NavDirections =
        ActionSmallPlanetFragmentToFullPlanetFragment(planet)
  }
}
