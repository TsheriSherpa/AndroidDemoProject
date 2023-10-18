package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FlowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flowerlist)

        // Create a list of items to display in the RecyclerView
        val items: MutableList<ActivityMainBinding> = ArrayList()
        items.add(ActivityMainBinding(
            "Marigold",
            "Marigold foliage has a musky, pungent scent, though some varieties have\n" +
                "been bred to be scentless. It is said to deter some common insect pests,\n" +
                "as well as nematodes.",
            10.0)
        )
        items.add(ActivityMainBinding(
            "Dahlia",
            "Dahlia is a genus of tuberous plants that are members of the Asteraceae\n" +
                    "family, which also includes the sunflower, daisy, chrysanthemum, zinnia,\n" +
                    "and, of course, aster. Dahlias are perennial plants with tuberous roots.",
            13.99)
        )
        items.add(ActivityMainBinding(
            "Daisy",
            "Daisy, any of several species of flowering plants belonging to the aster\n" +
                    "family, is a composite plant (as of the genera Bellis or Chrysanthemum)\n" +
                    "having a flower head with well-developed ray flowers usually arranged in\n" +
                    "one or a few whorls.",
            12.99)
        )
        items.add(ActivityMainBinding(
            "Freesia",
            "Freesia has intoxicating scent, long vase life, and enticing array of jewel-\n" +
                    "toned colors, these welcome winter bloomers are easy to force indoors\n" +
                    "as inexpensive, longer-lasting alternatives to cut flowers.",
            14.99)
        )
        items.add(ActivityMainBinding(
            "Lilac",
            "The paste is prepared with wheat that is stone-grounded every single day,\n" +
                    "the incredible \"just-ground\" pappardelle with sea urchin, cauliflower and\n" +
                    "crushed chile—a plate of silky pasta with briny seafood and a hint of hea.",
            15.99))
        items.add(ActivityMainBinding(
            "Lily",
            "Large hollow pasta tubes (paccheri) are mixed with chunks of lamb,\n" +
                    "tomato ragù and grated Pecorino, the dish is finished with mint With\n" +
                    "colorful, star-shaped flowers, lilies give star power to summer gardens.\n" +
                    "These perennial beauties need a bit of extra fall care in areas where\n" +
                    "winters are harsh.",
            16.99))
        items.add(ActivityMainBinding(
            "Peony",
            "The peony is outrageously beautiful in bloom with the fattest, most\n" +
                    "scrumptious flowers and lush green foliage. Peonies are perennials that\n" +
                    "come back every year to take your breath away. In fact, the plants may\n" +
                    "live longer than you do—some have been known to thrive for at least 100\n" +
                    "years.",
            17.99)
        )
        items.add(ActivityMainBinding(
            "Rose",
            "Roses are a popular crop for both domestic and commercial cut flowers.\n" +
                    "Generally they are harvested and cut when in bud, and held in\n" +
                    "refrigerated conditions until ready for display at their point of sale.",
            18.99))
        items.add(ActivityMainBinding(
            "Sunflower",
            "With bright blooms that go all summer, sunflowers are heat-tolerant,\n" +
                    "resistant to pests, and attractive to pollinators and birds. They make\n" +
                    "beautiful cut flowers and their seeds (and oil) are a source of food for\n" +
                    "birds and people",
            19.99))
        items.add(ActivityMainBinding(
            "Tulip",
            "Tulips (Tulipa) are a genus of spring-blooming perennial herbaceous\n" +
                    "bulbiferous geophytes (having bulbs as storage organs). The flowers are\n" +
                    "usually large, showy and brightly coloured, generally red, pink, yellow, or\n" +
                    "white (usually in warm colours)",
            20.99))


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemAdapter = RecyclerViewAdapter(items) { selectedItem ->
            println("I am clicked $selectedItem")
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("title", selectedItem.title)
            intent.putExtra("description", selectedItem.description)
            intent.putExtra("price", selectedItem.price)

            startActivity(intent)
        }

        recyclerView.adapter = itemAdapter

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Handle the up button click (e.g., navigate to the previous activity)
                onBackPressedDispatcher.onBackPressed()
                return true
            }

            R.id.action_settings -> {
                // Handle the settings action
                return true
            }
            // Add more cases for other menu items if needed
        }
        return super.onOptionsItemSelected(item)
    }

}
