package com.evolitist.lesson1

import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class ViewBindingFragment(
    @LayoutRes layoutId: Int = 0,
) : Fragment(layoutId) {

    private var onDestroyViewListener: OnDestroyViewListener? = null

    fun <O : ViewBinding> viewBinding(
        bind: (View) -> O,
    ) = ViewBindingProperty(bind)
        .also { onDestroyViewListener = it }

    override fun onDestroyView() {
        onDestroyViewListener?.onDestroyView()
        onDestroyViewListener = null
        super.onDestroyView()
    }

    internal interface OnDestroyViewListener {
        fun onDestroyView()
    }
}

class ViewBindingProperty<O : ViewBinding> internal constructor(
    private val bind: (View) -> O,
) : ReadOnlyProperty<ViewBindingFragment, O>, ViewBindingFragment.OnDestroyViewListener {

    private var binding: O? = null

    override fun getValue(thisRef: ViewBindingFragment, property: KProperty<*>): O {
        val rootView = thisRef.view ?: error("Fragment doesn't have attached view!")
        if (binding == null) {
            binding = bind(rootView)
        }
        return binding!!
    }

    override fun onDestroyView() {
        binding = null
    }
}
