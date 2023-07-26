package cl.awakelab.sprint41

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.sprint41.R.id.action_listaFragment_to_detalleFragment
import cl.awakelab.sprint41.databinding.ItemLayoutBinding
import coil.load

class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>() {
    var zapatos = mutableListOf<Zapato>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = zapatos[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return zapatos.size
    }

    fun setData(listaZapatos: List<Zapato>) {
        this.zapatos = listaZapatos.toMutableList()
    }

    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(zapato: Zapato) {
            //val texto = "Nombre: ${zapato.nombre}, Precio: ${zapato.precio}"
            binding.textView.text = zapato.nombre
            binding.textView2.text = zapato.precio.toString()
            binding.imageView.load(zapato.imgUrl)
            val bundle = Bundle()
            bundle.putString("nombre", zapato.nombre)
            bundle.putString("precio", zapato.precio.toString())
            bundle.putString("url", zapato.imgUrl)
            binding.cardView.setOnClickListener {
                Navigation.findNavController(binding.root)
                    .navigate(action_listaFragment_to_detalleFragment, bundle)
            }
        }

    }
}