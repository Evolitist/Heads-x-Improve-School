package com.example.homework4.ui.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.ResourcesCompat.getDrawable
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework4.R
import com.example.homework4.databinding.MybillsListItemRectangleBinding
import com.example.homework4.databinding.MybillsListItemSquareBinding
import com.google.android.material.snackbar.Snackbar
import data.Bill
import data.BillData
import data.BillType
import data.BillType.*
import java.text.DecimalFormat

class MyBillsListAdapter : ListAdapter<Bill, RecyclerView.ViewHolder>(DiffCallback) {

    private lateinit var context: Context
    private lateinit var recycler: RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.mybills_list_item_square -> {
                BillsSquareViewHolder(
                    MybillsListItemSquareBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.mybills_list_item_rectangle -> {
                BillRectangleViewHolder(
                    MybillsListItemRectangleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> error("Unexpected view type!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BillsSquareViewHolder -> (holder as BillsSquareViewHolder).bind(currentList[position])
            is BillRectangleViewHolder -> (holder as BillRectangleViewHolder).bind(currentList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            in 0..5 -> R.layout.mybills_list_item_square
            else -> R.layout.mybills_list_item_rectangle
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    object DiffCallback : DiffUtil.ItemCallback<Bill>() {
        override fun areItemsTheSame(oldItem: Bill, newItem: Bill): Boolean {
            return oldItem.type == newItem.type
        }

        override fun areContentsTheSame(oldItem: Bill, newItem: Bill): Boolean {
            return oldItem.data == newItem.data
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        context = recyclerView.context
        recycler = recyclerView
    }

    private fun getIconFromBillType(type: BillType): Drawable? {
        return when (type) {
            BILL -> getDrawable(context.resources, R.drawable.ic_bill, null)
            COUNTER -> getDrawable(context.resources, R.drawable.ic_counter, null)
            INSTALLMENT -> getDrawable(context.resources, R.drawable.ic_installment, null)
            INSURANCE -> getDrawable(context.resources, R.drawable.ic_insurance, null)
            INTERNET_AND_TV -> getDrawable(context.resources, R.drawable.ic_tv, null)
            INTERCOM -> getDrawable(context.resources, R.drawable.ic_homephone, null)
            SECURITY -> getDrawable(context.resources, R.drawable.ic_guard, null)
            UK_CONTACTS -> getDrawable(context.resources, R.drawable.ic_uk_contacts, null)
            MY_REQUESTS -> getDrawable(context.resources, R.drawable.ic_request, null)
            ABOUT -> getDrawable(context.resources, R.drawable.ic_about, null)
        }
    }

    private fun getTitleFromBill(bill: Bill): String {
        return when (bill.type) {
            BILL -> context.getString(R.string.myBills_list_screen_item_title_bill)
            COUNTER -> context.getString(R.string.myBills_list_screen_item_title_counter)
            INSTALLMENT -> context.getString(R.string.myBills_list_screen_item_title_installment)
            INSURANCE -> context.getString(R.string.myBills_list_screen_item_title_insurance)
            INTERNET_AND_TV -> context.getString(R.string.myBills_list_screen_item_title_internetAndTv)
            INTERCOM -> context.getString(R.string.myBills_list_screen_item_title_intercom)
            SECURITY -> context.getString(R.string.myBills_list_screen_item_title_security)
            UK_CONTACTS -> context.getString(R.string.myBills_list_screen_item_title_ukContacts)
            MY_REQUESTS -> context.getString(R.string.myBills_list_screen_item_title_myRequests)
            ABOUT -> context.getString(R.string.myBills_list_screen_item_title_about, bill.data)
        }
    }

    private fun getSubtitleFromBill(bill: Bill): CharSequence? {
        if (bill.data is BillData.Empty) return null
        val data = bill.data as BillData.Data<*>
        return when (bill.type) {
            BILL ->
                context.getString(
                    R.string.myBills_list_screen_item_subtitle_bill,
                    decorateNumber(data.getDouble())
                )

            COUNTER -> {
                if (data.getBoolean()) {
                    context.getText(R.string.myBills_list_screen_item_subtitle_counter_request)

                } else {
                    context.getText(R.string.myBills_list_screen_item_subtitle_counter_requested)

                }
            }
            INSTALLMENT -> context.getString(
                R.string.myBills_list_screen_item_subtitle_installment,
                data.getString()
            )
            INSURANCE -> context.getString(
                R.string.myBills_list_screen_item_subtitle_insurance,
                data.getString()
            )
            INTERNET_AND_TV -> context.getString(
                R.string.myBills_list_screen_item_subtitle_internetAndTv,
                data.getString()
            )
            INTERCOM -> context.getString(
                R.string.myBills_list_screen_item_subtitle_intercom,
                data.getString()
            )
            SECURITY -> context.getString(
                R.string.myBills_list_screen_item_subtitle_security,
                data.getString()
            )
            else -> null
        }
    }

    private fun decorateNumber(number: Double): String {
        return DecimalFormat.getInstance()
            .format(number)
            .replace(",", " ")
            .replace(".", ",")
    }

    inner class BillsSquareViewHolder(
        private val binding: MybillsListItemSquareBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Bill) {
            with(binding) {
                getIconFromBillType(item.type)?.let {
                    icon.setImageDrawable(it)
                }
                title.text = getTitleFromBill(item)
                val billSubtitle = getSubtitleFromBill(item)

                if (billSubtitle == null) {
                    subtitle.isVisible = false
                } else {
                    subtitle.isVisible = true
                    subtitle.text = billSubtitle
                    if (billSubtitle.contains("-")) { // kinda cringe, i know
                        subtitle.setTextColor(
                            ResourcesCompat.getColor(
                                context.resources,
                                R.color.coral,
                                null
                            )
                        )
                    }
                }
                root.setOnClickListener {
                    Snackbar.make(recycler, title.text, Snackbar.LENGTH_SHORT)
                        .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                        .show()
                }
            }

        }
    }

    inner class BillRectangleViewHolder(
        private val binding: MybillsListItemRectangleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Bill) {
            with(binding) {
                getIconFromBillType(item.type)?.let {
                    icon.setImageDrawable(it)
                }
                title.text = getTitleFromBill(item)
                val billSubtitle = getSubtitleFromBill(item)

                if (billSubtitle == null) {
                    subtitle.isVisible = false
                } else {
                    subtitle.isVisible = true
                    subtitle.text = billSubtitle
                }

                root.setOnClickListener {
                    Snackbar.make(recycler, title.text, Snackbar.LENGTH_SHORT)
                        .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                        .show()
                }
            }
        }
    }
}