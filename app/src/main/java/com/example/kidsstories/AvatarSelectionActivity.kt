package com.example.kidsstories

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AvatarSelectionActivity : AppCompatActivity() {

    private var selectedAvatarResId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_avatar_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userName = intent.getStringExtra("USER_NAME")
        val avatars = listOf(
            R.drawable.avatarone,
            R.drawable.avatartwo,
            R.drawable.avatarthree,
            R.drawable.avatarfour,
            R.drawable.avatarfive,
            R.drawable.avatarsix,
            R.drawable.avatareight,
            R.drawable.avatarnine,
            R.drawable.avatarseven,
            R.drawable.avatarten,
            R.drawable.avatareleven,
            R.drawable.avatartwelve
        )

        val avatarRecyclerView = findViewById<RecyclerView>(R.id.avatarRecyclerView)
        val doneButton = findViewById<Button>(R.id.doneButton)

        val avatarAdapter = AvatarAdapter(avatars) { avatarResId ->
            selectedAvatarResId = avatarResId
        }

        avatarRecyclerView.layoutManager = GridLayoutManager(this, 2)
        avatarRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, resources.getDimensionPixelSize(R.dimen.avatar_spacing), true))


        avatarRecyclerView.adapter = avatarAdapter

        doneButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("USER_NAME", userName)
                putInt("SELECTED_AVATAR", selectedAvatarResId)
                apply()
            }
            val intent = Intent(this, MainScreenActivity::class.java)
            startActivity(intent)
        }
    }
}


class AvatarAdapter(
    private val avatars: List<Int>,
    private val onAvatarSelected: (Int) -> Unit
) : RecyclerView.Adapter<AvatarAdapter.AvatarViewHolder>() {

    private var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_avatar, parent, false)
        return AvatarViewHolder(view)
    }

    override fun onBindViewHolder(holder: AvatarViewHolder, position: Int) {
        holder.bind(avatars[position])
        holder.itemView.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = holder.adapterPosition
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)
            onAvatarSelected(avatars[selectedPosition])
        }

        if (selectedPosition == position) {
            holder.itemView.alpha = 0.5f // Indication of selection
        } else {
            holder.itemView.alpha = 1.0f
        }
    }

    override fun getItemCount(): Int = avatars.size

    inner class AvatarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)

        fun bind(avatarResId: Int) {
            avatarImageView.setImageResource(avatarResId)
        }
    }
}

class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int, private val includeEdge: Boolean) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view) // item position
        val column = position % spanCount // item column

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)

            if (position < spanCount) { // top edge
                outRect.top = spacing
            }
            outRect.bottom = spacing // item bottom
        } else {
            outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing // item top
            }
        }
    }
}
