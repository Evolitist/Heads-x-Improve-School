package com.evolitist.lesson1.placeholder

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import java.util.*
import kotlin.random.Random

object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS = LinkedList<ListItem>().apply {
        repeat(COUNT) { i ->
            add(createPlaceholderItem(i))
        }
    }.toList()

    private const val COUNT = 25

    private fun createPlaceholderItem(position: Int): ListItem {
        return ListItem(
            position.toString(),
            "Item $position",
            "Details about Item: $position",
            ColorDrawable(Random.nextInt())
        )
    }

    data class ListItem(
        val id: String,
        val title: String,
        val subtitle: String?,
        val image: Drawable?,
    )
}