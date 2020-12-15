package by.st.generatorforms.athis.androidApp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.st.generatorforms.athis.androidApp.R
import by.st.generatorforms.athis.shared.model.Currency

class CurrencyAdapter(private var list: List<Currency>) :
    RecyclerView.Adapter<CurrencyAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val currencyList = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent,false)
        val myHolder = Holder(currencyList)
        return myHolder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currency = list[position]
        holder.abbrev.text = currency.curAbbreviation
        holder.date.text = changeDate(currency.date)
        holder.name.text = currency.curName
        holder.rate.text = currency.curOfficialRate.toString()
        holder.scale.text = "/" + currency.curScale
    }
    private fun changeDate(date: String):String{
        return date.substring(0, 10)
    }

    fun updateAdapter (newList: List<Currency>){
        list = newList
        notifyDataSetChanged()
    }
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val date = view.findViewById<TextView>(R.id.hw11Date)
        val abbrev = view.findViewById<TextView>(R.id.hw11Abbreviation)
        val name = view.findViewById<TextView>(R.id.hw11Name)
        val rate = view.findViewById<TextView>(R.id.hw11Rate)
        val scale  = view.findViewById<TextView>(R.id.hw11Scale)
    }
}