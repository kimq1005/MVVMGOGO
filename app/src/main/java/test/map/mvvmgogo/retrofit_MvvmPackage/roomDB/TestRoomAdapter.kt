package test.map.mvvmgogo.retrofit_MvvmPackage.roomDB

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.map.mvvmgogo.databinding.TestitemBinding
import test.map.mvvmgogo.retrofit_MvvmPackage.OnDeleteInterFace

class TestRoomAdapter(var onDeleteInterFace: OnDeleteInterFace) : RecyclerView.Adapter<TestRoomAdapter.RoomViewHolder>() {

    private var testEntity = emptyList<TestEntity>()

    inner class RoomViewHolder(val binding: TestitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(testEntity: TestEntity) {
            binding.roomtextview.text = testEntity.stationname.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = TestitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val deletelist = testEntity[position]



        holder.bind(testEntity[position])
       holder.binding.deletebtn.setOnClickListener {
           onDeleteInterFace.onDeleteStationList(deletelist)
       }
    }

    override fun getItemCount(): Int {
        return testEntity.size

    }

    //room 리사이클러뷰 addAll로 문제해결 근데 왜?
    @SuppressLint("NotifyDataSetChanged")
    fun submitlist(list: List<TestEntity>) {
//        testEntity.addAll(list)

        this.testEntity = list
        notifyDataSetChanged()
    }
}