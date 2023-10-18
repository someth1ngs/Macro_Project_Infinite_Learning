import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.macroproject.Home
import com.dicoding.macroproject.R
import com.dicoding.macroproject.task.Task

class TaskAdapter(private val context: Context, private val tasks: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskCheckbox: CheckBox = itemView.findViewById(R.id.taskCheckbox)
        val taskTitle: TextView = itemView.findViewById(R.id.taskTitle)
        val taskTitleNote: TextView = itemView.findViewById(R.id.taskNote)
        val taskTime: TextView = itemView.findViewById(R.id.taskTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskCheckbox.isChecked = task.isChecked
        holder.taskTitle.text = task.title
        holder.taskTitleNote.text = task.titlenote
        holder.taskTime.text = task.titletime

        holder.taskCheckbox.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Konfirmasi")
            builder.setMessage("Apakah Anda yakin ingin menyelesaikan tugas ini?")

            builder.setPositiveButton("Ya") { dialog, which ->
                task.isChecked = true
                notifyDataSetChanged()
                dialog.dismiss() // Tutup dialog konfirmasi pertama

                // Tambahkan konfirmasi kedua
                val builder2 = AlertDialog.Builder(context)
                builder2.setTitle("Konfirmasi")
                builder2.setMessage("Apakah Anda ingin Lihat Xp Point?")

                builder2.setPositiveButton("Ya") { dialog2, which2 ->
                    // Handle navigasi ke fragment "Home"
                    val activity = context as FragmentActivity
                    val fragment = Home() // Ganti Home() dengan fragment yang sesuai
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .addToBackStack(null)
                        .commit()

                    dialog2.dismiss() // Tutup dialog konfirmasi kedua
                }.setNegativeButton("Tidak") { dialog2, which2 ->
                    dialog2.dismiss() // Tutup dialog konfirmasi kedua
                }

                val dialog2 = builder2.create()
                dialog2.show()
            }.setNegativeButton("Tidak") { dialog, which ->
                holder.taskCheckbox.isChecked = false // Kembalikan checkbox ke status semula
                dialog.dismiss() // Tutup dialog konfirmasi pertama
            }

            val dialog = builder.create()
            dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}
