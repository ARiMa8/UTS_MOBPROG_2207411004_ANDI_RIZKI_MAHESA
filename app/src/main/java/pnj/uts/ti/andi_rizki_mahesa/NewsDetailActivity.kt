package pnj.uts.ti.andi_rizki_mahesa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val title = intent.getStringExtra("title")
        val summary = intent.getStringExtra("summary")
        val content = intent.getStringExtra("content")

        val titleTextView = findViewById<TextView>(R.id.newsTitleTextView)
        val summaryTextView = findViewById<TextView>(R.id.newsSummaryTextView)
        val contentTextView = findViewById<TextView>(R.id.newsContentTextView)

        titleTextView.text = title
        summaryTextView.text = summary
        contentTextView.text = content
    }
}
