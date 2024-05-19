package pnj.uts.ti.andi_rizki_mahesa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import pnj.uts.ti.andi_rizki_mahesa.News

class NewsAdapter(context: Context, private val newsList: List<News>) :
    ArrayAdapter<News>(context, 0, newsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_berita, parent, false)
        val news = newsList[position]

        val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        val summaryTextView = view.findViewById<TextView>(R.id.summaryTextView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        titleTextView.text = news.title
        summaryTextView.text = news.summary
        imageView.setImageResource(news.imageResId)

        return view
    }
}
