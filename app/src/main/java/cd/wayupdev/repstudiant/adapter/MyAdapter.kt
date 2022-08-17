package cd.wayupdev.repstudiant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cd.wayupdev.repstudiant.R
import cd.wayupdev.repstudiant.data.entity.Etudiant
import kotlinx.android.synthetic.main.my_row.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var oldData = emptyList<Etudiant>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view.rootView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.my_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.picture.text = oldData[position].promotion_etudiant
        holder.itemView.fullName.text = oldData[position].nom_etudiant + " " + oldData[position].prenom_etudiant
        holder.itemView.etBiographie.text = oldData[position].biographie

        when (holder.itemView.picture.text) {
            "L1" -> { holder.itemView.picture.setBackgroundResource(R.color.yelow) }
            "L2" -> { holder.itemView.picture.setBackgroundResource(R.color.red) }
            "L3" -> { holder.itemView.picture.setBackgroundResource(R.color.blue) }
            else -> { holder.itemView.picture.setBackgroundResource(R.color.gree) }
        }
    }

    override fun getItemCount(): Int {
        return oldData.size
    }

    fun setData(newData: List<Etudiant>){
        oldData = newData
        notifyDataSetChanged()
    }
}