package com.example.labaratory_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ibm.icu.text.RuleBasedNumberFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rw = findViewById<RecyclerView>(R.id.resView)
        rw.adapter = DataAdapter(this)
    }

}

class DataAdapter(context:Context) : RecyclerView.Adapter<DataAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.recycler_view_element, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 1000000

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val color = if (position % 2 == 1)
            ContextCompat.getColor(inflater.context, R.color.colorEven)
        else
            ContextCompat.getColor(inflater.context, R.color.colorOdd)
        holder.rve.setBackgroundColor(color)
        holder.tv.text = nf.format(position+1)

    }
    private val nf = RuleBasedNumberFormat(
        Locale("ru", "RU"),
        RuleBasedNumberFormat.SPELLOUT
    )

    private val inflater = LayoutInflater.from(context)

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tv:TextView = view.findViewById(R.id.text)
        val rve: LinearLayout = view.findViewById(R.id.rve)
    }
}