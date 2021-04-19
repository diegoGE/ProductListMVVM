package com.diego.pagatodotestapp.ui.transaction.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.SurfaceControl
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diego.pagatodotestapp.core.BaseViewHolder
import com.diego.pagatodotestapp.data.model.Transaction
import com.diego.pagatodotestapp.data.model.TransactionList
import com.diego.pagatodotestapp.databinding.TransactionItemBinding

class TrasactionAdapter (private  val transactionList: List<Transaction>): RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = TransactionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = TransactionViewHolder(itemBinding)

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
       when(holder){
           is TransactionViewHolder -> holder.bind(transactionList[position])
       }
    }

    override fun getItemCount() = transactionList.size

    private inner class TransactionViewHolder(
        val binding: TransactionItemBinding) :
        BaseViewHolder<Transaction>(binding.root) {
        override fun bind(item: Transaction) {
            binding.merchantName.text = item.merchantName
            binding.currencyCode.text = item.currencyCode
            binding.amount.text = item.amount.toString()
        }

    }
}