package com.android.shaadicard.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.android.domain.models.UserModel
import com.android.shaadicard.R
import com.android.shaadicard.databinding.UserListItemBinding
import com.android.shaadicard.utils.green
import com.android.shaadicard.utils.red

class UserAdapter(private val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = differ.currentList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class UserViewHolder(private val binding: UserListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userModel: UserModel) {
            binding.imageView.load(userModel.imageUrl) {
                transformations(CircleCropTransformation())
            }
            binding.textViewName.text = userModel.fullName
            binding.textViewAge.text = userModel.age.toString()
            binding.textViewAddress.text = userModel.address
            binding.textViewStatus.text = userModel.status

            binding.textViewStatus.let {
                if (it.text == context.getString(R.string.accept)) {
                    it.green()
                } else if(it.text == context.getString(R.string.decline)) {
                    it.red()
                }

                it.visibility = if(userModel.status.isNotEmpty()) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }

            binding.linearLayoutButton.let {
                it.visibility = if(userModel.status.isEmpty()) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }

            binding.buttonAccept.setOnClickListener {
                onItemClickListener?.let {
                    it(userModel.id!!, context.getString(R.string.accept))
                }
            }

            binding.buttonDecline.setOnClickListener {
                onItemClickListener?.let {
                    it(userModel.id!!, context.getString(R.string.decline))
                }
            }
        }
    }

    private var onItemClickListener: ((Int, String) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int, String) -> Unit) {
        onItemClickListener = listener
    }
}