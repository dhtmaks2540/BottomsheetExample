package kr.co.lee.coordinatorlayoutexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var coordinatorLayout: CoordinatorLayout
    var persistenetBottomSheet: BottomSheetBehavior<View>? = null
    var modalBottomSheet : BottomSheetDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coordinatorLayout = findViewById(R.id.coordinator)
        button = findViewById(R.id.button)

        initPersistentBottomSheet()

        // button 클릭 리스너
        button.setOnClickListener {
            createDialog()
        }
    }

    // modal bottom sheet 만드는 메서드
    private fun createDialog() {
        // 리스트 생성
        val itemList= ArrayList<DataVO>()

        // VO 객체에 지정할 텍스트와 이미지
        var title = "Keep"
        var image = ResourcesCompat.getDrawable(resources, R.drawable.ic_lab4_1, null)
        var item: DataVO = DataVO(title, image)
        itemList.add(item)

        title = "Inbox"
        image = ResourcesCompat.getDrawable(resources, R.drawable.ic_lab4_2, null)
        item = DataVO(title, image)
        itemList.add(item)

        title = "Messanger"
        image = ResourcesCompat.getDrawable(resources, R.drawable.ic_lab4_3, null)
        item= DataVO(title, image)
        itemList.add(item)

        title = "Google+"
        image = ResourcesCompat.getDrawable(resources, R.drawable.ic_lab4_4, null)
        item= DataVO(title, image)
        itemList.add(item)
        
        // Adapter 생성
        val recyclerViewAdapter = RecyclerViewAdapter(itemList)
        // modal bottom sheet를 위한 xml 파일 초기화
        val view = layoutInflater.inflate(R.layout.lab4_modal_sheet, null)
        // RecyclerView 초기화
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        // LayoutManager 설정(수직)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // RecyclerView adapter 설정
        recyclerView.adapter = recyclerViewAdapter

        // modal bottom sheet 객체 생성
        modalBottomSheet = BottomSheetDialog(this)
        // layout 파일 설정
        modalBottomSheet?.setContentView(view)
        // 다이얼로그 보여주기
        modalBottomSheet?.show()
    }

    // Persistent Bottom Sheet 만드는 메서드
    private fun initPersistentBottomSheet() {
        // persistent bottom sheet로 사용할 view 획득
        // coordinatorLayout안에 설정되어 있으므로 그곳에서 findViewById를 사용하여 얻어온다
        val bottomSheet = coordinatorLayout.findViewById<View>(R.id.bottom_sheet)
        // 위에서 획득한 view를 BottomSheet로 지정
        persistenetBottomSheet = BottomSheetBehavior.from(bottomSheet)
    }

    // persistent bottom sheet 이벤트 처리
    val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        // bottom sheet의 상태값 변경
        override fun onStateChanged(bottomSheet: View, newState: Int) {

        }

        // botton sheet가 스크롤될 때 호출
        override fun onSlide(bottomSheet: View, slideOffset: Float) {

        }
    }
}