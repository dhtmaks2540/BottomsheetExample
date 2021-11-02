package kr.co.lee.coordinatorlayoutexample

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// BottomSheetDialog를 구성하기 위한 RecyclerView
class RecyclerViewAdapter(val itemList: List<DataVO>): RecyclerView.Adapter<ItemHolder>() {
    // View를 초기화하고 ViewHolder 클래스의 매개변수로 전달하고 ViewHolder 객체 리턴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lab4_sheet_row, parent, false)
        return ItemHolder(view)
    }

    // 아이템 항목 구성
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item: DataVO = itemList[position]
        holder.textView.text = item.title
        holder.imageView.setImageDrawable(item.image)
    }

    // 아이템의 개수 리턴
    override fun getItemCount(): Int = itemList.size

}

// RecyclerView의 ViewHolder 클래스
// ViewHolder 클래스가 RecyclerView의 메모리에 존재하는동안 view의 findViewById를 한번만 실행해 성능을 개선하기 위한 방법
class ItemHolder(val view: View): RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.sheet_row_textView)
    val imageView: ImageView = view.findViewById(R.id.sheet_row_imageView)
}

// RecyclerView의 아이템 VO
data class DataVO(val title: String, val image: Drawable?)