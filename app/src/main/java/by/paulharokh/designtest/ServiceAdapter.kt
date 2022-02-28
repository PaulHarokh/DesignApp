package by.paulharokh.designtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServiceAdapter(private var services: List<Service>) :
    RecyclerView.Adapter<ServiceAdapter.ServiceHolder>() {

    class ServiceHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView? = null
        var im: ImageView? = null

        init {
            tvName = itemView.findViewById(R.id.tvNameS)
            im = itemView.findViewById(R.id.imService)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout = inflater.inflate(R.layout.item_service, parent, false)
        return ServiceHolder(layout)
    }

    override fun getItemCount(): Int {
        return services.size
    }

    override fun onBindViewHolder(holder: ServiceHolder, position: Int) {
        val service = services[position]

        service.let { holder.im?.setImageResource(it.photoRes) }
        holder.tvName?.text = service.name

    }

}
