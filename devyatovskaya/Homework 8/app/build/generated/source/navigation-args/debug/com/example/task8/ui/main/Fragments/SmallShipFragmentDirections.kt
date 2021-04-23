package com.example.task8.ui.main.Fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.task8.R
import com.example.task8.ui.main.models.Starship
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class SmallShipFragmentDirections private constructor() {
  private data class ActionSmallShipFragmentToFullShipFragment(
    public val starship: Starship
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_SmallShipFragment_to_FullShipFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
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
  }

  public companion object {
    public fun actionSmallShipFragmentToFullShipFragment(starship: Starship): NavDirections =
        ActionSmallShipFragmentToFullShipFragment(starship)
  }
}
