package pnj.uts.ti.andi_rizki_mahesa

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class FragmentBerita : Fragment() {

    private val newsList = listOf(
        News("CD Projekt Red Merilis Update Terbaru untuk Cyberpunk 2077", "CD Projekt Red telah merilis update terbaru untuk permainan mereka, Cyberpunk 2077, yang menjanjikan peningkatan signifikan dalam kinerja, stabilitas, dan pengalaman bermain. Update ini mencakup perbaikan bug, peningkatan grafis, dan penyesuaian mekanika permainan untuk meningkatkan kesenangan pemain.", R.drawable.cdprlogo, "AABBCCDD"),
        News("Pengumuman Kolaborasi Antara CD Projekt Red dan Penulis Terkenal", "CD Projekt Red telah mengumumkan kolaborasi mengejutkan dengan penulis terkenal untuk proyek game mendatang mereka. Detailnya masih dirahasiakan, tetapi para penggemar berspekulasi bahwa ini bisa menjadi awal dari sebuah franchise baru atau ekspansi dari alam semesta Cyberpunk 2077.", R.drawable.cdprlogo, "AABBCCDD"),
        News("CD Projekt Red Mengumumkan Rencana untuk Mengadaptasi Game Witcher ke dalam Format Baru", "CD Projekt Red telah mengungkapkan rencana untuk mengadaptasi game Witcher mereka ke dalam format baru yang belum pernah dilihat sebelumnya. Detailnya masih sedang dikembangkan, tetapi ini bisa menjadi adaptasi ke platform VR, mobile, atau bahkan serial animasi interaktif.", R.drawable.cdprlogo, "AABBCCDD"),
        News("ABCD", "ABCD", R.drawable.cdprlogo, "AABBCCDD"),
        News("ABCD", "ABCD", R.drawable.cdprlogo, "ABCD"),
        News("ABCD", "ABCD", R.drawable.cdprlogo, "ABCD"),
        News("ABCD", "ABCD", R.drawable.cdprlogo, "ABCD"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsListView: ListView = view.findViewById(R.id.newsListView)
        val adapter = NewsAdapter(requireContext(), newsList)
        newsListView.adapter = adapter

        newsListView.setOnItemClickListener { _, _, position, _ ->
            val news = newsList[position]
            val intent = Intent(requireContext(), NewsDetailActivity::class.java).apply {
                putExtra("title", news.title)
                putExtra("summary", news.summary)
                putExtra("content", news.content)
            }
            startActivity(intent)
        }
    }
}

data class News(val title: String, val summary: String, val imageResId: Int, val content: String)

